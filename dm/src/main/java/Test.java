import model.Student;
import service.StudentDAO;
import service.serviceImpl.StudentDAOImpl;

public class Test {

    public static void main ( String[] args ) {

        StudentDAO studentDAO = new StudentDAOImpl ( );
        Student student = new Student ( );
        student.setName ( "iii" );
        student.setAge ( 222 );


        System.out.println (studentDAO.addStu ( student ));
            //studentDAO.addStu ( student );


    }

}
