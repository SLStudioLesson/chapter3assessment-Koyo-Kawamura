package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class CSVDataHandler implements DataHandler {
    // レシピデータを格納するCSVファイルのパス
    private String filePath;

    // フィールドfilePathにapp/src/main/resources/recipes.csvを代入する
    public CSVDataHandler() {
        this.filePath = "app/src/main/resources/recipes.csv";
    }

    // フィールドfilePathに引数を代入する
    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    // モードを返す
    @Override
    public String getMode() {
        return "CSV";
    }

    // CSVファイルからデータを読み込んでレシピのリストを返す
    @Override
    public ArrayList<Recipe> readData() throws IOException {
        ArrayList<Recipe> recipes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // nullになるまで受け付ける
            while ((line = br.readLine()) != null) {
                // 1行をカンマで分割
                String[] data = line.split(",");
                //レシピ名
                String name = data[0];
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                for (int i = 1; i < data.length; i++) {
                    ingredients.add(new Ingredient(data[i]));
                }
                // レシピを作成しリストに追加
                Recipe recipe = new Recipe(name, ingredients);
                recipes.add(recipe);
            }
        } catch (IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
        return recipes;
    }

    // レシピデータを書き込む
    @Override
    public void writeData(Recipe recipe) throws IOException {
        // recipes.csv に追記するための BufferedWriter を作成
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // レシピ名と材料をカンマ区切りで書き込む
            writer.write(recipe.getName());
            for (Ingredient ingredient : recipe.getIngredients()) {
                writer.write("," + ingredient.getName());
            }
            writer.newLine();
        }
    }

    // キーワードでデータを検索する（未実装）
    @Override
    public ArrayList<Recipe> searchData(String keyword) {
        return null; // nullを返す
    }
}
