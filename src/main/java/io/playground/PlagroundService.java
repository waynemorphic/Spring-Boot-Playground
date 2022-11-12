package io.playground;
/*
* The class will be the service of our application
* It implements all the methods that will be defined in controller class
* It has a dependency injection from the PlaygroundRepository denoted by @Autowired
* @Service denotes that the class is a service*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PlagroundService {
    // dependency injection
    @Autowired
    private PlaygroundRepository playgroundRepository;

    // Get all
    public List<PlaygroundTable> getAll(){
        List<PlaygroundTable> playgrounds = new ArrayList<>();
        playgroundRepository.findAll()
                .forEach(playgrounds::add);
        return playgrounds;
    }

    // Get one
    public Optional<PlaygroundTable> getOne(int Id){
        return playgroundRepository.findById(Id);
    }

    // Post
    public void postOne(PlaygroundTable playgroundTable){
        playgroundRepository.save(playgroundTable);
    }

    // Delete
    public String deleteOne(int Id){
        playgroundRepository.deleteById(Id);
        return "Deleted successfully";
    }

    // Put
    public void putOne(int Id, PlaygroundTable playgroundTable){
        playgroundRepository.save(playgroundTable);
//        PlaygroundTable playgrounds = playgroundRepository.findById(Id).get();
//
//        if (Objects.nonNull(playgroundTable.getName()) && !"".equalsIgnoreCase(playgroundTable.getName())){
//            playgrounds.setName(playgroundTable.getName());
//        }
//        if (Objects.nonNull(playgroundTable.getDescription()) && !"".equalsIgnoreCase(playgroundTable.getDescription())){
//            playgrounds.setDescription(playgroundTable.getDescription());
//        }
//        return playgroundRepository.save(playgrounds);
    }
}
