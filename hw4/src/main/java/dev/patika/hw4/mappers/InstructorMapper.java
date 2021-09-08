package dev.patika.hw4.mappers;

import dev.patika.hw4.dto.PermanentInstructorDTO;
import dev.patika.hw4.dto.VisitingResearcherDTO;
import dev.patika.hw4.model.PermanentInstructor;
import dev.patika.hw4.model.VisitingResearcher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class InstructorMapper {

    public abstract PermanentInstructor mapFromPermanentInstructorDTOtoPermanentInstructor(PermanentInstructorDTO permanentInstructorDTO);

    public abstract PermanentInstructorDTO mapFromPermanentInstructortoPermanentInstructorDTO(PermanentInstructor permanentInstructor);

    public abstract VisitingResearcher mapFromVisitingResearcherDTOtoVisitingResearcher(VisitingResearcherDTO visitingResearcherDTO);

    public abstract VisitingResearcherDTO mapFromVisitingResearchertoVisitingResearcherDTO(VisitingResearcher visitingResearcher);

}
