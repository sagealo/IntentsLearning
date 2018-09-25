package com.example.per2.intentslearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SendMessageActivity extends AppCompatActivity {
    private Button buttonSendMessage;
    private Button buttonShare;
    private EditText editTextMessage;

    public static final String EXTRA_SENT_MESSAGE = "the message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        wireWidgets();

        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get text from the editText
                String message = editTextMessage.getText().toString();
                //create an intent
                Intent intentSendMessage =
                        new Intent(SendMessageActivity.this, ReceiveMessageActivity.class);
                //package the text into the intent
                intentSendMessage.putExtra( EXTRA_SENT_MESSAGE, message);
                //start the new activity
                startActivity(intentSendMessage);
            }
        });
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make intent with desired action
                Intent intentShareMessage = new Intent(Intent.ACTION_SEND);
                //set the data type of the stuff we are packaging away
                intentShareMessage.setType("text/plain");
                //put the extra with the message
                intentShareMessage.putExtra(EXTRA_SENT_MESSAGE,
                        editTextMessage.getText().toString());
                //launch the activity
                startActivity(intentShareMessage);
            }
        });
    }

    private void wireWidgets() {
        buttonSendMessage = findViewById(R.id.button_sendmessage_send);
        editTextMessage = findViewById(R.id.edittext_sendmessage_msg);
        buttonShare = findViewById(R.id.button_sendmessage_share);
    }
}
