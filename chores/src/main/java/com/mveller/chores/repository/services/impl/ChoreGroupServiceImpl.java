package com.mveller.chores.repository.services.impl;

import com.mveller.chores.repository.data.ChoreGroup;
import com.mveller.chores.repository.services.ChoreGroupService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Maryna on 3/7/16.
 */
@Service
public class ChoreGroupServiceImpl implements ChoreGroupService {
    @Autowired
    private ChoreGroupRepository choreGroupRepository;
    private static final Logger logger = LogManager.getLogger();


    public ChoreGroup createChoreGroup(ChoreGroup choreGroup) {
        ChoreGroup choreGroupNew = choreGroupRepository.save(choreGroup);
        logger.info("Chore Group {} with name {} was created ", choreGroup.getId(), choreGroup.getName());
        return choreGroupNew;
    }

    public ChoreGroup getChoreGroup(Long id) {
        ChoreGroup choreGroup = choreGroupRepository.findOne(id);
        if (choreGroup == null){
            throw new RuntimeException(String.format("Chore Group with %s not found", id));
        }
        logger.info("Found Chore Group with is {} ", choreGroup.getId());
        return choreGroup;
    }

    public ChoreGroup updateChoreGroup(ChoreGroup choreGroup) {
        ChoreGroup choreGroupFound = getChoreGroup(choreGroup.getId());
        choreGroupFound = choreGroupRepository.save(choreGroupFound);
        return choreGroupFound;
    }

    public Long deleteChoreGroup(Long id) {
        ChoreGroup choreGroupFound = getChoreGroup(id);
        choreGroupRepository.delete(choreGroupFound);
        return id;
    }
}
