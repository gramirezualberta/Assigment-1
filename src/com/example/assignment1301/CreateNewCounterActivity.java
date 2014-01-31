package com.example.assignment1301;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateNewCounterActivity extends Activity {
	
	private final String SEND_NAME_COUNTER ="name";
	private final int RESQUEST_NAME_FROM_CREATE = 1;
	private final int RESQUEST_CANCEL = 0;
	
	EditText nameCounter;
	Button createCounter;
	Button cancelCounter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_new_counter);
		// Show the Up button in the action bar.
		setupActionBar();
		
		createCounter = (Button) findViewById(R.id.createCounter);
		cancelCounter = (Button) findViewById(R.id.CancelButton);
		nameCounter = (EditText) findViewById(R.id.nameCounterCreate);
	}
	
	public void createCounter (View view)
	{
		
		String name =nameCounter.getText().toString();
		Intent intentName = new Intent();
		
		intentName.putExtra(SEND_NAME_COUNTER, name);
		setResult(RESQUEST_NAME_FROM_CREATE, intentName);
		finish();
		
	}
	
	public void cancelOperation(View view)
	{
		setResult(RESQUEST_CANCEL);
		finish();
	}

	
	
	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_new_counter, menu);
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
