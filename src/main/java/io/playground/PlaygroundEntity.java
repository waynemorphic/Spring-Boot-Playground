package io.playground;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
* Entity shows that the class is created as a record in the database using persistence package
* Table indicates that the class and its member variables will be table and columns
* */

@Getter
@Setter
@Entity
@Table(name = "playground")
@NoArgsConstructor
@AllArgsConstructor
public class PlaygroundEntity {
    @Id
    private int id;
    @Column
    private String name;
    @Column
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof PlaygroundEntity that))
            return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(),
            that.getName()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription());
    }
}