package dev.patika.hw4.controller;

import dev.patika.hw4.dto.StudentDTO;
import dev.patika.hw4.model.Student;
import dev.patika.hw4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<?> findAllStudents() {
        return new ResponseEntity<>(studentService.findAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<?> findStudentById(@PathVariable int studentId) {
        Optional<Student> foundStudent = studentService.findStudentById(studentId);
        if (foundStudent.isPresent()) {
            return new ResponseEntity<>(foundStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student with id: " + studentId + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/students/")
    public ResponseEntity<?> saveStudent(@RequestBody @Valid StudentDTO studentDTO) {
        Optional<Student> resultOptional = studentService.saveStudent(studentDTO);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/students")
    public ResponseEntity<?> updateStudent(@RequestBody @Valid StudentDTO studentDTO) {
        Optional<Student> resultOptional = studentService.saveStudent(studentDTO);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/students")
    public ResponseEntity<String> deleteStudent(@RequestBody Student student) {
        int studentId = student.getId();
        if (studentService.existsById(studentId)) {
            studentService.deleteStudent(student);
            return new ResponseEntity<>("Student with id: " + studentId + " deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student with id: " + studentId + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/students/{studentId}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int studentId) {
        if (studentService.existsById(studentId)) {
            studentService.deleteStudentById(studentId);
            return new ResponseEntity<>("Student with id: " + studentId + " deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student with id: " + studentId + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/students/byName")
    public ResponseEntity<?> findStudentsByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        return new ResponseEntity<>(studentService.findStudentsByFirstNameAndLastName(firstName, lastName), HttpStatus.OK);
    }

    @GetMapping("/students/groupByGender")
    public ResponseEntity<?> getStudentsGendersWithGrouping() {
        return new ResponseEntity<>(studentService.getStudentsGendersWithGrouping(), HttpStatus.OK);
    }

    @DeleteMapping("/students/byName")
    public ResponseEntity<String> deleteStudentsByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        if (studentService.findStudentsByFirstNameAndLastName(firstName, lastName).isEmpty()) {
            return new ResponseEntity<>("Student with name: " + firstName + " " + lastName + " not found.", HttpStatus.BAD_REQUEST);
        } else {
            studentService.deleteStudentsByFirstNameAndLastName(firstName, lastName);
            return new ResponseEntity<>("Student(s) with name: " + firstName + " " + lastName + " deleted.", HttpStatus.OK);
        }
    }
}