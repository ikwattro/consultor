package com.ikwattro.extension.consultor;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.*;
import java.util.HashMap;

import com.ikwattro.extension.consultor.InversionDefinition;
import com.ikwattro.extension.consultor.helper.JsonHelper;

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
    @Path( "/" )
    public Response hello()
    {
        System.out.println("this is the api root");
        // Do stuff with the database
        return Response.status( Status.OK ).entity(
                "Simple Hello World".getBytes(Charset.forName("UTF-8")) ).build();
    }

    @POST
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    @Path("/invert")
    public Response invertRelationshipsApi(String json) throws JsonParseException, IOException
    {

        JsonHelper jsonHelper = new JsonHelper();
        HashMap definition = (HashMap)jsonHelper.toObject(json, HashMap.class);

        Response response = Response.status( Status.OK ).entity(
                "{}"
        ).build();

        return response;
    }
}