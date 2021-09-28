package com.bssystem.commons.constant;

/**
 * redis前缀
 */
public class RedisPropName {
    /************************
     *     前缀
     ************************/

    // 消息
    public static final String PREFIX_MESSAGE = "MESSAGE: ";

    // websocket
    public static final String PREFIX_WEBSOCKET = "WEBSOCKET: ";

    //后台管理系统
    public static final String PREFIX_ADMIN = "ADMIN: ";

    // 缓存前缀
    public static final String CACHE_KEY_PREFIX = "CACHE:";

    // PC端
    public static final String PREFIX_PC = "PC: ";

    // WEB端
    public static final String PREFIX_WEB = "WEB: ";

    // 小程序端
    public static final String PREFIX_WECHAT = "WECHAT: ";

    // 在线授课
    public static final String PREFIX_ONLINE_CLASSROOM = "ONLINE_CLASSROOM: ";

    /************************
     *     活动信息
     ************************/
    // 短信
    public static final String TEL_MESSAGE_CODE_SET = PREFIX_MESSAGE + "tel_message_code_set_";
    // 邮箱验证码
    public static final String ACTIVITY_USER_MAIL_MESSAGE_CODE_SET = PREFIX_MESSAGE + "activity_user_mail_message_code_set_";
    // 邮箱链接
    public static final String BBKT_USER_MAIL_MESSAGE_LINK_SET = PREFIX_MESSAGE + "bbkt_user_mail_message_link_set_";
    // 微信formid
    public static final String MINI_PROGRAM_FORM_ID = PREFIX_MESSAGE + "mini_program_form_id_";
    // PC用户token
    public static final String PC_USER_TOKEN = PREFIX_PC + "pc_user_token_";
    // WEB用户token
    public static final String WEB_USER_TOKEN = PREFIX_WEB + "web_user_token_";
    // WECHAT用户token
    public static final String WECHAT_USER_TOKEN = PREFIX_WECHAT + "wechat_user_token_";

    /************************
     *     登录
     ************************/

    //登录操作码
    public static final String LOGIN_OPCODE = "LOGIN: login_operation_code_";

    //登录地理位置码，key为用户openid
    public static final String LOGIN_LOCATION_OPENID = "LOGIN: login_location_openid_";

    /************************
     *     后台管理系统      *
     ************************/
    //登录token
    public static final String ADMIN_TOKEN = PREFIX_ADMIN + "admin_token_";


    /************************
     *     WebSocket      *
     ************************/
    //某次在线授课的学生list（组播表）
    public static final String ONLINE_CLASSROOM_STU_LIST = PREFIX_ONLINE_CLASSROOM + "student_tid_";

//    //在线授课的总数
//    public static final String ONLINE_CLASSROOM_COUNT = PREFIX_ONLINE_CLASSROOM + "count";

    //某次在线授课的记录表
    public static final String ONLINE_CLASSROOM_LIST = PREFIX_ONLINE_CLASSROOM + "list";

    //某次在线授课的教师操作记录表
    public static final String ONLINE_CLASSROOM_OPERATE = PREFIX_ONLINE_CLASSROOM + "operate_tid_";

    //某次在线授课的签到情况
    public static final String ONLINE_CLASSROOM_SIGNIN = PREFIX_ONLINE_CLASSROOM + "sign_in_tid_";

    //某次在线授课的弹幕记录表
    public static final String ONLINE_CLASSROOM_BARRAGE = PREFIX_ONLINE_CLASSROOM + "barrage_tid_";
}

