package io.playground;
/*
* The class will be the service of our application
* It implements all the methods that will be defined in controller class
* It has a dependency injection from the PlaygroundRepository denoted by @Autowired
* @Service denotes that the class is a service*/

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PlaygroundService {
    // dependency injection
    private final PlaygroundRepository playgroundRepository;

    public PlaygroundService(PlaygroundRepository playgroundRepository){
        this.playgroundRepository = playgroundRepository;
    }

    // Get all
    public List<PlaygroundEntity> getAll(){
        List<PlaygroundEntity> playgrounds = new ArrayList<>();
        playgroundRepository.findAll()
                .forEach(playgrounds::add);
        return playgrounds;
    }

    // Get one
    public PlaygroundEntity getOne(int id) throws Exception{
        Optional<PlaygroundEntity> playgroundEntity = playgroundRepository.findById(id);
        if (playgroundEntity.isEmpty()){
            throw new Exception("Entity not found with id " + id);
        }
        return playgroundEntity.get();
    }

    // Post
    public void postOne(PlaygroundEntity playgroundEntity){
        playgroundRepository.save(playgroundEntity);
    }

    // Delete
    public void deleteOne(int id){
        playgroundRepository.deleteById(id);
    }

    // Put
    public void putOne(long id, PlaygroundEntity playgroundEntity){
        playgroundRepository.save(playgroundEntity);
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

    // Get by name
    public List<PlaygroundEntity> getByName(String name){
        return playgroundRepository.findByName(name);
    }
}
