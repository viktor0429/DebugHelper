package yuxiaofei93.debughelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onDeveloperConfigClick(View view) {
        Intent intent = new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS");
        startActivity(intent);
    }

    public void onAccessibilityConfigClick(View view) {
        Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
        startActivity(intent);
    }
}
