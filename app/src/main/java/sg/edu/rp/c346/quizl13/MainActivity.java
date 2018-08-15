package sg.edu.rp.c346.quizl13;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.RadialGradient;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver br = new WallpaperReceiver();

    RadioGroup rdG;
    RadioButton rb1;
    RadioButton rb2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rdG = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);



        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction("android.intent.action.WALLPAPER_CHANGED");
        this.registerReceiver(br,filter);




    }
    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putInt("id",rdG.getCheckedRadioButtonId());
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        int id = prefs.getInt("id",R.id.radioButton);
        rdG.check(id);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(br);
    }
}
