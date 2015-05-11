package ca.ualberta.cs.lonelytwitter.test;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.AbstractTweet;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.Tweet;
import ca.ualberta.cs.lonelytwitter.data.TweetListModel;

public class AbstaractTweetList extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
	public AbstaractTweetList() {
		super (LonelyTwitterActivity.class);
	}
	
	/*public void testFail () {
	// Cause test to auto fail
	//	fail("Message");
	}*/
	
	public void testFiveisFive () {
		// Trivial case to demonstrate jUnit Test Case
		assertEquals("Five is Five", 5, 5);
	}
	
	public void testdemoAbstractTweet () {
		Tweet t = new Tweet("Hello"); 
		String actual = t.getTweetBody();
		
		Tweet t2 = new Tweet("Hello");

		assertEquals("Tweet body is the same", "Hello", actual);
		//assertSame("SameTweets", t, t2); fails because point in memory is different
		assertEquals("SameTweets", t, t2);		
	}
	
	
	public void testhasTweetAdd() {
		TweetListModel tweetListModel = new TweetListModel ();
		
		Tweet t = new Tweet("Hello");
		Tweet t2 = new Tweet("Hello");
		Tweet t3 = new Tweet("Bonjour");
		Tweet t4 = new Tweet("Konichiwa");

		tweetListModel.addTweet(t);
		assertTrue("Added tweet t", tweetListModel.getList().size() == 1); 
		tweetListModel.addTweet(t3);
		tweetListModel.addTweet(t4);
		assertTrue("Added tweet t3, t4", tweetListModel.getList().size() == 3); 
		
		try {
			tweetListModel.addTweet(t2);
			fail("Didn't throw an exception when adding a duplicate tweet");
		} catch (Exception e) {
			assertEquals("Catch Duplicated Tweet", e.getMessage(), "Tweet already exists in the list of tweets");
		} 
		
	}

	public void testTweetCount() {
		TweetListModel tweetListModel = new TweetListModel ();
		
		Tweet t = new Tweet("Hello");
		Tweet t2 = new Tweet("Hello");
		Tweet t3 = new Tweet("Bonjour");
		Tweet t4 = new Tweet("Konichiwa");

		tweetListModel.addTweet(t);
		assertTrue("Count 1", tweetListModel.getCount() == 1);
		tweetListModel.addTweet(t3);
		tweetListModel.addTweet(t4);
		assertTrue("Count 3", tweetListModel.getCount() == 3);
		assertEquals("Count 3 equals", tweetListModel.getCount(), tweetListModel.getList().size());
		
		try {
			tweetListModel.addTweet(t2);
			fail("Didn't throw an exception when adding a duplicate tweet");
		} catch (Exception e) {
			assertEquals("Catch Duplicated Tweet", e.getMessage(), "Tweet already exists in the list of tweets");
		} 
		
		assertTrue("Count 3 after exception throw", tweetListModel.getCount() == 3); 
	}
	
	public void testTweetContains() {
		TweetListModel tweetListModel = new TweetListModel ();
		
		Tweet t = new Tweet("Hello");
		Tweet t2 = new Tweet("Hello");
		Tweet t3 = new Tweet("Bonjour");
		Tweet t4 = new Tweet("Konichiwa");
		Tweet t5 = new Tweet("Goodbye");

		tweetListModel.addTweet(t);
		assertEquals("List has t1", tweetListModel.hasTweet(t), tweetListModel.getList().contains(t));
		assertEquals("List does not have t3", tweetListModel.hasTweet(t3), tweetListModel.getList().contains(t3));
		tweetListModel.addTweet(t3);
		assertEquals("List has t3", tweetListModel.hasTweet(t3), tweetListModel.getList().contains(t3));
		tweetListModel.addTweet(t4);
		assertEquals("List has t4", tweetListModel.hasTweet(t4), tweetListModel.getList().contains(t4));
		assertEquals("List does not have t5", tweetListModel.hasTweet(t5), tweetListModel.getList().contains(t5));
		assertEquals("List has Hello (t2)", tweetListModel.hasTweet(t2), tweetListModel.getList().contains(t2));

		try {
			tweetListModel.addTweet(t2);
			fail("Didn't throw an exception when adding a duplicate tweet");
		} catch (Exception e) {
			assertEquals("Catch Duplicated Tweet", e.getMessage(), "Tweet already exists in the list of tweets");
		} 
		
		assertTrue("List has Hello (t2) after exception", tweetListModel.hasTweet(t2) == true);
	}
	
	public void testTweetRemove() {
		TweetListModel tweetListModel = new TweetListModel ();
		
		Tweet t = new Tweet("Hello");
		Tweet t2 = new Tweet("Hello");
		Tweet t3 = new Tweet("Bonjour");
		Tweet t4 = new Tweet("Konichiwa");
		Tweet t5 = new Tweet("Goodbye");

		tweetListModel.addTweet(t);
		assertTrue("Added tweet t", tweetListModel.getList().size() == 1); 
		tweetListModel.removeTweet(t);
		assertTrue("Removed tweet t", tweetListModel.getList().size() == 0); 
		tweetListModel.addTweet(t3);
		tweetListModel.addTweet(t4);

		try {
			tweetListModel.addTweet(t2);
			assertTrue ("Added non duplicated t2 tweet", tweetListModel.hasTweet(t2));
		} catch (Exception e) {
			assertEquals("Duplicated Tweet Error. Impossibility to reach this step", e.getMessage(), "Tweet already exists in the list of tweets");
		} 
		

	}
	
	public void testTweetSort() {
		TweetListModel tweetListModel = new TweetListModel ();
		
		Tweet t = new Tweet("Hello");
		Tweet t2 = new Tweet("Hello");
		Tweet t3 = new Tweet("Bonjour");
		Tweet t4 = new Tweet("Konichiwa");
		Tweet t5 = new Tweet("Goodbye");

		// Add the tweets out of order
		tweetListModel.addTweet(t3);
		tweetListModel.addTweet(t2);
		AbstractTweet[] displayList = tweetListModel.getTweets();
		assertTrue ("t2 in first spot", displayList[0].equals(t2));
		assertTrue ("t3 in second spot", displayList[1].equals(t3));

	}
	


}
