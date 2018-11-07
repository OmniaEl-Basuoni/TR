package com.example.omnia.taskrabit.Classes.Language;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by 3ZT on 27/03/17.
 */

public class PrefUtils {
    public static void setLanguage(Context ctx, String type, String language){
        SharedPreferences.Editor editor = ctx.getSharedPreferences(ctx.getPackageName(), MODE_PRIVATE).edit();
        editor.putString("type", type);
        editor.putString("language", language);
        editor.apply();
    }
}
