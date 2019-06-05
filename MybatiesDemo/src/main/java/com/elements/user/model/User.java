package com.elements.user.model;

public class User {
    private int Id;
    private String Name;
    private String Types_of_correction;
    private String Admission_data;
    private String Mentor_brother;
    private String Oath;

    public int getId ( ) {
        return Id;
    }

    public void setId ( int id ) {
        Id = id;
    }

    public String getName ( ) {
        return Name;
    }

    public void setName ( String name ) {
        Name = name;
    }

    public String getTypes_of_correction ( ) {
        return Types_of_correction;
    }

    public void setTypes_of_correction ( String types_of_correction ) {
        Types_of_correction = types_of_correction;
    }

    public String getAdmission_data ( ) {
        return Admission_data;
    }

    public void setAdmission_data ( String admission_data ) {
        Admission_data = admission_data;
    }

    public String getMentor_brother ( ) {
        return Mentor_brother;
    }

    public void setMentor_brother ( String mentor_brother ) {
        Mentor_brother = mentor_brother;
    }

    public String getOath ( ) {
        return Oath;
    }

    public void setOath ( String oath ) {
        Oath = oath;
    }

    @Override
    public String toString ( ) {
        return"\n"+ "User{" + "Id=" + Id + ", Name='" + Name + '\'' + ", Types_of_correction='" + Types_of_correction + '\'' + ", Admission_data='" + Admission_data + '\'' + ", Mentor_brother='" + Mentor_brother + '\'' + ", Oath='" + Oath + '\'' + '}';
    }
}