import java.util.Random;
public class NumbersGame {
    public static void main(String[] args){
        System.out.println("Hello, human. I am thinking of a number between 0 and 10.");
        System.out.println("*********************************************************");
        System.out.println("Can you guess the number?");
        System.out.println("If you are not up to the task, you can always type 'q' to quit.");
        int answer = new Random().nextInt(0,10);
        int count=0;
        while(true){
            count++;
            if(count>3){
                System.out.println("Can only guess 3 times. The answer was "+ answer);
                break;
                // System.out.println("Play again? Press y for yes and anything else for no.");
                // String replay = System.console().readLine();
                //     if(replay.equals("y")){
                //         ;
                //     }else{break;}
               
            }
            String guess = System.console().readLine();
            if(guess.equals("q")){
                System.out.println("I knew you didn't have it in you.");
                System.out.println("Shutting down...");
                break;}
            else {          
                continue;
            }
            if(Integer.parseInt(guess)>10||(Integer.parseInt(guess)<0)){
                System.out.println("Must guess a number between 0 and 10");
            }else if(Integer.parseInt(guess)==answer){
                System.out.println("Lucky guess! But can you do it again?");
                break;
                // System.out.println("Play again? Press y for yes and anything else for no.");
                // String replay = System.console().readLine();
                //     if(replay.equals("y")){
                //         true=true;
                //     }else{break;}
            }else{
                System.out.println("Swing and a miss! Keep trying...");
            }

           
            
        }
        System.out.println("Game over. Shutting down...");
    }
}

