package com.xoado.FilingCabinet.mapper;

import com.xoado.FilingCabinet.bean.TblArchives;
import com.xoado.FilingCabinet.bean.TblArchivesExample;

import java.util.LinkedHashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblArchivesMapper {
	
    int countByExample(TblArchivesExample example);

    int deleteByExample(TblArchivesExample example);

    int deleteByPrimaryKey(String archiveId);
 
    int insert(TblArchives record);

    int insertSelective(TblArchives record);

    List<TblArchives> selectByExample(TblArchivesExample example);
//    分页
    List<TblArchives> selectByExamplePaging(TblArchivesExample example);
//    当前用户的所有资料
    List<LinkedHashMap<String, Object>> selectTheCurrentUser(String	sql);

    TblArchives selectByPrimaryKey(String archiveId);

    int updateByExampleSelective(@Param("record") TblArchives record, @Param("example") TblArchivesExample example);

    int updateByExample(@Param("record") TblArchives record, @Param("example") TblArchivesExample example);

    int updateByPrimaryKeySelective(TblArchives record);

    int updateByPrimaryKey(TblArchives record);
}