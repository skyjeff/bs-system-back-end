package com.bssystem.commons.constant;

public class RedisKeys {
    // 缓存前缀
    public static final String CACHE_KEY_PREFIX = "CACHE:";

    // 后台管理系统-管理员
    public static final String CACHE_ADMIN = CACHE_KEY_PREFIX + "ADMIN";
    public static final String CACHE_ADMIN_LIST = CACHE_KEY_PREFIX + "ADMIN_LIST";
    // 后台管理系统-机构
    public static final String CACHE_OUTFIT = CACHE_KEY_PREFIX + "OUTFIT";
    public static final String CACHE_OUTFIT_LIST = CACHE_KEY_PREFIX + "OUTFIT_LIST";
    // 后台管理系统-新闻
    public static final String CACHE_NEWS = CACHE_KEY_PREFIX + "NEWS";
    public static final String CACHE_NEWS_LIST = CACHE_KEY_PREFIX + "NEWS_LIST";
    //后台管理系统-评论
    public static final String CACHE_REMARK = CACHE_KEY_PREFIX + "REMARK";
    public static final String CACHE_REMARK_LIST = CACHE_KEY_PREFIX + "REMARK_LIST";
    //后台管理系统-机构
    public static final String CACHE_OPERATOR = CACHE_KEY_PREFIX + "OPERATOR";
    public static final String CACHE_OPERATOR_LIST = CACHE_KEY_PREFIX + "OPERATOR_LIST";
    //后台管理系统-角色
    public static final String CACHE_ADMIN_ROLE = CACHE_KEY_PREFIX + "ADMIN_ROLE";
    public static final String CACHE_ADMIN_ROLE_LIST = CACHE_KEY_PREFIX + "ADMIN_ROLE_LIST";
}
