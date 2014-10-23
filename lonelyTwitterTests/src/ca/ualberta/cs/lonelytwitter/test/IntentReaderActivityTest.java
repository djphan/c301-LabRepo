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
    
    public void testReverseText() {
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "The empty environment is simply the process of computing 6!");
    	intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.REVERSE);
    	
    	
	    setActivityIntent(intent);
	    IntentReaderActivity ira = getActivity();	    
	    assertEquals(ira.getText(), "!6 gnitupmoc fo ssecorp eht ylpmis si tnemnorivne ytpme ehT");
    	
    }
    
    public void testDefaultMessage() {
    	String string = null;
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, string);
    	
	    setActivityIntent(intent);
	    IntentReaderActivity ira = getActivity();	    
	    assertEquals(ira.getText(), "The Fault Text");
    }
    
    public void testAssertView() {
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "The empty environment is simply the process of computing 6!");
    	intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.NORMAL);
    	setActivityIntent(intent);
	    IntentReaderActivity ira = getActivity();
	    
	    TextView testview = ((TextView)ira.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText));
    	ViewAsserts.assertOnScreen(ira.getWindow().getDecorView(), testview); 
    	
    }
       
}
