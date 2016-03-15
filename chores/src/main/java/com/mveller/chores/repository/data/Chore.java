package com.mveller.chores.repository.data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Maryna on 2/22/16.
 */
@Entity
public class Chore {

    private Long id;
    private String name;
    private Set<ChoreGroup> choreGroups;

    public Chore() {
    }

    public Chore(Long id) {
        this.id = id;
    }

    public Chore(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Chore(Long id, String name, Set<ChoreGroup> choreGroups) {
        this.id = id;
        this.name = name;
        this.choreGroups = choreGroups;
    }

    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(name = "ChoreInGroup", joinColumns = @JoinColumn(name = "choreId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "groupId", referencedColumnName = "id"))
    public Set<ChoreGroup> getChoreGroups() {
        return choreGroups;
    }

    public void setChoreGroups(Set<ChoreGroup> choreGroups) {
        this.choreGroups = choreGroups;
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
