package dev.gs.gsstream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class game extends AppCompatActivity {
    static public ProgressBar progress;
    static public int subscribe = 0;
    static public int money = 10;
    static public int energ = 0;
    static public int enstream = 1;
    static public int cam = 5;
    static public int addsub = 5;
    static public int win = 0;
    public static Random random = new Random();
    static public int timer = 0;
    Button qwe;
    Button opt;
    static public TextView sub;
    static public TextView E;
    static public TextView dolors;
    static public TextView bust;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);
        Saved.init(getApplicationContext());
        qwe = (Button) findViewById(R.id.qwe);
        sub = (TextView) findViewById(R.id.sub);
        sub.setText("Подписчики  " + subscribe);
        progress = (ProgressBar) findViewById(R.id.progressBar);
        bust = (TextView) findViewById(R.id.bust);
        dolors = (TextView) findViewById(R.id.money);
        dolors.setText(money + "$");
        E = (TextView) findViewById(R.id.energy);
        E.setText("Энергия  " + energ);
        opt = (Button) findViewById(R.id.opt);
        new Saved().load_save();
        qwe();
        opt();

        if (subscribe == 1000) {
            win += 1;
        }
    }
    void qwe() {
        final Animation animClick = AnimationUtils.loadAnimation(this, R.anim.scale);

        qwe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (energ >= 1) {
                v.startAnimation((animClick));
                if (timer == 0) {
                    new CountDownTimer(10000, 1000) {
                        @Override
                        public void onTick(long l) {
                            timer += 1;
                            progress.setProgress((int) (l / 1000));
                        }

                        @Override
                        public void onFinish() {

                            str();
                            timer -= 10;
                        }
                    }.start();
                }
                if (timer >= 10) {
//                    energ -= enstream;
//                    E.setText("Энергия  " + energ);
////                    Random random1 = new Random();
////                    int i1 = random1.nextInt(moneydiff);
////                    money += i1;
//                    dolors.setText(money + "$");
//                    Random random = new Random();
//                    int i = random.nextInt(diff);
//                    subscribe += i;
//                    sub.setText("Подписчики  " + subscribe);
//                    new Saved().save();
//                    qwe();
                } else {
                    Toast toast1222 = Toast.makeText(getApplicationContext(),
                            "Идет стрим!", Toast.LENGTH_SHORT);
                    toast1222.show();

                }
                }
            }
        });

    }
    void str() {
        if (energ >= 1) {
            energ -= enstream;
            E.setText("Энергия  " + energ);
            int A = random.nextInt(cam)+2;// от 2 до 5
            money += A;
            dolors.setText(money + "$");
            int B = random.nextInt(addsub)+2;
            subscribe += B;
            sub.setText("Подписчики  " + subscribe);
            new Saved().save();
            qwe();
            Toast toast122 = Toast.makeText(getApplicationContext(),
                    "Стрим закончен! За стрим вы получили " + A + "$ И на вас подписалось " + B + " Подписчиков"  , Toast.LENGTH_SHORT);
            toast122.show();
        }
    }
    void save(){
        preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("sub", subscribe);
        editor.putInt("E", energ);
        editor.putInt("dolors", money);
        editor.commit();
    }
    void load_save() {
        preferences = getPreferences(MODE_PRIVATE);
        subscribe = preferences.getInt("sub", 0);
        sub.setText("Подписчики  " + subscribe);
        money = preferences.getInt("money", 10);
        dolors.setText(money + "$");
        energ = preferences.getInt("E", 0);
        E.setText("Энергия  " + energ);
    }
    void opt() {
        final Animation animClick = AnimationUtils.loadAnimation(this, R.anim.scale);

        opt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation((animClick));
                    Intent intent = new Intent(game.this, options.class);
                    startActivity(intent);
            }
        });


    }

    }

