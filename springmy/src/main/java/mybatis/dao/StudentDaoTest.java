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

    //@Test
    //public void testSelectStudent ( ) {
    //    System.out.println ("\n" );
    //Student student = dao.selectStudent ( 1 );
    //    System.out.println ( student );
    //}
//上面代码是根据id单个查询，下面是查询所有
    @Test
    public void testSelectStudent(){
        System.out.println ("\n" );

        List < Student > list = dao.selectStudent (  );
        System.out.println (list );
    }
    @Test
    public void testdeleteStudent ( ) {
        dao.deleteStudent ( 14 );
        System.out.println ( "数据删除成功" );
    }

    @Test
    public void testinsertStudent ( ) {
        for ( int a = 0 ; a < 10 ; a++ ) {
            Student student = new Student ( );
            student.setName ( "张文凯" );
            student.setTypesOfCorrection ( "java工程师" );
            student.setAdmissionData ( "2019-3-1" );
            student.setMentorBrother ( "李四" );
            student.setOath ( "唯吾独尊" );
            dao.insertStudent ( student );
            System.out.println ( "数据添加成功" );
        }
    }
    @Test
    public void testupdateStudent ( ) {
        Student student = new Student ( );
        student.setId ( 1 );
        student.setName ( "娃儿" );
        student.setTypesOfCorrection ( "web工程师" );
        student.setAdmissionData ( "2019-4-1" );
        student.setMentorBrother ( "李四" );
        student.setOath ( "唯吾独尊" );
        dao.updateStudent ( student );
    }

}