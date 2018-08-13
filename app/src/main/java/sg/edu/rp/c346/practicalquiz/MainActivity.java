package sg.edu.rp.c346.practicalquiz;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver br = new WallpaperReceiver();
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.RadioGroup);

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction("android.intent.action.WALLPAPER_CHANGED");
        this.registerReceiver(br, filter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(br);
    }

    @Override
    protected void onPause() {
        super.onPause();

        //Step 1a: Obtain an instance of the SharedPreferences
        SharedPreferences prefs =  getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        //Step 1b: Obtain an instance of the SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();
        //Step 1c: Add the key-value pair
        int id = rg.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(id);

        String msg = radioButton.getText().toString();

        prefEdit.putString("msg", msg);
        prefEdit.commit();
    }
}
