package com.lambdaschool.friendfinderbe.controllers;

import com.lambdaschool.friendfinderbe.models.ErrorDetail;
import com.lambdaschool.friendfinderbe.models.User;
import com.lambdaschool.friendfinderbe.models.UserRoles;
import com.lambdaschool.friendfinderbe.services.RoleService;
import com.lambdaschool.friendfinderbe.services.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

@RestController
public class OpenController
{
    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "Creates a user profile", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Profile Created", response = User.class),
            @ApiResponse(code = 404, message = "Profile Not Created", response = ErrorDetail.class)})
    @PostMapping(value = "/createnewuser", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> addNewUser(HttpServletRequest request, @ApiParam(value = "JSON body of user attributes", required = true, example = "{ \"username\": \"name\", \"password\": \"password\", \"email\":\"person@lambdaschool.com\", \"location\":\"USA\", \"age\":\"18\", \"gender\":\"male\", \"hobby\":\"outdoors\" }") @Valid @RequestBody User newuser) throws URISyntaxException
    {
        logger.trace(request.getRequestURI() + " accessed");

        ArrayList<UserRoles> newRoles = new ArrayList<>();
        newRoles.add(new UserRoles(newuser, roleService.findByName("user")));
        newuser.setUserRoles(newRoles);

        newuser = userService.save(newuser);

        // set the location header for the newly created resource - to another controller!
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRestaurantURI = ServletUriComponentsBuilder.fromUriString(request.getServerName() + ":" + request.getLocalPort() + "/users/user/{userId}").buildAndExpand(newuser.getUserid()).toUri();
        responseHeaders.setLocation(newRestaurantURI);


        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

}
