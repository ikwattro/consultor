package com.ikwattro.extension.consultor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.junit.Rule;
import org.junit.Test;
import org.neo4j.harness.ServerControls;
import org.neo4j.harness.TestServerBuilders;
import org.neo4j.test.Mute;
import org.neo4j.test.server.HTTP;

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
            String base = "http://localhost:7474";
            HTTP.Response responseA = HTTP.GET(base);
            System.out.println(responseA.toString());
            System.out.println(endpoint);
            HTTP.Response response = HTTP.GET( endpoint );
            System.out.println(response);

            // Then
            assertEquals(200, response.status());
        }
    }
}