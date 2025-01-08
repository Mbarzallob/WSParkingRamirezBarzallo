package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.ContractType;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/contractType")
public class ContractTypeController {
    @GET
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
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addContractType(ContractType contractType) {
        try
        {
            // TODO: Insert logic
        }
        catch(Exception e)
        {

        }
    }
}
