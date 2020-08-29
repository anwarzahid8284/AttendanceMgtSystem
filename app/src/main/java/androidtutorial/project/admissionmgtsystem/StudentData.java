package androidtutorial.project.admissionmgtsystem;

public class StudentData {
    public String stdName, stdRollNo, stdClass, stdSection, stdPassword, stdAcCDate;
    public StudentData(){}
    /*public StudentData(String stdName, String stdRollNo, String stdClass, String stdSection, String stdPassword, String stdAcCDate) {
        this.stdName = stdName;
        this.stdRollNo = stdRollNo;
        this.stdClass = stdClass;
        this.stdSection = stdSection;
        this.stdPassword = stdPassword;
        this.stdAcCDate = stdAcCDate;
    }*/

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getStdRollNo() {
        return stdRollNo;
    }

    public void setStdRollNo(String stdRollNo) {
        this.stdRollNo = stdRollNo;
    }

    public String getStdClass() {
        return stdClass;
    }

    public void setStdClass(String stdClass) {
        this.stdClass = stdClass;
    }

    public String getStdSection() {
        return stdSection;
    }

    public void setStdSection(String stdSection) {
        this.stdSection = stdSection;
    }

    public String getStdPassword() {
        return stdPassword;
    }

    public void setStdPassword(String stdPassword) {
        this.stdPassword = stdPassword;
    }

    public String getStdAcCDate() {
        return stdAcCDate;
    }

    public void setStdAcCDate(String stdAcCDate) {
        this.stdAcCDate = stdAcCDate;
    }
}
