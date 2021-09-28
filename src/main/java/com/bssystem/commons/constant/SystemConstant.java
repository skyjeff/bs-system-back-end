package com.bssystem.commons.constant;

/**
 * 系统级全局变量
 *
 * @author QuanQqqqq
 * @date: 2018-04-18
 */
public class SystemConstant {
    /**
     * token（暂时没有刷新自动token机制，通过重新登录获取）
     */
    public static final int RESCODE_REFTOKEN_MSG = 1006;        // 刷新TOKEN(有返回数据)
    public static final int RESCODE_REFTOKEN = 1007;            // 刷新TOKEN

    public static final int JWT_ERRCODE_NULL = 4000;            // Token不存在
    public static final int JWT_ERRCODE_EXPIRE = 4001;          // Token过期
    public static final int JWT_ERRCODE_FAIL = 4002;            // 验证不通过

    /**
     * JWT
     */
    public static final String JWT_SECRET = "bLAQ0yjzPha5oiIMMdMIvdY1d4HKeNos";            // 密钥
    public static final long JWT_TTL = 60 * 60 * 1000 * 2;                                 // token有效时间，两个小时
    public static final long JWT_TTL_LONG = 60 * 60 * 1000 * 24;                           // token 24小时

    /**
     * 秒级 TTL
     */
    public static final long SECOND_ONE_MINUTE = 60;                                       // 1分钟
    public static final long SECOND_ONE_HOUR_TTL = 60 * 60;                                // 1小时
    public static final long SECOND_ONE_DAY_TTL = 60 * 60 * 24;                            // 1天
    public static final long SECOND_ONE_MONTH_TTL = 60 * 60 * 24 * 30;                     // 30天 一个月

}