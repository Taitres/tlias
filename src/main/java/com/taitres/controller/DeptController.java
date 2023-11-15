package com.taitres.controller;

import com.taitres.pojo.Dept;
import com.taitres.pojo.Result;
import com.taitres.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;


    @GetMapping
    public Result getDept(){
        log.info("查询全部部门");
        return Result.success(deptService.getDept());
    }

    @DeleteMapping("/{id}")
    public Result deleteDeptById(@PathVariable Integer id){
        log.info("根据id删除部门 {}",id);
        deptService.deleteDeptById(id);
        return Result.success();
    }

    @PostMapping
    public Result addDept(@RequestBody Dept dept){
        log.info("添加部门 {}",dept.getName());
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptService.addDept(dept);
        return Result.success();
    }

}
