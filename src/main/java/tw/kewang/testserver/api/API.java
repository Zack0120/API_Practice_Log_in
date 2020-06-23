package tw.kewang.testserver.api;

import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("User")                                                                                  //This class's path
public class API {
    private static final Gson GSON = new Gson();                                               //Set Gson object

    @Produces("application/json")                                                              //Return Json file to the client
    @POST                                                                                      //Use POST method tp get the information
    @Path("Add_Stu_Response")                                                                  //The function's path
    public Response addAPI(String body) { //, @HeaderParam("password") String password
        Add_Stu_Response add_stu_response = new Add_Stu_Response();

        String usernameDefault = "Zack";                                                       //Setting the default username and the password
        String passwordDefault = "0120";

        User user = new User();                                                                //initialize the object
        user = GSON.fromJson(body, User.class);                                                //User get a GSON from User class as a body in Json

        System.out.println(user.getUsername());

        if(user.verification(user.getUsername(), usernameDefault, user.getPassword(), passwordDefault)){     //Through verification function to check whether the data from postman is the same as the default
            add_stu_response.setResponseCode(0);                                               //The success code
            add_stu_response.setResponseMessage("Success");
        }
        else{
            add_stu_response.setResponseCode(1);
            add_stu_response.setResponseMessage("Fail");
        }

        return Response.ok().entity(GSON.toJson(add_stu_response)).build();                    //Return a JSON from Add_Stu_Response
    }
}