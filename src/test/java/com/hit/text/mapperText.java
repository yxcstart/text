package com.hit.text;

import com.hit.text.dao.HttpMapper;
import com.hit.text.dao.SQLMapper;
import com.hit.text.dao.StudentMapper;
import com.hit.text.entity.Http;
import com.hit.text.entity.SQLStatement;
import com.hit.text.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author yang
 * @create 2021-09-08 19:24
 */
@SpringBootTest
public class mapperText {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    HttpMapper httpMapper;
    @Autowired
    SQLMapper sqlMapper;

    @Test
    public void insertStudent() {
        Student tom = new Student("tom", "19S054001", 95, 98, 92, 0);
        Student jerry = new Student("jerry", "19S054002", 94, 99, 95, 0);
        studentMapper.insertStudent(tom);
        studentMapper.insertStudent(jerry);

    }

    @Test
    public void selectById() {
        System.out.println(studentMapper.selectById(1));
    }

    @Test
    public void selectByName() {
        System.out.println(studentMapper.selectByName("tom"));
    }

    @Test
    public void selectByStudentId() {
        System.out.println(studentMapper.selectByStudentId("19S054003"));
    }

    @Test
    public void updateChinese() {
        studentMapper.updateChinese(1, 90);
        System.out.println(studentMapper.selectById(1));
    }

    @Test
    public void updateMath() {
        studentMapper.updateMath(1, 92);
        System.out.println(studentMapper.selectById(1));
    }

    @Test
    public void updateEnglish() {
        studentMapper.updateEnglish(1, 95);
        System.out.println(studentMapper.selectById(1));
    }

    @Test
    public void updateStatus() {
        studentMapper.updateStatus(1, 1);
    }

    @Test
    public void queryStudents() {
        List<Student> students = studentMapper.queryStudents(0, 3);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void queryRows() {
        System.out.println(studentMapper.findStudentRows());
    }

    @Test
    public void insert() {
        Http http = new Http("2021-09-08", "127.0.0.1", 8080, "/text", "http", "测试", "测试", "测试", "测试");
        httpMapper.insertHttp(http);
    }

    @Test
    public void insertSql() {
        SQLStatement statement = new SQLStatement("2021-09-09", "127.0.0.1", 8080, "测试");
        sqlMapper.insertSql(statement);
    }

}
