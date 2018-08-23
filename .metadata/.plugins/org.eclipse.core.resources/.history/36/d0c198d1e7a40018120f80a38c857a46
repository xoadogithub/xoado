package com.xoado.tools.mapper;

import com.xoado.tools.bean.TblBoxes;
import com.xoado.tools.bean.TblBoxesExample;
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

    int updateByExampleSelective(@Param("record") TblBoxes record, @Param("example") TblBoxesExample example);

    int updateByExample(@Param("record") TblBoxes record, @Param("example") TblBoxesExample example);

    int updateByPrimaryKeySelective(TblBoxes record);

    int updateByPrimaryKey(TblBoxes record);
}