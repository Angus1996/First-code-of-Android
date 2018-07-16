package com.example.angus.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Intent intent = getIntent();
        //Intent 结合 Bundle 一起传递数据
        Bundle outState = intent.getBundleExtra("extra_data");
        final String data = outState.getString("data_key");
        // Intent 应用于向下一个活动传递数据
        /*final String data = intent.getStringExtra("extra_data");*/
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this, data, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}
