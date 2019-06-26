package com.lambdaschool.friendfinderbe.controllers;

import com.lambdaschool.friendfinderbe.exceptions.ResourceNotFoundException;
import com.lambdaschool.friendfinderbe.handlers.ExternalAccess;
import com.lambdaschool.friendfinderbe.models.RandomUserMe;
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

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(value = "/unfiltered", produces = {"application/json"})
    public ResponseEntity<?> getProfiles(HttpServletRequest request)
    {
        logger.trace(request.getRequestURI() + " accessed");

        ExternalAccess externalAccess = new ExternalAccess();
        ArrayList<RandomUserMe> arrayList = externalAccess.connectAndRetrieveJson("?results=10");

        return new ResponseEntity<>(arrayList, HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(value = "/unfiltered/{count}", produces = {"application/json"})
    public ResponseEntity<?> getProfilesCount(HttpServletRequest request, @PathVariable Long count)
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


    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(value = "/gender/{gender}/count/{count}", produces = {"application/json"})
    public ResponseEntity<?> getProfilesCountByGender(HttpServletRequest request, @PathVariable String gender, @PathVariable Long count)
    {
        logger.trace(request.getRequestURI() + " accessed");

        if (count < 1 || count > 5000)
        {
            throw new ResourceNotFoundException("Invalid count. Range should be between 1 and 5000!");
        }

        String genderSort = "male";
        if (gender.toLowerCase(Locale.US).startsWith("f"))
            genderSort = "female";

        ExternalAccess externalAccess = new ExternalAccess();
        ArrayList<RandomUserMe> arrayList = externalAccess.connectAndRetrieveJson("?gender=" + genderSort + "&results=" + count.toString());

        return new ResponseEntity<>(arrayList, HttpStatus.OK);
    }
}