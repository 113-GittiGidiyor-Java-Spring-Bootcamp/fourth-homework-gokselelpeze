package dev.patika.hw4.repository;

import dev.patika.hw4.model.Instructor;
import dev.patika.hw4.model.PermanentInstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermanentInstructorRepository extends InstructorRepository {

    // get 3 instructors with the greatest salary
    List<PermanentInstructor> findFirst3PermanentInstructorsByOrderByFixedSalaryDesc();

    //get 3 instructors with the lowest salary
    List<PermanentInstructor> findFirst3PermanentInstructorsByOrderByFixedSalaryAsc();

}