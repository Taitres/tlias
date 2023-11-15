package com.taitres.mapper;

import com.taitres.pojo.Emp;
import com.taitres.pojo.PageBean;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {


    /**
     * 条件查询所有员工
     * @return
     */
    List<Emp> getEmp(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 根据id删除员工
     * @param id
     */
    void deleteEmpById(List<Integer> ids);

}
