package dev.patika.hw4.repository;

import dev.patika.hw4.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findStudentsByFirstNameAndLastName(String firstName, String lastName);

    @Query("select s.gender, count(s.gender) from Student s GROUP BY s.gender")
    List<?> getStudentsGendersWithGrouping();

    void deleteStudentsByFirstNameAndLastName(String firstName, String lastName);


}
