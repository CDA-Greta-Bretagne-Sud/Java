package com.stevancorre.cda.mediaLibrary;

public class Media {
    private final String id;

    private String category;
    private String subCategory;
    private String description;

    private final int month;
    private final int year;

    private boolean loaned;

    Media(final long id, final String category, final String subCategory, final String description, final int month, final int year) {
        this.id = String.format("%d-%d-%d", month, year, id);
        this.category = category;
        this.subCategory = subCategory;
        this.description = description;
        this.month = month;
        this.year = year;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public void setSubCategory(final String subCategory) {
        this.subCategory = subCategory;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setIsLoaned(final boolean state) {
        loaned = state;
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return month + "/" + year;
    }

    public boolean isLoaned() {
        return loaned;
    }

    @Override
    public String toString() {
        return description;
    }
}
