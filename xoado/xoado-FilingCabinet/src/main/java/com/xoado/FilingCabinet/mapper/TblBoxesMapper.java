package com.xoado.FilingCabinet.mapper;

import com.xoado.FilingCabinet.bean.TblBoxes;
import com.xoado.FilingCabinet.bean.TblBoxesExample;

import java.util.LinkedHashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblBoxesMapper {
    int countByExample(TblBoxesExample example);

    int deleteByExample(TblBoxesExample example);

    int deleteByPrimaryKey(String boxId);

    int insert(TblBoxes record);

    int insertSelective(TblBoxes record);

    List<TblBoxes> selectByExample(TblBoxesExample example);

    TblBoxes selectByPrimaryKey(String boxId);
    
    List<LinkedHashMap<String, Object>> selectGis(String sql);

    int updateByExampleSelective(@Param("record") TblBoxes record, @Param("example") TblBoxesExample example);

    int updateByExample(@Param("record") TblBoxes record, @Param("example") TblBoxesExample example);

    int updateByPrimaryKeySelective(TblBoxes record);

    int updateByPrimaryKey(TblBoxes record);
}