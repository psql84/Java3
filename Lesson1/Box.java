package GeekBrains.Lesson4;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> box = new ArrayList<>();

    public Box(){}

    public float getWeight(){
        float weight = 0.0f;
        for (T t : box) {
            weight += t.getWeight();
        }
        return weight;
    }
    public boolean compare(Box<?> box1) {
        if (getWeight() == box1.getWeight()) return true;
        return false;
    }
    public void pour(Box<T> box1) {
        box1.box.addAll(box);
        box.clear();
    }

    public void addFruit(T fruit){
        box.add(fruit);
    }
}
