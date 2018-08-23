package com.xoado.client.http;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Paging {
	
private long total;
	
	private List<?> rows;
	
	private Map<String, Object> a = new HashMap<String ,Object>();

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public Map<String, Object> getA() {
		return a;
	}

	public void setA(Map<String, Object> a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "Paging [total=" + total + ", rows=" + rows + ", a=" + a + "]";
	}


}
