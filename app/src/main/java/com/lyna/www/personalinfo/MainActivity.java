package com.lyna.www.personalinfo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    EditText editTextName, editTextAge;
    RadioButton radioButtonWoman, radioButtonMan;
    RadioButton radioButtonStudent, radioButtonWorker;
    Button buttonResult;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText)findViewById(R.id.editTextName);
        editTextAge = (EditText)findViewById(R.id.editTextAge);

        radioButtonWoman = (RadioButton)findViewById(R.id.radioButtonWoman);
        radioButtonMan = (RadioButton)findViewById(R.id.radioButtonMan);
        radioButtonStudent = (RadioButton)findViewById(R.id.radioButtonStudent);
        radioButtonWorker = (RadioButton)findViewById(R.id.radioButtonWorker);
        buttonResult = (Button)findViewById(R.id.buttonResult);
        buttonResult.setOnClickListener(this);
        textViewResult = (TextView)findViewById(R.id.textViewResult);

        editTextName.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if((event.getAction()==KeyEvent.ACTION_DOWN) && (keyCode==KeyEvent.KEYCODE_ENTER)) {

                    InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                    return true;
                }
                return false;
            }
        });
        editTextAge.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if((event.getAction()==KeyEvent.ACTION_DOWN) && (keyCode==KeyEvent.KEYCODE_ENTER)) {

                    InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.buttonResult) {
            String sex;
            String opportunity;

            if (radioButtonWoman.isChecked()) sex = "여자";
            else sex = "남자";

            if (radioButtonStudent.isChecked()) opportunity = "학생";
            else opportunity = "직장인";

            String str = "이름은 " + editTextName.getText() + ", " + "나이는 " + editTextAge.getText() + ", "
                    + "성별은 " + sex + ", " + "직업은 " + opportunity + "입니다";

            textViewResult.setText(str);
        }
    }
}
