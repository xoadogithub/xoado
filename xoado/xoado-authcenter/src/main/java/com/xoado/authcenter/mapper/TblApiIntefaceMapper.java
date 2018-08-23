package com.xoado.authcenter.mapper;

import com.xoado.authcenter.bean.TblApiInteface;
import com.xoado.authcenter.bean.TblApiIntefaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblApiIntefaceMapper {
    int countByExample(TblApiIntefaceExample example);

    int deleteByExample(TblApiIntefaceExample example);

    int deleteByPrimaryKey(String apiId);

    int insert(TblApiInteface record);

    int insertSelective(TblApiInteface record);

    List<TblApiInteface> selectByExample(TblApiIntefaceExample example);

    TblApiInteface selectByPrimaryKey(String apiId);

    int updateByExampleSelective(@Param("record") TblApiInteface record, @Param("example") TblApiIntefaceExample example);

    int updateByExample(@Param("record") TblApiInteface record, @Param("example") TblApiIntefaceExample example);

    int updateByPrimaryKeySelective(TblApiInteface record);

    int updateByPrimaryKey(TblApiInteface record);
}