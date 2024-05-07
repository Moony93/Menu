package it.exercise.menuTopBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.exercise.menuTopBoot.entities.Recipe;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Long> {

	
}
