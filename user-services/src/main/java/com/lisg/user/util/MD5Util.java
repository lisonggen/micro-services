package com.lisg.user.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-10 17:20
 **/
public class MD5Util {

    private static final String SALT = "micro-services";

    public static String getPassword(String password) {
        // DigestUtils.md5Hex()此方法为加密方法
        String passwordMd5Hex = DigestUtils.md5Hex(password);
        //此处加密后加盐再进行加密
        return DigestUtils.md5Hex(passwordMd5Hex+SALT);
    }
}
