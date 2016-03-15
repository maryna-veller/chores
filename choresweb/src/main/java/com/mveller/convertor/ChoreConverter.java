package com.mveller.convertor;

import com.google.common.collect.ImmutableSet;
import com.mveller.chores.repository.data.Chore;
import com.mveller.chores.repository.data.ChoreGroup;
import com.mveller.dto.ChoreDto;
import com.mveller.dto.ChoreGroupDto;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Maryna on 3/7/16.
 */
@Component
public class ChoreConverter {

    public Chore fromDto(ChoreDto choreDto){
        Set<ChoreGroup> choreGroup = new HashSet<>();
        choreDto.getChoreGroupIds().stream().forEach(c -> choreGroup.add(new ChoreGroup(c)));
        Chore chore = new Chore(choreDto.getId(), choreDto.getName(), choreGroup);
        return chore;
    }

    public ChoreDto toDto(Chore chore){
        Set<Long> choreGroup = new HashSet<>();
        chore.getChoreGroups().stream().forEach(c -> choreGroup.add(c.getId()));
        ChoreDto choreDto = new ChoreDto(chore.getId(), chore.getName(), choreGroup);
        return choreDto;

    }
}
