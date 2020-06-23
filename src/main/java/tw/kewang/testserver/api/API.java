package tw.kewang.testserver.api;

import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("User")
public class API {
    private static final Gson GSON = new Gson();

    @Produces("application/json")
    @POST
    @Path("Add_Stu_Response")
    public Response addAPI(String body) { //, @HeaderParam("password") String password
        Add_Stu_Response add_stu_response = new Add_Stu_Response();

        String usernameDefault = "Zack";
        String passwordDefault = "0120";

        User user = new User();
        user = GSON.fromJson(body, User.class);

        System.out.println(user.getUsername());

        if(user.verification(user.getUsername(), usernameDefault, user.getPassword(), passwordDefault)){
            add_stu_response.setResponseCode(0);
            add_stu_response.setResponseMessage("Success");
        }
        else{
            add_stu_response.setResponseCode(1);
            add_stu_response.setResponseMessage("Fail");
        }

        return Response.ok().entity(GSON.toJson(add_stu_response)).build();
    }
}