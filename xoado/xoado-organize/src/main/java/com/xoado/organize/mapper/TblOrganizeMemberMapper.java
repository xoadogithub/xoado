package com.xoado.organize.mapper;

import com.xoado.organize.bean.TblOrganizeMember;
import com.xoado.organize.bean.TblOrganizeMemberExample;
import com.xoado.organize.bean.TblOrganizeMemberKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblOrganizeMemberMapper {
    int countByExample(TblOrganizeMemberExample example);

    int deleteByExample(TblOrganizeMemberExample example);

    int deleteByPrimaryKey(TblOrganizeMemberKey key);

    int insert(TblOrganizeMember record);

    int insertSelective(TblOrganizeMember record);

    List<TblOrganizeMember> selectByExample(TblOrganizeMemberExample example);

    TblOrganizeMember selectByPrimaryKey(TblOrganizeMemberKey key);

    int updateByExampleSelective(@Param("record") TblOrganizeMember record, @Param("example") TblOrganizeMemberExample example);

    int updateByExample(@Param("record") TblOrganizeMember record, @Param("example") TblOrganizeMemberExample example);

    int updateByPrimaryKeySelective(TblOrganizeMember record);

    int updateByPrimaryKey(TblOrganizeMember record);
}