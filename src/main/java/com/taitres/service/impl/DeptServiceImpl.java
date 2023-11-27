package com.taitres.service.impl;

import com.taitres.mapper.DeptMapper;
import com.taitres.mapper.EmpMapper;
import com.taitres.pojo.Dept;
import com.taitres.pojo.DeptLog;
import com.taitres.service.DeptLogService;
import com.taitres.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;

    @Override
    public List<Dept> getDept() {
        return deptMapper.getDept();
    }

    @Transactional
    @Override
    public void deleteDeptById(Integer id) {
        try {
            deptMapper.deleteDeptById(id);
            //删除部门的同时，删除部门下的员工
            empMapper.deleteEmpByDeptId(id);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作,此次解散的是"+id+"号部门");
            deptLogService.insert(deptLog);

        }
    }

    @Override
    public void addDept(Dept dept) {
        deptMapper.addDept(dept);
    }

}
