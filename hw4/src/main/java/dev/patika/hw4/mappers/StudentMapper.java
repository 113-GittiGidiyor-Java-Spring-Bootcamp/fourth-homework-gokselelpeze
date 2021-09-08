package dev.patika.hw4.mappers;

import dev.patika.hw4.dto.StudentDTO;
import dev.patika.hw4.model.Student;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper {

    Student mapFromStudentDTOtoStudent(StudentDTO dto);

    StudentDTO mapFromStudenttoStudentDTO(Student customer);

}
