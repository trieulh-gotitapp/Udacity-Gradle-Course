package com.example.jokeview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private TextView tvJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        initView();
        initData();
    }

    private void initView() {
        tvJoke = (TextView) findViewById(R.id.tv_joke);

    }

    private void initData() {
        Bundle bundle = getIntent().getExtras();

        String joke = bundle.getString("joke");

        if (joke != null)
            tvJoke.setText(joke);
        else
            tvJoke.setText(getString(R.string.sample_no_joke));
    }
}
