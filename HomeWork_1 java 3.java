public class Fruit {

}

public class Apple extends Fruit{


    public static float weight;


    public Apple() {
        this.weight = 1.0f;
    }
	
	
    public float getWeight() {
        return weight;
    }
}


public class Orange extends Fruit{


    private float weight;


    public Orange() {
        this.weight = 1.5f;
    }


    public float getWeight(){
        return weight;
    }

}


public class BoxFruit <T extends Fruit> extends ArrayList<T> {


    public float getWeightFruit(){
        return super.get(0).getWeight();
    }
 

}


public class BoxDemoApp {

    public static void main(String[] args) {

        BoxFruit<Apple> appleBoxFruit = new BoxFruit<>();
        appleBoxFruit.add(new Apple());
        
		appleBoxFruit.add(new Apple());
		
        appleBoxFruit.add(new Apple());

        appleBoxFruit1.get(0).getWeight();


    }
}
