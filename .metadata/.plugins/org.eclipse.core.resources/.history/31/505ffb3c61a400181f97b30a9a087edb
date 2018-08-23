package com.xoado.tools.mapper;

import com.xoado.tools.bean.TblExpress;
import com.xoado.tools.bean.TblExpressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblExpressMapper {
    int countByExample(TblExpressExample example);

    int deleteByExample(TblExpressExample example);

    int deleteByPrimaryKey(String companyid);

    int insert(TblExpress record);

    int insertSelective(TblExpress record);

    List<TblExpress> selectByExample(TblExpressExample example);

    TblExpress selectByPrimaryKey(String companyid);

    int updateByExampleSelective(@Param("record") TblExpress record, @Param("example") TblExpressExample example);

    int updateByExample(@Param("record") TblExpress record, @Param("example") TblExpressExample example);

    int updateByPrimaryKeySelective(TblExpress record);

    int updateByPrimaryKey(TblExpress record);
}