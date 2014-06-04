package threads;

/**
 * Created by Alessandro.Dantas on 27/03/2014.
 */
public class BallotPosition {
    String question;
    int votes;
    BallotPosition(String q) { question = q; }
    public String getName() { return question; }
    public int getVotes() { return votes; }
}
