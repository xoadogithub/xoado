package com.xoado.wx.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xoado.common.XoadoResult;
import com.xoado.wx.service.ITheMenu;
import com.xoado.wx.wxbean.Button;
import com.xoado.wx.wxbean.CommonButton;
import com.xoado.wx.wxbean.ComplexButton;
import com.xoado.wx.wxbean.Menu;
import com.xoado.wx.wxbean.ViewButton;
import com.xoado.wx.wxbean.WeixinU;

/**
* @author 作者
* @version 创建时间：2018年6月26日 下午2:14:36
* 类说明
*/
@Service
public class TheMenu implements ITheMenu{
	
	private static final Logger logger = Logger.getLogger(TheMenu.class);

	@Override
	public XoadoResult MenuManager(HttpServletRequest request, HttpServletResponse response) {
		
		String access_token =(String) request.getSession().getServletContext().getAttribute("authorizer_access_token");
		
		if(access_token!=null){
			
			Menu menu = getMenu();
			
			int result  = WeixinU.createMenu(menu, access_token);
			
			if (0 == result) {
				
				logger.info("菜单创建成功！");
				
				return XoadoResult.build(200, "菜单创建成功");
			}
			
		}
		return XoadoResult.build(202, "菜单创建失败");
	}
	
	private static Menu getMenu() {
		 ViewButton btn11 = new ViewButton();
	        btn11.setName("查询账单");  
	        btn11.setType("view");  
	        btn11.setKey("11"); 
	        btn11.setUrl("http://www.baidu.com");
	  
	        CommonButton btn12 = new CommonButton(); 
	        btn12.setName("查看物流");  
	        btn12.setType("click");  
	        btn12.setKey("12"); 
	      
	  
	        ViewButton btn13 = new ViewButton();  
	        btn13.setName("周边搜索");  
	        btn13.setType("view");  
	        btn13.setKey("13"); 
	        btn13.setUrl("http://www.baidu.com");
	  
	        ViewButton btn14 = new ViewButton(); 
	        btn14.setName("扫一扫");  
	        btn14.setType("view");  
	        btn14.setKey("14");
	        btn14.setUrl("http://www.baidu.com");
	  
	        CommonButton btn21 = new CommonButton();  
	        btn21.setName("点歌");  
	        btn21.setType("click");  
	        btn21.setKey("21");  
	  
	        CommonButton btn22 = new CommonButton();  
	        btn22.setName("快递服务");  
	        btn22.setType("click");  
	        btn22.setKey("22");  
	  
	        CommonButton btn23 = new CommonButton();  
	        btn23.setName("电台");  
	        btn23.setType("click");  
	        btn23.setKey("23");  
	  
	        CommonButton btn24 = new CommonButton();  
	        btn24.setName("人脸识别");  
	        btn24.setType("click");  
	        btn24.setKey("24");  
	  
	        CommonButton btn25 = new CommonButton();  
	        btn25.setName("聊天唠嗑");  
	        btn25.setType("click");  
	        btn25.setKey("25");  
	  
	        
	        CommonButton btn31 = new CommonButton();  
	        btn31.setName("我的朋友圈");  
	        btn31.setType("click");  
	        btn31.setKey("31");  
	  
	        CommonButton btn32 = new CommonButton();  
	        btn32.setName("电影");  
	        btn32.setType("click");  
	        btn32.setKey("32");  
	  
	        CommonButton btn33 = new CommonButton();  
	        btn33.setName("联系客服");  
	        btn33.setType("click");  
	        btn33.setKey("33");  
	  
	        ComplexButton mainBtn1 = new ComplexButton();  
	        mainBtn1.setName("生活助手");  
	        mainBtn1.setSub_button(new Button[] { btn11, btn12, btn13, btn14 });  
	  
	        ComplexButton mainBtn2 = new ComplexButton();  
	        
	        mainBtn2.setName("休闲驿站");  
	        mainBtn2.setSub_button(new CommonButton[] { btn21, btn22, btn23, btn24, btn25 });  
	  
	        ComplexButton mainBtn3 = new ComplexButton();  
	        mainBtn3.setName("更多体验");  
	        mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33 });  
	  		
	       
	        Menu menu = new Menu();  
	        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });  
	  
	        return menu;  
		
	}

}
