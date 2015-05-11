package ca.ualberta.cs.lonelytwitter.test;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;

public class LonelyTwitterActivityUITest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	Instrumentation instrumentation;
	Activity activity;
	EditText textInput;
	
	public LonelyTwitterActivityUITest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		instrumentation = getInstrumentation();
		activity = getActivity();
		textInput = ((EditText) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.body));
	}
	
	 //makeTweet(text) fills in the input text field and clicks the 'save' button for the activity under test:
	private void makeTweet(String text) {
		assertNotNull(activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save));
		textInput.setText(text);
		((Button) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save)).performClick();
	}
	
//TODO: Add your code here:
	@UiThreadTest
	public void testMakeTweet() {
		// Set that the Listview Adapter gets a new tweet
		LonelyTwitterActivity lta = getActivity();
		int old_length = lta.getAdapter().getCount();
		makeTweet("NaOH Test. Wub. Wub.");
		ArrayAdapter<NormalTweetModel> aa = lta.getAdapter();
		assertEquals(aa.getCount(), old_length+1);
		
		assertTrue(aa.getItem(aa.getCount()-1) instanceof NormalTweetModel);
		
		assertEquals(aa.getItem(aa.getCount()-1).getText(), "NaOH Test. Wub. Wub.");
	}
	
	
	
			
}