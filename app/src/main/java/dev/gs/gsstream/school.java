package dev.gs.gsstream;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class school extends AppCompatActivity {
Button back;
Button rz;
Dialog dialog;
static public TextView sub;
static public TextView cena;
    public static Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);
        cena = (TextView) findViewById(R.id.cena);
        sub = (TextView) findViewById(R.id.sub);
        sub.setText("Подписчики " + game.subscribe);
        back = (Button) findViewById(R.id.back);
        back();
        rz = (Button) findViewById(R.id.rz);
        rz();
        sub.setText("Подписчики " + game.subscribe);
        cena.setText("Цена " + 500);

        //---D

        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.rz);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        TextView close = (TextView)dialog.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                }catch (Exception e) {
                }
                dialog.dismiss();
            }
        });

        Button button = (Button)dialog.findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (game.money >= 500) {
                    game.money -= 500;
                    int A = random.nextInt(game.subscribe) + 1;
                    game.subscribe += A;
                    game.sub.setText("Подписчики " + game.subscribe);
                    sub.setText("Подписчики " + game.subscribe);
                    cena.setText("Цена " + 500);
                    Toast toast122 = Toast.makeText(getApplicationContext(),
                            "Ваш розыгрыш приманил к вам " + A + " Подписчиков!", Toast.LENGTH_SHORT);
                    toast122.show();

                }
            }
        });


        //---D
        new Saved().save();
    }
    void back() {
        final Animation animClick = AnimationUtils.loadAnimation(this, R.anim.scale);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation((animClick));
                Intent intent2 = new Intent(school.this, options.class);
                startActivity(intent2);
            }
        });
    }

    void rz() {
        rz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (game.money >= 500) {
                    dialog.show();
                } else {
                    Toast toast1312221 = Toast.makeText(getApplicationContext(),
                            "Недостаточно средств!", Toast.LENGTH_SHORT);
                    toast1312221.show();
                }
            }
        });
    }
}
