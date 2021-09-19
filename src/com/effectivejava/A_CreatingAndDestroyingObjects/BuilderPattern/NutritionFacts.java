package com.effectivejava.A_CreatingAndDestroyingObjects.BuilderPattern;

public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    //optional
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class NutritionBuilder implements Builder{
        // Required parameters
        private final int servingSize;
        private final int servings;
        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public NutritionBuilder(int servingSize, int servings){
            this.servingSize=servingSize;
            this.servings=servings;
        }


        @Override
        public Builder calories(int value) {
            this.calories=value;
            return this;
        }

        @Override
        public Builder fat(int value) {
            this.fat=fat;
            return this;
        }

        @Override
        public Builder sodium(int value) {
            this.sodium=value;
            return this;
        }

        @Override
        public Builder carbohydrate(int value) {
            this.carbohydrate=value;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(NutritionBuilder builder){
        this.servingSize= builder.servingSize;
        this.servings=builder.servings;
        this.calories=builder.calories;
        this.fat=builder.fat;
        this.sodium=builder.sodium;
        this.carbohydrate=builder.sodium;
    }

    @Override
    public String toString() {
        return "NutritionFacts{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }
}
