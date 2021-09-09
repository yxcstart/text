package com.hit.text.service;

import com.hit.text.dao.StudentMapper;
import com.hit.text.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yang
 * @create 2021-09-08 20:41
 */
@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public Student findStudentById(int id){
        return studentMapper.selectById(id);
    }

    public Student findStudentByName(String name) {
        return studentMapper.selectByName(name);
    }

    public Student findStudentByStudentId(String studentId) {
        return studentMapper.selectByStudentId(studentId);
    }

    public List<Student> findStudents(int offset, int limit) {
        return studentMapper.queryStudents(offset, limit);
    }

    public int findRows() {
        return studentMapper.findStudentRows();
    }

    public int addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("参数不能为空");
        }
        return studentMapper.insertStudent(student);
    }

    public void updateChinese(int id, int chinese) {
        studentMapper.updateChinese(id, chinese);
    }

    public void updateMath(int id, int math) {
        studentMapper.updateMath(id, math);
    }

    public void updateEnglish(int id, int english) {
        studentMapper.updateEnglish(id, english);
    }

    public void deleteStudent(int id) {
        studentMapper.updateStatus(id, 1);
    }
}
