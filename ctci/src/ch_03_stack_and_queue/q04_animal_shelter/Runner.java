package ch_03_stack_and_queue.q04_animal_shelter;

public class Runner {
    public static void main(String[] args) {
        AnimalShelter as = new AnimalShelter();
        as.enqueue("pika1", AnimalShelter.AnimalType.DOG);
        as.enqueue("pika2", AnimalShelter.AnimalType.DOG);
        as.enqueue("pika3", AnimalShelter.AnimalType.DOG);
        as.enqueue("pika4", AnimalShelter.AnimalType.DOG);

        as.enqueue("pika5", AnimalShelter.AnimalType.CAT);
        as.enqueue("pika6", AnimalShelter.AnimalType.CAT);
        as.enqueue("pika7", AnimalShelter.AnimalType.CAT);
        as.enqueue("pika8", AnimalShelter.AnimalType.CAT);

        System.out.println(as);
        System.out.println();

        System.out.println("Dequeue: " + as.dequeueCat());

        System.out.println("Dequeue: " + as.dequeueDog());
        System.out.println("Dequeue: " + as.dequeueDog());
        System.out.println("Dequeue: " + as.dequeueDog());
        System.out.println(as);

        System.out.println();
        System.out.println("Dequeue: " + as.dequeueAny());
        System.out.println("Dequeue: " + as.dequeueAny());
        System.out.println("Dequeue: " + as.dequeueAny());
        System.out.println("Dequeue: " + as.dequeueAny());
        System.out.println("Dequeue: " + as.dequeueAny());
        System.out.println(as);
    }
}
