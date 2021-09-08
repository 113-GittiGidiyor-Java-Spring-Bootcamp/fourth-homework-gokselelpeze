package dev.patika.hw4.mappers;

import dev.patika.hw4.dto.CourseDTO;
import dev.patika.hw4.model.Course;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper {

    Course mapFromCourseDTOtoCourse(CourseDTO courseDTO);

    CourseDTO mapFromCoursetoCourseDTO(Course course);

}
