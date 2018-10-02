package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class DateTimeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToString() {
		DateTime dateTime = new DateTime(2018, 9, 10, 20, 0, 0);
		
		Assert.assertEquals(new String("2018-09-10 20:00"), dateTime.toString());
	}

	@Test
	public void testDateTimeString() {
		DateTime dateTime = new DateTime("2018-09-10 20:00:00");
		
		Assert.assertEquals(new String("2018-09-10 20:00"), dateTime.toString());
	}

}
