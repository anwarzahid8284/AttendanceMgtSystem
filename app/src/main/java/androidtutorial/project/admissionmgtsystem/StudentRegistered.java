package androidtutorial.project.admissionmgtsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class StudentRegistered extends AppCompatActivity implements View.OnClickListener {
    EditText editTextName, editTextRollNo, editTextCDate, editTextPassword, editTextSection;
    TextView textViewClickhere;
    Button buttonRegistered;
    Spinner spinnerClass;
    StudentData studentData;
    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registered);
        // xml resource initialize
        editTextName = (EditText) findViewById(R.id.nameId);
        editTextRollNo = (EditText) findViewById(R.id.rollNoId);
        editTextCDate = (EditText) findViewById(R.id.cDateId);
        editTextPassword = (EditText) findViewById(R.id.passwordId);
        editTextSection = (EditText) findViewById(R.id.classSectionId);
        textViewClickhere = (TextView) findViewById(R.id.clickHereId);
        buttonRegistered = (Button) findViewById(R.id.registeredBtnId);
        spinnerClass = (Spinner) findViewById(R.id.classSpinner);
        dataBase = new DataBase(this);
        studentData=new StudentData();
        buttonRegistered.setOnClickListener(this);
        textViewClickhere.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registeredBtnId:
                studentRegistered();
                if (dataBase.insertQuery()) {
                    Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, StudentHome.class);
                    startActivity(intent);
                    finish();
                } else {
                    SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
                    pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                    pDialog.setTitleText("Oops...");
                    pDialog.setContentText("User already exist.");
                    pDialog.show();
                }
                break;
            case R.id.clickHereId:
                Intent intentToLoginAc = new Intent(this, StudentLogin.class);
                startActivity(intentToLoginAc);
                break;
            default:
        }
    }

    private void studentRegistered() {
        String stdName = editTextName.getText().toString().trim();
        String stdRollNo = editTextRollNo.getText().toString().trim();
        String stdClass = spinnerClass.getSelectedItem().toString().trim();
        String stdClassSection = editTextSection.getText().toString().trim();
        String stdPassword = editTextPassword.getText().toString().trim();
        final Calendar myCalendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            }
        };
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        editTextCDate.setText(sdf.format(myCalendar.getTime()));
        String cDate = sdf.format(myCalendar.getTime());
        if (stdName.isEmpty()) {
            editTextName.setFocusable(false);
            editTextName.setError("Name is required");
        } else if (stdRollNo.isEmpty()) {
            editTextRollNo.setFocusable(false);
            editTextRollNo.setError("Roll No is required");
        } else if (stdPassword.isEmpty()) {
            editTextPassword.setFocusable(false);
            editTextPassword.setError("Password is required");
        } else if (cDate.isEmpty()) {
            editTextCDate.setFocusable(false);
            editTextCDate.setError("CDate is required");
        } else {
                studentData.setStdName(stdName);
                studentData.setStdRollNo(stdRollNo);
                studentData.setStdClass(stdClass);
                studentData.setStdSection(stdClassSection);
                studentData.setStdAcCDate(cDate);
                studentData.setStdPassword(stdPassword);
        }
    }
}
