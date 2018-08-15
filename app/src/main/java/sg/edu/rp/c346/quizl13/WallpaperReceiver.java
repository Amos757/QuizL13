package sg.edu.rp.c346.quizl13;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;


public class WallpaperReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast myToast = Toast.makeText(context,"You have changed the wallpaper", Toast.LENGTH_LONG);
        myToast.show();


        //1B TASK
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        int id = preferences.getInt("id",R.id.radioButton);
        if (id== R.id.radioButton){
            Toast.makeText(context, R.string.rb1, Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(context, R.string.rb2, Toast.LENGTH_LONG).show();
        }

    }
}
