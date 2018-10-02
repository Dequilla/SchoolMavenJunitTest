package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import se.ju.csi.oom.lab4.Person;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class TimeZoneTranslatorTest 
{
	@Before
	public void setUp() throws Exception 
	{
	}

	@Test
	public void testShiftTimeZone() 
	{
		DateTime dateTime = new DateTime(2001, 9, 10, 13, 37, 37);
		
		dateTime = TimeZoneTranslator.shiftTimeZone(dateTime, TimeZone.JAPAN.getOffset(), TimeZone.SINGAPORE.getOffset());
		
		Assert.assertEquals(new String("2001-09-10 12:37"), dateTime.toString());
	}
	
	@Test
	public void testShiftTimeZone2() 
	{
		DateTime dateTime = new DateTime(2016, 1, 1, 6, 00, 00);
		
		dateTime = TimeZoneTranslator.shiftTimeZone(dateTime, TimeZone.CENTRAL_EUROPEAN_TIME.getOffset(), TimeZone.US_PACIFIC.getOffset());
		
		Assert.assertEquals(new String("2015-12-31 21:00"), dateTime.toString());
	}

	@Test
	public void testShiftEventTimeZone() 
	{	
		Event event = new Event(
				new String("My Birthday"), 
				new DateTime(2018, 9, 10, 1, 0, 0), 
				new DateTime(2018, 9, 11, 1, 0, 0),
				new HashSet<>(Arrays.asList(new Person("Dad"), new Person("Mom"), new Person("Brother"))),
				new Place("Home", 1.1, 1.1, 1.1)
		);
		
		event = TimeZoneTranslator.shiftEventTimeZone(event, TimeZone.HAWAII, TimeZone.JAPAN);
		
		Assert.assertEquals(new String("2018-09-10 20:00"), event.getStartDate().toString());
		Assert.assertEquals(new String("2018-09-11 20:00"), event.getEndDate().toString());
	}
}
