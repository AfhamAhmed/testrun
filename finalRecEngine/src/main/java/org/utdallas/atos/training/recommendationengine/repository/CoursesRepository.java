package org.utdallas.atos.training.recommendationengine.repository;

import org.utdallas.atos.training.recommendationengine.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called coursesRepository
// CRUD refers Create, Read, Update, Delete
public interface CoursesRepository extends JpaRepository<Courses,Integer>
{
    Courses findByCourseId(long courseId);
}