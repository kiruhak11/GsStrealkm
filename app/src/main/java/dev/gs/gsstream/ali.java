package dev.gs.gsstream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ali extends AppCompatActivity {

    static public int camP = 5;
    Button back;
    Button cam;
    Button ssd;
    Button stul;
    static TextView money;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ali);
        money = (TextView) findViewById(R.id.money);
        money.setText(game.money + "$");
        back = (Button) findViewById(R.id.back);
        new Saved().save();
        back();
        cam = (Button) findViewById(R.id.cam);
        if (game.money <= 100) {
            cam.setBackground(getDrawable(R.drawable.button_bg_red));
        } else {
            cam.setBackground(getDrawable(R.drawable.button_bg_green));
        }

        ssd = (Button) findViewById(R.id.ssd);
        if (game.money <= 500) {
            ssd.setBackground(getDrawable(R.drawable.button_bg_red));
        } else {
            ssd.setBackground(getDrawable(R.drawable.button_bg_green));
        }

        stul = (Button) findViewById(R.id.stul);
        if (game.money <= 1000) {
            stul.setBackground(getDrawable(R.drawable.button_bg_red));
        } else {
            stul.setBackground(getDrawable(R.drawable.button_bg_green));
        }
        new Saved().save();
        cam();
        ssd();
        stul();
    }
    void back() {
        final Animation animClick = AnimationUtils.loadAnimation(this, R.anim.scale);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation((animClick));
                Intent intent = new Intent(ali.this, options.class);
                startActivity(intent);
            }
        });

    }
    void cam() {
        final Animation animClick = AnimationUtils.loadAnimation(this, R.anim.scale);
        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation((animClick));
                if (game.money >= 100) {
                    game.money -= 100;
                    game.cam +=5;
                    game.addsub +=5;
                    game.dolors.setText(game.money + "$");
                    money.setText(game.money + "$");
                    game.bust.setText("Буст " + game.cam);

                    new Saved().save();
                    cam();
                } else {
                    Toast toast122 = Toast.makeText(getApplicationContext(),
                            "Нехватает малех(", Toast.LENGTH_SHORT);
                    toast122.show();
                }
                if (game.money <= 100) {
                    cam.setBackground(getDrawable(R.drawable.button_bg_red));
                } else {
                    cam.setBackground(getDrawable(R.drawable.button_bg_green));
                }
                new Saved().save();
                cam();

            }
        });
    }
    void ssd() {
        final Animation animClick = AnimationUtils.loadAnimation(this, R.anim.scale);
        ssd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation((animClick));
                if (game.money >= 500) {
                    game.money -= 500;
                    game.cam +=55;
                    game.addsub +=55;
                    game.dolors.setText(game.money + "$");
                    money.setText(game.money + "$");
                    game.bust.setText("Буст " + game.cam);

                    new Saved().save();
                    ssd();
                } else {
                    Toast toast121322 = Toast.makeText(getApplicationContext(),
                            "Нехватает малех(", Toast.LENGTH_SHORT);
                    toast121322.show();
                }
                if (game.money <= 500) {
                    ssd.setBackground(getDrawable(R.drawable.button_bg_red));
                } else {
                    ssd.setBackground(getDrawable(R.drawable.button_bg_green));
                }
                new Saved().save();
                ssd();

            }
        });
    }
    void stul() {
        final Animation animClick = AnimationUtils.loadAnimation(this, R.anim.scale);
        stul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation((animClick));
                if (game.money >= 1000) {
                    game.money -= 1000;
                    game.cam +=115;
                    game.addsub +=100;
                    game.dolors.setText(game.money + "$");
                    money.setText(game.money + "$");
                    game.bust.setText("Буст " + game.cam);

                    new Saved().save();
                    stul();
                } else {
                    Toast toast1232 = Toast.makeText(getApplicationContext(),
                            "Нехватает малех(", Toast.LENGTH_SHORT);
                    toast1232.show();
                }
                if (game.money <= 1000) {
                    stul.setBackground(getDrawable(R.drawable.button_bg_red));
                } else {
                    stul.setBackground(getDrawable(R.drawable.button_bg_green));
                }
                new Saved().save();
                stul();

            }
        });
    }
}
