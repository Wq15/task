import model.Student;
import service.StudentDAO;
import service.serviceImpl.StudentDAOImpl;

public class Test {

    public static void main ( String[] args ) {

            StudentDAO studentDAO = new StudentDAOImpl ( );
            Student student = new Student ( );
            student.setName ( "iii" );
            student.setTypesOfConnection ( "java工程师" );
            student.setAdmissionData ( "2019-2-3" );
            student.setMentorBrother ( "张三" );
            student.setOath ( "不学好就是猪" );

            //for(int x = 0 ; x < 100 ; x++) {
            studentDAO. addStu ( student );
        //}

    }

}
