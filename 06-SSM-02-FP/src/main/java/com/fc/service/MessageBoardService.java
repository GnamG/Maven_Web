package com.fc.service;

import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.vo.ResultVo;

public interface MessageBoardService {
    ResultVo getList(Long id, Integer pageNum, Integer pageSize);

    ResultVo add(MessageBoardWithBLOBs messageBoardWithBLOBs);

    ResultVo update(MessageBoardWithBLOBs messageBoardWithBLOBs);

    ResultVo delete(Long id);
}
