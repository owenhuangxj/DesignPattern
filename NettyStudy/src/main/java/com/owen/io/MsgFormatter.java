package com.owen.io;/**
 * @Author：Owen
 * @Package：com.owen.io
 * @Project：NettyStudy
 * @name：MsgFomatter
 * @Date：2022/11/20 15:56
 * @Filename：MsgFomatter
 */

import java.util.UUID;

/**
 * @author OwenHuang
 * @since 2022/11/20 15:56
 */
public class MsgFormatter {
    public static String format(UUID uuid, String msg) {
        return String.format(ChatroomConstants.CONTENT, uuid, msg);
    }
}
