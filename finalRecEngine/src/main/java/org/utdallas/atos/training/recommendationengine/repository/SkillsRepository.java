package org.utdallas.atos.training.recommendationengine.repository;

import org.utdallas.atos.training.recommendationengine.model.Employees;
import org.utdallas.atos.training.recommendationengine.model.Jobs;
import org.utdallas.atos.training.recommendationengine.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called coursesRepository
// CRUD refers Create, Read, Update, Delete
public interface SkillsRepository extends JpaRepository<Skills,Integer>
{
    List<Skills> findAllByIdIn(List<Long> id);

    Skills findByName(String name);

    @Query(value = "SELECT * FROM skills WHERE Skill_Course_ID = ?1", nativeQuery = true)
    List<Skills> findByCourseId(Long courseID);


    List<Skills> findByJobs(Jobs jobs);
    List<Skills> findByEmployees(Employees employees);
    List<Skills> findByJobs_IdAndSubDomainIn(Long id, List<String> subDomain);

    List<Skills> findBySubDomain(String subDomain);
}