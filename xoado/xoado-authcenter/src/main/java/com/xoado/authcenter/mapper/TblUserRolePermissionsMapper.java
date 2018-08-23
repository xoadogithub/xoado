package com.xoado.authcenter.mapper;

import com.xoado.authcenter.bean.TblUserRolePermissions;
import com.xoado.authcenter.bean.TblUserRolePermissionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblUserRolePermissionsMapper {
    int countByExample(TblUserRolePermissionsExample example);

    int deleteByExample(TblUserRolePermissionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblUserRolePermissions record);

    int insertSelective(TblUserRolePermissions record);

    List<TblUserRolePermissions> selectByExample(TblUserRolePermissionsExample example);

    TblUserRolePermissions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblUserRolePermissions record, @Param("example") TblUserRolePermissionsExample example);

    int updateByExample(@Param("record") TblUserRolePermissions record, @Param("example") TblUserRolePermissionsExample example);

    int updateByPrimaryKeySelective(TblUserRolePermissions record);

    int updateByPrimaryKey(TblUserRolePermissions record);
}