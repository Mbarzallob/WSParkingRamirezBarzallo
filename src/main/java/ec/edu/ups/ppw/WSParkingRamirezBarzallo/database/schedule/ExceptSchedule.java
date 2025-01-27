package ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.schedule;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "except_schedule")
public class ExceptSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "start_hour")
    private String startHour;

    @Column(name = "end_hour")
    private String endHour;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
