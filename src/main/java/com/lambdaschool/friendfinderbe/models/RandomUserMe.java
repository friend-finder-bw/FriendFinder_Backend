package com.lambdaschool.friendfinderbe.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class RandomUserMe
{
    private String firstName, lastName, title, gender, age, dob, nationality, hobby, email, phone, cell, street, city, state, postcode, timezoneOffset, timezoneDescription, latitude, longitude, urlLarge, urlMedium, urlThumbnail;
    private enum Hobby {Movies, Sports, Outdoors, Computers, Gaming}

    public RandomUserMe()
    {
    }

    public RandomUserMe(JSONObject jsonObject)
    {
        try
        {
            this.firstName = jsonObject.getJSONObject("name").getString("first");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        try
        {
            this.lastName = jsonObject.getJSONObject("name").getString("last");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        try
        {
            this.title = jsonObject.getJSONObject("name").getString("title");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        try
        {
            this.gender = jsonObject.getString("gender");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        try
        {
            this.age = Integer.toString(jsonObject.getJSONObject("dob").getInt("age"));
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        try
        {
            this.dob = jsonObject.getJSONObject("dob").getString("date");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        try
        {
            this.nationality = jsonObject.getString("nat");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        try
        {
            this.email = jsonObject.getString("email");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        try
        {
            this.phone = jsonObject.getString("phone");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        try
        {
            this.cell = jsonObject.getString("cell");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        try
        {
            this.street = jsonObject.getJSONObject("location").getString("street");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        try
        {
            this.city = jsonObject.getJSONObject("location").getString("city");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        try
        {
            this.state = jsonObject.getJSONObject("location").getString("state");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        try
        {
            this.postcode = Integer.toString(jsonObject.getJSONObject("location").getInt("postcode"));
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        try
        {
            this.timezoneOffset = jsonObject.getJSONObject("location").getJSONObject("timezone").getString("offset");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        try
        {
            this.timezoneDescription = jsonObject.getJSONObject("location").getJSONObject("timezone").getString("description");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        try
        {
            this.latitude = jsonObject.getJSONObject("location").getJSONObject("coordinates").getString("latitude");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        try
        {
            this.longitude = jsonObject.getJSONObject("location").getJSONObject("coordinates").getString("longitude");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        try
        {
            this.urlLarge = jsonObject.getJSONObject("picture").getString("large");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        try
        {
            this.urlMedium = jsonObject.getJSONObject("picture").getString("medium");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        try
        {
            this.urlThumbnail = jsonObject.getJSONObject("picture").getString("thumbnail");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }


        this.hobby=Hobby.values()[(int) (Math.random()*Hobby.values().length)].toString();

        switch (this.nationality){
            case "AU":
                this.nationality="Australia";
                break;
            case "BR":
                this.nationality="Brazil";
                break;
            case "CA":
                this.nationality="Canada";
                break;
            case "CH":
                this.nationality="Switzerland";
                break;
            case "DE":
                this.nationality="Germany";
                break;
            case "DK":
                this.nationality="Denmark";
                break;
            case "ES":
                this.nationality="Spain";
                break;
            case "FI":
                this.nationality="Finland";
                break;
            case "FR":
                this.nationality="France";
                break;
            case "GB":
                this.nationality="Great Britain";
                break;
            case "IE":
                this.nationality="Ireland";
                break;
            case "IR":
                this.nationality="Iran";
                break;
            case "NO":
                this.nationality="Norway";
                break;
            case "NL":
                this.nationality="Netherlands";
                break;
            case "NZ":
                this.nationality="New Zealand";
                break;
            case "TR":
                this.nationality="Turkey";
                break;
            case "US":
                this.nationality="USA";
                break;
            default:
                this.nationality="Unknown";
                break;
        }
    }
}
