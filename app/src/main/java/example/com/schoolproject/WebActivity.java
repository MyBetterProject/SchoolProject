package example.com.schoolproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        String url = getIntent().getStringExtra("url"); // url

        WebView webView = findViewById(R.id.webView);

        // 加载网页
        webView.loadUrl(url);
        //使用js
        webView.getSettings().setJavaScriptEnabled(true);
        //优先使用缓存
        webView.getSettings().setCacheMode(webView.getSettings().LOAD_CACHE_ELSE_NETWORK);
        //跳转页面在当前页面打开
        webView.setWebViewClient(new android.webkit.WebViewClient());


    }

}