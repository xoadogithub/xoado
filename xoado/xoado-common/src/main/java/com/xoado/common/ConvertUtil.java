package com.xoado.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
* @author 作者
* @version 创建时间：2018年8月7日 下午3:55:47
* 类说明
*/
public class ConvertUtil {
	 //inputStream转outputStream
    public ByteArrayOutputStream parse(InputStream in) throws Exception
    {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        int ch;
        while ((ch = in.read()) != -1) {   
            swapStream.write(ch);   
        }
        return swapStream;
    }
    //outputStream转inputStream
    public ByteArrayInputStream parse(OutputStream out) throws Exception
    {
        ByteArrayOutputStream   baos=new   ByteArrayOutputStream();
        baos=(ByteArrayOutputStream) out;
        ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
        return swapStream;
    }
    //inputStream转String
    public String parse_String(InputStream in) throws Exception
    {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        int ch;
        while ((ch = in.read()) != -1) {   
            swapStream.write(ch);   
        }
        return swapStream.toString();
    }
    //OutputStream 转String
    public String parse_String(OutputStream out)throws Exception
    {
        ByteArrayOutputStream   baos=new   ByteArrayOutputStream();
        baos=(ByteArrayOutputStream) out;
        ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
        return swapStream.toString();
    }
    //String转inputStream
    public ByteArrayInputStream parse_inputStream(String in)throws Exception
    {
        ByteArrayInputStream input=new ByteArrayInputStream(in.getBytes());
        return input;
    }
    //String 转outputStream
    public ByteArrayOutputStream parse_outputStream(String in)throws Exception
    {
        return parse(parse_inputStream(in));
    }
}
