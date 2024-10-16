package com.recipeapp.datahandler;

import java.util.ArrayList;

import com.recipeapp.model.Recipe;

public class JSONDataHandler implements DataHandler {

    public String getMode() {
        return "JSON";// 文字列JSONを返す
    }

    public ArrayList<Recipe> readData() {
        return null;// nullをreturn
    }

    public void writeData(Recipe recipe) {

    };//定義のみ

    public ArrayList<Recipe> searchData(String keyword) {
        return null;//nullをreturn
    }

}
