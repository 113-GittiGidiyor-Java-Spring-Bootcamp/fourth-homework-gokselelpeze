package dev.patika.hw4.mappers;

import dev.patika.hw4.dto.StudentDTO;
import dev.patika.hw4.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {

    public abstract Student mapFromStudentDTOtoStudent(StudentDTO studentDTO);

    public abstract StudentDTO mapFromStudenttoStudentDTO(Student student);

}
