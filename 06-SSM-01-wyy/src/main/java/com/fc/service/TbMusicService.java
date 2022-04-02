package com.fc.service;

import com.fc.entity.TbMusic;

import java.util.List;

public interface TbMusicService {
     List<TbMusic> findAll();
     TbMusic findById(Integer musicId);
    // 下一首
    TbMusic nextSong(Integer musicId);
    // 上一首
    TbMusic prevSong(Integer musicId);

    List<TbMusic> search(String keyword);
}
