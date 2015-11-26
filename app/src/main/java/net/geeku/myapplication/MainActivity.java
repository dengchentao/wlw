package net.geeku.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.Map;
import java.util.Set;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Logcat", "Hello Android");

        findViewById(R.id.btnCal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });

        findViewById(R.id.btnIntent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String counter;

                SharedPreferences sp = getSharedPreferences("counter", Context.MODE_PRIVATE);
                counter = sp.getString("c", "1");

                SharedPreferences.Editor editor = sp.edit();
                editor.putString("c", String.valueOf(Integer.parseInt(counter) + 1));
                editor.commit();

                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                intent.putExtra("counter", counter);
                startActivity(intent);

            }
        });


        findViewById(R.id.btnCal2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity4.class));
            }
        });

        findViewById(R.id.btnMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity5.class));
            }
        });
    }

}
