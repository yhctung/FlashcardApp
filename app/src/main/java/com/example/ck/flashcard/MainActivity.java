package com.example.ck.flashcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
            }
        });

        findViewById(R.id.flashcard_answer).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_answer).setVisibility(View.INVISIBLE);
            }
        });

        // when plus clicked, start AddCardActivity
        findViewById(R.id.Plus).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddCardActivity.class);
                i.putExtra("mode", 2); // pass arbitrary data to launched activity
                startActivityForResult(i, 100);
            }
        });
    }

    /* First shot
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            String question = data.getExtras().getString("question");
            String answer = data.getExtras().getString("answer");

            ((TextView) findViewById(R.id.flashcard_answer)).setText(question);
            ((TextView) findViewById(R.id.flashcard_question)).setText(answer);
        }

    }
    */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 100) {

            // Extract name value from result extras
            String question = data.getExtras().getString("Question");
            String answer = data.getExtras().getString("Answer");
            int code = data.getExtras().getInt("code", 0);

            ((TextView) findViewById(R.id.flashcard_answer)).setText(answer);
            ((TextView) findViewById(R.id.flashcard_question)).setText(question);
        }
    }


}

