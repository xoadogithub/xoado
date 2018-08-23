package com.xoado.wx.common;
/**
* @author 作者
* @version 创建时间：2018年6月26日 上午10:20:40
* 类说明  解析xml
*/

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 * 
 * @author 80665
 *  Xml解析
 */

public class XmlParsing {
	/**
	 * 
	 * @param result  xml
	 * @return
	 */
	public static Map<String, String> ToXml(String result){
		
		 Map<String, String> data = new HashMap<String, String>();	
		
		try {
			 DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			 
			 DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			 
			 InputStream stream = new ByteArrayInputStream(result.getBytes("UTF-8"));
			 
			 Document doc = documentBuilder.parse(stream);
			 
			 doc.getDocumentElement().normalize();
			 
			 NodeList nodeList = doc.getDocumentElement().getChildNodes();
			 
			 for (int idx = 0; idx < nodeList.getLength(); ++idx) {
				 
				 Node node = nodeList.item(idx);
				 
				 if (node.getNodeType() == Node.ELEMENT_NODE) {
					 
					 Element element = (Element) node;
					 
					 data.put(element.getNodeName(), element.getTextContent());
					 
				 }
			 }
		} catch (Exception e) {
			
		}
		
		return data;
		
	}

}
