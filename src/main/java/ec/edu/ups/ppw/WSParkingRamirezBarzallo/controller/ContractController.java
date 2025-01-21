package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.contract.ContractType;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/contract")
public class ContractController {
    @GET
    @Path("/types")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContractType() {
        try
        {
            List<ContractType> contractTypes = new ArrayList<>();
            return Response.ok(contractTypes).build();
        }
        catch(Exception e)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
