package ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.shedule;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.schedule.ExceptSchedule;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.schedule.RegularSchedule;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.schedule.ExceptScheduleRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.schedule.ScheduleRequest;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class ScheduleRepository {
    @PersistenceContext
    private EntityManager em;

    public List<RegularSchedule> getRegularSchedules() {
        String query = "SELECT s FROM RegularSchedule s order by s.weekDay";
        TypedQuery<RegularSchedule> q = em.createQuery(query, RegularSchedule.class);
        return q.getResultList();
    }

    public void updateRegularSchedule(ScheduleRequest request) throws Exception {
        RegularSchedule regularSchedule = em.find(RegularSchedule.class, request.getId());
        if(regularSchedule == null) {
            throw new Exception("Regular Schedule Not Found");
        }
        regularSchedule.setEndHour(request.getEndTime());
        regularSchedule.setStartHour(request.getStartTime());
        em.merge(regularSchedule);
    }

    public List<ExceptSchedule> getExceptSchedules() {
        String query = "SELECT s FROM ExceptSchedule s";
        TypedQuery<ExceptSchedule> q = em.createQuery(query, ExceptSchedule.class);
        return q.getResultList();
    }

    public void addExceptSchedule(ExceptScheduleRequest es) {
        ExceptSchedule e = new ExceptSchedule();
        e.setDate(es.getDate());
        e.setStartHour(es.getStartHour());
        e.setEndHour(es.getEndHour());
        em.persist(e);
    }

    public RegularSchedule getRegularScheduleByDay(int day){
        try {
            String query = "SELECT s FROM RegularSchedule s where s.weekDay = :day";
            TypedQuery<RegularSchedule> q = em.createQuery(query, RegularSchedule.class);
            q.setParameter("day", day);
            return q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<ExceptSchedule> getExceptSchedulesToday() {
        String jpql = "SELECT s FROM ExceptSchedule s WHERE s.date = :today";

        return em.createQuery(jpql, ExceptSchedule.class)
                .setParameter("today", LocalDate.now())
                .getResultList();
    }

    public void deleteExceptSchedule(int id){
        ExceptSchedule e = em.find(ExceptSchedule.class, id);
        em.remove(em.merge(e));
    }

    public void updateExceptSchedule(ExceptScheduleRequest es, int id) throws Exception {
        ExceptSchedule e = em.find(ExceptSchedule.class, id);
        if(e == null) {
            throw new Exception("ExceptSchedule Not Found");
        }
        e.setEndHour(es.getEndHour());
        e.setStartHour(es.getStartHour());
        em.merge(e);
    }
}

