package dev.patika.hw4.mappers;

import dev.patika.hw4.dto.CourseDTO;
import dev.patika.hw4.model.Course;
import dev.patika.hw4.service.CourseService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CourseMapper {

    @Autowired
    protected CourseService courseService;

    @Mapping(target = "customer", expression = "java(courseService.findCustomerById(courseDTO.getCustomerId()))")
    @Mapping(target = "createDate", expression = "java(java.time.LocalDate.now())")
    public abstract Course mapFromCourseDTOtoCourse(CourseDTO courseDTO);

    public abstract CourseDTO mapFromCoursetoCourseDTO(Course course);

}
