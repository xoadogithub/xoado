package com.xoado.FilingCabinet.mapper;

import com.xoado.FilingCabinet.bean.TblCurrentArchives;
import com.xoado.FilingCabinet.bean.TblCurrentArchivesExample;
import com.xoado.FilingCabinet.bean.TblCurrentArchivesKey;

import java.util.LinkedHashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblCurrentArchivesMapper {
    int countByExample(TblCurrentArchivesExample example);

    int deleteByExample(TblCurrentArchivesExample example);

    int deleteByPrimaryKey(TblCurrentArchivesKey key);

    int insert(TblCurrentArchives record);

    int insertSelective(TblCurrentArchives record);

    List<TblCurrentArchives> selectByExample(TblCurrentArchivesExample example);

    List<LinkedHashMap<String,Object>> selectByExamplePage(String ownerid);

    TblCurrentArchives selectByPrimaryKey(TblCurrentArchivesKey key);

    int updateByExampleSelective(@Param("record") TblCurrentArchives record, @Param("example") TblCurrentArchivesExample example);

    int updateByExample(@Param("record") TblCurrentArchives record, @Param("example") TblCurrentArchivesExample example);

    int updateByPrimaryKeySelective(TblCurrentArchives record);

    int updateByPrimaryKey(TblCurrentArchives record);
}