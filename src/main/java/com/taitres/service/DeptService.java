package com.taitres.service;

import com.taitres.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> getDept();

    void deleteDeptById(Integer id);

    void addDept(Dept dept);
}
