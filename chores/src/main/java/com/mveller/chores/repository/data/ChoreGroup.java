package com.mveller.chores.repository.data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Maryna on 2/22/16.
 */
@Entity
public class ChoreGroup {

    private Long id;
    private String name;
    private Set<Chore> chores;

    public ChoreGroup() {
    }

    public ChoreGroup(Long id) {
        this.id = id;
    }
    public ChoreGroup(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @ManyToMany(cascade= CascadeType.MERGE,mappedBy = "choreGroups")
    public Set<Chore> getChores() {
        return chores;
    }

    public void setChores(Set<Chore> chores) {
        this.chores = chores;
    }



    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
