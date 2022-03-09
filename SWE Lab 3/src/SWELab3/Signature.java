package SWELab3;

public class Signature {

    private String student;
    private String personToSign;

    public Signature(String student, String personToSign) {
        this.student = student;
        this.personToSign = personToSign;
    }

    public String getStudent() {
        return student;
    }

    public String getPersonToSign() {
        return personToSign;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public void setPersonToSign(String personToSign) {
        this.personToSign = personToSign;
    }

}
