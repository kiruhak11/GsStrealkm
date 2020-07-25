package dev.gs.gsstream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class info extends AppCompatActivity {
TextView raz;
Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        raz = (TextView) findViewById(R.id.raz);
        raz();
        back = (Button) findViewById(R.id.back);
        back();
    }
    void raz() {
        raz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/kiruhak11"));
                startActivity(browserIntent);
            }
        });
    }

    void back() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(info.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
