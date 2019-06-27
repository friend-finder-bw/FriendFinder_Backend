package com.lambdaschool.friendfinderbe.controllers;

import com.lambdaschool.friendfinderbe.exceptions.ResourceNotFoundException;
import com.lambdaschool.friendfinderbe.handlers.ExternalAccess;
import com.lambdaschool.friendfinderbe.models.ErrorDetail;
import com.lambdaschool.friendfinderbe.models.RandomUserMe;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Locale;

@RestController
@RequestMapping("/profiles")
public class RandomUserMeController
{
    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);

    @ApiOperation(value = "Retrieves 10 user profiles", response = RandomUserMe.class, responseContainer = "List")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Profiles Found", response = RandomUserMe.class), @ApiResponse(code = 404, message = "Profiles Not Found", response = ErrorDetail.class)})
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(value = "/unfiltered", produces = {"application/json"})
    public ResponseEntity<?> getProfiles(HttpServletRequest request)
    {
        logger.trace(request.getRequestURI() + " accessed");

        ExternalAccess externalAccess = new ExternalAccess();
        ArrayList<RandomUserMe> arrayList = externalAccess.connectAndRetrieveJson("?results=10");

        return new ResponseEntity<>(arrayList, HttpStatus.OK);
    }


    @ApiOperation(value = "Retrieves the specified number of user profiles", response = RandomUserMe.class, responseContainer = "List")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Profiles Found", response = RandomUserMe.class), @ApiResponse(code = 404, message = "Profiles Not Found", response = ErrorDetail.class)})
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(value = "/unfiltered/{count}", produces = {"application/json"})
    public ResponseEntity<?> getProfilesCount(HttpServletRequest request, @ApiParam(value = "Number of profiles", required = true, example = "1") @PathVariable Long count)
    {
        logger.trace(request.getRequestURI() + " accessed");

        if (count < 1 || count > 5000)
        {
            throw new ResourceNotFoundException("Invalid count. Range should be between 1 and 5000!");
        }

        ExternalAccess externalAccess = new ExternalAccess();
        ArrayList<RandomUserMe> arrayList = externalAccess.connectAndRetrieveJson("?results=" + count.toString());

        return new ResponseEntity<>(arrayList, HttpStatus.OK);
    }


    @ApiOperation(value = "Retrieves the specified number of user profiles which are filtered by gender", response = RandomUserMe.class, responseContainer = "List")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Profiles Found", response = RandomUserMe.class), @ApiResponse(code = 404, message = "Profiles Not Found", response = ErrorDetail.class)})
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(value = "/gender/{gender}/count/{count}", produces = {"application/json"})
    public ResponseEntity<?> getProfilesCountByGender(HttpServletRequest request, @ApiParam(value = "Gender", required = true, example = "male") @PathVariable String gender, @ApiParam(value = "Number of profiles", required = true, example = "1") @PathVariable Long count)
    {
        logger.trace(request.getRequestURI() + " accessed");

        if (count < 1 || count > 5000)
        {
            throw new ResourceNotFoundException("Invalid count. Range should be between 1 and 5000!");
        }

        if (gender.trim().equals(""))
        {
            throw new ResourceNotFoundException("Gender type must be specified!");
        }

        String genderSort = "male";
        if (gender.toLowerCase(Locale.US).startsWith("f"))
            genderSort = "female";

        ExternalAccess externalAccess = new ExternalAccess();
        ArrayList<RandomUserMe> arrayList = externalAccess.connectAndRetrieveJson("?gender=" + genderSort + "&results=" + count.toString());

        return new ResponseEntity<>(arrayList, HttpStatus.OK);
    }


    @ApiOperation(value = "Retrieves the specified number of user profiles with matching city, state", response = RandomUserMe.class, responseContainer = "List")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Profiles Found", response = RandomUserMe.class), @ApiResponse(code = 404, message = "Profiles Not Found", response = ErrorDetail.class)})
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(value = "/city/{city}/state/{state}/count/{count}", produces = {"application/json"})
    public ResponseEntity<?> getProfilesCountByLocation(HttpServletRequest request, @ApiParam(value = "City", required = true, example = "Minneapolis") @PathVariable String city, @ApiParam(value = "State", required = true, example = "MN") @PathVariable String state, @ApiParam(value = "Number of profiles", required = true, example = "1") @PathVariable Long count)
    {
        logger.trace(request.getRequestURI() + " accessed");

        if (count < 1 || count > 5000)
        {
            throw new ResourceNotFoundException("Invalid count. Range should be between 1 and 5000!");
        }

        if (city.trim().equals("") || state.trim().equals(""))
        {
            throw new ResourceNotFoundException("Both city and state must be specified!");
        }

        ExternalAccess externalAccess = new ExternalAccess();
        ArrayList<RandomUserMe> arrayList = externalAccess.connectAndRetrieveJson("?results=" + count.toString());

        for (RandomUserMe entry : arrayList)
        {
            entry.setCity(city);
            entry.setState(state);
        }

        return new ResponseEntity<>(arrayList, HttpStatus.OK);
    }


    @ApiOperation(value = "Retrieves the specified number of user profiles with matching hobby", response = RandomUserMe.class, responseContainer = "List")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Profiles Found", response = RandomUserMe.class), @ApiResponse(code = 404, message = "Profiles Not Found", response = ErrorDetail.class)})
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(value = "/hobby/{hobby}/count/{count}", produces = {"application/json"})
    public ResponseEntity<?> getProfilesCountByHobby(HttpServletRequest request, @ApiParam(value = "Hobby", required = true, example = "Outdoors") @PathVariable String hobby, @ApiParam(value = "Number of profiles", required = true, example = "1") @PathVariable Long count)
    {
        logger.trace(request.getRequestURI() + " accessed");

        if (count < 1 || count > 5000)
        {
            throw new ResourceNotFoundException("Invalid count. Range should be between 1 and 5000!");
        }

        if (hobby.trim().equals(""))
        {
            throw new ResourceNotFoundException("Hobby must be specified!");
        }

        ExternalAccess externalAccess = new ExternalAccess();
        ArrayList<RandomUserMe> arrayList = externalAccess.connectAndRetrieveJson("?results=" + count.toString());

        for (RandomUserMe entry : arrayList)
        {
            entry.setHobby(hobby);
        }

        return new ResponseEntity<>(arrayList, HttpStatus.OK);
    }
}