package com.owen.io;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author OwenHuang
 * @since 2022/11/12 21:55
 */
public class ProjectThreadPool extends ThreadPoolExecutor {
    private static ProjectThreadPool pool;

    private ProjectThreadPool() {
        super(PropertyMgr.getInt("thread.pool.corePoolSize"),
                PropertyMgr.getInt("thread.pool.maximumPoolSize"),
                PropertyMgr.getInt("thread.pool.keepAliveTime"), TimeUnit.SECONDS, new ArrayBlockingQueue<>(1),
                new DefaultThreadFactory("OwenThreadPool"), new ExecutionRejectHandler());
    }

    public static ProjectThreadPool getInstance() {
        if (pool == null) {
            synchronized (ProjectThreadPool.class) {
                if (pool == null) {
                    pool = new ProjectThreadPool();
                }
            }
        }
        return pool;
    }

    @Override
    public void execute(Runnable command) {
        super.execute(command);
        System.out.println("Current active count:" + super.getActiveCount());
    }
}
