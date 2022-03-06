package data;

import java.util.Random;

public class Dog extends Pet{
    private static final double MAX_SPD = 20.0;

    public Dog(String id, String name, int yob, double weight) {
        super(id, name, yob, weight);
    }

    @Override
    public double run() {
        return new Random().nextDouble() * MAX_SPD;
    }

    @Override
    public void showProfile() {
        System.out.printf("|%6s|%-10s|%4d|%4.1f|%4.1f|\n",
                id, name, yob, weight, run());
    }
}
