package com.iie.st10320489.marene.ui.category;

//Model class representing a Category item with icon, title, and color.

public class CategoryModel {

    // Resource ID for the category icon
    private final Integer catIcon;

    // Name or title of the category
    private final String catTitle;

    // Resource ID for the background color of the category
    private final Integer catColor;


     // Constructor to initialize a CategoryModel object.

     // @param catIcon  the drawable resource ID for the icon
     // @param catTitle the name/title of the category
     // @param catColor the color resource ID for the background

    public CategoryModel(Integer catIcon, String catTitle, Integer catColor) {
        this.catIcon = catIcon;
        this.catTitle = catTitle;
        this.catColor = catColor;
    }

    // Getter for category icon
    public Integer getCatIcon() {
        return catIcon;
    }

    // Getter for category title
    public String getCatTitle() {
        return catTitle;
    }

    // Getter for category background color
    public Integer getCatColor() {
        return catColor;
    }
}