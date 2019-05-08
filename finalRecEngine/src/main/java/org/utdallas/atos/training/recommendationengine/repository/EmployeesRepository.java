package org.utdallas.atos.training.recommendationengine.repository;

import java.util.List;

import org.utdallas.atos.training.recommendationengine.model.Employees;
import org.utdallas.atos.training.recommendationengine.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeesRepository extends CrudRepository<Employees, Long>
{
	List<Employees> findAllByLastName(String lastName);

	List<Employees> findAllByOrderByYearsExperienceDesc();

	List<Employees> findAllByEmailAddressContaining(String subtext);

	boolean existsByEmailAddress(String subtext);

	Employees findByEmployeeId(Long id);
	@Transactional
	List<Employees> removeByEmailAddressContaining(String subtext);
}


