package data;

import util.Handelnput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cabinet {
    private List<Pet> petList = new ArrayList<>();

    public void addNewCat(){
        String id, name;
        int yob, pos;
        double weight;
        do {
            id = Handelnput.retrieveID("Enter Cat ID (CXXXXX): ",
                    "Wrong ID format (CXXXXX). X stands for integer digit!", "^[C|c]\\d{5}$");
            pos = searchPetById(id);

            if (pos >= 0){
                System.out.println("Cat ID already exist. Please enter another one!");
            }
        } while (pos != -1);

        name = Handelnput.retrieveString("Enter cat's name: ", "Cat's name is required!");
        yob = Handelnput.retrieveInteger("Enter cat's year of birth: ",
                "Invalid year of birth. Year of birth must be from 2000 to 2022!", 2000, 2022);
        weight = Handelnput.retrieveDouble("Enter cat's weight: ",
                "Invalid weight. Weight must be from 0.1 to 99.9!", 0.1, 99.9);
        petList.add(new Cat(id, name, yob, weight));
        System.out.println("A cat profile has been added successfully.");
    }

    public void addNewDog(){
        String id, name;
        int yob, pos;
        double weight;
        do {
            id = Handelnput.retrieveID("Enter Dog ID (DXXXXX): ",
                    "Wrong ID format (DXXXXX). X stands for integer digit!", "^[D|d]\\d{5}$");
            pos = searchPetById(id);

            if (pos >= 0){
                System.out.println("Dog ID already exist. Please enter another one!");
            }
        } while (pos != -1);

        name = Handelnput.retrieveString("Enter dog's name: ", "Dog's name is required!");
        yob = Handelnput.retrieveInteger("Enter dog's year of birth: ",
                "Invalid year of birth. Year of birth must be from 2000 to 2022!", 2000, 2022);
        weight = Handelnput.retrieveDouble("Enter dog's weight: ",
                "Invalid weight. Weight must be from 0.1 to 99.9!", 0.1, 99.9);
        petList.add(new Dog(id, name, yob, weight));
        System.out.println("A dog profile has been added successfully.");
    }

    public void searchPetById(){
        String id;
        Pet pet;
        if (petList.isEmpty()){
            System.out.println("The list is currently empty. Nothing here to search");
            return;
        }

        id = Handelnput.retrieveString("Enter the ID that you want to search: ", "ID is required");
        pet = searchPetObjectByID(id);
        if (pet == null){
            System.out.println("ID not found. Pet not exist!");
        } else {
            System.out.println("----------------------------");
            System.out.println("Pet found! Here is the profile: ");
            pet.showProfile();
        }

    }

    public int searchPetById(String id){
        if (petList.isEmpty()){
            return -1;
        }

        for (int i = 0; i < petList.size(); i++){
            if (petList.get(i).getId().equalsIgnoreCase(id)){
                return i;
            }
        }
        return -1;
    }

    public Pet searchPetObjectByID(String id){
        if (petList.isEmpty()){
            return null;
        }

        for (Pet pet: petList) {
            if (pet.getId().equalsIgnoreCase(id)){
                return pet;
            }
        }
        return null;
    }

    public void updatePetName(){
        String newName, id;
        Pet pet;
        id = Handelnput.retrieveString("Enter the pet's ID that you want to update: ", "ID is required!");
        pet = searchPetObjectByID(id);
        if (pet == null){
            System.out.println("ID not found. Pet not exist!");
            return;
        }
        System.out.println("---------------------");
        System.out.println("Here is the pet's profile: ");
        pet.showProfile();
        newName = Handelnput.retrieveString("Enter a new name: ", "A new name is required!");
        pet.setName(newName);
        System.out.println("Pet's name updated successfully.");
    }

    public void updatePetYob(){
        int newYob;
        String id;
        Pet pet;

        id = Handelnput.retrieveString("Enter the pet's ID that you want to update: ", "ID is required!");
        pet = searchPetObjectByID(id);

        if (pet == null){
            System.out.println("ID not found. Pet not exist!");
            return;
        }

        System.out.println("----------------------");
        System.out.println("Here is the pet's profile: ");
        pet.showProfile();
        newYob = Handelnput.retrieveInteger("Enter pet's new year of birth (2000 - 2022): ",
                "Invalid year of birth. Must be from 2000 to 2022!", 2000, 2022);
        pet.setYob(newYob);
        System.out.println("Pet's year of birth updated successfully.");
    }

    public void updatePetWeight(){
        double newWeight;
        String id;
        Pet pet;

        id = Handelnput.retrieveString("Enter the pet's id that you want to update: ", "ID is required!");
        pet = searchPetObjectByID(id);

        if (pet == null){
            System.out.println("ID not found. Pet not exist!");
            return;
        }

        System.out.println("----------------------");
        System.out.println("Here is the pet's profile: ");
        pet.showProfile();
        newWeight = Handelnput.retrieveDouble("Enter pet's new weight(0.1 - 99.0): ",
                "Invalid weight. Must be from 0.1 to 99.9!", 0.1, 99.9);
        pet.setWeight(newWeight);
        System.out.println("Pet's weight updated successfully.");
    }

    public void updatePetInfo(){
        int choice;
        System.out.println("Here are the available information that you can update: ");
        System.out.println("1. Name");
        System.out.println("2. Year of birth");
        System.out.println("3. Weight");
        choice = Handelnput.retrieveInteger("Select pet information that you want to update: ",
                "Option invalid. Must be from 1 to 3!", 1, 3);
        switch (choice){
            case 1:
                updatePetName();
                break;
            case 2:
                updatePetYob();
                break;
            case 3:
                updatePetWeight();
                break;
        }
    }

    public void removePet(){
        String id;
        Pet pet;

        id = Handelnput.retrieveString("Enter the pet's id that you want to delete: ", "ID is required!");
        pet = searchPetObjectByID(id);
        if (pet == null){
            System.out.println("ID not found. Pet not exist!");
        }
        System.out.println("----------------------");
        System.out.println("The following pet profile will be removed:");
        pet.showProfile();
        petList.remove(pet);
        System.out.println("Pet profile removed successfully.");
    }

    public void printPetListAscendingByID(){
        if (petList.isEmpty()){
            System.out.println("The list is currently empty. Nothing here to print!");
        }

        Collections.sort(petList);

        System.out.println("Here is the list of pet profile with ID ascending: ");
        System.out.printf("|%6s|%10s|%4s|%4s|%4s|\n",
                            "ID", "NAME", "YOB", "WGT", "REC");
        for (Pet pet: petList) {
            pet.showProfile();
        }
    }

    public void printPetListAscendingByName(){
        if (petList.isEmpty()){
            System.out.println("The list is currently empty. Nothing here to print!");
        }

        Comparator nameCompare = new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Collections.sort(petList, nameCompare);

        System.out.println("Here is the list of pet profile with name ascending: ");
        System.out.printf("|%6s|%10s|%4s|%4s|%4s|\n",
                "ID", "NAME", "YOB", "WGT", "REC");
        for (Pet pet: petList) {
            pet.showProfile();
        }
    }

    //only for testing
    public void printPetList(){
        for (Pet pet: petList) {
            pet.showProfile();
        }
    }

}
