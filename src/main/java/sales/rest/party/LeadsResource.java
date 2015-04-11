package sales.rest.party;

import com.silvermoongroup.common.domain.ObjectReference;
import sales.frontend.cunsumable.domain.party.LeadDTO;
import sales.rest.AbstractResource;
import sales.transactional.process.party.LeadsManagementBean;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

import static java.lang.String.valueOf;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created with IntelliJ IDEA by henryb.
 *
 * @author <a href="mailto:henry.g.brown@gmail.com">henryb</a>
 * @version 0.1201504091047
 * @since 0.1201504091047
 */
@Path("/lead")
public class LeadsResource extends AbstractResource {

    @Inject
    LeadsManagementBean leadsManagement;

    @Context
    UriInfo info;

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response create(LeadDTO leadDTO) {
        final ObjectReference objectReference = leadsManagement.createLead(getApplicationContext(), leadDTO);
        final URI uri = info.getBaseUriBuilder().path(LeadsResource.class).path(valueOf(objectReference.getObjectId())).build();
        return Response.created(uri).build();
    }

    @GET
    @Produces(APPLICATION_JSON)
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        final LeadDTO lead = leadsManagement.get(getApplicationContext(), id);
        return Response.ok(lead).build();
    }

    @PUT
    @Consumes(APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") Long id, LeadDTO lead) {
//        leadsManagement.update(getApplicationContext(), lead);
        return Response.noContent().build();
    }

    @GET
    @Produces(APPLICATION_JSON)
    public Response getAll(@QueryParam("offset") @DefaultValue("0") int offset,
                           @QueryParam("limit") @DefaultValue("50") int limit) {
//        final List<LeadDTO> leads = leadsManagement.getAll(getApplicationContext(), offset, limit);
//        final LeadDTO[] leadsArray = leads.toArray(new LeadDTO[leads.size()]);
//        return Response.ok(leadsArray).build();
        return null;
    }


    public void notifyDataBrokerOfLeadStatus() {

    }
}
