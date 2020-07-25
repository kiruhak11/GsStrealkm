package dev.gs.gsstream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class achivmens extends AppCompatActivity {
Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achivmens);
        back = (Button) findViewById(R.id.back);
        back();
    }


    void back() {
        final Animation animClick = AnimationUtils.loadAnimation(this, R.anim.scale);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation((animClick));
                Intent intent2 = new Intent(achivmens.this, options.class);
                startActivity(intent2);
            }
        });
    }
}