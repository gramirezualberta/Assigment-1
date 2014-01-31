/**
 * This class store data for a counter such as Date, Count, also 
 * give information about the counter.
 * 
 */
package com.example.assignment1301;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Guillermo Ramirez
 *
 */
public class Counter implements Serializable, Comparable<Counter> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 997698552402989531L;
	String counterName;
	Date initDate;
	int Count;
	
	public Counter(String counterName, Date initDate)
	{
		this.counterName=counterName;
		this.initDate=initDate;
		this.Count=0;
	}

	/**
	 * @return the counterName
	 */
	public String getCounterName() {
		return counterName;
	}

	/**
	 * @param counterName the counterName to set
	 */
	public void setCounterName(String counterName) {
		this.counterName = counterName;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return Count;
	}

	/**
	 * @param initDate the initDate to set
	 */
	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		Count = count;
	}

	/**
	 * @return the initDate
	 */
	public Date getInitDate() {
		return initDate;
	}
	
	public String toString()
	{
		String msg =getCounterName() +" created on " +(getInitDate().getYear()+1900)+"/"+(getInitDate().getMonth()+1)
				+"/"+getInitDate().getDate() +" and has " + getCount() +" counts";
		return msg;
	}

	@Override
	public int compareTo(Counter another) {
		// TODO Auto-generated method stub
		return this.getCount()-another.getCount();
	}


}
