package com.iiitd.garvita.primequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class ShowAnswerActivity extends AppCompatActivity {
    private Button mShowAnswerButton;
    private Button mBackButton;
    private TextView mAns;
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_answer);
        mShowAnswerButton = (Button) findViewById(R.id.button);
        mBackButton = (Button) findViewById(R.id.button2);
        mAns = (TextView) findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        final int mAnswer = bundle.getInt("cheatmessage");
        mShowAnswerButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        checkPrime(mAnswer);
                        if(!flag)
                        mAns.setText(R.string.isnotprime);
                        else
                        mAns.setText(R.string.isprime);
                        Intent ansIntent = new Intent();
                        ansIntent.putExtra("answermessage", true);
                        setResult(ShowHintActivity.RESULT_OK, ansIntent);

                    }

                }
        );
        mBackButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        finish();
                    }
                }
        );
    }

    private void checkPrime(int random) {
        flag = true;
        for (int i = 2; i <= random / 2; i++) {
            if (random % i == 0) {
                flag = false;
                break;
            }
        }
    }
}