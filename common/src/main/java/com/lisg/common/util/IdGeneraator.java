package com.lisg.common.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-07 14:57
 **/
public class IdGeneraator {

    // datacenterId 和 workerId 可根据部署情况动态配置
    private static final Snowflake snowflake = IdUtil.getSnowflake(1, 1);

    public static String generateOrderId() {
        return "1" + snowflake.nextId(); // 订单
    }

    public static String generateProductId() {
        return "2" + snowflake.nextId(); // 商品
    }

    public static String generateUserId() {
        return "3" + snowflake.nextId(); // 用户
    }

    public static void main(String[] args) {
        System.out.println(generateUserId());
        System.out.println(generateProductId());
        System.out.println(generateOrderId());
    }
}
