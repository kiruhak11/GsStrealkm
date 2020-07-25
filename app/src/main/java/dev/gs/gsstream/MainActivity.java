package dev.gs.gsstream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static String APP_PREFERENCES;
    public static String APP_PREFERENCES_THEME; // выбранная тема
    public static int psh = 0;
    SharedPreferences mSettings;
    private BreakIterator dolors;



    private static final int INTERNET_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;



    private void Cheker(){
        checkPermission(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                STORAGE_PERMISSION_CODE);
        checkPermission(
                Manifest.permission.INTERNET,
                INTERNET_PERMISSION_CODE);
        checkPermission(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                STORAGE_PERMISSION_CODE);
        checkPermission(
                Manifest.permission.ACCESS_NETWORK_STATE,
                INTERNET_PERMISSION_CODE);
        checkPermission(
                Manifest.permission.MANAGE_DOCUMENTS,
                INTERNET_PERMISSION_CODE);
    }



    public void checkPermission(String permission, int requestCode)
    {
        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(
                MainActivity.this,
                permission)
                == PackageManager.PERMISSION_DENIED) {
            ActivityCompat
                    .requestPermissions(
                            MainActivity.this,
                            new String[] { permission },
                            requestCode);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        int currentNightMode = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        if(mSettings.contains(APP_PREFERENCES_THEME)) {

            String mCounter = mSettings.getString(APP_PREFERENCES_THEME, "auto");


            if(!mCounter.equals("auto") && !mCounter.equals("white") && !mCounter.equals("black")){
                mCounter = "auto";
            }


            switch(mCounter){
                case "white":
                    Log.i("Theme", mCounter );
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                        setTheme(R.style.AppThem123e);
                    } else {
                        setTheme(R.style.AppT21332121hem1e);
//                        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); нахуй ненада
                    }
                    break;
                case "black":
                    Log.i("Theme", mCounter );
                    setTheme(R.style.AppT213hem1e);
                    break;
                case "pink":
                    break;
                case "auto":
                    Log.i("Theme", mCounter );
                    switch (currentNightMode) {
                        case Configuration.UI_MODE_NIGHT_NO:
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                                setTheme(R.style.AppTheme);
                            } else {
                                setTheme(R.style.AppT213hem1e);
                                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                            }
                            break;
                        case Configuration.UI_MODE_NIGHT_YES:
                            setTheme(R.style.AppTheme);
                            break;
                        default:
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                                setTheme(R.style.AppT213hem1e);
                            } else {
                                setTheme(R.style.AppT21332121hem1e);
                                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                            }
                            break;
                        // We don't know what mode we're in, assume notnight
                    }
                    break;
                default:
                    Log.i("Theme", mCounter );
                    break;
            }
        }
        setContentView(R.layout.activity_main);

        
        Cheker();


        TextView start = (TextView) findViewById(R.id.start);
        start.setOnClickListener(this);

        TextView info = (TextView) findViewById(R.id.info);
        info.setOnClickListener(this);

        TextView psh = (TextView) findViewById(R.id.psh);
        psh.setOnClickListener(this);

        TextView promo = (TextView) findViewById(R.id.promo);
        promo.setOnClickListener(this);


    }
    @Override
    public void onClick(View view){
        final Animation animClick = AnimationUtils.loadAnimation(this, R.anim.scale);
        switch (view.getId()) {
            case R.id.start:
                view.startAnimation((animClick));
                Intent intent = new Intent(MainActivity.this, game.class);
                startActivity(intent);
                break;

            case R.id.info:
                view.startAnimation((animClick));
                Intent intent1 = new Intent(MainActivity.this, info.class);
                startActivity(intent1);
                break;

            case R.id.psh:
                view.startAnimation((animClick));
                break;

            case R.id.promo:
                view.startAnimation((animClick));
                Intent intent2 = new Intent(MainActivity.this, promo.class);
                startActivity(intent2);
                break;


        }
    }


}
