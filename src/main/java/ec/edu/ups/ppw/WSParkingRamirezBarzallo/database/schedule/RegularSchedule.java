package ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.schedule;

import jakarta.persistence.*;

@Entity
@Table(name = "regular_schedule")
public class RegularSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "week_day", nullable = false)
    private int weekDay;

    @Column(name = "start_hour", nullable = false)
    private String startHour; //HH:mm:ss

    @Column(name="end_date", nullable = false)
    private String endDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
