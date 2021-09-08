package dev.patika.hw4.repository;

import dev.patika.hw4.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    List<Instructor> findInstructorsByName(String name);

    void deleteInstructorByName(String firstName);

    Instructor findInstructorByPhoneNumber(String phoneNumber);

}
