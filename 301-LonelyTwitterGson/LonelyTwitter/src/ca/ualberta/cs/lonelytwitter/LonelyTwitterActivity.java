package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import ca.ualberta.cs.lonelytwitter.data.GsonDataManager;
import ca.ualberta.cs.lonelytwitter.data.IDataManager;

public class LonelyTwitterActivity extends Activity {

	private IDataManager dataManager;

	private EditText bodyText;

	private ListView oldTweetsList;

	private ArrayList<Tweet> tweets;

	private ArrayAdapter<Tweet> tweetsViewAdapter;
	
	private SummaryClass mySummary;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		dataManager = new GsonDataManager(this);
		mySummary = new SummaryClass();

		bodyText = (EditText) findViewById(R.id.body);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
	}

	@Override
	protected void onStart() {
		super.onStart();

		tweets = dataManager.loadTweets();
		tweetsViewAdapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(tweetsViewAdapter);
	}

	public void save(View v) {

		String text = bodyText.getText().toString();

		Tweet tweet = new Tweet(new Date(), text);
		tweets.add(tweet);

		tweetsViewAdapter.notifyDataSetChanged();

		bodyText.setText("");
		dataManager.saveTweets(tweets);
	}

	public void clear(View v) {
		tweets.clear();
		
		tweetsViewAdapter.notifyDataSetChanged();
		dataManager.saveTweets(tweets);
	}
	
	public void summaryAction(View v) {
		Toast.makeText(this, "Summary Page", Toast.LENGTH_SHORT).show();
		createSummary();
		
		Intent intent = new Intent (LonelyTwitterActivity.this, Summary.class);
		Bundle sBundle = new Bundle();
		sBundle.putSerializable("bSummary", mySummary);
		intent.putExtra("iSummary", sBundle);
		startActivity(intent);
	}
	
	private void createSummary() {
		mySummary.setNumTweets(getNumber());
		mySummary.setAvgLengthTweets(getAvgLength());
	}
	
	
	private long getNumber() {
		return tweets.size();
	}
	
	private long getAvgLength() {
		long total = 0;
		long result = 0;
		
		for (Tweet tweet : tweets) {
			total += tweet.getTweetBody().length();
		}
		
		result = total/tweets.size();
		
		return result;
			
	}

}