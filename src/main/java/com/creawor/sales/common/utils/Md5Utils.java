package com.creawor.sales.common.utils;


import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Zero on 2017/3/20.
 * 密码加密
 */

public class Md5Utils {
    public static String encoderByMd5(String str) {
        MessageDigest md5 = null;
        String result = null;
        try {
            md5 = MessageDigest.getInstance("MD5");// MD5
            BASE64Encoder base64en = new BASE64Encoder();
            result = base64en.encode(md5.digest(str.getBytes("utf-8")));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
}
