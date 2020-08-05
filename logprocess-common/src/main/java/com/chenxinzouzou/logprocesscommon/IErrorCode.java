package com.chenxinzouzou.logprocesscommon;

/**
 * 封装API的错误码
 *
 * @author ：chenxin
 * @date ：Created in 2020/6/20 14:51
 */
public interface IErrorCode {
    /**
     * 获取状态码
     *
     * @return long 状态码
     * @author chenxin
     * @date 2020/6/20 16:54
     **/
    long getCode();

    /**
     * 获取消息信息
     *
     * @return java.lang.String 消息信息
     * @author chenxin
     * @date 2020/6/20 16:54
     **/
    String getMessage();
}
