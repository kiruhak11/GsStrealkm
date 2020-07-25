package dev.gs.gsstream;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;


public class Saved extends AppCompatActivity {
    private static SharedPreferences.Editor editor;
    private static SharedPreferences preferences;
    public Saved(){};
    public static void init(Context context) {
        if (preferences == null){
            preferences = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
            editor = preferences.edit();
        }
    }
    void save(){
        editor.putInt("money", game.money);
        editor.putInt("E", game.energ);
        editor.putInt("sub", game.addsub);
        editor.putInt("sub", game.subscribe);
        editor.putInt("cam", game.cam);
        editor.commit();
    }
    void load_save() {
        game.subscribe = preferences.getInt("sub", 0);
        game.money = preferences.getInt("money", 10);
        game.energ = preferences.getInt("E", 0);
        game.addsub = preferences.getInt("submax", 5);
        game.cam = preferences.getInt("cam", 5);
        game.E.setText("Энергия  " + game.energ);
        game.sub.setText("Подписчики  " + game.subscribe);
        game.dolors.setText(game.money + "$");
        game.bust.setText("Буст " + game.cam);
    }
}
