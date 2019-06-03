package mybatis.dao;
import mybatis.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration ( locations = "classpath:applicationContext-common.xml" )
@RunWith ( SpringJUnit4ClassRunner.class )
public class StudentDaoTest {
    @Autowired
    private StudentDao dao;

//    @Test
//    public void testSelectStudent ( ) {
//        System.out.println ("\n" );
//    Student student = dao.selectStudent ( 30 );
//        System.out.println ( student );
//    }
//上面代码是根据id单个查询，下面是查询所有
    @Test
    public void testSelectStudent(){
        System.out.println ("\n" );
        Student student=new Student ();
        List < Student > list = dao.selectStudent ( student );
        System.out.println (list );
        //final Logger logger = Logger.getLogger ( MimeTypeUtils.class.getName ( ) );
    }

    @Test
    public void testdeleteStudent ( ) {
        //Student student = dao.deleteStudent ( 35 );
        dao.deleteStudent ( 30 );
        System.out.println ( "数据删除成功" );
    }

    @Test
    public void testinsertStudent ( ) {
        for ( int a = 0 ; a < 10 ; a++ ) {
            Student student = new Student ( );
            student.setName ( "wqe" );
            student.setAge ( 8 );
            dao.insertStudent ( student );
            System.out.println ( "数据添加成功" );
        }
    }
    @Test
    public void testupdateStudent ( ) {
        Student student = new Student ( );
        student.setId (33);
        student.setName ( "qqq" );
        student.setAge ( 80 );
        dao.updateStudent ( student );
    }

}