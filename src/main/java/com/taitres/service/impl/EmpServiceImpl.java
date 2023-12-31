package com.taitres.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taitres.mapper.EmpMapper;
import com.taitres.pojo.Emp;
import com.taitres.pojo.PageBean;
import com.taitres.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;


    @Override
    public PageBean getEmpPage(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        PageHelper.startPage(page, pageSize);
        List<Emp> emps = empMapper.getEmp(name,gender,begin,end);
        Page<Emp> p = (Page<Emp>) emps;
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void deleteEmpById(List<Integer> ids) {
        empMapper.deleteEmpById(ids);
    }

    @Override
    public void addEmp(Emp emp) {
        empMapper.addEmp(emp);
    }

    @Override
    public Emp getEmpById(Integer id) {
        return empMapper.getEmpById(id);
    }

    @Override
    public void updateEmpById(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateEmpById(emp);
    }

    @Override
    public Emp login(Emp emp) {
        String username = emp.getUsername();
        String password = emp.getPassword();
        return empMapper.getEmpByUsernameAndPassword(username,password);
    }

}
