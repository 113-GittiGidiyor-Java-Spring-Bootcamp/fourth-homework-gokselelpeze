package dev.patika.hw4.service;

import dev.patika.hw4.dto.PermanentInstructorDTO;
import dev.patika.hw4.dto.VisitingResearcherDTO;
import dev.patika.hw4.exceptions.InstructorIsAlreadyExistException;
import dev.patika.hw4.mappers.InstructorMapper;
import dev.patika.hw4.model.Instructor;
import dev.patika.hw4.model.PermanentInstructor;
import dev.patika.hw4.model.VisitingResearcher;
import dev.patika.hw4.repository.InstructorRepository;
import dev.patika.hw4.repository.PermanentInstructorRepository;
import dev.patika.hw4.repository.VisitingResearcherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstructorService {


    private final InstructorRepository instructorRepository;
    private final PermanentInstructorRepository permanentInstructorRepository;
    private final VisitingResearcherRepository visitingResearcherRepository;
    private final InstructorMapper instructorMapper;

    public boolean existsById(int instructorId) {
        return instructorRepository.existsById(instructorId);
    }

    public List<Instructor> findAllInstructors() {
        return instructorRepository.findAll();
    }

    public Optional<Instructor> findInstructorById(int instructorId) {
        return instructorRepository.findById(instructorId);
    }

    /**
     * Check instructor is already existing
     * If not throw exception
     * Else save to db
     *
     * @param permanentInstructorDTO
     * @return Optional<Instructor>
     */
    @Transactional
    public Optional<Instructor> savePermanentInstructor(PermanentInstructorDTO permanentInstructorDTO) {
        PermanentInstructor instructor = instructorMapper.mapFromPermanentInstructorDTOtoPermanentInstructor(permanentInstructorDTO);
        if (Objects.nonNull(instructorRepository.findInstructorByPhoneNumber(instructor.getPhoneNumber()))) {
            throw new InstructorIsAlreadyExistException("Instructor " + instructor.getName() + " is already exists!");
        }
        return Optional.of(permanentInstructorRepository.save(instructor));
    }

    /**
     * Check instructor is already existing
     * If not throw exception
     * Else save to db
     *
     * @param visitingResearcherDTO
     * @return Optional<Instructor>
     */
    @Transactional
    public Optional<Instructor> saveVisitingResearcher(VisitingResearcherDTO visitingResearcherDTO) {
        VisitingResearcher instructor = instructorMapper.mapFromVisitingResearcherDTOtoVisitingResearcher(visitingResearcherDTO);
        if (Objects.nonNull(instructorRepository.findInstructorByPhoneNumber(instructor.getPhoneNumber()))) {
            throw new InstructorIsAlreadyExistException("Instructor " + instructor.getName() + " is already exists!");
        }
        return Optional.of(visitingResearcherRepository.save(instructor));
    }

    @Transactional
    public void deletePermanentInstructor(PermanentInstructor instructor) {
        instructorRepository.delete(instructor);
    }

    @Transactional
    public void deleteVisitingResearcher(VisitingResearcher instructor) {
        instructorRepository.delete(instructor);
    }

    @Transactional
    public void deleteInstructorById(int instructorId) {
        instructorRepository.deleteById(instructorId);
    }

    @Transactional
    public List<Instructor> findInstructorsByName(String name) {
        return instructorRepository.findInstructorsByName(name);
    }

    @Transactional
    public void deleteInstructorByName(String name) {
        instructorRepository.deleteInstructorByName(name);
    }

    public List<PermanentInstructor> findFirst3PermanentInstructorsByOrderByFixedSalaryDesc() {
        return permanentInstructorRepository.findFirst3PermanentInstructorsByOrderByFixedSalaryDesc();
    }

    public List<PermanentInstructor> findFirst3PermanentInstructorsByOrderByFixedSalaryAsc() {
        return permanentInstructorRepository.findFirst3PermanentInstructorsByOrderByFixedSalaryAsc();
    }

    public List<VisitingResearcher> findFirst3VisitingResearchersByOrderByHourlySalaryDesc() {
        return visitingResearcherRepository.findFirst3VisitingResearchersByOrderByHourlySalaryDesc();
    }

    public List<VisitingResearcher> findFirst3VisitingResearchersByOrderByHourlySalaryAsc() {
        return visitingResearcherRepository.findFirst3VisitingResearchersByOrderByHourlySalaryAsc();
    }

}
