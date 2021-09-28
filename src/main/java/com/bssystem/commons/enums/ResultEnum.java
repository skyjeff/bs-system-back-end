package com.bssystem.commons.enums;

import lombok.Getter;

/**
 * @Description: 枚举异常错误码和错误提示
 * @Author: Shawn Van
 * @CreateDate: 2019/04/12 下午 06:47
 */
@Getter
public enum ResultEnum {

    SUCCESS(200, "操作成功"),

    INSERT_FAIL(400, "新增失败"),
    QUERY_NO_PERMISSION(400, "无操作权限"),
    BAN_OPERATION(400, "默认资源不允操作"),
    QUERY_NOT_EXIT(400, "查询对象为空"),
    DELETE_FAIL(400, "删除失败"),
    UPDATE_FAIL(400, "更新失败"),
    INSERT_SUCCESS(200, "新增成功"),
    DELETE_SUCCESS(200, "删除成功"),
    UPDATE_SUCCESS(200, "更新成功"),
    QUERY_SUCCESS(200, "查询成功"),
    NOT_DEL_EQUAL_AUTH(400, "无法对同等权限对象进行操作"),
    /**
     * http请求状态码封装
     */
    NOT_MODIFIED(304, "未修改"),
    BAD_REQUEST(400, "请求出错"),
    UNAUTHORIZED(401, "用户没有登录"),
    FORBIDDEN(403, "用户没有权限"),
    NOT_FOUND(404, "资源未找到"),
    METHOD_NOT_ALLOWED(405, "客户端请求中的方法被禁止"),
    REQUEST_OVERTIME(408, "请求超时"),
    UNSUPPORTED_MEDIA_TYPE(415, "服务器无法处理请求附带的媒体格式"),
    INTERNAL_SERVER_ERROR(500, "后台异常"),
    NEED_CONTINUE_OPERATE(100, "请用户继续操作"),
    INTERFACE_NOT_FINISH(1000, "接口未实现"),
    ENTITY_PARAM_ERROR(1001, "参数错误"),
    AUTH_CODE_ERROR(1002, "验证码错误"),
    /**
     *
     */
    HOME_REMARK_NOT_EXIT(0, "该评论不存在"),
    HOME_REMARK_NOT_SHOW(1, "该评论不允许展示"),
    HOME_REMARK_SUCCESS(2, "获取指定评论成功"),
    HOME_REMARK_FAIL(3, "获取指定评论失败"),
    HOME_REMARK_LIST_SUCCESS(4, "获取指定评论列表成功"),
    HOME_REMARK_LIST_FAIL(5, "获取指定评论列表失败"),
    INSERT_REMARK_FAIL(6, "创建评论失败"),
    INSERT_REMARK_SUCCESS(7, "创建评论成功"),
    DELETE_REMARK_FAIL(8, "删除评论失败"),
    DELETE_REMARK_SUCCESS(9, "删除评论成功"),
    BATCH_DELETE_REMARK_FAIL(10, "批量删除评论失败"),
    BATCH_DELETE_REMARK_SUCCESS(11, "批量删除评论成功"),
    UPDATE_REMARK_FAIL(12, "更新评论失败"),
    UPDATE_REMARK_SUCCESS(13, "更新评论成功"),
    SHOW_ALL_REMARK_FAIL(14, "获取所有评论失败"),
    SHOW_ALL_REMARK_SUCCESS(15, "获取所有评论成功"),
    HOME_DEFAULT_REMARK_LIST_SUCCESS(16, "获取默认评论列表成功"),
    HOME_DEFAULT_REMARK_LIST_FAIL(17, "获取默认评论列表失败"),

    HOME_NEWS_NOT_EXIT(18, "该新闻不存在"),
    HOME_NEWS_NOT_SHOW(19, "该新闻不允许展示"),
    HOME_NEWS_SUCCESS(20, "获取指定新闻成功"),
    HOME_NEWS_FAIL(21, "获取指定评论失败"),
    HOME_NEWS_LIST_SUCCESS(22, "获取指定新闻列表成功"),
    HOME_NEWS_LIST_FAIL(23, "获取指定评论列表失败"),
    INSERT_NEWS_FAIL(24, "创建新闻失败"),
    INSERT_NEWS_SUCCESS(25, "创建新闻成功"),
    DELETE_NEWS_FAIL(26, "删除新闻失败"),
    DELETE_NEWS_SUCCESS(27, "删除新闻成功"),
    BATCH_DELETE_NEWS_FAIL(28, "批量删除新闻失败"),
    BATCH_DELETE_NEWS_SUCCESS(29, "批量删除新闻成功"),
    UPDATE_NEWS_FAIL(30, "更新新闻失败"),
    UPDATE_NEWS_SUCCESS(31, "更新新闻成功"),
    SHOW_ALL_NEWS_FAIL(32, "获取所有新闻失败"),
    SHOW_ALL_NEWS_SUCCESS(33, "获取所有新闻成功"),
    HOME_DEFAULT_NEWS_LIST_SUCCESS(34, "获取默认新闻列表成功"),
    HOME_DEFAULT_NEWS_LIST_FAIL(35, "获取默认新闻列表失败"),

