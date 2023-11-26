package io.playground;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
* Entity shows that the class is created as a record in the database using persistence package
* Table indicates that the class and its member variables will be table and columns
* */

@Entity
@Table
public class PlaygroundTable {
    @Id
    @Column
    private int Id;
    @Column
    private String name;
    @Column
    private String description;

    // constructors
    public PlaygroundTable(){}

    public PlaygroundTable(int Id, String name, String description){
        super();
        this.Id = Id;
        this.name = name;
        this.description = description;
    }

    // Getters and setter methods
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
