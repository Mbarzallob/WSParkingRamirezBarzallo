package ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.email;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.schedule.ExceptSchedule;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.schedule.RegularSchedule;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.parking.ParkingRepository;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.shedule.ScheduleRepository;
import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Singleton
public class ParkingNotifierService {

    @Inject
    private EmailService emailService;
    @Inject
    private ScheduleRepository scheduleRepository;
    @Inject
    private ParkingRepository parkingRepository;



    @Schedule(hour = "*", minute = "*", second = "0", persistent = false)
    public void checkParkingClosingTime() {
        LocalTime now = LocalTime.now();
        LocalDate today = LocalDate.now();
        int todayIndex = today.getDayOfWeek().getValue() % 7;



        List<ExceptSchedule> exceptSchedules = scheduleRepository.getExceptSchedulesToday();

        for (ExceptSchedule exceptSchedule : exceptSchedules) {
            if (exceptSchedule.getStartHour() == null && exceptSchedule.getEndHour() == null) {
                return;
            }
        }

        RegularSchedule schedule = scheduleRepository.getRegularScheduleByDay(todayIndex);
        List<LocalTime> closingTimes = new ArrayList<>();

        if (schedule != null && schedule.getEndHour() != null) {
            closingTimes.add(LocalTime.parse(schedule.getEndHour(), DateTimeFormatter.ofPattern("HH:mm:ss")));
        }

        for (ExceptSchedule exceptSchedule : exceptSchedules) {
            if (exceptSchedule.getStartHour() != null && exceptSchedule.getEndHour() != null) {
                LocalTime exceptionClosingTime = LocalTime.parse(exceptSchedule.getEndHour(), DateTimeFormatter.ofPattern("HH:mm:ss"));
                closingTimes.add(exceptionClosingTime);
            }
        }

        for (LocalTime closingTime : closingTimes) {
            LocalTime nowTruncated = now.truncatedTo(ChronoUnit.MINUTES);
            LocalTime notificationTime = closingTime.minusMinutes(10).truncatedTo(ChronoUnit.MINUTES);


            if (nowTruncated.equals(notificationTime)) {
                List<String> usersEmails = parkingRepository.getEmailsOfPersonsWithActiveTickets();
                for (String email : usersEmails) {
                    try {
                        emailService.sendEmail(email, "Aviso de Cierre", "El parqueadero cerrará en 10 minutos.");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Schedule(hour = "*", minute = "*", second = "0", persistent = false)
    public void checkParkingOpenTime() {
        LocalTime now = LocalTime.now();
        LocalDate today = LocalDate.now();
        int todayIndex = today.getDayOfWeek().getValue() % 7;


        List<ExceptSchedule> exceptSchedules = scheduleRepository.getExceptSchedulesToday();

        for (ExceptSchedule exceptSchedule : exceptSchedules) {
            if (exceptSchedule.getStartHour() == null && exceptSchedule.getEndHour() == null) {
                return;
            }
        }

        RegularSchedule schedule = scheduleRepository.getRegularScheduleByDay(todayIndex);
        List<LocalTime> openingTimes = new ArrayList<>();

        if (schedule != null && schedule.getStartHour() != null) {
            openingTimes.add(LocalTime.parse(schedule.getStartHour(), DateTimeFormatter.ofPattern("HH:mm:ss")));
        }

        for (ExceptSchedule exceptSchedule : exceptSchedules) {
            if (exceptSchedule.getStartHour() != null && exceptSchedule.getEndHour() != null) {
                LocalTime exceptionOpeningTime = LocalTime.parse(exceptSchedule.getStartHour(), DateTimeFormatter.ofPattern("HH:mm:ss"));
                openingTimes.add(exceptionOpeningTime);
            }
        }

        for (LocalTime openingTime : openingTimes) {
            LocalTime nowTruncated = now.truncatedTo(ChronoUnit.MINUTES);
            LocalTime notificationTime = openingTime.minusMinutes(10).truncatedTo(ChronoUnit.MINUTES);

            if (nowTruncated.equals(notificationTime) ) {
                List<String> usersEmails = parkingRepository.getEmailsOfPersonsWithActiveTickets();
                for (String email : usersEmails) {
                    try {
                        emailService.sendEmail(email, "Aviso de Apertura", "El parqueadero abrirá en 10 minutos.");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
