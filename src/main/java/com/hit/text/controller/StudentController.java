package com.hit.text.controller;

import com.hit.text.entity.Page;
import com.hit.text.entity.Student;
import com.hit.text.service.StudentService;
import com.hit.text.utils.StudentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yang
 * @create 2021-09-08 21:18
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndex(Model model, Page page) {
        page.setRows(studentService.findRows());
        page.setPath("/text");
        List<Student> students = studentService.findStudents(page.getOffset(), page.getLimit());
        model.addAttribute("students", students);
        return "/index";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addStudent(String studentName, String studentId, int chinese, int math, int english) {
        Student student = new Student(studentName, studentId, chinese, math, english, 0);
        studentService.addStudent(student);
        return StudentUtils.getJSONString(0, "添加成功");
    }

    @RequestMapping(path = "/detail/{id}", method = RequestMethod.GET)
    public String getDetails(@PathVariable("id") int id, Model model) {
        Student student = studentService.findStudentById(id);
        model.addAttribute("student", student);
        return "/site/student-detail";
    }
    @RequestMapping(path = "/update/{id}",method = RequestMethod.POST)
    public String update(@PathVariable("id") int id,Student student, Model model){
        studentService.updateChinese(id, student.getChinese());
        studentService.updateMath(id, student.getMath());
        studentService.updateEnglish(id, student.getEnglish());
        Student stu = studentService.findStudentById(id);
        model.addAttribute("student", stu);
        return "/site/student-detail";
    }
    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String deleteGlass(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return "redirect:/index";
    }
}
