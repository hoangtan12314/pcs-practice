package petcaresystem;

import data.Cabinet;
import ui.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu("Pet Care System");
        menu.addOption("1. Add a cat profile");
        menu.addOption("2. Add a dog profile");
        menu.addOption("3. Search a pet");
        menu.addOption("4. Update a pet");
        menu.addOption("5. Remove a pet");
        menu.addOption("6. Print pet profile list ascending by ID");
        menu.addOption("7. Print pet profile list ascending by Name");
        menu.addOption("8. Quit");

        Cabinet cabinet = new Cabinet();
        int choice;

        do {
            menu.printMenu();
            choice = menu.retrieveChoice();

            switch (choice){
                case 1:
                    System.out.println("You are preparing to add a cat profile: ");
                    cabinet.addNewCat();
                    break;
                case 2:
                    System.out.println("You are preparing to add a dog profile: ");
                    cabinet.addNewDog();
                    break;
                case 3:
                    System.out.println("You are preparing to search for a pet");
                    cabinet.searchPetById();
                    break;
                case 4:
                    System.out.println("You are preparing to update information for a pet");
                    cabinet.updatePetInfo();
                    break;
                case 5:
                    System.out.println("You are preparing remove a pet");
                    cabinet.removePet();
                    break;
                case 6:
                    cabinet.printPetListAscendingByID();
                    break;
                case 7:
                    cabinet.printPetListAscendingByName();
                    break;
                case 8:
                    System.out.println("Exiting System. See you again.");
                    break;
            }

        } while (choice != 8);
    }
}
