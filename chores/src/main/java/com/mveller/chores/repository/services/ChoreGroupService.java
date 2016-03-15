package com.mveller.chores.repository.services;

import com.mveller.chores.repository.data.ChoreGroup;

/**
 * Created by Maryna on 3/7/16.
 */
public interface ChoreGroupService {
    ChoreGroup createChoreGroup(ChoreGroup choreGroup);
    ChoreGroup getChoreGroup(Long id);
    ChoreGroup updateChoreGroup(ChoreGroup choreGroup);
    Long deleteChoreGroup(Long id);

}
