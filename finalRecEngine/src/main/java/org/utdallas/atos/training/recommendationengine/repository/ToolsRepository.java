package org.utdallas.atos.training.recommendationengine.repository;

import org.utdallas.atos.training.recommendationengine.model.Employees;
import org.utdallas.atos.training.recommendationengine.model.Jobs;
import org.utdallas.atos.training.recommendationengine.model.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called coursesRepository
// CRUD refers Create, Read, Update, Delete
public interface ToolsRepository extends JpaRepository<Tools,Integer>
{
    List<Tools> findAllByIdIn(List<Long> id);

    //Tools findByName(String name);
    List<Tools> findByName(String name);

    @Query(value = "SELECT * FROM skills WHERE Skill_Course_ID = ?1", nativeQuery = true)
    List<Tools> findByCourseId(Long courseID);


    List<Tools> findByJobs(Jobs jobs);
    List<Tools> findByEmployees(Employees employees);
    List<Tools> findByJobs_IdAndSubDomainIn(Long id, List<String> subDomain);

    List<Tools> findBySubDomain(String subDomain);
}