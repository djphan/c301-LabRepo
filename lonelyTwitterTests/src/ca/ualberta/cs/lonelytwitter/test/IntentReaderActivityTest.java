package ca.ualberta.cs.lonelytwitter.test;

//import android.annotation.SuppressLint;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import ca.ualberta.cs.lonelytwitter.R;

//@SuppressLint("NewApi") 
public class IntentReaderActivityTest extends
        ActivityInstrumentationTestCase2<IntentReaderActivity> {

    public IntentReaderActivityTest() {
        super(IntentReaderActivity.class);
    }

    public void testSendText() {
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "testing send text");
    	
    	setActivityIntent(intent);
    	
    	IntentReaderActivity ira = getActivity();
    	assertEquals(ira.getText(), "testing send text");
    }
    
    public void testDisplayText() {
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "testing display");
    	
    	setActivityIntent(intent);
    	
    	IntentReaderActivity ira = getActivity();
    	TextView tv = ((TextView)ira.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText));
    	assertEquals(tv.getText(), "testing display");
    	
    }
    
    public void testDoubleText() {
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "HARRO-WIN");
    	intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
    	
    	
    setActivityIntent(intent);
    
    IntentReaderActivity ira = getActivity();
    
    assertEquals(ira.getText(), "HARRO-WINHARRO-WIN");
    }
       
}
