package com.example.sel.mappers;

import com.example.sel.dto.DeptDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from dept order by dept_code asc")
    List<DeptDto> getDeptAll();
    @Insert("insert into pos values(#{deptCode}, #{deptName})")
    void addDept(DeptDto deptDto);
}
