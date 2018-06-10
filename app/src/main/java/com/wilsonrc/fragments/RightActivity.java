package com.wilsonrc.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RightActivity extends AppCompatActivity {


    private final static String INTENT_KEY_MESSAGE = "INTENT_KEY_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right);

        // Get intent and transferred message.
        Intent intent = getIntent();
        String message = intent.getStringExtra(INTENT_KEY_MESSAGE);

        // Show the message in the text view.
        TextView textView = (TextView)findViewById(R.id.fragmentRightTextView);
        textView.setText(message);
    }

    public void startActivity(Context ctx, String message)
    {
        Intent intent  = new Intent(ctx, RightActivity.class);
        intent.putExtra(INTENT_KEY_MESSAGE, message);
        ctx.startActivity(intent);
    }
}
