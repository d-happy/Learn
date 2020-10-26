package com.kh.tabhostex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find 안 쓰고, TabHost 전용 ~~ 사용
        TabHost tabhost = getTabHost();

        //탭 설정
        TabHost.TabSpec sepRed = tabhost.newTabSpec("RED").setIndicator("빨강");
        TabHost.TabSpec sepGreen = tabhost.newTabSpec("GREEN").setIndicator("초록");
        TabHost.TabSpec sepBlue = tabhost.newTabSpec("BLUE").setIndicator("파랑");

        //탭 선택 시 사용할 뷰 시정
        sepRed.setContent(R.id.layoutRed);
        sepGreen.setContent(R.id.layoutGreen);
        sepBlue.setContent(R.id.layoutBlue);

        //탭 달기
        tabhost.addTab(sepRed);
        tabhost.addTab(sepGreen);
        tabhost.addTab(sepBlue);

        //시작 탭 지정
        tabhost.setCurrentTab(0);
    }

}//class