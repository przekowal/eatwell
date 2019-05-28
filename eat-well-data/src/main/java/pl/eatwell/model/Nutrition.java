package pl.eatwell.model;

public enum Nutrition {

    KCAL("kcal"), PROTEIN("protein"), CARBS("carbs"), FAT("fat");

    public final String label;

    Nutrition(String label) {
        this.label = label;
    }
}
