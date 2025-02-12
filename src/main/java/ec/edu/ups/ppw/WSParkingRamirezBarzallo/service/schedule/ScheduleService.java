package ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.schedule;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.schedule.ExceptSchedule;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.schedule.RegularSchedule;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.generic.Result;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.schedule.ExceptScheduleRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.schedule.ScheduleRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.shedule.ScheduleRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ScheduleService {
    @Inject
    private ScheduleRepository repo;

    public Result<List<RegularSchedule>> getRegularSchedules() {
        try{
            var schedules = repo.getRegularSchedules();
            return Result.success(schedules);
        } catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }

    public Result<Void> updateSchedule(ScheduleRequest request){
        try{
            repo.updateRegularSchedule(request);
            return Result.ok();
        }catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }

    public Result<Void> addExceptSchedule(List<ExceptScheduleRequest> schedules){
        try{
            for(ExceptScheduleRequest request : schedules){
                repo.addExceptSchedule(request);
            }
            return Result.ok();
        }catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }

    public Result<List<ExceptSchedule>> getExceptSchedules() {
        try{
            var schedules = repo.getExceptSchedules();
            return Result.success(schedules);
        }catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }

    public Result<Void> deleteExceptSchedule(int id){
        try{
            repo.deleteExceptSchedule(id);
            return Result.ok();
        }catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }

    public Result<Void> updateExceptSchedule(ExceptScheduleRequest request, int id){
        try{
            repo.updateExceptSchedule(request,id);
            return Result.ok();
        }catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }
}
