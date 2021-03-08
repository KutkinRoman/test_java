package Feed_the_cat;

import java.util.Random;

public class Cat {

    String name;
    boolean satiety;
    int needFood;
    boolean outputEnConsole;

    public Cat(String name){

        this.name = name;
        this.satiety = false;
        int needFood = (new Random()).ints(15,20).iterator().nextInt();
        this.needFood = needFood;

    }

   int cat_eating(int needFood, int i, Cat[] cat){

        if (needFood <= Plate.food) {

            Plate.food -= needFood;

            cat[i].satiety = true;

        }

        return Plate.food;

   }


}
