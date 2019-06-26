package com.lambdaschool.friendfinderbe.models;

import org.json.JSONException;
import org.json.JSONObject;

import javax.persistence.*;

@Entity
@Table(name = "randomuserme")
public class RandomUserMe
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName, lastName, title, gender, age, dob, nationality, hobby, email, phone, cell, street, city, state, postcode, timezoneOffset, timezoneDescription, latitude, longitude, urlLarge, urlMedium, urlThumbnail;

    private enum Hobby
    {Movies, Sports, Outdoors, Computers, Gaming}

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


        this.hobby = Hobby.values()[(int) (Math.random() * Hobby.values().length)].toString();

        switch (this.nationality)
        {
            case "AU":
                this.nationality = "Australia";
                break;
            case "BR":
                this.nationality = "Brazil";
                break;
            case "CA":
                this.nationality = "Canada";
                break;
            case "CH":
                this.nationality = "Switzerland";
                break;
            case "DE":
                this.nationality = "Germany";
                break;
            case "DK":
                this.nationality = "Denmark";
                break;
            case "ES":
                this.nationality = "Spain";
                break;
            case "FI":
                this.nationality = "Finland";
                break;
            case "FR":
                this.nationality = "France";
                break;
            case "GB":
                this.nationality = "Great Britain";
                break;
            case "IE":
                this.nationality = "Ireland";
                break;
            case "IR":
                this.nationality = "Iran";
                break;
            case "NO":
                this.nationality = "Norway";
                break;
            case "NL":
                this.nationality = "Netherlands";
                break;
            case "NZ":
                this.nationality = "New Zealand";
                break;
            case "TR":
                this.nationality = "Turkey";
                break;
            case "US":
                this.nationality = "USA";
                break;
            default:
                this.nationality = "Unknown";
                break;
        }
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge(String age)
    {
        this.age = age;
    }

    public String getDob()
    {
        return dob;
    }

    public void setDob(String dob)
    {
        this.dob = dob;
    }

    public String getNationality()
    {
        return nationality;
    }

    public void setNationality(String nationality)
    {
        this.nationality = nationality;
    }

    public String getHobby()
    {
        return hobby;
    }

    public void setHobby(String hobby)
    {
        this.hobby = hobby;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getCell()
    {
        return cell;
    }

    public void setCell(String cell)
    {
        this.cell = cell;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public String getTimezoneOffset()
    {
        return timezoneOffset;
    }

    public void setTimezoneOffset(String timezoneOffset)
    {
        this.timezoneOffset = timezoneOffset;
    }

    public String getTimezoneDescription()
    {
        return timezoneDescription;
    }

    public void setTimezoneDescription(String timezoneDescription)
    {
        this.timezoneDescription = timezoneDescription;
    }

    public String getLatitude()
    {
        return latitude;
    }

    public void setLatitude(String latitude)
    {
        this.latitude = latitude;
    }

    public String getLongitude()
    {
        return longitude;
    }

    public void setLongitude(String longitude)
    {
        this.longitude = longitude;
    }

    public String getUrlLarge()
    {
        return urlLarge;
    }

    public void setUrlLarge(String urlLarge)
    {
        this.urlLarge = urlLarge;
    }

    public String getUrlMedium()
    {
        return urlMedium;
    }

    public void setUrlMedium(String urlMedium)
    {
        this.urlMedium = urlMedium;
    }

    public String getUrlThumbnail()
    {
        return urlThumbnail;
    }

    public void setUrlThumbnail(String urlThumbnail)
    {
        this.urlThumbnail = urlThumbnail;
    }
}
