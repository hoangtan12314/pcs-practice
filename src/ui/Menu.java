package ui;

import util.Handelnput;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String menuTitle;
    private List<String> optionList = new ArrayList<>();

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public void addOption(String option){
        optionList.add(option);
    }

    public void printMenu(){
        if (optionList.isEmpty()){
            System.out.println("The option list is empty. Nothing here to print!");
            return;
        }

        System.out.println("Welcome to the " + menuTitle);

        for (String option : optionList){
            System.out.println(option);
        }
    }

    public int retrieveChoice(){
        int optionAmount = optionList.size();
        String inputMsg = "Enter your option [1 - " + optionAmount + "]: ";
        String errMsg = "Option invalid. Must be from 1 to " + optionAmount + "!";
        return Handelnput.retrieveInteger(inputMsg, errMsg, 1, optionAmount);
    }


}
