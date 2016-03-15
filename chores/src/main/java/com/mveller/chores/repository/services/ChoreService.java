package com.mveller.chores.repository.services;

import com.mveller.chores.repository.data.Chore;

/**
 * Created by Maryna on 3/7/16.
 */
public interface ChoreService {
    Chore createChore(Chore chore);
    Chore getChore(Long id);
    Chore updateChore(Chore chore);
    Long deleteChore(Long id);

}
