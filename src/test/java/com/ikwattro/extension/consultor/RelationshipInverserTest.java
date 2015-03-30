package com.ikwattro.extension.consultor;

import org.json.JSONArray;
import org.junit.Rule;
import org.junit.Test;
import org.neo4j.harness.ServerControls;
import org.neo4j.harness.TestServerBuilders;
import org.neo4j.test.Mute;
import org.neo4j.test.server.HTTP;
import com.ikwattro.extension.consultor.helper.JsonHelper;
import com.ikwattro.extension.consultor.InversionDefinition;

import static org.junit.Assert.*;

import com.ikwattro.extension.consultor.RelationshipInverter;

public class RelationshipInverserTest
{
    @Rule public Mute mute = Mute.muteAll();

    @Test
    public void TestRelationshipInverser() throws Exception
    {
        // Given
        try ( ServerControls server = TestServerBuilders.newInProcessBuilder()
                .withExtension( "/ikwattro", RelationshipInverter.class )
                .newServer())
        {
            // When
            String endpoint = server.httpURI().resolve( "ikwattro" ).toString();
            HTTP.Response response = HTTP.GET(endpoint);

            // Then
            assertEquals(200, response.status());
        }
    }

    @Test
    public void TestPostInverterParams() throws Exception
    {
        InversionDefinition definition = new InversionDefinition();
        definition.setDirection("OUTGOING");
        definition.setLabel("Page");
        definition.setType("TARGET_BY_LINK");
        JsonHelper jsonHelper = new JsonHelper();
        String json = jsonHelper.toJson(definition);
        // Given The RelationshipInverter is loaded
        try ( ServerControls server = TestServerBuilders.newInProcessBuilder()
                .withExtension("/ikwattro", RelationshipInverter.class)
                .newServer())
        {
            // When I post a params json object
            String endpoint = server.httpURI().resolve("ikwattro").toString();
            String url = endpoint + "/invert";
            HTTP.Response response = HTTP.POST(url, json);
            // Then it should start the conversion
            assertEquals(200, response.status());

        }
    }
}