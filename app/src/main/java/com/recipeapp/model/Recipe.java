package com.recipeapp.model;

import java.util.ArrayList;

public class Recipe {
    
private String name;//レシピの名前

private ArrayList<Ingredient> ingredients = new ArrayList<>();//レシピの材料リスト

//nameフィールドとingredientsフィールドそれぞれに、同名の引数を代入する
public Recipe(String name, ArrayList<Ingredient> ingredients){

    this.name = name;
    this.ingredients = ingredients;
}

public String getName(){
    return name;//nameフィールドを返す
}
public ArrayList<Ingredient> getIngredients(){
    return ingredients;//ingredientsフィールドを返す
}

}

