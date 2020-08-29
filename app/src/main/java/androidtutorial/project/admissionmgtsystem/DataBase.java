package androidtutorial.project.admissionmgtsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "AttendanceMgtSystem";
    private static final String StudentAC_TB = "Student_TB";
    private static final String AdminAC_TB = "Admin_TB";
    private static final String Attendance_TB = "Attendance_TB";
    //create column name for student table
    private static final String studentId = "studentId";
    private static final String studentRollNo = "studentRollNo";
    private static final String studentName = "studentName";
    private static final String studentClass = "className";
    private static final String classSection = "classSection";
    private static final String studentPicture = "studentPicture";
    private static final String studentAcDate = "createdDate";
    private static final String studentPassword = "studentPassword";
    // create column name for admin table
    private static final String adminId = "adminId";
    private static final String adminName = "adminName";
    private static final String adminEmail = "adminEmail";
    private static final String adminPicture = "adminPicture";
    private static final String adminPassword = "adminPassword";
    private static final String adminAcDate = "adminCDate";
    // created column name for attendance table
    private static final String attendanceId = "attendanceId";
    private static final String attendanceStatus = "attendanceStatus";
    private static final String attendanceDate = "attendanceDate";
    StudentData studentData;
    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        studentData=new StudentData();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create table of student
        String createStudentTB = "Create table " + StudentAC_TB + "(" + studentId + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                "" + studentRollNo + " TEXT NOT NULL," + studentName + " TEXT NOT NULL," + studentClass + " TEXT NOT NULL," +
                "" + classSection + " TEXT," + studentPicture + " LONGBLOB," +
                "" + studentAcDate + " DATE NOT NULL," + studentPassword + " TEXT NOT NULL" + ")";
        // create table of admin
        String createAdminTB = "Create table " + AdminAC_TB + "(" + adminId + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                "" + adminName + " TEXT NOT NULL," + adminEmail + " TEXT NOT NULL," + adminAcDate + " DATE NOT NULL," +
                "" + adminPassword + " TEXT NOT NULL," + adminPicture + " LONGBLOB" + ")";
        // create table of attendance
        String createAttendanceTB = "Create table " + Attendance_TB + "(" + attendanceId + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                "" + attendanceStatus + " INTEGER NOT NULL," + attendanceDate + " DATE NOT NULL," +studentId+" INTEGER,"+adminId+" INTEGER,"+
                "FOREIGN KEY (" + studentId + ") REFERENCES " + StudentAC_TB + "(" + studentId + ")," +
                "FOREIGN KEY (" + adminId + ") REFERENCES " + AdminAC_TB + "(" + adminId + ")" + ")";
        // execute queries for all table
        try {
            db.execSQL(createStudentTB);
            db.execSQL(createAdminTB);
            db.execSQL(createAttendanceTB);
        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + StudentAC_TB);
        db.execSQL("DROP TABLE IF EXISTS " + AdminAC_TB);
        db.execSQL("DROP TABLE IF EXISTS " + Attendance_TB);

        // Create tables again
        onCreate(db);
    }

    public boolean insertQuery() {
        SQLiteDatabase db = this.getWritableDatabase();
        if (selectQuery()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(studentName, studentData.getStdName());
            contentValues.put(studentRollNo, studentData.getStdRollNo());
            contentValues.put(studentClass, studentData.getStdClass());
            contentValues.put(classSection, studentData.getStdSection());
            contentValues.put(studentAcDate, studentData.getStdAcCDate());
            contentValues.put(studentPassword, studentData.getStdPassword());
            db.insert(StudentAC_TB, null, contentValues);
            db.close();
            return true;
        } else {
            return false;
        }

    }

    public boolean selectQuery() {
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            String checkStudent = "Select * from "+StudentAC_TB + " where "+studentRollNo+"=" + studentData.getStdRollNo();
            Cursor cursor = db.rawQuery(checkStudent, null);
            if (cursor.getCount() <= 0) {
                cursor.close();
                return true;
            } else {
                cursor.close();
                return false;
            }
        }catch (Exception e){
            e.getMessage();
        }
        return false;
    }

    public void updateQuery() {

    }
}
