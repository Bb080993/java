import java.util.ArrayList;
import java.util.Random;
    
// // To use methods from the Random library you will need to create an instance of Random
// Random randMachine = new Random();
// // From there you can use any of the methods listed in the documentation. For example:
// randMachine.setSeed(35679); // <--- you won't need to use this method.

public class PuzzleJava{
    // Write a method that will generate and return an array with 10 random numbers between 1 and 20 inclusive.
    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> newArray= new ArrayList<Integer>();
        Random oneToTwenty =new Random();
        for(int i=0; i<10; i++){
            newArray.add(oneToTwenty.nextInt(1,21));
        }
        return newArray;
    }
    public String getRandomLetter(){
        String[] letters = {"A", "B", "C", "D", "E", "F",
        "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
        "T", "U", "V", "W", "X", "Y", "Z"};
        Random findLetter= new Random();
        int index=findLetter.nextInt(26);
        // System.out.println(letters[index]);
        return letters[index];
    }

    public String generatePassword(){
        String password= "";
        for(int i=0; i<8; i++){
           String newLetter=getRandomLetter();
           password+=newLetter;
        } return password;
    }

    // public String[] getNewPasswordSet(int length){
    //     //create an array of random 8 character words
    //     String [] randomWords= new String[length];
    //     //array should be length passed in
    //     for(int i=0; i<length; i++){
    //         randomWords[i]=generatePassword();
    //         // System.out.println(randomWords[i]);  
    //     }
    //     //  System.out.println(randomWords);
    //     return randomWords;
    // }

    public ArrayList<String> getNewPasswordSet(int length){
        ArrayList<String> randomWords= new ArrayList<String>();
        for(int i=0; i<length; i++){
            randomWords.add(generatePassword());
        }return randomWords;
    }

}
