package sit707_week5;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class WeatherControllerTest {

    @Test
	public void testStudentIdentity() {
		String studentId = "S223182277";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Isuru Perera";
		Assert.assertNotNull("Student name is null", studentName);
	}

    @Test
    public void testTemperaturePersist() {
        // Set a fixed clock
        Clock fixedClock = Clock.fixed(Instant.parse("2022-01-01T10:15:30.00Z"), ZoneId.systemDefault());
        WeatherController wController = new WeatherController(fixedClock);

        String persistTime = wController.persistTemperature(10, 19.5);
        String now = new SimpleDateFormat("H:m:s").format(Date.from(fixedClock.instant()));

        Assert.assertTrue(persistTime.equals(now));

        wController.close();
    }
}