    ADMIN_NOT_EXIT(36, "该管理员账号不存在"),
    ADMIN_NOT_SHOW(37, "该管理员账号已被冻结"),
    ADMIN_SUCCESS(38, "查询管理员成功"),
    ADMIN_FAIL(39, "查询管理员失败"),
    ADMIN_LOGIN_SUCCESS(40, "管理员登录成功"),
    ADMIN_LOGIN_FAIL(41, "查询管理员失败"),
    INSERT_ADMIN_FAIL(42, "新增管理员失败"),
    INSERT_ADMIN_SUCCESS(42, "新增管理员成功"),
    DELETE_ADMIN_FAIL(43, "删除管理员失败"),
    DELETE_ADMIN_SUCCESS(44, "删除管理员成功"),
    BATCH_DELETE_ADMIN_FAIL(45, "批量删除管理员失败"),
    BATCH_DELETE_ADMIN_SUCCESS(46, "批量删除管理员成功"),
    UPDATE_ADMIN_FAIL(47, "更新管理员失败"),
    UPDATE_ADMIN_SUCCESS(48, "更新管理员成功"),
    SHOW_ALL_ADMIN_FAIL(49, "获取所有管理员列表失败"),
    SHOW_ALL_ADMIN_SUCCESS(50, "获取所有管理员列表成功"),
    SHOW_RELATED_ADMIN_FAIL(51, "获取相关管理员列表失败"),
    SHOW_RELATED_ADMIN_SUCCESS(52, "获取相关管理员列表成功"),

    OUTFIT_NOT_EXIT(53, "该机构不存在"),
    OUTFIT_SUCCESS(54, "查询机构成功"),
    OUTFIT_FAIL(55, "查询机构失败"),
    INSERT_OUTFIT_FAIL(56, "新增机构失败"),
    INSERT_OUTFIT_SUCCESS(57, "新增机构成功"),
    DELETE_OUTFIT_FAIL(58, "删除机构失败"),
    DELETE_OUTFIT_SUCCESS(59, "删除机构成功"),
    BATCH_DELETE_OUTFIT_FAIL(60, "批量删除机构失败"),
    BATCH_DELETE_OUTFIT_SUCCESS(61, "批量删除机构成功"),
    UPDATE_OUTFIT_FAIL(62, "更新机构失败"),
    UPDATE_OUTFIT_SUCCESS(63, "更新机构成功"),
    SHOW_ALL_OUTFIT_FAIL(64, "获取所有机构列表失败"),
    SHOW_ALL_OUTFIT_SUCCESS(65, "获取所有机构列表成功"),

    CITY_NOT_EXIT(66, "该城市不存在"),
    CITY_SUCCESS(67, "查询城市成功"),
    CITY_FAIL(68, "查询城市失败"),

    ADMIN_ROLE_NOT_EXIT(69, "该角色不存在"),
    ADMIN_ROLE_SUCCESS(70, "查询角色成功"),
    ADMIN_ROLE_FAIL(71, "查询角色失败"),
    INSERT_ADMIN_ROLE_FAIL(72, "新增角色失败"),
    INSERT_ADMIN_ROLE_SUCCESS(73, "新增角色成功"),
    DELETE_ADMIN_ROLE_FAIL(74, "删除角色失败"),
    DELETE_ADMIN_ROLE_SUCCESS(75, "删除角色成功"),
    UPDATE_ADMIN_ROLE_FAIL(76, "更新角色失败"),
    UPDATE_ADMIN_ROLE_SUCCESS(78, "更新角色成功"),
    SHOW_ALL_ADMIN_ROLE_FAIL(79, "获取所有角色列表失败"),
    SHOW_ALL_ADMIN_ROLE_SUCCESS(80, "获取所有角色列表成功"),
    ADMIN_USER_ROLE_FAIL(81, "查找用户角色关联失败"),

    SUBMIT_PAPER_TIME_OUT(82, "提交试卷已超时"),
    UID_NONE_SUBMIT_RIGHT(83, "该用户已提交过该事件，无再次提交权限"),
    UP_SECONDARY_ADMIN_SUCCESS(200, "升级二级管理员权限成功"),

    /**
     * 公众号返回信息
     */
    UNSUBSCRIBE_MP(2000, "还未关注公众号"),
    ERROR_KEYWORD(2001, "邀请码错误"),
    ALREADY_IN_CLASS(2002, "您已加入班级,不可重复添加"),
    ONLINE_CLASS(2003, "加入班级成功，当前班级正在上课呢"),
    NEED_INFO(2004, "需要填写信息"),
    JOIN_CLASS_SUCCESS(2005, "成功加入班级"),

    /**
     *
     */
    INSUFFICIENT_PRIVILEGE(1512, "权限不足"),
    ALREADY_HIGHEST_PRIVILEGE(1513, "已是最高权限无需升级"),
    ADMIN_USER_ROLE_PERMISSIONS_FAIL(1514, "查无此角色权限"),

    LESSON_NULL(1600, "您还未发布习题"),

    ;
    private Integer code;
    private String message;

    ResultEnum(String message) {
        this.message = message;
    }

    ResultEnum(Integer code) {
        this.code = code;
    }

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getMessageByCode(int code) {
        for (ResultEnum enums : ResultEnum.values()) {
            if (code == enums.getCode()) {
                return enums.getMessage();
            }
        }
        return null;
    }
}
