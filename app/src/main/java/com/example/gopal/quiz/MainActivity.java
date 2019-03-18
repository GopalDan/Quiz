package com.example.gopal.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup mRadiogroup1;
    boolean firstTime = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRadiogroup1 = findViewById(R.id.radioGroup1);
        mRadiogroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedRadioButtonId) {
                if(!firstTime) {

                    switch (checkedRadioButtonId) {
                        case R.id.question_1_option_1:
                            Toast.makeText(MainActivity.this, "Correct answered", Toast.LENGTH_SHORT).show();
                            for(int i = 0;  i < mRadiogroup1.getChildCount(); i++){
                                if(i!=0){
                                    mRadiogroup1.getChildAt(i).setClickable(false);}
                            }
                            break;
                        default:
                            Toast.makeText(MainActivity.this, "Wrong answered", Toast.LENGTH_SHORT).show();
                            for(int i = 0;  i < mRadiogroup1.getChildCount(); i++){
                                mRadiogroup1.getChildAt(i).setClickable(false);
                            }
                    }
                    firstTime = true;
                }
                else{
                    Toast.makeText(MainActivity.this, "You have already answered", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
