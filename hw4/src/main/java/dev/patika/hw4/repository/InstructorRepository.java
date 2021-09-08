package dev.patika.hw4.repository;

import dev.patika.hw4.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    List<Instructor> findInstructorsByFirstNameAndLastName(String firstName, String lastName);

    void deleteInstructorByFirstNameAndLastName(String firstName, String lastName);

    Instructor findInstructorByPhoneNumber(String phoneNumber);

}
