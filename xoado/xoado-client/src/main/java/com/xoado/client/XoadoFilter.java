package com.xoado.client;


import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.xoado.protocol.AccessIdentity;

import com.xoado.protocol.XoadoConstant;

/*
 * 小多过滤器
 */

public class XoadoFilter implements Filter{
	/**
	 * 需要排除的path
	 */
	private String excludedPages;       
	private String[] excludedPageArray;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("项目创建启动过滤器");
//	项目创建启动过滤器
		/**/

		excludedPages = filterConfig.getInitParameter("excludedPages");
		if (StringUtils.isNotEmpty(excludedPages)) { 
			excludedPageArray = excludedPages.split(","); 
		}
		return;
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("dofilter");
		
		boolean isExcludedPage = false;
		for (String page : excludedPageArray) {
			if(((HttpServletRequest) request).getServletPath().equals(page)){ 
				isExcludedPage = true;
				break;
			}
		}
		if(isExcludedPage){
			chain.doFilter(request, response);  
		}else {
			
		}
		
		/**/
		
//		获取到httprequestsession
		 HttpServletRequest httpRequest = (HttpServletRequest)request;
		 
		 HttpServletResponse httpresponse =  (HttpServletResponse)response;
		 httpresponse.setCharacterEncoding("UTF-8");//解决中文乱码
		 httpRequest.setCharacterEncoding("UTF-8");
//		 处理日志
		 XoadoLog.getlog(httpRequest);
//		 获取token
		 AccessIdentity token = TokenVerify.verfiy(httpRequest, httpresponse);
		
		 System.out.println("过滤器中的token："+token);
		 if(token!=null){
//			 if(token.getUserType().equals(OrganizationStauts.CONTROLLED.getDescribe())){
//				 return;
//			 }
			try {
				 httpRequest.getSession().getServletContext().setAttribute(XoadoConstant.XOADOTOKEN, token);
				 chain.doFilter(httpRequest, httpresponse);
			} catch (Exception e) {
				e.printStackTrace();

			}
		 }else{
			 /*
			 PrintWriter out = response.getWriter();  
			 out.print("<script>alert('请重新登录');</script>");
			 out.close();
			 */
			 return;
		 }		
	}

	@Override
	public void destroy() {
		
		
	}

}
