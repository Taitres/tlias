package com.taitres.service;

import com.taitres.pojo.Emp;
import com.taitres.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    PageBean getEmpPage(Integer start, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void deleteEmpById(List<Integer> ids);

}
