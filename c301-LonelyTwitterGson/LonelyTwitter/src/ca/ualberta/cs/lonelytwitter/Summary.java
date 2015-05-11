package ca.ualberta.cs.lonelytwitter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class Summary extends Activity {
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summary);
		Bundle sBundle = getIntent().getBundleExtra("iSummary");
		SummaryClass summaryvalue = (SummaryClass) sBundle.get("bSummary");
		
		editTheText(summaryvalue);

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.summary, menu);
		return true;
	}

	public void editTheText (SummaryClass summaryvalue) {
		TextView numValue = (TextView) findViewById(R.id.number);
		numValue.setText(String.valueOf(summaryvalue.getNumTweets()));
		TextView numAvgValue = (TextView) findViewById(R.id.avgNumber);
		numAvgValue.setText(String.valueOf(summaryvalue.getAvgLengthTweets()));
	}
	

}
