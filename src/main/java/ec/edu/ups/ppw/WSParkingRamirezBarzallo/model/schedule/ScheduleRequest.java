package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.schedule;


import jakarta.validation.constraints.NotBlank;

public class ScheduleRequest {
    private int id;


    private String startTime;

    private String endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank(message = "Hora de inicio invalida") String getStartTime() {
        return startTime;
    }

    public void setStartTime(@NotBlank(message = "Hora de inicio invalida") String startTime) {
        this.startTime = startTime;
    }

    public @NotBlank(message = "Hora de fin invalida") String getEndTime() {
        return endTime;
    }

    public void setEndTime(@NotBlank(message = "Hora de fin invalida") String endTime) {
        this.endTime = endTime;
    }
}
