package com.taitres.mapper;

import com.taitres.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {

    /**
     * 查询所有部门
     * @return
     */
    List<Dept> getDept();

    /**
     * 根据id删除部门
     * @param id
     */
    void deleteDeptById(Integer id);


    /**
     * 添加部门
     * @param dept
     */
    void addDept(Dept dept);
}
