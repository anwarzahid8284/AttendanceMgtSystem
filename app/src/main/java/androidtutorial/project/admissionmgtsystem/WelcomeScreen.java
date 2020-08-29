package androidtutorial.project.admissionmgtsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity implements View.OnClickListener {
    Button buttonAdmin, buttonStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdmin = (Button) findViewById(R.id.adminBtnId);
        buttonStudent = (Button) findViewById(R.id.studentBtnId);
        buttonStudent.setOnClickListener(this);
        buttonAdmin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.adminBtnId:
                Intent intentToAdmLogin = new Intent(this, AdminLogin.class);
                startActivity(intentToAdmLogin);
                finish();
                break;
            case R.id.studentBtnId:
                Intent intentToStdLogin = new Intent(this, StudentLogin.class);
                startActivity(intentToStdLogin);
                finish();
                break;
            default:
        }
    }
}
