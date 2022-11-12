package io.playground;

/*
* controller class implements all methods defined in the PlaygroundService
* it is denoted with @RestController
* has dependency injection with PlaygroundService so that all methods in service are also
* injected in this class
* */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlaygroundController {
    // dependency injection
    @Autowired
    private PlagroundService plagroundService;

    // Get all
    @GetMapping("/playground")
    public List<PlaygroundTable> getAll(@RequestBody PlaygroundTable playgroundTable){
        return plagroundService.getAll();
    }

    // Get one
    @GetMapping("/playground/{Id}")
    public Optional<PlaygroundTable> getOne(@PathVariable int Id){
        return plagroundService.getOne(Id);
    }

    // Post
    @PostMapping("/playground")
    public void postOne(@RequestBody PlaygroundTable playgroundTable){
        plagroundService.postOne(playgroundTable);
    }

    // Delete
    @DeleteMapping ("/playground/{Id}")
    public void deleteOne(@PathVariable String Id){
        plagroundService.deleteOne(Integer.parseInt(Id));
    }

    // Put
    @PutMapping("/playground/{Id}")
    public void putOne(@RequestBody PlaygroundTable playgroundTable, @PathVariable String Id){
        plagroundService.putOne(Integer.parseInt(Id), playgroundTable);
    }
}
