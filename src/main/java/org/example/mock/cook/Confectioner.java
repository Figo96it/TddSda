package org.example.mock.cook;

public class Confectioner {

    private final Flour flour;


    public Confectioner(Flour flour) {
        this.flour = flour;
    }

    public String createRecipe() {
        int portion = flour.getPortion();
        return "Ciasto z " + portion + "gr. mąki.";
    }

}
