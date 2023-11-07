package example.com.schoolproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,WebActivity.class);
                intent1.putExtra("url","https://www.tsinghua.edu.cn/");
                startActivity(intent1);
            }
        });

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this,WebActivity.class);
                intent2.putExtra("url","https://www.sist.tsinghua.edu.cn/");
                startActivity(intent2);
            }
        });

        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this,WebActivity.class);
                intent3.putExtra("url","https://www.sem.tsinghua.edu.cn/");
                startActivity(intent3);
            }
        });

        Button btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(MainActivity.this,WebActivity.class);
                intent4.putExtra("url","https://www.civil.tsinghua.edu.cn/");
                startActivity(intent4);
            }
        });

        Button btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(MainActivity.this,WebActivity.class);
                intent5.putExtra("url","https://www.tsinghua.edu.cn/news.htm");
                startActivity(intent5);
            }
        });


    }
}