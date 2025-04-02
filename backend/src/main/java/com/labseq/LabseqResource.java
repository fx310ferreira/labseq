package com.labseq;

import java.util.Map;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/labseq")
public class LabseqResource {

    @Inject
    LabseqService labseqService;

    @GET
    @Path("/{n}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLabseq(@PathParam("n") int n) {
        long result = labseqService.getLabseq(n);
        return Response.ok(result).build();
    }

    @GET
    @Path("/cache")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCache() {
        Map<Integer, Long> cache = labseqService.getCache();
        return Response.ok(cache).build();
    }
}
