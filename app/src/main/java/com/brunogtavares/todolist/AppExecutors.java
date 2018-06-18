package com.brunogtavares.todolist;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;



/**
 * Created by brunogtavares on 6/18/18.
 *
 * Executor is an object that executes a submitted runnable tasks. It is normally used instead of
 * explicitly creating threads for each of a set of tasks.
 */

public class AppExecutors {

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static AppExecutors sInstance;
    private final Executor mDiskIO;
    private final Executor mMainThread;
    private final Executor mNetworkIO;


    private AppExecutors(Executor mDiskIO, Executor mNetworkIO, Executor mMainThread) {
        this.mDiskIO = mDiskIO;
        this.mMainThread = mMainThread;
        this.mNetworkIO = mNetworkIO;
    }

    public static AppExecutors getInstance() {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = new AppExecutors(Executors.newSingleThreadExecutor(),
                        Executors.newFixedThreadPool(3),
                        new MainThreadExecutor());
            }
        }
        return sInstance;
    }

    // diskIO is a single thread executor.
    // It ensures that the database transactions are done in order, so we do not have race conditions.
    public Executor diskIO() { return mDiskIO; }
    public Executor mainThread() { return mMainThread; }
    // The network IO executor is a pool for three threads. This allows the app to run
    // different network calls simultaneosly while controlling the number of threads that we have.
    public Executor networkIO() { return mNetworkIO; }

    // This class will post runnables using a handle associated with the main looper.
    private static class MainThreadExecutor implements Executor {
        private Handler mMainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mMainThreadHandler.post(command);
        }
    }
}
