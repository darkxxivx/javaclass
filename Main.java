abstract class Animal {
  String name;
  Animal(String name) { this.name = name; }
  String getName() { return name; }
  abstract void makeSound();
}


interface AnimalBehavior {
  void sleep();
}

interface AnimalMove {
  default void move() {
      System.out.println("Animal moves.");
  }
}

interface AnimalName {
  static void name(String name) {
      System.out.println("Animal name is: " + name);
  }
}


class Dog extends Animal implements AnimalBehavior, AnimalMove {
  Dog(String name) { super(name); }
  void makeSound() { System.out.println("Woof!"); }
  public void sleep() { System.out.println("Dog sleeps."); }
  public void move() { System.out.println("Dog runs."); }
}

class Pigeon extends Animal implements AnimalBehavior, AnimalMove {
  Pigeon(String name) { super(name); }
  void makeSound() { System.out.println("Coo!"); }
  public void sleep() { System.out.println("Pigeon sleeps."); }
  public void move() { System.out.println("Pigeon flies."); }
}

class Blowfish extends Animal implements AnimalBehavior, AnimalMove {
  Blowfish(String name) { super(name); }
  void makeSound() { System.out.println("Blub!"); }
  public void sleep() { System.out.println("Blowfish sleeps."); }
  public void move() { System.out.println("Blowfish swims."); }
}



public class Main {
  public static void main(String[] args) {
      Animal[] animals = {
          new Dog("Buddy"),
          new Pigeon("Sky"),
          new Blowfish("Bubbles")
      };

      AnimalBehavior[] behaviors = {
          new Dog("Buddy"),
          new Pigeon("Sky"),
          new Blowfish("Bubbles")
      };

      for (AnimalBehavior ab : behaviors) ab.sleep();
      for (Animal a : animals) ((AnimalMove) a).move();
      for (Animal a : animals) AnimalName.name(a.getName());
  }
}







