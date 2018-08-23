package com.xoado.organize.mapper;

import com.xoado.organize.bean.TblUserRolePermissions;
import com.xoado.organize.bean.TblUserRolePermissionsExample;
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