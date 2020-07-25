package dev.gs.gsstream;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class shopcase extends AppCompatActivity {
Button back;
    Button casee1;
Dialog dialog;

    static TextView money;
    public static Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopcase);
//------------------------------------------------------------
        back = (Button) findViewById(R.id.back);
        back();
//------------------------------------------------------------
        money = (TextView) findViewById(R.id.money);
        money.setText(game.money + "$");
//------------------------------------------------------------
        new Saved().save();

        casee1 = (Button) findViewById(R.id.casee1);
        casee1();
//------------------------------------------------------------
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.prew);
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
                int A = random.nextInt(5);
                    if (A == 1) {
                        Toast toast122 = Toast.makeText(getApplicationContext(),
                                "Вы открыли кейс и вышли в 0", Toast.LENGTH_SHORT);
                        toast122.show();
                    } else {
                        int B = random.nextInt(10);
                            if (B == 1) {
                                game.money += 100;
                                game.dolors.setText(game.money + "$");
                                money.setText(game.money + "$");
                                new Saved().save();
                                Toast toast1322 = Toast.makeText(getApplicationContext(),
                                        "Вы выиграли 100$!", Toast.LENGTH_SHORT);
                                toast1322.show();
                            } else {
                                int С = random.nextInt(20);
                                    if (С == 1) {
                                        game.money -= 50;
                                        game.dolors.setText(game.money + "$");
                                        money.setText(game.money + "$");
                                        new Saved().save();
                                        Toast toast13222 = Toast.makeText(getApplicationContext(),
                                                "Вы проиграли 50$!", Toast.LENGTH_SHORT);
                                        toast13222.show();
                                    } else {
                                        int D = random.nextInt(1000);
                                            if (D == 3) {
                                                game.money += 50000;
                                                game.dolors.setText(game.money + "$");
                                                money.setText(game.money + "$");
                                                new Saved().save();
                                                Toast toast131222 = Toast.makeText(getApplicationContext(),
                                                        "Вы сорвали джекпот! +50000$!", Toast.LENGTH_SHORT);
                                                toast131222.show();
                                            } else {
                                                int E = random.nextInt(200)+1;
                                                game.money -= 100;
                                                game.money += E;
                                                game.dolors.setText(game.money + "$");
                                                money.setText(game.money + "$");
                                                new Saved().save();
                                                Toast toast1312221 = Toast.makeText(getApplicationContext(),
                                                        "Вы получили утешительный приз " + E + "$", Toast.LENGTH_SHORT);
                                                toast1312221.show();
                                            }
                                    }

                            }
                    }
            }
        });

    }

    void back() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(shopcase.this, options.class);
                startActivity(intent);
            }
        });
    }

    void casee1() {
        casee1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (game.money >= 100) {
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