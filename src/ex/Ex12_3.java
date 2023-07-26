package ex;

import java.lang.reflect.Array;
import java.util.ArrayList;

class Fruit implements Eatable {
    public String toString() {
        return "Fruit";
    }

}

class Apple extends Fruit {
    public String toString() {
        return "Apple";
    }

    public String getColor() {
        return "Red";
    }
}

class Grape extends Fruit {
    public String toString() {
        return "Grape";
    }
}

class Toy {
    public String toString() {
        return "Toy";
    }
}

interface Eatable {
}

public class Ex12_3 {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<>();
        FruitBox<Apple> appleBox = new FruitBox<>();
        FruitBox<Grape> grapeBox = new FruitBox<>();

        Box<Toy> toyBox = new Box<>();

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        appleBox.add(new Apple());
        toyBox.add(new Toy());
        System.out.println("fruitBox = " + fruitBox);
        System.out.println("appleBox = " + appleBox);
        System.out.println("toyBox = " + toyBox);

//        Fruit f = new Apple();
//        Apple a = (Apple) f;
        Fruit a = (Apple) new Apple();
        System.out.println("a.toString() = " + a.toString());
    }
}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {

}

class Box<T> {
    ArrayList<T> list = new ArrayList<>();
    void add(T item) {
        list.add(item);
    }
    T get(int i) {
        return list.get(i);
    }

    int size() {
        return list.size();
    }

    public String toString() {
        return list.toString();
    }
}