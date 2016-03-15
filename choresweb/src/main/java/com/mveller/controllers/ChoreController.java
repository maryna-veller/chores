package com.mveller.controllers;

import com.mveller.chores.repository.data.Chore;
import com.mveller.chores.repository.services.ChoreService;
import com.mveller.convertor.ChoreConverter;
import com.mveller.dto.ChoreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Maryna on 3/14/16.
 */
@Controller
@RequestMapping("/chore")
public class ChoreController extends AbstractController {

    @Autowired
    private ChoreService choreService;
    @Autowired
    private ChoreConverter choreConverter;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ChoreDto createChore(@RequestBody @Valid ChoreDto choreDto) {
        Chore chore = choreConverter.fromDto(choreDto);
        Chore createdAccount = choreService.createChore(chore);
        return choreConverter.toDto(createdAccount);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ChoreDto updateChore(@RequestBody @Valid ChoreDto choreDto, @PathVariable Long id) {
        Chore account = choreConverter.fromDto(choreDto);
        account.setId(id);
        Chore updateChore = choreService.updateChore(account);
        return choreConverter.toDto(updateChore);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ChoreDto getChore(@PathVariable Long id) {
        Chore retrievedChore = choreService.getChore(id);
        return choreConverter.toDto(retrievedChore);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteChore(@PathVariable Long id) {
        choreService.deleteChore(id);
    }
}
