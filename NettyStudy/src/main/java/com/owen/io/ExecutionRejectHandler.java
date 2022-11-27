package com.owen.io;/**
 * @Author：Owen
 * @Package：com.owen.io
 * @Project：NettyStudy
 * @name：ExecutionRejectHandler
 * @Date：2022/11/27 13:33
 * @Filename：ExecutionRejectHandler
 */

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author OwenHuang
 * @since 2022/11/27 13:33
 */
public class ExecutionRejectHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
        System.out.println("Task " + runnable + " has been rejected....................");
    }
}
