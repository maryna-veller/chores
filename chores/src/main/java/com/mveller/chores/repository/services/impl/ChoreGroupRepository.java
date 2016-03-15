package com.mveller.chores.repository.services.impl;

import com.mveller.chores.repository.data.ChoreGroup;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Maryna on 3/7/16.
 */
public interface ChoreGroupRepository extends JpaRepository<ChoreGroup, Long> {
}
