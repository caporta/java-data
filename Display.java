import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

    Map<String, Integer> mentionCounts = new HashMap<String, Integer>();
    for (Tweet twt : tweets) {
      for (String mention : twt.getMentions()) {
        Integer count = mentionCounts.get(mention);
        if (count == null) {
          count = 0;
        }
        count++;
        mentionCounts.put(mention, count);
      }
    }
    System.out.printf("Mention counts: %s %n", mentionCounts);

    Map<String, List<Tweet>> tweetsByAuthor = new HashMap<String, List<Tweet>>();
    for (Tweet twt : tweets) {
      List<Tweet> authoredTweets = tweetsByAuthor.get(twt.getAuthor());
      if (authoredTweets == null) {
        authoredTweets = new ArrayList<Tweet>();
        tweetsByAuthor.put(twt.getAuthor(), authoredTweets);
      }
      authoredTweets.add(twt);
    }
    System.out.printf("Tweets by author: %s %n", tweetsByAuthor);
    System.out.printf("Tweets by elgringobarbudo: %s %n", tweetsByAuthor.get("elgringobarbudo"));

  }
}
