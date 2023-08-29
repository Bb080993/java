import java.util.ArrayList;
import java.util.Random;
public class TestPuzzleJava {
    
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();
		ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);
		
    	        //..
		// Write your other test cases here.
		String oneLetter= generator.getRandomLetter();
        System.out.println(oneLetter);

		String newPassword=generator.generatePassword();
		System.out.println(newPassword);

		// String[] passwordSet=generator.getNewPasswordSet(5);
		// System.out.println(passwordSet);

		ArrayList<String> passwordSet=generator.getNewPasswordSet(5);
		System.out.println(passwordSet);
	}
}
