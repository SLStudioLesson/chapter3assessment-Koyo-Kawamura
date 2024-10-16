package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }

    public void displayMenu() {

        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        // displayRecipesメソッドを呼び出す
                        displayRecipes();
                        break;
                    case "2":
                    //addNewRecipeメソッドを呼び出す
                    addNewRecipe();
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    // displayRecipe
    private void displayRecipes() throws IOException {
        // DataHandlerを使用してレシピデータを読み込む
        ArrayList<Recipe> recipes = dataHandler.readData();
        // 空の場合
        if (recipes.isEmpty()) {
            System.out.println("No recipes available.");
        } else {
            //
            System.out.println("Recipes:");
            for (Recipe recipe : recipes) {
                // 一行ずつ取り出し
                System.out.println("Recipe Name: " + recipe.getName());
                System.out.print("Main Ingredients: ");
                // カンマで区切って取り出し
                for (Ingredient ingredient : recipe.getIngredients()) {
                    System.out.print(ingredient.getName() + ",");
                }
                System.out.println(); // 改行
            }
        }
    }

    private void addNewRecipe() {
        try {
            // ユーザーにレシピ名を入力させる
            System.out.println("Adding a new recipe.");
            System.out.print("Enter recipe name: ");
            String recipeName = reader.readLine();

            // 材料を格納するリストを初期化
            ArrayList<Ingredient> ingredients = new ArrayList<>();
            System.out.println("Enter ingredients (type 'done' when finished):");

            while (true) {
                System.out.print("Ingredient: ");
                String ingredientName = reader.readLine();

                // doneと入力されたら終了
                if (ingredientName.equals("done")) {
                    break;
                }
                // 材料をリストに追加
                ingredients.add(new Ingredient((ingredientName)));
            }
            // 新しいレシピを作成
            Recipe newRecipe = new Recipe(recipeName, ingredients);
            // DataHandlerを使用してレシピを追加
            dataHandler.writeData(newRecipe);
            System.out.println("Recipe added successfully.");

        } catch (Exception e) {
            // 例外が発生した場合はエラーメッセージを表示
            System.out.println("Failed to add new recipe: " + e.getMessage());
        }
    }

}
