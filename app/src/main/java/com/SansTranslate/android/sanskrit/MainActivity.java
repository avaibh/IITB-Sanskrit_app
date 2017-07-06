package com.SansTranslate.android.sanskrit;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
        // Create a new intent to open the {@link NumbersActivity}
                if (position == 0){
                    MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.categ_1); // sound is inside res/raw/mysound
                    mp.start();
                    Toast.makeText(MainActivity.this, "Tap and Hold to see the magic", Toast.LENGTH_SHORT).show();
                }else if (position == 1){
                    MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.categ_2); // sound is inside res/raw/mysound
                    mp.start();
                    Toast.makeText(MainActivity.this, "Tap and Hold to see the magic", Toast.LENGTH_SHORT).show();
                }else if (position == 2){
                    MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.categ_11); // sound is inside res/raw/mysound
                    mp.start();
                    Toast.makeText(MainActivity.this, "Tap and Hold to see the magic", Toast.LENGTH_SHORT).show();
                }else if( position == 3){
                    MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.categ_10); // sound is inside res/raw/mysound
                    mp.start();
                    Toast.makeText(MainActivity.this, "Tap and Hold to see the magic", Toast.LENGTH_SHORT).show();
                }else if( position == 4){
                    MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.categ_12); // sound is inside res/raw/mysound
                    mp.start();
                    Toast.makeText(MainActivity.this, "Tap and Hold to see the magic", Toast.LENGTH_SHORT).show();
                }else if( position == 5){
                    MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.categ_9); // sound is inside res/raw/mysound
                    mp.start();
                    Toast.makeText(MainActivity.this, "Tap and Hold to see the magic", Toast.LENGTH_SHORT).show();
                }else if( position == 6){
                    MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.categ_3); // sound is inside res/raw/mysound
                    mp.start();
                    Toast.makeText(MainActivity.this, "Tap and Hold to see the magic", Toast.LENGTH_SHORT).show();
                }else if( position == 7){
                    MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.categ_4); // sound is inside res/raw/mysound
                    mp.start();
                    Toast.makeText(MainActivity.this, "Tap and Hold to see the magic", Toast.LENGTH_SHORT).show();
                }else if( position == 8){
                    MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.categ_5); // sound is inside res/raw/mysound
                    mp.start();
                    Toast.makeText(MainActivity.this, "Tap and Hold to see the magic", Toast.LENGTH_SHORT).show();
                }else if( position == 9){
                    MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.categ_6); // sound is inside res/raw/mysound
                    mp.start();
                    Toast.makeText(MainActivity.this, "Tap and Hold to see the magic", Toast.LENGTH_SHORT).show();
                }else if( position == 10){
                    MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.categ_7); // sound is inside res/raw/mysound
                    mp.start();
                    Toast.makeText(MainActivity.this, "Tap and Hold to see the magic", Toast.LENGTH_SHORT).show();
                }else if( position == 11){
                    MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.categ_8); // sound is inside res/raw/mysound
                    mp.start();
                    Toast.makeText(MainActivity.this, "Tap and Hold to see the magic", Toast.LENGTH_SHORT).show();
                }
            }
        });
        gridview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
        int position, long arg3) {
            if (position == 0){
                Intent intent = new Intent(MainActivity.this, TempleActivity.class);
                // Start the new activity
                startActivity(intent);
            }else if (position == 1){
                Intent intent = new Intent(MainActivity.this, SchoolActivity.class);
                // Start the new activity
                startActivity(intent);
            }else if (position == 2){
                Intent intent = new Intent(MainActivity.this, NumbersActivity.class);
                // Start the new activity
                startActivity(intent);
            }else if( position == 3){
                Intent intent = new Intent(MainActivity.this, FamilyActivity.class);
                // Start the new activity
                startActivity(intent);
            }else if( position == 4){
                Intent intent = new Intent(MainActivity.this, ColorsActivity.class);
                // Start the new activity
                startActivity(intent);
            }else if( position == 5){
                Intent intent = new Intent(MainActivity.this, PhrasesActivity.class);
                // Start the new activity
                startActivity(intent);
            }else if( position == 6){
                Intent intent = new Intent(MainActivity.this, SportsActivity.class);
                // Start the new activity
                startActivity(intent);
            }else if( position == 7){
                Intent intent = new Intent(MainActivity.this, TimeActivity.class);
                // Start the new activity
                startActivity(intent);
            }else if( position == 8){
                Intent intent = new Intent(MainActivity.this, SkyActivity.class);
                // Start the new activity
                startActivity(intent);
            }else if( position == 9){
                Intent intent = new Intent(MainActivity.this, WaterActivity.class);
                // Start the new activity
                startActivity(intent);
            }else if( position == 10){
                Intent intent = new Intent(MainActivity.this, TreeActivity.class);
                // Start the new activity
                startActivity(intent);
            }else if( position == 11){
                Intent intent = new Intent(MainActivity.this, FlowerActivity.class);
                // Start the new activity
                startActivity(intent);
            }
            return true;

        }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });

    }
}