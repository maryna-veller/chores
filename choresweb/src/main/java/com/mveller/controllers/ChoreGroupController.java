package com.mveller.controllers;

import com.mveller.chores.repository.data.ChoreGroup;
import com.mveller.chores.repository.services.ChoreGroupService;
import com.mveller.convertor.ChoreGroupConverter;
import com.mveller.dto.ChoreGroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Maryna on 3/7/16.
 */
@Controller
@RequestMapping("/choreGroups")
public class ChoreGroupController extends AbstractController{

    @Autowired
    private ChoreGroupService choreGroupService;
    @Autowired
    private ChoreGroupConverter choreGroupConverter;
    
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ChoreGroupDto createChoreGroup(@RequestBody @Valid ChoreGroupDto choreGroupDto) {
        ChoreGroup choreGroup = choreGroupConverter.fromDto(choreGroupDto);
        ChoreGroup createdAccount = choreGroupService.createChoreGroup(choreGroup);
        return choreGroupConverter.toDto(createdAccount);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ChoreGroupDto updateChoreGroup(@RequestBody @Valid ChoreGroupDto choreGroupDto, @PathVariable Long id) {
        ChoreGroup account = choreGroupConverter.fromDto(choreGroupDto);
        account.setId(id);
        ChoreGroup updateChoreGroup = choreGroupService.updateChoreGroup(account);
        return choreGroupConverter.toDto(updateChoreGroup);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ChoreGroupDto getChoreGroup(@PathVariable Long id) {
        ChoreGroup retrievedChoreGroup = choreGroupService.getChoreGroup(id);
        return choreGroupConverter.toDto(retrievedChoreGroup);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteChoreGroup(@PathVariable Long id) {
        choreGroupService.deleteChoreGroup(id);
    }


}
