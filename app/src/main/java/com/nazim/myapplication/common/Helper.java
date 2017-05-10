package com.nazim.myapplication.common;

import android.content.Context;
import android.content.res.Configuration;

public class Helper {

    //TODO Improve not be static
    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
            >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }
}
