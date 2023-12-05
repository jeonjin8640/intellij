package com.example.member.mappers;

import com.example.member.dto.MemberDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {
    @Insert("insert into member values(null, #{userid}, #{passwd}, #{username}, now())")
    void setInsert(MemberDto memberDto);

    @Select("select * from member ${queryString} order by id desc")
    List<MemberDto> getMemberList(String queryString);

    @Select("select count(*) from member ${queryString}")
    int getMemberCount(String queryString);

    @Delete("delete from member where id = #{id}")
    void deleteMember(int id);

    @Select("select * from member where id = #{id}")
    MemberDto viewMember(int id);

    @Select("select * from member where userid = #{userid} and passwd = #{passwd}")
    MemberDto setLogin(MemberDto memberDto);

    @Update("update member set userid = #{userid}, passwd = #{passwd}, username = #{username}, regdate = now() where id = #{id}")
    void setUpdate(MemberDto memberDto);

}
