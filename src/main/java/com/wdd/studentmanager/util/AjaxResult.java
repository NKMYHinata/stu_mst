package com.wdd.studentmanager.util;

/**
 * 此类用于封装返回结果
 * 包含操作成功标记、返回消息、图片URL和类型
 *
 * @Classname AjaxResult
 * @Description 用于ajax json返回数据的类
 * @Date 2023/11/25 10:21
 * @Created
 */
public class AjaxResult {
    private boolean success; // 操作是否成功
    private String message;  // 返回的消息
    private String imgurl;   // 图片的URL
    private String type;     // 返回数据的类型

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
