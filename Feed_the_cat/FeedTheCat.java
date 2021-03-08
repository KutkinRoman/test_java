package Feed_the_cat;

import java.util.Scanner;

public class FeedTheCat {

    static int feedEveryone = 0;

    public static void main(String[] args) {


        Plate.setFood(32);
        System.out.println(Plate.food);

        Cat[] cat = new Cat[4];
        cat[0] = new Cat("Мурзик");
        cat[1] = new Cat("Барсик");
        cat[2] = new Cat("Снежок");
        cat[3] = new Cat("Пушок");


        feedEveryone(cat);


    }
    static void comUser(int x){

        Scanner scanner = new Scanner(System.in);

            for (;;) {

                System.out.println("Сколько добавить еды в талеку ? 0 - отказаться");

                int com = scanner.nextInt();

                if (com > 0) {

                    Plate.setFood(com);

                    break;

                } else if (com == 0){

                    feedEveryone = x;

                    scanner.close();

                    break;

                }

                System.out.println("Значение не может быть меньше чем ноль");

            }


    }

    static void feedEveryone(Cat[] cat){


        while (feedEveryone < cat.length){

        for (int i = 0; i < cat.length; i++){

            if (!cat[i].satiety) {

                cat[i].cat_eating(cat[i].needFood, i, cat);

            }
        }

        for (int i = 0; i < cat.length; i++){

            if (cat[i].satiety && !cat[i].outputEnConsole) {

                System.out.println(cat[i].name + " наелся");

                feedEveryone++;

                cat[i].outputEnConsole = true;

            } else if (!cat[i].satiety){

                System.out.println(cat[i].name + " отстался голодным");

            }
        }
            System.out.println("Осталось еды: " + Plate.food);

            if (feedEveryone < cat.length) {

                comUser(cat.length);

                }
            }
        }

    }


