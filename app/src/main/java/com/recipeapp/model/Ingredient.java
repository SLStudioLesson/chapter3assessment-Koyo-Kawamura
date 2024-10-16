package com.recipeapp.model;


public class Ingredient {

    private String name;//材料の名前
    
    public Ingredient(String name){
        this.name = name;//nameフィールドに、同名の引数を代入する
    }
    public String getName(){
        return name;//nameフィールドを返す
    }

}
