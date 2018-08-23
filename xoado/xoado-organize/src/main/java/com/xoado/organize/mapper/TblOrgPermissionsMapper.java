package com.xoado.organize.mapper;

import com.xoado.organize.bean.TblOrgPermissions;
import com.xoado.organize.bean.TblOrgPermissionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblOrgPermissionsMapper {
    int countByExample(TblOrgPermissionsExample example);

    int deleteByExample(TblOrgPermissionsExample example);

    int deleteByPrimaryKey(String permissionsid);

    int insert(TblOrgPermissions record);

    int insertSelective(TblOrgPermissions record);

    List<TblOrgPermissions> selectByExample(TblOrgPermissionsExample example);

    TblOrgPermissions selectByPrimaryKey(String permissionsid);

    int updateByExampleSelective(@Param("record") TblOrgPermissions record, @Param("example") TblOrgPermissionsExample example);

    int updateByExample(@Param("record") TblOrgPermissions record, @Param("example") TblOrgPermissionsExample example);

    int updateByPrimaryKeySelective(TblOrgPermissions record);

    int updateByPrimaryKey(TblOrgPermissions record);
}