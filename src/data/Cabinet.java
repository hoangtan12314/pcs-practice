package data;

import util.Handelnput;

import java.util.ArrayList;
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

    //only for testing
    public void printPetList(){
        for (Pet pet: petList) {
            pet.showProfile();
        }
    }

}
