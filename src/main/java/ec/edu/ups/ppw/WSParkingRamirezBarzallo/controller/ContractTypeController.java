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
            return Response.ok(contractType).build();
        }
        catch(Exception e)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
    @PUT
    @Path("/{contractTypeId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateContractType(@PathParam("contractTypeId") int contractTypeId,ContractType contractType) {
        try
        {
            //TODO: UPDATE LOGIC
            return Response.ok().build();
        }
        catch(Exception e)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
    @DELETE
    @Path("/{contractTypeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteContractType(@PathParam("contractTypeId") int contractTypeId) {
        try
        {
            return Response.ok().build();
        }
        catch (Exception e)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
