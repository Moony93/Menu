package it.exercise.menuTopBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.exercise.menuTopBoot.entities.Recipe;
import it.exercise.menuTopBoot.repository.RecipeRepo;

@Service
public class RecipeService {

	@Autowired
	private RecipeRepo repo;
	
	
	public List<Recipe> listAll()
	{
		List<Recipe> recipes = repo.findAll();
		return recipes;
	}
		
	public void save(Recipe recipe)
	{
		repo.save(recipe);
	}
	
	public void delete(long id)
	{
		repo.deleteById(id);
	}
	
	//WIP edited in COntroller?
	public void editRecipe(Recipe editedRecipe)
	{
		repo.save(editedRecipe);
	}
	
	public Recipe get(long id)
	{
		return repo.findById(id).get();
	}
	
}
