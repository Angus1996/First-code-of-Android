package com.example.angus.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    /*@Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "Hello, SecondActivity!";
        outState.putString("data_key", tempData);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1 = findViewById(R.id.buitton_1);
        button1.setOnClickListener(new View.OnClickListener(){
            //Intent 结合 Bundle 一起传递数据
            @Override
            public void onClick(View view) {
                Bundle outState = new Bundle();
                //首先，将需要传递的数据保存在Bundle对象中
                outState.putString("data_key", "Hello SecondActivity");
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //将Bundle对象存放在Intent里面
                intent.putExtra("extra_data",outState);
                startActivity(intent);
            }
        });
        /*button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                *//*Toast.makeText(FirstActivity.this, "You clicked Button 1", Toast.LENGTH_SHORT).show();
                finish();*//*
                *//*finish();*//*
                String data = "Hello SecondActivity";
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data", data);
                startActivity(intent);
                *//*Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);*//*
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}
