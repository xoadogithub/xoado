package com.xoado.authcenter.mapper;

import com.xoado.authcenter.bean.TblOrgPermissions;
import com.xoado.authcenter.bean.TblOrgPermissionsExample;
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