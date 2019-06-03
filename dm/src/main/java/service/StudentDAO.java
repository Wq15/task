package service;


import model.Student;

public  interface StudentDAO {

     boolean addStu(Student stu);

    boolean delStu(Student stu);

    boolean updateStu(Student stu);

    boolean queryStu( Student stu);

    void selectStu( Student stu);
    }




