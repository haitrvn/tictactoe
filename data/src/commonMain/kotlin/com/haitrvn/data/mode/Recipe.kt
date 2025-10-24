package com.haitrvn.data.mode

data class Recipe(
    val id: Int,
    val title: String,
    val description: String?,
    val prepTime: RecipeTime = RecipeTime.UNKNOW,
    val cookTime: RecipeTime = RecipeTime.UNKNOW,
    val readyIn: RecipeTime = RecipeTime.UNKNOW,
    val yields: String?,
    val level: Level?,
    val caloriesPerServing: Int?,
    val cuisine: Cuisine?,
    val source: String?,
    val rating: Double?,
    val imagePath: String?,
    val steps: List<RecipeStep> = emptyList(),
    val ingredients: List<RecipeIngredient> = emptyList(),
    val nutritionalInfo: List<NutritionalInfo> = emptyList(),
    val foodCategories: List<FoodCategory> = emptyList(),
    val courses: List<Course> = emptyList(),
    val parts: List<RecipePart> = emptyList(),
    val footnotes: List<Footnote> = emptyList()
)

sealed interface RecipeTime {
    data object UNKNOW : RecipeTime
    data class SpecificTime(val value: Long) : RecipeTime
}

data class RecipeStep(
    val id: Int,
    val recipeId: Int,
    val stepNumber: Int,
    val instructions: String
)

data class RecipeIngredient(
    val id: Int,
    val recipeId: Int,
    val ingredient: Ingredient,
    val amount: Double?,
    val measurement: Measurement?,
    val instructions: String?
)

data class Ingredient(
    val id: Int,
    val name: String,
    val sortOrder: Int?,
    val isActive: Boolean
)

data class Measurement(
    val id: Int,
    val name: String,
    val abbreviation: String?,
    val isActive: Boolean,
    val sortOrder: Int?
)

data class NutritionalInfo(
    val id: Int,
    val nutrition: String,
    val measurement: Measurement?,
    val sortOrder: Int?,
    val isActive: Boolean
)

data class FoodCategory(
    val id: Int,
    val name: String,
    val sortOrder: Int?,
    val isActive: Boolean
)

data class Course(
    val id: Int,
    val name: String,
    val sortOrder: Int?,
    val isActive: Boolean
)

data class Level(
    val id: Int,
    val sortOrder: Int?,
    val isActive: Boolean
)

data class Cuisine(
    val id: Int,
    val name: String,
    val sortOrder: Int?,
    val isActive: Boolean
)

data class RecipePart(
    val id: Int,
    val recipeId: Int,
    val partTitle: String
)

data class Footnote(
    val id: Int,
    val recipeId: Int,
    val text: String,
    val print: Boolean
)

data class Menu(
    val id: Int,
    val title: String,
    val description: String?,
    val sortOrder: Int?,
    val isActive: Boolean,
    val recipes: List<Recipe> = emptyList()
)

data class RecipeCourse(
    val recipeId: Int,
    val courseId: Int
)

data class RecipeFoodCategory(
    val recipeId: Int,
    val foodCategoryId: Int
)

data class MenuRecipe(
    val menuId: Int,
    val recipeId: Int,
    val notes: String?
)
