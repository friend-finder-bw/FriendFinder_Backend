/*
package com.lambdaschool.friendfinderbe.controllers;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RandomUserMeControllerIntegrationTest
{
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception
    {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getProfiles()
    {
        given().when().get("/profiles/unfiltered").then().time(lessThan(5000L));
    }

    @Test
    public void getProfilesCount()
    {
        given().when().get("/profiles/unfiltered/10").then().time(lessThan(5000L));
    }

    @Test
    public void getProfilesCountByGender()
    {
        given().when().get("/profiles/gender/male/count/10").then().time(lessThan(5000L));
    }

    @Test
    public void getProfilesCountByLocation()
    {
        given().when().get("/profiles/city/minneapolis/state/mn/count/10").then().time(lessThan(5000L));
    }

    @Test
    public void getProfilesCountByHobby()
    {
        given().when().get("/profiles/hobby/outdoors/count/10").then().time(lessThan(5000L));
    }
}
*/
