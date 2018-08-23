package com.xoado.common;

import java.security.MessageDigest;


/**
 * User: rizenguo
 * Date: 2014/10/23
 * Time: 15:43
 */
public class MD5 {
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * 转换字节数组为16进制字串
     * @param b 字节数组
     * @return 16进制字串
     */
    public static String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /**
     * 转换byte到16进制
     * @param b 要转换的byte
     * @return 16进制格式
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * MD5编码
     * @param origin 原始字符串
     * @return 经过MD5加密之后的结果
     */
    public static String MD5Encode(String origin) {
    	
        String resultString = null;
        try {
        	resultString = new String(origin);
        	 MessageDigest md = MessageDigest.getInstance("MD5");
        	 resultString = byteArrayToHexString(md.digest(resultString .getBytes()));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return resultString;
    }
 public static boolean isValidate(String input,String output){
        
        boolean status = false;
        
        if(MD5.MD5Encode(input).equals(output)){
            status = true;
        }else{
            status = false;
        }
        
        return status;
    }
	
//	 // 全局数组
//    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
//            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
//
//    public MD5() {
//    }
//
//    // 返回形式为数字跟字符串
//    private static String byteToArrayString(byte bByte) {
//        int iRet = bByte;
//        // System.out.println("iRet="+iRet);
//        if (iRet < 0) {
//            iRet += 256;
//        }
//        int iD1 = iRet / 16;
//        int iD2 = iRet % 16;
//        return strDigits[iD1] + strDigits[iD2];
//    }
//
//    // 返回形式只为数字
//    private static String byteToNum(byte bByte) {
//        int iRet = bByte;
//        System.out.println("iRet1=" + iRet);
//        if (iRet < 0) {
//            iRet += 256;
//        }
//        return String.valueOf(iRet);
//    }
//
//    // 转换字节数组为16进制字串
//    private static String byteToString(byte[] bByte) {
//        StringBuffer sBuffer = new StringBuffer();
//        for (int i = 0; i < bByte.length; i++) {
//            sBuffer.append(byteToArrayString(bByte[i]));
//        }
//        return sBuffer.toString();
//    }
//
//    public static String GetMD5Code(String strObj) {
//        String resultString = null;
//        try {
//            resultString = new String(strObj);
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            // md.digest() 该函数返回值为存放哈希值结果的byte数组
//            resultString = byteToString(md.digest(strObj.getBytes()));
//        } catch (NoSuchAlgorithmException ex) {
//            ex.printStackTrace();
//        }
//        return resultString;
//    }
//
//    public static void main(String[] args) {
//        MD5 getMD5 = new MD5();
//        System.out.println(getMD5.GetMD5Code("000000"));
//    }

}

