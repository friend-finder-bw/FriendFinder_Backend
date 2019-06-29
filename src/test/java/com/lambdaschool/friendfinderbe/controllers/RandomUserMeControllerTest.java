//package com.lambdaschool.friendfinderbe.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.lambdaschool.friendfinderbe.handlers.ExternalAccess;
//import com.lambdaschool.friendfinderbe.models.RandomUserMe;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(value = RandomUserMeController.class, secure = false)
//public class RandomUserMeControllerTest
//{
//    @Autowired
//    private MockMvc mockMvc;
//
//    //@MockBean
//    //private RandomUserMeService randomUserMeService;
//
//    private ExternalAccess externalAccess;
//    private ArrayList<RandomUserMe> arrayList;
//
//    @Before
//    public void setUp() throws Exception
//    {
//        externalAccess = new ExternalAccess();
//        arrayList = new ArrayList<>();
//
//        arrayList.add(new RandomUserMe("jurema", "rodrigues", "miss", "female", "69", "1950-05-26T16:40:14Z", "Brazil", "Movies", "jurema.rodrigues@example.com", "(87) 8384-0912", "(64) 7991-3560", "1264 rua primeiro de maio ", "porto velho", "tocantins", "30621", "-3:30", "Newfoundland", "-76.2407", "130.2668", "https://randomuser.me/api/portraits/women/85.jpg", "https://randomuser.me/api/portraits/med/women/85.jpg", "https://randomuser.me/api/portraits/thumb/women/85.jpg"));
//
//
//        arrayList.add(new RandomUserMe("léane", "moulin", "mrs", "female", "58", "1961-03-22T03:59:35Z", "France", "Movies", "léane.moulin@example.com", "03-59-93-00-06", "06-14-54-77-96", "4972 rue des ecrivains", "marseille", "haute-marne", "69833", "+7:00", "Bangkok, Hanoi, Jakarta", "87.9160", "-129.5046", "https://randomuser.me/api/portraits/women/20.jpg", "https://randomuser.me/api/portraits/med/women/20.jpg", "https://randomuser.me/api/portraits/thumb/women/20.jpg"));
//
//
//        arrayList.add(new RandomUserMe("bella", "patel", "miss", "female", "25", "1994-05-26T11:28:32Z", "New Zealand", "Movies", "bella.patel@example.com", "(120)-450-0838", "(481)-097-1881", "1813 castle street", "hamilton", "tasman", "59187", "+10:00", "Eastern Australia, Guam, Vladivostok", "73.7675", "-84.8891", "https://randomuser.me/api/portraits/women/31.jpg", "https://randomuser.me/api/portraits/med/women/31.jpg", "https://randomuser.me/api/portraits/thumb/women/31.jpg"));
//    }
//
//    @After
//    public void tearDown() throws Exception
//    {
//    }
//
//    @Test
//    public void getProfiles() throws Exception
//    {
//        String apiUrl = "/profiles/unfiltered";
//
//        //Mockito.when(/*randomUserMeService.getProfiles()*/externalAccess.connectAndRetrieveJson("?seed=ffbe&results=3", RandomUserMe.Hobby.Movies)).thenReturn(arrayList);
//
//        RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);
//
//        MvcResult r = mockMvc.perform(rb).andReturn();
//        String tr = r.getResponse().getContentAsString();
//
//        ObjectMapper mapper = new ObjectMapper();
//        String er = mapper.writeValueAsString(arrayList);
//
//        assertEquals("Rest API Returns List", er, tr);
//    }
//
//    @Test
//    public void getProfilesCount()
//    {
//    }
//
//    @Test
//    public void getProfilesCountByGender()
//    {
//    }
//
//    @Test
//    public void getProfilesCountByLocation()
//    {
//    }
//
//    @Test
//    public void getProfilesCountByHobby()
//    {
//    }
//}
