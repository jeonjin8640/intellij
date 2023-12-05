package com.example.tut05.mappers;

import com.example.tut05.dto.UsersDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UsersMapper { //mapper -> query

    @Insert("insert into users values(#{email},#{passwd})")
    public void setInsert(UsersDto usersDto); // select 를 제외하고 void 씀
    @Select("select * from users /*order by email desc*/")
    public List<UsersDto> getUsers();
}
