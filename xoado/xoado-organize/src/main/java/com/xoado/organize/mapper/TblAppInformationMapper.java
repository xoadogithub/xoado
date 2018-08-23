package com.xoado.organize.mapper;

import com.xoado.organize.bean.TblAppInformation;
import com.xoado.organize.bean.TblAppInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblAppInformationMapper {
    int countByExample(TblAppInformationExample example);

    int deleteByExample(TblAppInformationExample example);

    int deleteByPrimaryKey(String appId);

    int insert(TblAppInformation record);

    int insertSelective(TblAppInformation record);

    List<TblAppInformation> selectByExample(TblAppInformationExample example);

    TblAppInformation selectByPrimaryKey(String appId);

    int updateByExampleSelective(@Param("record") TblAppInformation record, @Param("example") TblAppInformationExample example);

    int updateByExample(@Param("record") TblAppInformation record, @Param("example") TblAppInformationExample example);

    int updateByPrimaryKeySelective(TblAppInformation record);

    int updateByPrimaryKey(TblAppInformation record);
}