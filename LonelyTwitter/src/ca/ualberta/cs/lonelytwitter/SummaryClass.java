package ca.ualberta.cs.lonelytwitter;

import java.io.Serializable;

public class SummaryClass implements Serializable{
	
	protected long numTweets;
	protected int avgLatencyTweets;
	protected long avgLengthTweets;
	
	public SummaryClass() {
		super(); 
	}

	public long getNumTweets() {
		return numTweets;
	}

	public void setNumTweets(long numTweets) {
		this.numTweets = numTweets;
	}

	public int getAvgLatencyTweets() {
		return avgLatencyTweets;
	}

	public void setAvgLatencyTweets(int avgLatencyTweets) {
		this.avgLatencyTweets = avgLatencyTweets;
	}

	public long getAvgLengthTweets() {
		return avgLengthTweets;
	}

	public void setAvgLengthTweets(long avgLengthTweets) {
		this.avgLengthTweets = avgLengthTweets;
	}

	
	
}
