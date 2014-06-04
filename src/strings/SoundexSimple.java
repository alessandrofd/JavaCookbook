package strings;

/**
 * Created by Alessandro.Dantas on 05/03/14.
 */
public class SoundexSimple {
    public static void main(String[] args) {
        String[] names = {
                "Darwin, Ian",
                "Davidson, Greg",
                "Darwent, William",
                "Derwin, Daemon"
        };
        for (String name: names) {
            System.out.println(Soundex.soundex(name) + ' ' + name);
        }
    }
}
