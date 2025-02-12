package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.schedule;

import java.time.LocalDate;

public class ExceptScheduleRequest {
    public LocalDate date;
    public String startHour;
    public String endHour;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }
}
