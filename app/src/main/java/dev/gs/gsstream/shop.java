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

public class shop extends AppCompatActivity {
    static public int pernm = 10;
    static public int pernE = 5;
    static public int vipom = 40;
    static public int vipoE = 25;
    static public int doshikm = 80;
    static public int doshikE = 55;
    Button pern;
    Button doshik;
    Button vipo;
    Button back;
    static TextView money;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_shop);

        back = (Button) findViewById(R.id.back);
        new Saved().save();
        back();
        money = (TextView) findViewById(R.id.money);
        money.setText(game.money + "$");
        doshik = (Button) findViewById(R.id.doshik);
        if (game.energ <= 100) {
            if (game.money < 80) {
                doshik.setBackground(getDrawable(R.drawable.button_bg_red));
            } else {
                doshik.setBackground(getDrawable(R.drawable.button_bg_green));
            }
        } else {
            doshik.setBackground(getDrawable(R.drawable.button_bg_orange));
            Toast toast12 = Toast.makeText(getApplicationContext(),
                    "Энергия переполнена!", Toast.LENGTH_SHORT);
            toast12.show();
        }
        new Saved().save();
        doshik();

        pern = (Button) findViewById(R.id.pern);
        if (game.energ <= 100) {
        if(game.money < 10){
                pern.setBackground(getDrawable(R.drawable.button_bg_red));
            } else {
                pern.setBackground(getDrawable(R.drawable.button_bg_green));
        }
        } else {
            pern.setBackground(getDrawable(R.drawable.button_bg_orange));
            Toast toast12 = Toast.makeText(getApplicationContext(),
                    "Энергия переполнена!", Toast.LENGTH_SHORT);
            toast12.show();
            }
            new Saved().save();
        pern();

        vipo = (Button) findViewById(R.id.vipo);
        if (game.energ <= 100) {
            if (game.money < 40) {
                vipo.setBackground(getDrawable(R.drawable.button_bg_red));
            } else {
                vipo.setBackground(getDrawable(R.drawable.button_bg_green));
            }
        } else {
            vipo.setBackground(getDrawable(R.drawable.button_bg_orange));
            Toast toast12 = Toast.makeText(getApplicationContext(),
                    "Энергия переполнена!", Toast.LENGTH_SHORT);
            toast12.show();
        }
        new Saved().save();
        vipo();

        }




    void pern() {
        final Animation animClick = AnimationUtils.loadAnimation(this, R.anim.scale);
        pern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation((animClick));
                if (game.energ <= 100) {
                    if (game.money >= 10) {
                        game.money -= pernm;
                        game.energ += pernE;
                        game.E.setText("Энергия  " + game.energ);
                        game.dolors.setText(game.money + "$");
                        money.setText(game.money + "$");
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Успешно!", Toast.LENGTH_SHORT);
                        toast.show();
                        new Saved().save();
                        pern();

                    } else {
                        Toast toast11 = Toast.makeText(getApplicationContext(),
                                "Недостаточно денег!", Toast.LENGTH_SHORT);
                        toast11.show();
                    }
                    if (game.money <= 10) {
                        pern.setBackground(getDrawable(R.drawable.button_bg_red));
                    } else {
                        pern.setBackground(getDrawable(R.drawable.button_bg_green));
                    }
                }else {
                    pern.setBackground(getDrawable(R.drawable.button_bg_orange));
                    Toast toast12 = Toast.makeText(getApplicationContext(),
                            "Энергия переполнена!", Toast.LENGTH_SHORT);
                    toast12.show();
                    pern();
                }
            }
        });

    }

    void doshik() {
        final Animation animClick = AnimationUtils.loadAnimation(this, R.anim.scale);
        doshik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation((animClick));
                if (game.energ <=100) {
                    if (game.money >= 80) {
                        game.money -= doshikm;
                        game.energ += doshikE;
                        game.E.setText("Энергия  " + game.energ);
                        game.dolors.setText(game.money + "$");
                        money.setText(game.money + "$");
                        new Saved().save();
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Успешно!", Toast.LENGTH_SHORT);
                        toast.show();
                        doshik();
                    } else {
                        Toast toast13 = Toast.makeText(getApplicationContext(),
                                "Недостаточно денег!", Toast.LENGTH_SHORT);
                        toast13.show();
                    }


                    if (game.money <= 300) {
                        doshik.setBackground(getDrawable(R.drawable.button_bg_red));
                    } else {
                        doshik.setBackground(getDrawable(R.drawable.button_bg_green));
                    }
                }else {
                    doshik.setBackground(getDrawable(R.drawable.button_bg_orange));
                    Toast toast11 = Toast.makeText(getApplicationContext(),
                            "Энергия переполнена!", Toast.LENGTH_SHORT);
                    toast11.show();
                    doshik();
                }
            }
        });

    }
    void back() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(shop.this, options.class);
                startActivity(intent);
            }
        });

        new Saved().save();
    }

    void vipo() {
        final Animation animClick = AnimationUtils.loadAnimation(this, R.anim.scale);
        vipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation((animClick));
                if (game.energ <=100) {
                    if (game.money >= 40) {
                        game.money -= vipom;
                        game.energ += vipoE;
                        game.E.setText("Энергия  " + game.energ);
                        game.dolors.setText(game.money + "$");
                        money.setText(game.money + "$");
                        new Saved().save();
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Успешно!", Toast.LENGTH_SHORT);
                        toast.show();
                        vipo();

                    } else {
                        Toast toast1 = Toast.makeText(getApplicationContext(),
                                "Недостаточно денег!", Toast.LENGTH_SHORT);
                        toast1.show();
                    }

                    if (game.money <= 40) {
                        vipo.setBackground(getDrawable(R.drawable.button_bg_red));
                    } else {
                        vipo.setBackground(getDrawable(R.drawable.button_bg_green));
                    }
                } else {
                    vipo.setBackground(getDrawable(R.drawable.button_bg_orange));
                    Toast toast11 = Toast.makeText(getApplicationContext(),
                            "Энергия переполнена!", Toast.LENGTH_SHORT);
                    toast11.show();
                    vipo();
                }
            }
        });

    }


    }



