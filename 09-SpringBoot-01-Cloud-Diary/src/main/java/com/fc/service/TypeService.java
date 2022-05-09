package com.fc.service;

import com.fc.entity.TbNote;
import com.fc.entity.TbNoteType;

import java.util.List;

public interface TypeService {
    List<TbNoteType> getType(Integer id);
}
