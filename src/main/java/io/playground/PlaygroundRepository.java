package io.playground;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PlaygroundRepository extends JpaRepository<PlaygroundEntity, Integer> {
  @Query("SELECT i FROM PlaygroundEntity i WHERE i.name = :name")
  List<PlaygroundEntity> findByName(@Param("name") String name);

  @Query("SELECT i FROM PlaygroundEntity i WHERE i.id = :id")
  Optional<PlaygroundEntity> findById(@Param("id") int id);

}