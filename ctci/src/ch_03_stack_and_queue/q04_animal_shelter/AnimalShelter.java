package ch_03_stack_and_queue.q04_animal_shelter;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {

    enum AnimalType {DOG, CAT}

    private Queue<Animal> cats;
    private Queue<Animal> dogs;

    public AnimalShelter() {
        cats = new LinkedList<>();
        dogs = new LinkedList<>();
    }

    public void enqueue(String name, AnimalType type){
        Queue<Animal> queue = null;
        if(type == AnimalType.DOG) queue = dogs;
        if(type == AnimalType.CAT) queue = cats;

        queue.add(new Animal(name, type));
    }

    public boolean isEmpty() {
        return cats.isEmpty() && dogs.isEmpty();
    }

    public Animal dequeueAny(){
        if (cats.size() > dogs.size()) {
            return cats.poll();
        }
        return dogs.poll();
    }

    public Animal dequeueCat() {
        if (cats.isEmpty()) {
            return null;
        }
        return cats.poll();
    }

    public Animal dequeueDog() {
        if (dogs.isEmpty()) {
            return null;
        }
        return dogs.poll();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CATS: " + cats.toString());

        sb.append("\nDOGS: " + dogs.toString());
        return sb.toString();
    }


    class Animal {
        private String name;
        private AnimalType type;

        public Animal(String name, AnimalType type){
            this.name = name;
            this.type = type;
        }

        public String toString(){
            return type + "-" + name;
        }
    }
}
