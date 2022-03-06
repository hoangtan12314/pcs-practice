package test;

import data.Cabinet;
import util.Handelnput;

public class Test {
    public static void main(String[] args) {
        Cabinet cabinet = new Cabinet();
        cabinet.addNewCat();
        cabinet.addNewDog();
        cabinet.printPetList();
    }
}
