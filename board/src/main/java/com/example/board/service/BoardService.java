package com.example.board.service;

import com.example.board.dto.BoardDto;
import com.example.board.dto.PageDto;
import com.example.board.mappers.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardService {
    //검색 메소드
    @Autowired
    BoardMapper boardMapper;
    public List<BoardDto> getSearch(int page, String searchType, String words){
        Map<String, Object> map = new HashMap<>();
        String searchQuery = "";
    //if -> subject, writer, content
    //searchType
    //subject,writer => where =
    //content => where like '%%'

        //where subject = '텍스트 테스트용 게시글'
        //where writer = '관리자'
        if(searchType.equals("subject") || searchType.equals("writer")){
            searchQuery = "where " + searchType + " = '" + words + "'";
        } else if (searchType.equals("content")) {
            searchQuery = "where " + searchType + " like '%"+words+"%'";
        }else {
            searchQuery = "";
        }
        System.out.println(searchQuery);
        map.put("searchQuery", searchQuery);

        PageDto pageDto = new PageDto();

        int startNum = (page -1 )* pageDto.getPageCount();
        map.put("searchQuery", searchQuery);
        map.put("startNum", startNum);
        map.put("offset", pageDto.getPageCount());

        return boardMapper.getList(map);
    }

    public int getSearchCnt(String searchType, String words){
        Map<String, Object> map = new HashMap<>();
        String searchQuery = "";
        //if -> subject, writer, content
        //searchType
        //subject,writer => where =
        //content => where like '%%'

        //where subject = '텍스트 테스트용 게시글'
        //where writer = '관리자'
        if(searchType.equals("subject") || searchType.equals("writer")){
            searchQuery = "where " + searchType + " = '" + words + "'";
        } else if (searchType.equals("content")) {
            searchQuery = "where " + searchType + " like '%"+words+"%'";
        }else {
            searchQuery = "";
        }
        System.out.println(searchQuery);
        map.put("searchQuery", searchQuery);

        return boardMapper.getListCount(map);
    }
    public void setDelete(int id) {

        if( id > 0 ) {
            //file
            BoardDto bd = boardMapper.getView(id);
            //db
            boardMapper.setDelete(id);
            //절대경로
            String removeFile = bd.getSavedPathFileName(); //c //상대경로
//            String removeFile = "src/main/resources/static/upload/" + bd.getFolderName() + "/" + bd.getSavedFileName();
            //System.out.println(removeFile);
            if( removeFile != null ){
                //File객체는 생성 또는 삭제할 준비
                File f = new File(removeFile);
                if( f.exists() ){
                    f.delete();
                }
            }
        }
    }
    /* 페이지 알고리즘 구현 */
    public PageDto BoardPageCalc(int page, String searchType, String words){
        PageDto pageDto = new PageDto();

        Map<String, Object> map = new HashMap<>();
        String searchQuery = "";
        //if -> subject, writer, content
        //searchType
        //subject,writer => where =
        //content => where like '%%'

        //where subject = '텍스트 테스트용 게시글'
        //where writer = '관리자'
        if(searchType.equals("subject") || searchType.equals("writer")){
            searchQuery = "where " + searchType + " = '" + words + "'";
        } else if (searchType.equals("content")) {
            searchQuery = "where " + searchType + " like '%"+words+"%'";
        }else {
            searchQuery = "";
        }

        map.put("searchQuery", searchQuery);

        int totalCount = boardMapper.getListCount(map);
        int totalPage = (int)Math.ceil((double) totalCount / pageDto.getPageCount());


        int startPage = ((int)(Math.ceil((double ) page / pageDto.getBlockCount())) -1) * pageDto.getPage() + 1;
        int endPage = startPage + pageDto.getBlockCount() -1;

        if( endPage > totalPage ){
            endPage = totalPage;
        }

        pageDto.setPage(page);
        pageDto.setStartPage(startPage);
        pageDto.setEndPage(endPage);
        pageDto.setTotalPage(totalPage);

        return pageDto;
    }

    /* 계산한 페이지 값을 select 보내서 limit */
}
