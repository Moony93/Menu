package it.exercise.menuTopBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.exercise.menuTopBoot.entities.Recipe;
import it.exercise.menuTopBoot.service.RecipeService;

@Controller
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;
	
	
	//{READ}pagina base, lettura di tutti i valori nella tabella
	@RequestMapping("/main")
	public String viewHomePage(Model model)
	{
		List<Recipe> recipes = recipeService.listAll();
		model.addAttribute("recipes", recipes);
		return "main";	
	}
	
	//accesso alla pagina di aggiunta nuovo oggetto
	@RequestMapping("/add")
	public String addRecipePage(Model model)
	{
		//creo un nuovo oggetto "vuoto" Recipe
		Recipe newRecipe = new Recipe();
		//lo aggiungo come attributo thimeleaf per permetterne l'elaborazione dalla pagina, dandogli nome newRecipe
		model.addAttribute("newRecipe", newRecipe);
		return "add_recipe";
	}
	
	//{CREATE} salvataggio nuovo oggetto (creato dalla pagina add_recipe alla quale accediamo tramite il metodo addRecipePage
	@RequestMapping("/saveRecipe")
	public String saveRecipe(@ModelAttribute("newRecipe") Recipe recipe) {
		recipeService.save(recipe);		
		return "redirect:/main";
	}
	
	
	//{UPDATE}
	@RequestMapping("/edit/{id}")
	public ModelAndView editRecipePage(@PathVariable(name = "id") int id)
	{
		ModelAndView mav = new ModelAndView("edit_recipe");
		Recipe editedRecipe = recipeService.get(id);
		mav.addObject("editedRecipe", editedRecipe);
		return mav;
	}
	
	//{DELETE}cancellazione di un oggetto tramite il suo ID, selezionato dalla tabella
	@RequestMapping("/delete/{id}")
	public String deleteRecipe(@PathVariable(name = "id") int id)
	{
		recipeService.delete(id);
		return "redirect:/main";	
	}
}
