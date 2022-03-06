package test;

import util.Handelnput;

public class Test {
    public static void main(String[] args) {
        System.out.println("The string you have just input is: "
        + Handelnput.retrieveID("Input String: ", "String cannot be empty", "^[C|c]\\d{5}$"));
    }
}
