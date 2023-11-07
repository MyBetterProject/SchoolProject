package example.com.schoolproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = findViewById(R.id.btn_login);
        EditText etAccount = findViewById(R.id.ed_e_mail);
        EditText etPassword = findViewById(R.id.ed_password);
        TextView register = findViewById(R.id.btn_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    startActivity(new Intent(LoginActivity.this,RegisterActivity.class));


            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入的用户名和密码
                String username = etAccount.getText().toString();
                String password = etPassword.getText().toString();

                DatabaseOpenHelper dbHelper = new DatabaseOpenHelper(LoginActivity.this); // 替换成你的上下文

                boolean isLoggedIn = dbHelper.loginUser(username, password);
                if (isLoggedIn) {
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}