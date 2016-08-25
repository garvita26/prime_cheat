package com.iiitd.garvita.primequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.iiitd.garvita.primequiz.R.string.hint;

public class ShowHintActivity extends AppCompatActivity {

    private TextView mHint;
    private Button mShowHintButton;
    private Button mBackButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_hint);
        mShowHintButton = (Button) findViewById(R.id.button);
        mBackButton=(Button) findViewById(R.id.button2);
        mHint = (TextView) findViewById(R.id.textView);
        mShowHintButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        mHint.setText(getString(hint));
                       Intent hintIntent = new Intent();
                        hintIntent.putExtra("hintmessage",true);
                        setResult(ShowHintActivity.RESULT_OK,hintIntent);

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


                    }



