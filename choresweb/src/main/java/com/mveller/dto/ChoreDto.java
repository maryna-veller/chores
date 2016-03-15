package com.mveller.dto;

import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Maryna on 3/7/16.
 */
public class ChoreDto {
    private Long id;
    @NotNull(message = "{error.choreGroupName.required}")

    private String name;
    private Set<Long> choreGroupIds;

    public ChoreDto(){

    }
    public ChoreDto(Long id, String name, Set<Long> choreGroupIds) {
        this.id = id;
        this.name = name;
        this.choreGroupIds = choreGroupIds;
    }

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

    public Set<Long> getChoreGroupIds() {
        return choreGroupIds;
    }

    public void setChoreGroupIds(Set<Long> choreGroupIds) {
        this.choreGroupIds = choreGroupIds;
    }
}
