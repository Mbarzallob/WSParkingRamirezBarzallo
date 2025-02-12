package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.schedule.ExceptScheduleRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.schedule.ScheduleRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.schedule.ScheduleService;
import jakarta.ejb.Schedule;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

import java.util.List;

@Path("/schedule")
public class ScheduleController {
    @Inject
    private ScheduleService scheduleService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSchedule() {
        var result = scheduleService.getRegularSchedules();
        return Response.ok(result).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSchedule(@Context SecurityContext sc, ScheduleRequest schedule) {
        if(!sc.isUserInRole("1")){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        var result = scheduleService.updateSchedule(schedule);
        return Response.ok(result).build();
    }

    @POST
    @Path("/except")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addExceptSchedules(@Context SecurityContext sc, List<ExceptScheduleRequest> schedule) {
        if(!sc.isUserInRole("1")){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        var result = scheduleService.addExceptSchedule(schedule);
        return Response.ok(result).build();
    }

    @GET
    @Path("/except")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExceptSchedules() {
        var result = scheduleService.getExceptSchedules();
        return Response.ok(result).build();
    }

    @DELETE
    @Path("/except/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteExceptSchedules(@Context SecurityContext sc,@PathParam("id")int id) {
        if(!sc.isUserInRole("1")){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        var result = scheduleService.deleteExceptSchedule(id);
        return Response.ok(result).build();
    }

    @PUT
    @Path("/except/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateExceptSchedules(@Context SecurityContext sc,@PathParam("id")int id, ExceptScheduleRequest schedule) {
        if(!sc.isUserInRole("1")){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        var result = scheduleService.updateExceptSchedule(schedule, id);
        return Response.ok(result).build();
    }
}
