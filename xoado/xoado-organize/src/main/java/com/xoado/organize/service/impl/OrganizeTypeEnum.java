package com.xoado.organize.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xoado.common.XoadoResult;
import com.xoado.protocol.OrganizeType;

import net.sf.json.JSONArray;

/**
* @author 作者
* @version 创建时间：2018年7月10日 上午10:54:21
* 类说明
*/
public class OrganizeTypeEnum {
	
	/**
	 * 展示组织的类型
	 */
	public static XoadoResult orgType(){
		JSONArray array = new JSONArray();
		for (OrganizeType e : OrganizeType.values()) {
			JSONObject object = new JSONObject();
			object.put("typeId", e.getStauts());
            object.put("typeName", e.getDescribe());
            array.add(object);
		}
		return XoadoResult.build(0, "组织类型",array);
	}

}
