package com.xoado.authcenter.mapper;

import com.xoado.authcenter.bean.TblWeixinUser;
import com.xoado.authcenter.bean.TblWeixinUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblWeixinUserMapper {
    int countByExample(TblWeixinUserExample example);

    int deleteByExample(TblWeixinUserExample example);

    int deleteByPrimaryKey(String openid);

    int insert(TblWeixinUser record);

    int insertSelective(TblWeixinUser record);

    List<TblWeixinUser> selectByExample(TblWeixinUserExample example);

    TblWeixinUser selectByPrimaryKey(String openid);

    int updateByExampleSelective(@Param("record") TblWeixinUser record, @Param("example") TblWeixinUserExample example);

    int updateByExample(@Param("record") TblWeixinUser record, @Param("example") TblWeixinUserExample example);

    int updateByPrimaryKeySelective(TblWeixinUser record);

    int updateByPrimaryKey(TblWeixinUser record);
}