package mybatis.domain;

public class Student {

    private int id;
    private String name;
    private String typesOfCorrection;
    private String admissionData;
    private String mentorBrother;
    private String oath;

    public int getId ( ) {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getTypesOfCorrection ( ) {
        return typesOfCorrection;
    }

    public void setTypesOfCorrection ( String typesOfCorrection ) {
        this.typesOfCorrection = typesOfCorrection;
    }

    public String getAdmissionData ( ) {
        return admissionData;
    }

    public void setAdmissionData ( String admissionData ) {
        this.admissionData = admissionData;
    }

    public String getMentorBrother ( ) {
        return mentorBrother;
    }

    public void setMentorBrother ( String mentorBrother ) {
        this.mentorBrother = mentorBrother;
    }

    public String getOath ( ) {
        return oath;
    }

    public void setOath ( String oath ) {
        this.oath = oath;
    }

    @Override
    public String toString ( ) {
        return "\n"+"Student{" + "id=" + id + ", name='" + name + '\'' + ", typesOfCorrection='" + typesOfCorrection + '\'' + ", admissionData='" + admissionData + '\'' + ", mentorBrother='" + mentorBrother + '\'' + ", oath='" + oath + '\'' + '}';
    }
}