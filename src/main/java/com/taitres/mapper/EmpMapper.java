package com.taitres.mapper;

import com.taitres.pojo.Emp;
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
     * 根据id列表删除员工
     * @param ids
     */
    void deleteEmpById(List<Integer> ids);
    /**
     * 添加员工
     * @param emp
     */
    void addEmp(Emp emp);
    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    Emp getEmpById(Integer id);
    /**
     * 根据id修改员工
     * @param emp
     */
    void updateEmpById(Emp emp);

    /**
     * 登录时根据用户名和密码查询员工
     *
     * @param username
     * @param password
     * @return
     */
    Emp getEmpByUsernameAndPassword(String username, String password);

    /**
     * 根据部门id删除员工
     * @param deptId
     */
    void deleteEmpByDeptId(Integer deptId);
}
