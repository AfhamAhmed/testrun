package org.utdallas.atos.training.recommendationengine.repository;


import org.utdallas.atos.training.recommendationengine.model.References;
import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called coursesRepository
// CRUD refers Create, Read, Update, Delete
public interface ReferencesRepository extends JpaRepository<References,Integer> //references is the table object, integer for the primary key id
{

}