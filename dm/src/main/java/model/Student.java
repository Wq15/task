package model;

public class Student {

    private int id;
    private String name;
    private String typesOfConnection;
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

    public String getTypesOfConnection ( ) {
        return typesOfConnection;
    }

    public void setTypesOfConnection ( String typesOfConnection ) {
        this.typesOfConnection = typesOfConnection;
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
        return "Student{" + "id=" + id + ", name='" + name + '\'' + ", typesOfConnection='" + typesOfConnection + '\'' + ", admissionData='" + admissionData + '\'' + ", mentorBrother='" + mentorBrother + '\'' + ", oath='" + oath + '\'' + '}';
    }
}
