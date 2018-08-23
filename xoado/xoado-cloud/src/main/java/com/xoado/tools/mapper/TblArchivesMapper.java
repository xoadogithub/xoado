package com.xoado.tools.mapper;

import com.xoado.tools.bean.TblArchives;
import com.xoado.tools.bean.TblArchivesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblArchivesMapper {
    int countByExample(TblArchivesExample example);

    int deleteByExample(TblArchivesExample example);

    int deleteByPrimaryKey(String archiveId);

    int insert(TblArchives record);

    int insertSelective(TblArchives record);

    List<TblArchives> selectByExample(TblArchivesExample example);

    TblArchives selectByPrimaryKey(String archiveId);

    int updateByExampleSelective(@Param("record") TblArchives record, @Param("example") TblArchivesExample example);

    int updateByExample(@Param("record") TblArchives record, @Param("example") TblArchivesExample example);

    int updateByPrimaryKeySelective(TblArchives record);

    int updateByPrimaryKey(TblArchives record);
}