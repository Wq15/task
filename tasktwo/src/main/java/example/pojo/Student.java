package example.pojo;

public class Student {

    private Integer id;
    private String name;
    private String qq;
    private String typesOfCorrection;
    private String admissionDate;
    private String graduateSchool;
    private Integer studentId;
    private String dailyLink;
    private String mentorBrother;
    private String oath;

    public Student(){}
    public Student(Integer id, String name, String qq, String typesOfCorrection, String admissionDate, String graduateSchool, Integer studentId, String dailyLink, String mentorBrother, String oath) {
        this.id = id;
        this.name = name;
        this.qq = qq;
        this.typesOfCorrection = typesOfCorrection;
        this.admissionDate = admissionDate;
        this.graduateSchool = graduateSchool;
        this.studentId = studentId;
        this.dailyLink = dailyLink;
        this.mentorBrother = mentorBrother;
        this.oath = oath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getTypesOfCorrection() {
        return typesOfCorrection;
    }

    public void setTypesOfCorrection(String typesOfCorrection) {
        this.typesOfCorrection = typesOfCorrection;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getDailyLink() {
        return dailyLink;
    }

    public void setDailyLink(String dailyLink) {
        this.dailyLink = dailyLink;
    }

    public String getMentorBrother() {
        return mentorBrother;
    }

    public void setMentorBrother(String mentorBrother) {
        this.mentorBrother = mentorBrother;
    }

    public String getOath() {
        return oath;
    }

    public void setOath(String oath) {
        this.oath = oath;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", typesOfCorrection='" + typesOfCorrection + '\'' +
                ", admissionDate='" + admissionDate + '\'' +
                ", graduateSchool='" + graduateSchool + '\'' +
                ", studentId=" + studentId +
                ", dailyLink='" + dailyLink + '\'' +
                ", mentorBrother='" + mentorBrother + '\'' +
                ", oath='" + oath + '\'' +
                '}';
    }
}

