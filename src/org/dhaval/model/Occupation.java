package org.dhaval.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by Dhaval on 4/16/2016.
 */
@Component
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "OCCUPATION_TYPE",
//                     discriminatorType = DiscriminatorType.STRING )
public class Occupation {

    @Id
    @GenericGenerator(name = "opt-seq", strategy = "sequence", parameters = @Parameter(name = "prefer_sequence_per_entity", value = "true"))
    @GeneratedValue(generator = "opt-seq")
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
