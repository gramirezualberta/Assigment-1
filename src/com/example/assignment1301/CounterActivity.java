/**
 * This app was developed for CMPUT 301 assigment 1.
 * 
 * The app allows the user to creater a new counter, which will be display in the main screen in the phone.
 * The user would click on one to list of counter in the ListView to see more detail of it.
 * 
 * CCID: GRAMIREZ
 * Guillermo Ramirez
 * 
 * Instrutor:
 * TAs:
 */

package com.example.assignment1301;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CounterActivity extends Activity implements OnItemClickListener {

	private final String SEND_NAME_COUNTER = "name";
	private final String SEND_DATA_COUNTER = "data";
	private final int RESQUEST_CANCEL = 0; 
	private final int RESQUEST_NAME_FROM_CREATE = 1;
	public final int RESQUEST_COUNTER_STATUS = 2;

	int pos=0;
	
	ListView counterListView;
	Button addCounterButton;
	private List <Counter> counterList; //store a list of counter object.

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter);

		counterList = new ArrayList<Counter>();

		counterListView = (ListView) findViewById(R.id.counterList);
		addCounterButton = (Button) findViewById(R.id.addCounterButton);
		Adapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,counterList);
		counterListView.setAdapter((ListAdapter) adapter);

		Collections.sort(counterList);
		
		//use to click on item on the listview to show more detail about counters.
		counterListView.setOnItemClickListener(this);
		 ;


	}
	
	protected void onResume(Bundle saveInstanceState)
	{
		Collections.sort(counterList);
		super.onResume();
		
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.counter, menu);
		return true;
	}



	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
		// TODO Auto-generated method stub

		Counter aCounter = counterList.get(position);
		pos=position;
		Intent intent=new Intent(this,CounterViewActivity.class);
		Bundle bundle=new Bundle();
		bundle.putSerializable(SEND_DATA_COUNTER, aCounter);
		intent.putExtras(bundle);
		startActivityForResult(intent, RESQUEST_COUNTER_STATUS);
		
		
		
	}

	/*
	 * This methodo open the create counter activity
	 */
	public void addCounterOpen(View view)
	{
		Intent intent=new Intent(this,CreateNewCounterActivity.class);
		intent.putExtra(SEND_NAME_COUNTER, "name");
		startActivityForResult(intent, RESQUEST_NAME_FROM_CREATE);
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);

		if(requestCode == RESQUEST_NAME_FROM_CREATE && data!=null){
			String counterName =data.getStringExtra(SEND_NAME_COUNTER);
			String msg ="Counter " + counterName+ " has been added";
			Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
			counterList.add(new Counter(counterName, new Date(System.currentTimeMillis())));
			counterListView.invalidateViews();
		}
		if(resultCode == RESQUEST_COUNTER_STATUS)
		{	
			Counter aCounter= (Counter) data.getSerializableExtra(SEND_DATA_COUNTER);
			
			String msg= "hola como estas?";
			Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
			
			counterList.set(pos, aCounter);
			counterListView.invalidateViews();
			
			
		}
		if(resultCode == RESQUEST_CANCEL)
		{
			String cancel ="Creation of counter canceled";
			Toast.makeText(this, cancel, Toast.LENGTH_SHORT).show();
		}
	}

}
