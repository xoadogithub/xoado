package com.xoado.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class XoadoResult {
private static final ObjectMapper mapper = new ObjectMapper();
	
	private Integer status;
	
	private String msg;
	
	private Object data;
	
	
	
	public static XoadoResult build(Integer status, String msg, Object data) {
	        return new XoadoResult(status, msg, data);
	    }
	 public static XoadoResult ok(Object data) {
	        return new XoadoResult(data);
	    }
	 public static XoadoResult ok() {
	        return new XoadoResult(null);
	    }
	 
	 public static XoadoResult build(Integer status, String msg) {
	        return new XoadoResult(status, msg, null);
	    }
	 
	 
	 	
	 
	    public XoadoResult(Integer status, String msg, Object data) {
	        this.status = status;
	        this.msg = msg;
	        this.data = data;
	    }
	    public XoadoResult(Object data) {
	        this.status = 200;
	        this.msg = "CODE_SUCCESS";
	        this.data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	       
	    }

	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static ObjectMapper getMapper() {
		return mapper;
	}
	
	  public static XoadoResult formatToPojo(String jsonData, Class<?> clazz) {
	        try {
	            if (clazz == null) {
	                return mapper.readValue(jsonData, XoadoResult.class);
	            }
	            JsonNode jsonNode = mapper.readTree(jsonData);
	            JsonNode data = jsonNode.get("data");
	            Object obj = null;
	            if (clazz != null) {
	                if (data.isObject()) {
	                    obj = mapper.readValue(data.traverse(), clazz);
	                } else if (data.isTextual()) {
	                    obj = mapper.readValue(data.asText(), clazz);
	                }
	            }
	            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
	        } catch (Exception e) {
	            return null;
	        }
	    }
	  
	  /**
	     * 没有object对象的转化
	     * 
	     * @param json
	     * @return
	     */
	    public static XoadoResult format(String json) {
	        try {
	            return mapper.readValue(json, XoadoResult.class);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	    /**
	     * Object是集合转化
	     * 
	     * @param jsonData json数据
	     * @param clazz 集合中的类型
	     * @return
	     */
	    public static XoadoResult formatToList(String jsonData, Class<?> clazz) {
	        try {
	            JsonNode jsonNode = mapper.readTree(jsonData);
	            JsonNode data = jsonNode.get("data");
	            Object obj = null;
	            if (data.isArray() && data.size() > 0) {
	                obj = mapper.readValue(data.traverse(),
	                		mapper.getTypeFactory().constructCollectionType(List.class, clazz));
	            }
	            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
	        } catch (Exception e) {
	            return null;
	        }
	    }



}
