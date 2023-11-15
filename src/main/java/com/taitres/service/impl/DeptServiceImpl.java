package com.taitres.service.impl;

import com.taitres.mapper.DeptMapper;
import com.taitres.pojo.Dept;
import com.taitres.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> getDept() {
        return deptMapper.getDept();
    }

    @Override
    public void deleteDeptById(Integer id) {
        deptMapper.deleteDeptById(id);
    }

    @Override
    public void addDept(Dept dept) {
        deptMapper.addDept(dept);
    }

}
