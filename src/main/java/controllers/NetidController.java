package controllers;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

import static java.util.stream.Collectors.toList;

@Path("/netid")
public class NetidController {

    @GET
    public String netid() {
        return "rc737";
    }
}
