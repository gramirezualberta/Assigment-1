package com.example.assignment1301;

import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CounterViewActivity extends Activity {
	
	private final String SEND_DATA_COUNTER = "data";
	
	Button addButton;
	Button resetButton;
	Button renameButton;
	Button quitButton;
	TextView counterName;
	TextView counterCount;
	private Counter aCounter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter_view);
		// Show the Up button in the action bar.
		setupActionBar();
		
		//initialization
		addButton = (Button) findViewById(R.id.add);
		resetButton = (Button) findViewById(R.id.reset);
		renameButton = (Button) findViewById(R.id.renameCounter);
		quitButton = (Button) findViewById(R.id.quit);
		counterName = (TextView) findViewById(R.id.counterNameSelect);
		counterCount = (TextView) findViewById(R.id.counterNumber);
	
		// Get the data from the CounterActivity
		Intent intent =this.getIntent();
		Bundle bundle= intent.getExtras();
		aCounter = (Counter) bundle.getSerializable(SEND_DATA_COUNTER);
		//this pass the current data to the view, do it can display the correct information to the user.
		counterName.setText(aCounter.getCounterName());
		counterCount.setText(Integer.toString(aCounter.getCount()));
		

	}
	
	/**
	 * this method it is called after the user press the  "+" button from the screen and add 1 to the counter.
	 * @param view
	 */
	public void addOne(View view)
	{
		int count = aCounter.getCount();
		count++;
		aCounter.setCount(count);
		counterCount.setText(Integer.toString(aCounter.getCount()));
		// refresh view
		counterCount.invalidate();
	}
	
	/**
	 * This method wrap up all the new data that the user has modified and send them back to CounterActivity. Also, close the activity after the user press "quit" button
	 * @param view
	 */
	public void quit(View view)
	{
		Intent intent = new Intent();
		intent.putExtra(SEND_DATA_COUNTER, aCounter);
		setResult(2, intent);
		finish();
	}
	
	/**
	 * This method rename the counterName, after the user press the "rename" button.
	 * @param view
	 */
	public void rename(View view)
	{
		//testing code
		Context context = this;
		AlertDialog.Builder alertDialaBuilder = new AlertDialog.Builder(context);
		alertDialaBuilder.setTitle("Rename counter");
		alertDialaBuilder.setMessage("rename");
		
		alertDialaBuilder.create();
		alertDialaBuilder.show();
		//testing code
		
	}
	
	/**
	 * This mehtod reset the counter, that is, count = 0 and the the date it's reset to the current time after the user press "reset" button
	 * @param view
	 */
	public void reset(View view)
	{
	    aCounter.setCount(0);
	    aCounter.setInitDate(new Date(System.currentTimeMillis()));
	    counterCount.setText(Integer.toString(aCounter.getCount()));
	    counterCount.invalidate();
	}
/*
	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.counter_view, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
