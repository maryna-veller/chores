package com.mveller.chores.repository.services.impl;

import com.mveller.chores.repository.data.Chore;
import com.mveller.chores.repository.services.ChoreService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Maryna on 3/7/16.
 */
@Service
public class ChoreServiceImpl implements ChoreService {
    @Autowired
    private ChoreRepository choreRepository;
    private static final Logger logger = LogManager.getLogger();

    public Chore createChore(Chore chore) {
        logger.info("Chore {} with {} will be created", chore.getId(), chore.getName());

        Chore newChore = choreRepository.save(chore);
        logger.info("Chore {} with {} is created", chore.getId(), chore.getName());
        return newChore;
    }

    public Chore getChore(Long id) {
        Chore chore = choreRepository.findOne(id);
        if (chore == null){
            throw new RuntimeException(String.format("Chore with id %s is not found", id));
        }
        logger.info("Found Chore with id {}", chore.getId());
        return chore;
    }

    public Chore updateChore(Chore chore) {
        Chore foundChore = getChore(chore.getId());
        foundChore = choreRepository.save(foundChore);
        return foundChore;
    }

    public Long deleteChore(Long id) {
        Chore foundChore = getChore(id);
        choreRepository.delete(foundChore);
        logger.info("Deleted Chore with id {}", id);
        return id;
    }

}
