package dev.patika.hw4.repository;

import dev.patika.hw4.model.Instructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermanentInstructorRepository extends InstructorRepository {

    // get 3 instructors with the greatest salary
    List<Instructor> findFirst3PermanentInstructorsByOrderByFixedSalaryDesc();

    //get 3 instructors with the lowest salary
    List<Instructor> findFirst3PermanentInstructorsByOrderByFixedSalaryAsc();

}