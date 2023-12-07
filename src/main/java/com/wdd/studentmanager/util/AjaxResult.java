package com.wdd.studentmanager.util;

/**
 * 此类用于封装返回结果
 * 包含操作成功标记、返回消息、图片URL和类型
 *
 * @Classname AjaxResult
 * @Description 用于ajax json返回数据的类
 * @Date 2019/6/25 10:21
 * @Created by WDD
 */
public class AjaxResult {
    private boolean success; // 操作是否成功
    private String message;  // 返回的消息
    private String imgurl;   // 图片的URL
    private String type;     // 返回数据的类型

    /**
     * 获取操作是否成功的标志
     *
     * @return 成功返回 true,失败返回 false
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * 设置操作成功的标志。
     *
     * @param success 成功为 true，失败为 false。
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * 获取返回消息
     *
     * @return 返回操作消息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置返回消息
     *
     * @param message 要设置的消息字符串
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取图片URL
     *
     * @return 图片的URL字符串
     */
    public String getImgurl() {
        return imgurl;
    }

    /**
     * 设置图片URL
     *
     * @param imgurl 要设置的图片URL字符串
     */
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    /**
     * 获取返回数据的类型
     *
     * @return 返回数据的类型字符串
     */
    public String getType() {
        return type;
    }

    /**
     * 设置返回数据的类型
     *
     * @param type 要设置的数据类型字符串
     */
    public void setType(String type) {
        this.type = type;
    }
}
