package org.utdallas.atos.training.recommendationengine.repository;

import org.utdallas.atos.training.recommendationengine.model.Jobs;
import org.utdallas.atos.training.recommendationengine.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called coursesRepository
// CRUD refers Create, Read, Update, Delete
public interface JobsRepository extends JpaRepository<Jobs,Integer>
{
	long findIdByName(String name);

	List<Jobs> findAllByNameContains(String name);

	Jobs findOneByNameIs(String id);

	Jobs findByName(String name);


}