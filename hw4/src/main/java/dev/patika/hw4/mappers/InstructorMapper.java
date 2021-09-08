package dev.patika.hw4.mappers;

import dev.patika.hw4.dto.PermanentInstructorDTO;
import dev.patika.hw4.dto.VisitingResearcherDTO;
import dev.patika.hw4.model.PermanentInstructor;
import dev.patika.hw4.model.VisitingResearcher;
import org.mapstruct.Mapper;

@Mapper
public interface InstructorMapper {

    PermanentInstructor mapFromPermanentInstructorDTOtoPermanentInstructor(PermanentInstructorDTO permanentInstructorDTO);

    PermanentInstructorDTO mapFromPermanentInstructortoPermanentInstructorDTO(PermanentInstructor permanentInstructor);

    VisitingResearcher mapFromVisitingResearcherDTOtoVisitingResearcher(VisitingResearcherDTO visitingResearcherDTO);

    VisitingResearcherDTO mapFromVisitingResearchertoVisitingResearcherDTO(VisitingResearcher visitingResearcher);

}
