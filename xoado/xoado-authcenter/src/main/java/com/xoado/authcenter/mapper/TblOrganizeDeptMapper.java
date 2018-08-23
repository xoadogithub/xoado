package com.xoado.authcenter.mapper;

import com.xoado.authcenter.bean.TblOrganizeDept;
import com.xoado.authcenter.bean.TblOrganizeDeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblOrganizeDeptMapper {
    int countByExample(TblOrganizeDeptExample example);

    int deleteByExample(TblOrganizeDeptExample example);

    int deleteByPrimaryKey(String deptid);

    int insert(TblOrganizeDept record);

    int insertSelective(TblOrganizeDept record);

    List<TblOrganizeDept> selectByExample(TblOrganizeDeptExample example);

    TblOrganizeDept selectByPrimaryKey(String deptid);

    int updateByExampleSelective(@Param("record") TblOrganizeDept record, @Param("example") TblOrganizeDeptExample example);

    int updateByExample(@Param("record") TblOrganizeDept record, @Param("example") TblOrganizeDeptExample example);

    int updateByPrimaryKeySelective(TblOrganizeDept record);

    int updateByPrimaryKey(TblOrganizeDept record);
}