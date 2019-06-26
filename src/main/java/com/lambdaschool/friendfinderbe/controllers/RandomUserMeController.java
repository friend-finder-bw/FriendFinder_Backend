package com.lambdaschool.friendfinderbe.controllers;

import com.lambdaschool.friendfinderbe.handlers.ExternalAccess;
import com.lambdaschool.friendfinderbe.models.RandomUserMe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequestMapping("/profiles")
public class RandomUserMeController
{
    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(value = "/unfiltered", produces = {"application/json"})
    public ResponseEntity<?> listAllProfiles(HttpServletRequest request)
    {
        logger.trace(request.getRequestURI() + " accessed");

        ExternalAccess externalAccess = new ExternalAccess();
        ArrayList<RandomUserMe> arrayList = externalAccess.connectAndRetrieveJson("?results=10");

        return new ResponseEntity<>(arrayList, HttpStatus.OK);
    }
}