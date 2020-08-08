package arkitchen.karachi.vidcnfappwfhscreens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import arkitchen.karachi.vidcnfappwfhscreens.fragments.HistoryFragment;
import arkitchen.karachi.vidcnfappwfhscreens.fragments.MeetingFragment;
import arkitchen.karachi.vidcnfappwfhscreens.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {


    LinearLayout profile, history;
    Button btn_join, btn_host;
    EditText meeting_id, metting_id_host, nick_name;
    ImageView profile_icon, history_icon;
    TextView profile_tv, history_tv;
    FloatingActionButton fab;


    public void FullScreencall() {
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
//        getWindow().getDecorView().setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
//                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //FullScreencall();
        setContentView(R.layout.activity_main);

        profile = findViewById(R.id.profile);
        history = findViewById(R.id.history);
        profile_icon = findViewById(R.id.settings_icon);
        history_icon = findViewById(R.id.history_icon);

        fab = findViewById(R.id.fab);
        profile_tv = findViewById(R.id.settings_text);
        history_tv = findViewById(R.id.history_text);

        //findViewById(R.id.bottombar)

        profile.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switchColors("profile");
                loadFragment(new ProfileFragment());
                Utils.titles("Setting", "Profile and app settings", MainActivity.this);
                return false;
            }
        });
     history.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View view, MotionEvent motionEvent) {
             switchColors("history");
             loadFragment(new HistoryFragment());
             Utils.titles("History", "All meetings history", MainActivity.this);
             return false;
         }
     });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchColors("video");
                loadFragment(new MeetingFragment());
                Utils.titles("History", "All meetings history", MainActivity.this);
            }
        });


        initialState();
        Utils.titles("History", "All meetings history", MainActivity.this);


        loadFragment(new HistoryFragment());

    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                .commit();
    }

    private void switchColors(String switcher) {
        if (switcher.equals("profile")) {
            profile_icon.setColorFilter(Color.parseColor("#6200EE"));
            profile_tv.setTextColor(Color.parseColor("#6200EE"));
            history_icon.setColorFilter(Color.parseColor("#9F9F9F"));
            history_tv.setTextColor(Color.parseColor("#9F9F9F"));
        } else if (switcher.equals("history")) {
            profile_icon.setColorFilter(Color.parseColor("#9F9F9F"));
            profile_tv.setTextColor(Color.parseColor("#9F9F9F"));
            history_icon.setColorFilter(Color.parseColor("#6200EE"));
            history_tv.setTextColor(Color.parseColor("#6200EE"));
        } else {
            profile_icon.setColorFilter(Color.parseColor("#9F9F9F"));
            profile_tv.setTextColor(Color.parseColor("#9F9F9F"));
            history_icon.setColorFilter(Color.parseColor("#9F9F9F"));
            history_tv.setTextColor(Color.parseColor("#9F9F9F"));
        }
    }


    private void initialState() {

        switchColors("history");


    }
}