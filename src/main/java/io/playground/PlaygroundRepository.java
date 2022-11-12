package io.playground;

import org.springframework.data.repository.CrudRepository;

/*
* this class will is an interface that extends the CrudRepository class
* the CrudRepository class enables us to create Crud operations easily
* if Crud methods are not defined in the CrudRepository, we can easily define them within
* the interface and implement them in the service class
* */

public interface PlaygroundRepository extends CrudRepository<PlaygroundTable, Integer> {
}
