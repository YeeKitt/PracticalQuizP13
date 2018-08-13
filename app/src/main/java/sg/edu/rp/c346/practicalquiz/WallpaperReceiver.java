package sg.edu.rp.c346.practicalquiz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

/**
 * Created by 16030820 on 13/8/2018.
 */

public class WallpaperReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //Step 2a: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);

        String msg = prefs.getString("msg", "");

        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
