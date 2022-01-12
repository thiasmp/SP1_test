package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Owner;
import facades.BoatFacade;
import facades.UserFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("HarbourInfo")
public class BoatResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final BoatFacade boatFacade = BoatFacade.getBoatFacade(EMF);
    private static String securityToken;

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Owner")
    public List<Owner> allOwners() {
        {
            return boatFacade.getAllOwners();
        }
    }

}
