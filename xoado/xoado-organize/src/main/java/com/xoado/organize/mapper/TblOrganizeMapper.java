package com.xoado.organize.mapper;

import com.xoado.organize.bean.TblOrganize;
import com.xoado.organize.bean.TblOrganizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblOrganizeMapper {
    int countByExample(TblOrganizeExample example);

    int deleteByExample(TblOrganizeExample example);

    int deleteByPrimaryKey(String organizeid);

    int insert(TblOrganize record);

    int insertSelective(TblOrganize record);

    List<TblOrganize> selectByExample(TblOrganizeExample example);

    TblOrganize selectByPrimaryKey(String organizeid);

    int updateByExampleSelective(@Param("record") TblOrganize record, @Param("example") TblOrganizeExample example);

    int updateByExample(@Param("record") TblOrganize record, @Param("example") TblOrganizeExample example);

    int updateByPrimaryKeySelective(TblOrganize record);

    int updateByPrimaryKey(TblOrganize record);
}