package io.playground;

/*
* controller class implements all methods defined in the PlaygroundService
* it is denoted with @RestController
* has dependency injection with PlaygroundService so that all methods in service are also
* injected in this class
* */

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlaygroundController {

    // dependency injection
    private final PlagroundService plagroundService;

    public PlaygroundController(PlagroundService plagroundService){
        this.plagroundService = plagroundService;
    }

    // Get all
    @GetMapping("/playground")
    public ResponseEntity<List<PlaygroundEntity>> getAll(
        @RequestBody PlaygroundEntity playgroundEntity) {
        return new ResponseEntity<>(plagroundService.getAll(), HttpStatus.OK);
    }

    // Get one
    @GetMapping("/playground/{Id}")
    public ResponseEntity<Optional<PlaygroundEntity>> getOne(@PathVariable int Id) {
        return new ResponseEntity<>(plagroundService.getOne(Id), HttpStatus.OK);
    }

    // Post
    @PostMapping("/playground")
    public ResponseEntity<String> postOne(@RequestBody PlaygroundEntity playgroundEntity) {
        plagroundService.postOne(playgroundEntity);
        return new ResponseEntity<>("Posted Successfully", HttpStatus.ACCEPTED);
    }

    // Delete
    @DeleteMapping("/playground/{Id}")
    public ResponseEntity<String> deleteOne(@PathVariable String Id) {
        plagroundService.deleteOne(Integer.parseInt(Id));
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

    // Put
    @PutMapping("/playground/{Id}")
    public ResponseEntity<List<PlaygroundEntity>> putOne(
        @RequestBody PlaygroundEntity playgroundEntity, @PathVariable String Id) {
        plagroundService.putOne(Integer.parseInt(Id), playgroundEntity);
        List<PlaygroundEntity> list = new ArrayList<>();
        list.add(playgroundEntity);
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }
}