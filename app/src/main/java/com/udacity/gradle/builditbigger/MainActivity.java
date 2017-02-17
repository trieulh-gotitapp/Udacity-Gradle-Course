package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.jokeview.JokeActivity;
import com.joke.JokeProvider;


public class MainActivity extends AppCompatActivity {

    private JokeProvider mJokeProvider;
    private static String mRootUrl = "http://192.168.100.52:8080/_ah/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
    }

    private void initData() {
        mJokeProvider = new JokeProvider();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
//        if (mJokeProvider.getSize() > 0) {
//            Joke joke = mJokeProvider.getJokes().get(new Random().nextInt(mJokeProvider.getSize()));
////            Toast.makeText(this, joke.getJoke(), Toast.LENGTH_SHORT).show();
//
//            Intent intent = new Intent(this, JokeActivity.class);
//            intent.putExtra("joke", joke.getJoke());
//            startActivity(intent);
//        }
        new EndpointsAsyncTask(new EndpointsAsyncTask.OnAsynTaskListener() {
            @Override
            public void onFinish(String result) {
                Intent intent = new Intent(MainActivity.this, JokeActivity.class);
                intent.putExtra("joke", result);
                startActivity(intent);
            }
        }).execute(mRootUrl);
    }


}
