package ca.ualberta.cs.lonelytwitterdata;

import java.util.ArrayList;
import java.util.List;

import ca.ualberta.cs.lonelytwitter.Tweet;

public interface iDataManager {
	public ArrayList<Tweet> loadTweets();
	
	public void saveTweets(List<Tweet> lts); 

}
