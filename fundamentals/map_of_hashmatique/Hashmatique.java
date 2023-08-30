import java.util.HashMap;
import java.util.Set;

public class Hashmatique {

    public static void main(String[] args){

        HashMap<String, String>songList = new HashMap<String, String>();


        //Add 4 songs and lyrics to hashmap
        songList.put("Twinkle Twinkle Little Star", "Twinkle, twinkle, little star, How I wonder what you are! Up above the world so high, Like a diamond in the sky. Twinkle, twinkle, little star, How I wonder what you are!");
        songList.put("Mister Sun", "Oh, Mr. Sun, Sun, Mr. Golden Sun, please shine down on me. Oh, Mr. Sun, Sun, Mr. Golden Sun, hiding behind the tree. These little children are asking you to please come out so we can play with you. Oh, Mr. Sun, Sun, Mr. Golden Sun, please shine down on me.");
        songList.put("The Itsy Bitsy Spider", "The itsy bitsy spider crawled up the water spout. Down came the rain, and washed the spider out. Out came the sun, and dried up all the rain, and the itsy bitsy spider went up the spout again");
        songList.put("This Little Light of Mine", "This little light of mine Im going to let it shine Oh, this little light of mine Im going to let it shine This little light of mine Im going to let it shine Let it shine, all the time, let it shine");


        //Pull out one song by its track title
        String song1=songList.get("Twinkle Twinkle Little Star");
        System.out.println(song1);

        //Get all song titles and lyrics
        Set<String> keys = songList.keySet();
        for(String key:keys){
            System.out.println(key + ": " + (songList.get(key)));
        }



    }
}