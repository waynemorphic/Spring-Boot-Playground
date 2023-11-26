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
import java.util.Optional;

@Service
public class PlagroundService {
    // dependency injection
    @Autowired
    private PlaygroundRepository playgroundRepository;

    // Get all
    public List<PlaygroundEntity> getAll(){
        List<PlaygroundEntity> playgrounds = new ArrayList<>();
        playgroundRepository.findAll()
                .forEach(playgrounds::add);
        return playgrounds;
    }

    // Get one
    public Optional<PlaygroundEntity> getOne(int Id){
        return playgroundRepository.findById(Id);
    }

    // Post
    public String postOne(PlaygroundEntity playgroundEntity){
        playgroundRepository.save(playgroundEntity);
        return "Posted Successfully";
    }

    // Delete
    public String deleteOne(int Id){
        playgroundRepository.deleteById(Id);
        return "Deleted successfully";
    }

    // Put
    public String putOne(int Id, PlaygroundEntity playgroundEntity){
        playgroundRepository.save(playgroundEntity);
        return "Updated Successfully";
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
