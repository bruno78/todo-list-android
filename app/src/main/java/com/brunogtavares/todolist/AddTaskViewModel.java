package com.brunogtavares.todolist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.brunogtavares.todolist.database.AppDatabase;
import com.brunogtavares.todolist.database.TaskEntry;

/**
 * Created by brunogtavares on 6/18/18.
 */

class AddTaskViewModel extends ViewModel {

    private LiveData<TaskEntry> mTask;

    public AddTaskViewModel(AppDatabase database, int taskId) {
        mTask = database.taskDao().loadTaskById(taskId);
    }

    public LiveData<TaskEntry> getTask() {
        return mTask;
    }
}
