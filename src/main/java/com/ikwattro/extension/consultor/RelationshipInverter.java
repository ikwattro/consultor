package com.ikwattro.extension.consultor;

import java.nio.charset.Charset;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.neo4j.graphdb.GraphDatabaseService;

@Path( "" )
public class RelationshipInverter
{
    private final GraphDatabaseService database;

    public RelationshipInverter( @Context GraphDatabaseService database )
    {
        this.database = database;
    }

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    //@Path( "/" )
    public Response hello()
    {
        // Do stuff with the database
        return Response.status( Status.OK ).entity(
                "Simple Hello World".getBytes(Charset.forName("UTF-8")) ).build();
    }
}