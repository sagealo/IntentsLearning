package com.example.per2.intentslearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveMessageActivity extends AppCompatActivity {
    private TextView textViewDisplayMesage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        textViewDisplayMesage = findViewById(R.id.textview_receivemessage_displaymessage);
        textViewDisplayMesage.setText
                (getIntent().getStringExtra(SendMessageActivity.EXTRA_SENT_MESSAGE));
    }

}
