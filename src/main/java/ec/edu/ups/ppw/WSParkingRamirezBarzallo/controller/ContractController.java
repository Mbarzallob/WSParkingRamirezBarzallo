package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.contract.ContractRequest;

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

}
