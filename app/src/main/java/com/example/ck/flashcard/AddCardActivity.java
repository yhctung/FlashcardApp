package com.example.ck.flashcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        // when cancel clicked, stop AddCardActivity
        findViewById(R.id.Cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.Cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCardActivity.this, MainActivity.class);
                AddCardActivity.this.startActivity(intent);
            }

        });

        // when check clicked, send data to main and go
        findViewById(R.id.Check).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            EditText Q = (EditText) findViewById(R.id.QuestionField);
            EditText A = (EditText) findViewById(R.id.AnswerField);

            // Prepare data intent
            Intent data = new Intent();

            // Pass relevant data back as a result
            data.putExtra("Question", Q.getText().toString());
            data.putExtra("Answer", A.getText().toString());
            data.putExtra("code", 100); // ints work too

            // Activity finished ok, return the data
            setResult(RESULT_OK, data); // set result code and bundle data for response
            finish(); // closes the activity, pass data to parent
        }
        });
    }
}
