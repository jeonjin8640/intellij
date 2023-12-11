package com.example.multiple.mappers;

import com.example.multiple.dto.BoardDto;
import com.example.multiple.dto.FileDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {
    @Select("select ifnull(MAX(grp)+1, 1) from board_${configCode}")
    public int getGrpMaxCnt(String configCode);

    @Insert("insert into board_${configCode} values(null, #{subject}, #{writer}, #{content}, 0, now(), #{grp}, 1, 1, #{isFiles})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void setBoard(BoardDto boardDto);

    @Insert("insert into files_${configCode} values(#{id}, #{orgName}, #{savedFileName}, #{savedPathName}, #{savedFileSize}, #{folderName}, #{ext})")
    public void setFiles(FileDto fileDto);

    @Select("select * from board_${configCode} order by id desc limit #{startNum}, #{offset}")
    public List<BoardDto> getBoardList(Map<String, Object> map);

    @Select("select * from board_${configCode} where id = #{id}")
    public BoardDto getBoard(String configCode, int id);
    @Select("select * from files_${configCode} where id = #{id}")
    public List<FileDto> getFiles(String configCode, int id);
    @Delete("delete from board_${configCode} where id = #{id}")
    public void getBoardDelete(BoardDto boardDto);
    @Delete("delete from files_${configCode} where id = #{id}")
    public void setFilesDelete(BoardDto boardDto);
    @Select("select count(*) from board_${configCode}")
    public int getBoardCount(String configCode);

}
