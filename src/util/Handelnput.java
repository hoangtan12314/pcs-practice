package util;

import java.util.Scanner;

public class Handelnput {
    private static final Scanner input = new Scanner(System.in);

    public static int retrieveInteger(String inputMsg, String errMsg){
        int n;
        do {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(input.nextLine());
                return n;
            } catch (Exception e){
                System.out.println(errMsg);
            }
        } while (true);
    }

    public static int retrieveInteger(String inputMsg, String errMsg, int startBound, int endBound){
        int n;
        do {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(input.nextLine());
                if (n < startBound || n > endBound){
                    throw new Exception();
                }
                return n;
            } catch (Exception e){
                System.out.println(errMsg);
            }
        } while (true);
    }

    public static double retrieveDouble(String inputMsg, String errMsg){
        double n;
        do {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(input.nextLine());
                return n;
            } catch (Exception e){
                System.out.println(errMsg);
            }
        } while (true);
    }

    public static double retrieveDouble(String inputMsg, String errMsg, double startBound, double endBound){
        double n;
        do {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(input.nextLine());
                if (n < startBound || n > endBound){
                    throw new Exception();
                }
                return n;
            } catch (Exception e){
                System.out.println(errMsg);
            }
        } while (true);
    }

    public static String retrieveString(String inputMsg, String errMsg){
        String str;
        do {
            System.out.print(inputMsg);
            str = input.nextLine().trim();
            if (str.isEmpty()){
                System.out.println(errMsg);
            } else {
                return str;
            }
        } while (true);
    }

    public static String retrieveID(String inputMsg, String errMsg, String format){
        String id;
        boolean match;

        do {
            System.out.print(inputMsg);
            id = input.nextLine().trim().toUpperCase();
            match = id.matches(format);

            if (match == false || id.isEmpty()){
                System.out.println(errMsg);
            } else {
                return id;
            }
        } while (true);
    }

    public static boolean isDogID(String id){
        char firstChar = id.charAt(0);
        if (firstChar == 'D' || firstChar == 'd')
            return true;

        return false;
    }

    public static boolean isCatID(String id){
        char firstChar = id.charAt(0);
        if (firstChar == 'C' || firstChar == 'c')
            return true;

        return false;
    }


}
