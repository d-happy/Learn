package com.kh.intentvote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView[] imges = new ImageView[9];
    int[] imagesId = {R.id.pic1, R.id.pic2, R.id.pic3,
            R.id.pic4, R.id.pic5, R.id.pic6,
            R.id.pic7, R.id.pic8, R.id.pic9};
    String[] imagesName = {"책소녀", "모자소녀", "부채소녀", "긴머리소녀",
            "조는소녀", "두소녀", "피아노소녀", "피아노두소녀", "의자소녀"};
    int[] imagesVote = new int[imges.length];
    //int[] rank = new int[imges.length]; //순위에 따라 배열 순서 바꿔서 필요 없음
    Button btnNext; //int index=0;

    int[] src = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
            R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
            R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setListener();
    }

    private void setListener() {
        btnNext.setOnClickListener(this);
        for (int i=0; i<imges.length; i++) {
            imges[i].setOnClickListener(this);
        }
    }//setListener

    private void findView() {
        btnNext = findViewById(R.id.btnNext);
        for (int i=0; i<imges.length; i++) {
            imges[i] = findViewById(imagesId[i]);
            imges[i].setTag(imagesName[i]);
        }
    }//findView

    @Override
    public void onClick(View v) {
        for(int i=0; i<imges.length; i++) {
            if (v == imges[i]) {
                if (imagesVote[i] < 5) {
                    imagesVote[i]++;
                } //5 넘어가면 클릭해도 반응 없음
                /*if (imagesVote[i] == 6) {
                    imagesVote[i] = 1;
                }*/ //1~5 값 들어가고 6 이상은 없음

                Log.d("mytag", String.valueOf
                        (imges[i].getTag()+" : "+imagesVote[i]));
                Toast.makeText(this,
                        imges[i].getTag() +" : "+ imagesVote[i], Toast.LENGTH_SHORT).show();
            }
        }//imges[i]

        if (v == btnNext) {
            rank();

            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("src", src); //int[]
            intent.putExtra("imagesName", imagesName); //String[]
            intent.putExtra("imagesVote", imagesVote); //int[]
            startActivity(intent);
        }
    }//onClick

    private void rank() {
        int tempNum = 0;
        String tempStr = "null";

        for (int i=0; i < imges.length; i++) {
            for (int j=0; j < i; j++) { //Like 로또 반복 제거
                if (imagesVote[i] > imagesVote[j]) {

                    tempNum = src[j];
                    src[j] = src[i];
                    src[i] = tempNum;

                    tempStr = imagesName[j];
                    imagesName[j] = imagesName[i];
                    imagesName[i] = tempStr;

                    tempNum = imagesVote[j];
                    imagesVote[j] = imagesVote[i];
                    imagesVote[i] = tempNum;
                }
            }
        }//for
    }//rank

}//MainActivity