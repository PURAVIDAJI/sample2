package com.example.sample2.repository;

import com.example.sample2.domain.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScoreRepository {

    List<Score> findAll();
    Score findById(int id);
    void updateScore(Score score);
    int insertScore (Score score);
    Score deleteById(int id);

}
