package com.nttd.api;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.nttd.api.request.AuditRequest;
import com.nttd.api.response.AuditResponse;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/audit")
@RegisterRestClient
public interface AuditApi {

    @GET
    AuditResponse getAll();

    @POST
    AuditResponse add(AuditRequest auditRequest);

}
