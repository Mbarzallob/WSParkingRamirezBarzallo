package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.contract.ContractRequest;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.contract.FilterContract;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.contract.FilterTicket;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.contract.TicketRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.parking.ContractService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/contract")
public class ContractController {
    @Inject
    private ContractService contractService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addContract(@Valid ContractRequest contractRequest) {
        var result = contractService.createContract(contractRequest);
        return Response.ok(result).build();
    }

    @GET
    @Path("/{parkingId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getContract(@PathParam("parkingId") int parkingId) {
        var result = contractService.getAllContracts(parkingId);
        return Response.ok(result).build();
    }


    @POST
    @Path("/ticket")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTicket(@Valid TicketRequest ticketRequest) {
        var result = contractService.addTicket(ticketRequest);
        return Response.ok(result).build();
    }

    @PUT
    @Path("/ticket/{ticketId}/end")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response endTicket(@PathParam("ticketId") int ticketId) {
        var result =contractService.endTicket(ticketId);
        return Response.ok(result).build();
    }

    @GET
    @Path("/ticket")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllTickets() {
        var result = contractService.getAllTickets();
        return Response.ok(result).build();
    }

    @POST
    @Path("/report")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response reportContract(FilterContract filter) {
        var result = contractService.getReportContracts(filter);
        return Response.ok(result).build();
    }

    @POST
    @Path("/ticket/report")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response reportTicket(FilterTicket filter) {
        var result = contractService.getReportTickets(filter);
        return Response.ok(result).build();
    }


    @GET
    @Path("/types")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getContractTypes() {
        var result = contractService.getTypes();
        return Response.ok(result).build();
    }
}
