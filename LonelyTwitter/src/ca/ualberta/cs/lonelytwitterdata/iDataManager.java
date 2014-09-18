package ca.ualberta.cs.lonelytwitterdata;

import java.util.ArrayList;
import java.util.List;

import ca.ualberta.cs.lonelytwitter.AbstractTweet;

public interface iDataManager {
	public ArrayList<AbstractTweet> loadTweets();
	
	public void saveTweets(List<AbstractTweet> lts); 

}
