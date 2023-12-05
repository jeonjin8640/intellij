package com.example.board.mappers;

import com.example.board.dto.BoardDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {
    @Select("select ifnull( max(grp) +1, 1 ) as maxGrp from board")
    int getMaxGrp();
    @Insert("insert into board values(null, #{subject}, #{writer}, #{content}, 0, now(), #{orgName}, #{savedFileName}, #{savedPathFileName}, #{savedFileSize}, #{folderName}, #{ext}, #{grp}, 1, 1)")
    void setWrite(BoardDto boardDto);
    @Insert("insert into board values(null, #{subject}, #{writer}, #{content}, 0, now(), #{orgName}, #{savedFileName}, #{savedPathFileName}, #{savedFileSize}, #{folderName}, #{ext}, #{grp}, #{seq}, #{depth})")
    void setReply(BoardDto boardDto);
    @Select("select * from board ${searchQuery} order by grp desc, seq asc limit #{startNum}, #{offset}")
    List<BoardDto> getList(Map<String, Object> map);

    @Select("select count(*) from board ${searchQuery}")
    int getListCount(Map<String, Object> map);

    @Select("select count(*) from board")
    int totalCount();

    @Select("select * from board where id = #{id}")
    BoardDto getView(int id);

    @Update("update board set visit = visit + 1 where id = #{id}")
    void updateVisit(int id);

    @Delete("delete from board where id = #{id}")
    void setDelete(int id);

    @Update("update board set subject=#{subject}, writer=#{writer}, content=#{content}, regdate=now(), orgName=#{orgName}, savedFileName=#{savedFileName}, savedPathFileName=#{savedPathFileName}, savedFileSize=#{savedFileSize}, folderName=#{folderName}, ext=#{ext} where id = #{id}")
    void setUpdate(BoardDto boardDto);
}
