package data;

import java.util.Random;

public class Cat extends Pet{
    private static final double MAX_SPD = 15.0;

    public Cat(String id, String name, int yob, double weight) {
        super(id, name, yob, weight);
    }

    @Override
    public void showProfile() {
        System.out.printf("|%6s|%-10s|%4d|%4.1f|\n",
                id, name, yob, weight);
    }
}
