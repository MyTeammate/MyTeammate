package com.znsd.circuit.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.znsd.circuit.model.Power;

@MapperScan
public interface HomeDao {
    public List<Power> selectAllPower(Integer nid);
}
