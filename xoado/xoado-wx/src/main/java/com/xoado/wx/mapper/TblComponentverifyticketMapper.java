package com.xoado.wx.mapper;

import com.xoado.wx.bean.TblComponentverifyticket;
import com.xoado.wx.bean.TblComponentverifyticketExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblComponentverifyticketMapper {
    int countByExample(TblComponentverifyticketExample example);

    int deleteByExample(TblComponentverifyticketExample example);

    int deleteByPrimaryKey(String wx3AppId);

    int insert(TblComponentverifyticket record);

    int insertSelective(TblComponentverifyticket record);

    List<TblComponentverifyticket> selectByExample(TblComponentverifyticketExample example);

    TblComponentverifyticket selectByPrimaryKey(String wx3AppId);

    int updateByExampleSelective(@Param("record") TblComponentverifyticket record, @Param("example") TblComponentverifyticketExample example);

    int updateByExample(@Param("record") TblComponentverifyticket record, @Param("example") TblComponentverifyticketExample example);

    int updateByPrimaryKeySelective(TblComponentverifyticket record);

    int updateByPrimaryKey(TblComponentverifyticket record);
}