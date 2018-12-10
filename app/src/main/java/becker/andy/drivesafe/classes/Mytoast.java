package becker.andy.drivesafe.classes;

import android.content.Context;
import android.widget.Toast;

public class Mytoast {

    public static void showToast(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
