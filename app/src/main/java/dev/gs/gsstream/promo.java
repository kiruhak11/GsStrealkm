package dev.gs.gsstream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class promo extends AppCompatActivity {
    Button promo1;
    EditText promo;
    String vse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);
        promo1 = (Button) findViewById(R.id.bpromo);
        promo = (EditText) findViewById(R.id.promot);
        promo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vse = promo.getText().toString();
                if(vse.equals("free")) {
                    game.money += 10;
                    game.dolors.setText(game.money + "$");
                    Toast toast122 = Toast.makeText(getApplicationContext(),
                            "Вы успешно активировали промокод на 10$" , Toast.LENGTH_SHORT);
                    toast122.show();
                }
            }
        });

    }
}