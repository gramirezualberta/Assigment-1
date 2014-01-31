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
		
		addButton = (Button) findViewById(R.id.add);
		resetButton = (Button) findViewById(R.id.reset);
		renameButton = (Button) findViewById(R.id.renameCounter);
		quitButton = (Button) findViewById(R.id.quit);
		counterName = (TextView) findViewById(R.id.counterNameSelect);
		counterCount = (TextView) findViewById(R.id.counterNumber);
	
		Intent intent =this.getIntent();
		Bundle bundle= intent.getExtras();
		aCounter = (Counter) bundle.getSerializable(SEND_DATA_COUNTER);
		counterName.setText(aCounter.getCounterName());
		counterCount.setText(Integer.toString(aCounter.getCount()));
		

	}
	
	public void addOne(View view)
	{
		int count = aCounter.getCount();
		count++;
		aCounter.setCount(count);
		counterCount.setText(Integer.toString(aCounter.getCount()));
		counterCount.invalidate();
	}
	
	public void quit(View view)
	{
		Intent intent = new Intent();
		intent.putExtra(SEND_DATA_COUNTER, aCounter);
		setResult(2, intent);
		finish();
	}
	
	public void rename(View view)
	{
		//testing code
		Context context = this;
		AlertDialog.Builder alertDialaBuilder = new AlertDialog.Builder(context);
		alertDialaBuilder.setTitle("Rename counter");
		alertDialaBuilder.setMessage("holas");
		
		alertDialaBuilder.create();
		alertDialaBuilder.show();
		//testing code
		
	}
	
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
