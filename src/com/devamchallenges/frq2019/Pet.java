package com.devamchallenges.frq2019;
import java.util.*;

public abstract class Pet {
    private String myName;

    public Pet(String name) {
        myName = name;
    }

    public String getName() {
        return myName;
    }

    public abstract String speak();
}

public class Dog extends Pet {

    public Dog(String name) {
        super(name);
    }
    public String dogsound = "woof";
    public String speak() {
        return dogsound;
    }
}

public class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }

    public String speak() {
        return "meow";
    }
}

public class LoudDog extends Dog {
    public LoudDog(String name) {
        super(name);
    }
    for (int i = 1; i >= 2;) {
        return super.speak() + " ";
        i++;
    }
}

public class Kennel {
    private ArrayList petList;

    public void allSpeak() {
        for (int i = 0; i < petList.size(); i++) {
            if (Pet = Dog) {
                if (Dog = LoudDog) {
                    LoudDog();
                    for (int i = 1; i >= 2;) {
                        Dog.speak();
                        i++;
                    }
                }
                else {
                    Dog();
                    Dog.speak();
                }
            }
            else if (Pet = Cat) {
                Cat();
                Cat.speak();
            }
            else {
                Pet();
                Pet.speak();
            }
        }
    }
}