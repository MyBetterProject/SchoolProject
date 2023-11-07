package example.com.schoolproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {


    private EditText etAccount;
    private EditText etPassword;
    private EditText etPassword2;
    private Button bnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etAccount = findViewById(R.id.et_account);
        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                StringBuilder filteredStringBuilder = new StringBuilder();
                for (int i = start; i < end; i++) {
                    char character = source.charAt(i);
                    if (Character.UnicodeBlock.of(character) != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) {
                        // 如果字符不是汉字，则添加到过滤后的字符串中
                        filteredStringBuilder.append(character);
                    }
                }
                return filteredStringBuilder.toString();
            }
        };
        etAccount.setFilters(new InputFilter[]{filter});
        etPassword = findViewById(R.id.et_password);
        etPassword2 = findViewById(R.id.et_password2);
        bnAdd = findViewById(R.id.bn_add);

        bnAdd.setEnabled(false); // 初始状态下禁用注册按钮

        // 监听用户名EditText的文本变化
        etAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                validateInputFields(); // 检查输入字段的有效性
            }
        });

        // 监听密码EditText的文本变化
        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                validateInputFields(); // 检查输入字段的有效性
            }
        });

        // 监听重复密码EditText的文本变化
        etPassword2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                validateInputFields(); // 检查输入字段的有效性
            }
        });

        bnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = etAccount.getText().toString().trim().toLowerCase();
                String password = etPassword.getText().toString().trim();
                String password2 = etPassword2.getText().toString().trim();

                if (password.equals(password2)) {
                    // 两次密码一致
                    DatabaseOpenHelper dbHelper = new DatabaseOpenHelper(RegisterActivity.this); // 替换成你的上下文
                    boolean isRegistered = dbHelper.registerUser(account, password);


                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    finish(); // 返回登录页面
                } else {
                    Toast.makeText(RegisterActivity.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void validateInputFields() {
        String account = etAccount.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String password2 = etPassword2.getText().toString().trim();

        boolean isValid = !TextUtils.isEmpty(account) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(password2);

        bnAdd.setEnabled(isValid);
    }



}