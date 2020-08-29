package androidtutorial.project.admissionmgtsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StudentLogin extends AppCompatActivity implements View.OnClickListener {
    EditText rollNoEditText, passwordEditText;
    TextView clickTextView;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        // xml resource initialize
        rollNoEditText = (EditText) findViewById(R.id.rollNoId);
        passwordEditText = (EditText) findViewById(R.id.passwordId);
        clickTextView = (TextView) findViewById(R.id.clickHereId);
        loginBtn = (Button) findViewById(R.id.loginBtnId);
        loginBtn.setOnClickListener(this);
        clickTextView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginBtnId:
                Toast.makeText(this,"login button pressed",Toast.LENGTH_LONG).show();
                break;
            case R.id.clickHereId:
                Intent intentToRegisteredAc = new Intent(this, StudentRegistered.class);
                startActivity(intentToRegisteredAc);
                finish();
                break;
            default:

        }
    }
}
