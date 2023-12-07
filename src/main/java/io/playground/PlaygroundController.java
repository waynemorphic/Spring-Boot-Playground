package io.playground;

/*
* controller class implements all methods defined in the PlaygroundService
* it is denoted with @RestController
* has dependency injection with PlaygroundService so that all methods in service are also
* injected in this class
* */

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class PlaygroundController {

    // dependency injection
    private final PlaygroundService playgroundService;

    public PlaygroundController(PlaygroundService playgroundService){
        this.playgroundService = playgroundService;
    }

    // Get all
    @GetMapping("/playground")
    public ResponseEntity<List<PlaygroundEntity>> getAll(@RequestParam(required = false) String name) {

        List<PlaygroundEntity> list;

        if (name != null){
            list = playgroundService.getByName(name);
            log.info("Queried by name {} ", list);
        } else {
            list = playgroundService.getAll();
            log.info("Queried all {} ", list);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // Get one
    @GetMapping("/playground/{id}")
    public ResponseEntity<PlaygroundEntity> getOne(@PathVariable long id) throws Exception {
        log.info("Queried by id {} ", playgroundService.getOne((int) id));
        return new ResponseEntity<>(playgroundService.getOne((int) id), HttpStatus.OK);
    }

    // Post
    @PostMapping("/playground")
    public ResponseEntity<String> postOne(@RequestBody PlaygroundEntity playgroundEntity) {
        playgroundService.postOne(playgroundEntity);
        return new ResponseEntity<>("Posted Successfully", HttpStatus.ACCEPTED);
    }

    // Delete
    @DeleteMapping("/playground/{id}")
    public ResponseEntity<String> deleteOne(@PathVariable int id) {
        playgroundService.deleteOne(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

    // Put
    @PutMapping("/playground/{id}")
    public ResponseEntity<List<PlaygroundEntity>> putOne(
        @RequestBody PlaygroundEntity playgroundEntity, @PathVariable int id) {
        playgroundService.putOne(id, playgroundEntity);
        List<PlaygroundEntity> list = new ArrayList<>();
        list.add(playgroundEntity);
        log.info("Updated entity {}", list);
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }
}