package dev.patika.hw4.repository;

import dev.patika.hw4.model.Instructor;
import dev.patika.hw4.model.VisitingResearcher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitingResearcherRepository extends InstructorRepository {

    // get 3 instructors with the greatest salary
    List<VisitingResearcher> findFirst3VisitingResearchersByOrderByHourlySalaryDesc();

    //get 3 instructors with the lowest salary
    List<VisitingResearcher> findFirst3VisitingResearchersByOrderByHourlySalaryAsc();

}
