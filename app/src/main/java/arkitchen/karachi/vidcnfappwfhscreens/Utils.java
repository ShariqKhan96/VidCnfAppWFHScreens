package arkitchen.karachi.vidcnfappwfhscreens;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class Utils {
    public static void titles(String main, String sub, Activity activity)
    {
        TextView maintv,subtv;
        maintv = activity.findViewById(R.id.main_title);
        subtv = activity.findViewById(R.id.sub_title);

        if(sub.length()<=0)
            subtv.setVisibility(View.GONE);
        subtv.setText(sub);
        maintv.setText(main);


    }
}
