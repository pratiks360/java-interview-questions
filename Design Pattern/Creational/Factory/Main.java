package Creational.Factory;

abstract class Animal {
    public abstract String sound();
}

class Dog extends Animal {
    @Override
    public String sound() {
        return "Woof";
    }
}

class Cat extends Animal {
    @Override
    public String sound() {
        return "Meow";
    }
}

class AnimalFactory {
    public static Animal createAnimal(String type) {
        if (type.equalsIgnoreCase("dog")) {
            return new Dog();
        } else if (type.equalsIgnoreCase("cat")) {
            return new Cat();
        }
        return null;
    }


    public class Main {
        public static void main(String[] args) {
            Animal dog = AnimalFactory.createAnimal("dog");
            Animal cat = AnimalFactory.createAnimal("cat");

            System.out.println(dog.sound());  // Woof
            System.out.println(cat.sound());  // Meow
        }
    }


}
