package com.example.root.roomlivedatajava.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.root.roomlivedatajava.R;
import com.example.root.roomlivedatajava.databinding.ActivityAddWordBinding;

public class AddWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY =
            "com.example.android.roomwordssample.REPLY";

    ActivityAddWordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_add_word);
        initialize();

    }

    private void initialize(){
        OnClickListenerWithView onClickListener=new OnClickListenerWithView() {
            @Override
            public void onClick(View view) {
                EditText mEditWordView=(EditText) view;
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditWordView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = mEditWordView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, word);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        };

        binding.setOnClickListenerWithView(onClickListener);

    }
}
