package seedu.address.model.appointment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

class UpcomingAppointmentTest {

    @Test
    public void constructor_nullString_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new UpcomingAppointment((String) null));
    }

    @Test
    public void constructor_nullLocalDate_success() {
        UpcomingAppointment upcomingAppointment = new UpcomingAppointment((LocalDate) null);
        assertNull(upcomingAppointment.getDate());
    }

    @Test
    public void constructor_invalidString_throwsIllegalArgumentException() {
        String invalidDate = "abcd";
        assertThrows(IllegalArgumentException.class, () -> new UpcomingAppointment(invalidDate));
    }

    @Test
    public void constructor_validString_success() {
        String validDate = "12-12-2022";
        UpcomingAppointment upcomingAppointment = new UpcomingAppointment(validDate);
        assertEquals("12-12-2022", upcomingAppointment.getDate()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }

    @Test
    public void constructor_emptyString_success() {
        String emptyDate = "";
        UpcomingAppointment upcomingAppointment = new UpcomingAppointment(emptyDate);
        assertNull(upcomingAppointment.getDate());
    }

    @Test
    public void isValidDate_emptyString_returnsTrue() {
        assertTrue(UpcomingAppointment.isValidDate(""));
    }

    // boundary condition, partition - current date
    @Test
    public void isValidDate_today_returnsTrue() {
        assertTrue(UpcomingAppointment.isValidDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
    }

    // partition - past dates
    @Test
    public void isValidDate_yesterday_returnsFalse() {
        assertFalse(UpcomingAppointment.isValidDate(LocalDate.now().minusDays(1)
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
    }

    // partition - future dates
    @Test
    public void isValidDate_tomorrow_returnsTrue() {
        assertTrue(UpcomingAppointment.isValidDate(LocalDate.now().plusDays(1)
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
    }

    @Test
    public void toString_emptyDate_returnsNoneString() {
        UpcomingAppointment upcomingAppointment = new UpcomingAppointment("");
        assertEquals("Upcoming Appointment Date: None", upcomingAppointment.toString());
    }

    @Test
    public void toString_validDate_returnsDate() {
        UpcomingAppointment upcomingAppointment = new UpcomingAppointment("12-12-2022");
        assertEquals("Upcoming Appointment Date: 12-12-2022", upcomingAppointment.toString());
    }
}
