package com.hit.text.dao;

import com.hit.text.annotation.ModelSubmit;
import com.hit.text.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yang
 * @create 2021-09-08 17:40
 */
@Mapper
public interface StudentMapper {
    @ModelSubmit
    Student selectById(int id);

    @ModelSubmit
    Student selectByName(String studentName);

    @ModelSubmit
    Student selectByStudentId(String studentId);

    @ModelSubmit
    List<Student> queryStudents(@Param("offset") int offset, @Param("limit") int limit);

    @ModelSubmit
    int findStudentRows();

    @ModelSubmit
    int insertStudent(Student student);

    @ModelSubmit
    int updateChinese(@Param("id") int id, @Param("chinese") int chinese);

    @ModelSubmit
    int updateMath(@Param("id") int id, @Param("math") int math);

    @ModelSubmit
    int updateEnglish(@Param("id") int id, @Param("english") int english);

    @ModelSubmit
    int updateStatus(@Param("id") int id, @Param("status") int status);
}
