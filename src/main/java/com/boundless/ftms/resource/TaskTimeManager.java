package com.boundless.ftms.resource;

import com.boundless.ftms.model.Task;

import java.sql.*;

/**
 * A static manager class used to keep track of the start and end time for a Task
 * and update its duration accordingly.
 *
 */

public class TaskTimeManager {

    /* The static instance */
    private static TaskTimeManager instance = new TaskTimeManager();

    private static final int hoursPerDay = 24;
    private static final int minsPerHour = 60;

    public TaskTimeManager getInstance() { return instance; }


    public double pauseTask(Task task) {

        double duration = task.getDuration();

        // this is the first time we're pausing the task
        if (task.getEndTime() == null) {

            task.setEndTime(getNow());
            duration = getMinutesDifference(task.getStartTime(), task.getEndTime());
        }
        else {

            Timestamp now = getNow();
            duration += getMinutesDifference(task.getEndTime(), now);
            task.setEndTime(now);
        }

        return duration;
    }


    public double resumeTask(Task task) { return 0.0; }


    public void startTask(Task task) {
        task.setStartTime(getNow());
    }


    private static Timestamp getNow() {
        return new Timestamp(System.currentTimeMillis());
    }

    private int getMinutesDifference(Timestamp t1, Timestamp t2) {

        int minsDiff = t1.getMinutes() > t2.getMinutes() ? t1.getMinutes() - t2.getMinutes() : t2.getMinutes() - t1.getMinutes();

        return getHoursDifference(t1, t2) * minsPerHour + minsDiff;

    }


    private int getDaysDifference(Timestamp t1, Timestamp t2) {

        return t1.getDay() > t2.getDay() ? t1.getDay() - t2.getDay() : t2.getDay() - t1.getDay();

    }


    private int getHoursDifference(Timestamp t1, Timestamp t2) {

        int hoursDiff = t1.getHours() > t2.getHours() ? t1.getHours() - t2.getHours() : t2.getHours() - t1.getHours();

        return getDaysDifference(t1, t2) * hoursPerDay + hoursDiff;

    }


}


