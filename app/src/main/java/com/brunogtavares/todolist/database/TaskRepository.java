package com.brunogtavares.todolist.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import java.util.List;

/**
 * Created by brunogtavares on 6/19/18.
 */

public class TaskRepository {
    private static String TAG = TaskRepository.class.getSimpleName();

    private TaskDao mTaskDao;
    private LiveData<List<TaskEntry>> mAllTasks;

    public TaskRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        mTaskDao = db.taskDao();
        mAllTasks = mTaskDao.loadAllTasks();
    }

    public LiveData<List<TaskEntry>> getAllTasks() {
        return mAllTasks;
    }

}
