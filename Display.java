import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import com.java_data.Tweet;
import com.java_data.Tweets;

public class Display {
  public static void main(String[] args) {
    //Tweet tweet = new Tweet(
      //"elgringobarbudo",
      //"Made my first OSS contrib today thanks to @hackerhours && @blacktm! Many more to come...",
      //new Date(1457904840000L) //Long (-L suffix) expression of Epoch/Unix time
    //);

    //Tweet tweet2 = new Tweet(
      //"LFC",
      //"The moment Dejan Lovren left club commentator @Shunter77 and @RealAldo474 breathless...",
      //new Date(1421849732000L)
    //);

    //Tweet[] tweets = {tweet, tweet2};
    //Arrays.sort(tweets);
    //for (Tweet twt : tweets) {
      //System.out.println(twt);
    //}

    ////serialize tweets
    //Tweets.save(tweets);

    //deserialize tweets
    Tweet[] tweets = Tweets.load();

    System.out.printf("There are %d tweets. %n", tweets.length);

    Set<String> allHashTags = new HashSet<String>();
    Set<String> allMentions = new TreeSet<String>();
    for (Tweet twt : tweets) {
      allHashTags.addAll(twt.getHashTags());
      allMentions.addAll(twt.getMentions());
    }
    System.out.printf("Hashtags: %s %n", allHashTags);
    System.out.printf("Mentions: %s %n", allMentions);

  }
}
