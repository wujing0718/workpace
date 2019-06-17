package com.huohougongfu.app.Utils;

/**
 * 发送广播接口
 * @author  cWX286335
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface IListener
{
    void notifyAllActivity(int audience_cnt, String status);
}
