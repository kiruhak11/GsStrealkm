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
import android.widget.Toast;

public class options extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_options);

        Button button = (Button) findViewById(R.id.ali);
        button.setOnClickListener(this);

        Button button1 = (Button) findViewById(R.id.shop);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.school);
        button2.setOnClickListener(this);

        Button button12 = (Button) findViewById(R.id.achivmens);
        button12.setOnClickListener(this);

        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);

        Button backm = (Button) findViewById(R.id.backM);
        backm.setOnClickListener(this);

        Button cases =(Button) findViewById(R.id.cases);
        cases.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        final Animation animClick = AnimationUtils.loadAnimation(this, R.anim.scale);
        switch(view.getId()) {
            case R.id.ali:
                view.startAnimation((animClick));
                Intent intent12 = new Intent(options.this, ali.class);
                startActivity(intent12);
                break;

            case R.id.shop:
                view.startAnimation((animClick));
                Intent intent1 = new Intent(options.this, shop.class);
                startActivity(intent1);
                break;

            case R.id.school:
                view.startAnimation((animClick));
                Intent intent1221 = new Intent(options.this, school.class);
                startActivity(intent1221);
                break;

            case R.id.back:
                view.startAnimation((animClick));
                Intent intent2 = new Intent(options.this, game.class);
                startActivity(intent2);
                break;

            case R.id.backM:
                view.startAnimation((animClick));
                Intent intent22 = new Intent(options.this, MainActivity.class);
                startActivity(intent22);
                break;

            case R.id.achivmens:
                view.startAnimation((animClick));
                Intent intent = new Intent(options.this, achivmens.class);
                startActivity(intent);
                break;

            case R.id.cases:
                view.startAnimation((animClick));
                Intent intent3 = new Intent(options.this, shopcase.class);
                startActivity(intent3);
                break;
        }
    }
}
