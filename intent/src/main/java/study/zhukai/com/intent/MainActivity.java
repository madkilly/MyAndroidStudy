package study.zhukai.com.intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        Button blankButton= (Button) findViewById(R.id.blankButton);
        Button httpButton= (Button) findViewById(R.id.httpButton);
        Button ImplicitButton= (Button) findViewById(R.id.implicitButton);
        //显式intent
        blankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HttpActivity.class);
                startActivity(intent);
            }
        });

        //隐式intent,打开http
        httpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //不用Intent.ACTION_VIEW不出网页
                //Intent intent = new Intent(MainActivity.this, HttpActivity.class);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

        ImplicitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("TEST");
                startActivity(intent);
            }
        });
    }
}
