import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    void display();
}

class VegetarianMeal implements MealPlan {
    String dish;

    VegetarianMeal(String dish) {
        this.dish = dish;
    }

    @Override
    public void display() {
        System.out.println("Vegetarian Meal: " + dish);
    }
}

class VeganMeal implements MealPlan {
    String dish;

    VeganMeal(String dish) {
        this.dish = dish;
    }

    @Override
    public void display() {
        System.out.println("Vegan Meal: " + dish);
    }
}

class KetoMeal implements MealPlan {
    String dish;

    KetoMeal(String dish) {
        this.dish = dish;
    }

    @Override
    public void display() {
        System.out.println("Keto Meal: " + dish);
    }
}

class HighProteinMeal implements MealPlan {
    String dish;

    HighProteinMeal(String dish) {
        this.dish = dish;
    }

    @Override
    public void display() {
        System.out.println("High-Protein Meal: " + dish);
    }
}

class Meal<T extends MealPlan> {
    List<T> meals = new ArrayList<>();

    public void addMeal(T meal) {
        meals.add(meal);
    }

    public void displayMeals() {
        for (T meal : meals) {
            meal.display();
        }
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(List<T> options) {
        Meal<T> mealPlan = new Meal<>();
        for (T meal : options) {
            mealPlan.addMeal(meal);
        }
        return mealPlan;
    }
}

public class Main {
    public static void main(String[] args) {
        List<VegetarianMeal> vegOptions = new ArrayList<>();
        vegOptions.add(new VegetarianMeal("Grilled Paneer"));
        vegOptions.add(new VegetarianMeal("Veggie Stir Fry"));

        List<VeganMeal> veganOptions = new ArrayList<>();
        veganOptions.add(new VeganMeal("Tofu Salad"));
        veganOptions.add(new VeganMeal("Chickpea Curry"));

        List<KetoMeal> ketoOptions = new ArrayList<>();
        ketoOptions.add(new KetoMeal("Cauliflower Rice"));
        ketoOptions.add(new KetoMeal("Zucchini Noodles"));

        List<HighProteinMeal> highProteinOptions = new ArrayList<>();
        highProteinOptions.add(new HighProteinMeal("Grilled Chicken"));
        highProteinOptions.add(new HighProteinMeal("Egg White Omelette"));

        System.out.println("Generated Vegetarian Meal Plan:");
        Meal<VegetarianMeal> vegPlan = MealPlanGenerator.generateMealPlan(vegOptions);
        vegPlan.displayMeals();

        System.out.println("\nGenerated Vegan Meal Plan:");
        Meal<VeganMeal> veganPlan = MealPlanGenerator.generateMealPlan(veganOptions);
        veganPlan.displayMeals();

        System.out.println("\nGenerated Keto Meal Plan:");
        Meal<KetoMeal> ketoPlan = MealPlanGenerator.generateMealPlan(ketoOptions);
        ketoPlan.displayMeals();

        System.out.println("\nGenerated High-Protein Meal Plan:");
        Meal<HighProteinMeal> proteinPlan = MealPlanGenerator.generateMealPlan(highProteinOptions);
        proteinPlan.displayMeals();
    }
}
