package com.taitres.controller;


import com.taitres.pojo.Emp;
import com.taitres.pojo.PageBean;
import com.taitres.pojo.Result;
import com.taitres.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    //分页查询全部员工
    @GetMapping
    public Result getEmpPage(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             String name, Short gender,
                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询全部员工,参数：{}, {}, {}, {}, {}, {}",page,pageSize,name,gender,begin,end);
        PageBean pagebean = empService.getEmpPage(page, pageSize,name,gender,begin,end);
        return Result.success(pagebean);
    }

    //根据id批量删除员工
    @DeleteMapping("/{ids}")
    public Result deleteEmpById(@PathVariable("ids") List<Integer> ids){
        log.info("根据id删除员工,参数：{}",ids);
        empService.deleteEmpById(ids);
        return Result.success();
    }

    //添加员工
    @PostMapping
    public Result addEmp(@RequestBody Emp emp){
        log.info("添加员工,参数：{}",emp);
        empService.addEmp(emp);
        return Result.success();
    }

    //根据id查询员工
    @GetMapping("/{id}")
    public Result getEmpById(@PathVariable Integer id){
        log.info("根据id查询员工,参数：{}",id);
        Emp emp = empService.getEmpById(id);
        return Result.success(emp);
    }

    //根据id修改员工
    @PutMapping
    public Result updateEmpById(@RequestBody Emp emp){
        log.info("根据id修改员工,参数：{}",emp);
        empService.updateEmpById(emp);
        return Result.success();
    }

}
