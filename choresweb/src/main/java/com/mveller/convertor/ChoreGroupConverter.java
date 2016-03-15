package com.mveller.convertor;

import com.mveller.chores.repository.data.ChoreGroup;
import com.mveller.dto.ChoreGroupDto;
import org.springframework.stereotype.Component;

/**
 * Created by Maryna on 3/7/16.
 */
@Component
public class ChoreGroupConverter {
    public ChoreGroup fromDto(ChoreGroupDto choreGroupDto){
        return new ChoreGroup(choreGroupDto.getId(), choreGroupDto.getName());
    }

    public ChoreGroupDto toDto(ChoreGroup choreGroup){
        return new ChoreGroupDto(choreGroup.getId(), choreGroup.getName());
    }
}
