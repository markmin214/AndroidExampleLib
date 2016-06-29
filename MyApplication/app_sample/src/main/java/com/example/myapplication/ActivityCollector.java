package com.example.myapplication;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by markmin on 16/6/29.
 */
public class ActivityCollector {

    public  static   List<Activity> activitiesList = new ArrayList<Activity>();

    public static void addToActivityList(Activity activity) {
        activitiesList.add(activity);

    }

    public static void removeFromActivityList(Activity activity) {
        activitiesList.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activitiesList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

}
