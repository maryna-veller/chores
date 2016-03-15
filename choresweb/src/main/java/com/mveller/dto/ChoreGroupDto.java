package com.mveller.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by Maryna on 3/7/16.
 */
public class ChoreGroupDto {
    private Long id;
    @NotNull(message = "{error.choreGroupName.required}")

    private String name;

    public ChoreGroupDto(){

    }
    public ChoreGroupDto(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
