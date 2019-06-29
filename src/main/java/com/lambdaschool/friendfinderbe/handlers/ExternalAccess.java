package com.lambdaschool.friendfinderbe.handlers;

import com.lambdaschool.friendfinderbe.models.RandomUserMe;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ExternalAccess
{
    public ArrayList<RandomUserMe> connectAndRetrieveJson(String urlSuffix)
    {
        return connectAndRetrieveJson(urlSuffix, null);
    }

    public ArrayList<RandomUserMe> connectAndRetrieveJson(String urlSuffix, RandomUserMe.Hobby hobby)
    {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        ArrayList<RandomUserMe> arrayList = new ArrayList<>();

        try
        {
            URL restAPIUrl = new URL("https://randomuser.me/api/" + urlSuffix);
            connection = (HttpURLConnection) restAPIUrl.openConnection();
            connection.setRequestMethod("GET");

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder jsonRawData = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null)
            {
                jsonRawData.append(line);
            }

            JSONObject jsonObject = new JSONObject(jsonRawData.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("results");

            for (int i = 0; i < jsonArray.length(); ++i)
            {
                arrayList.add(new RandomUserMe(jsonArray.getJSONObject(i), hobby));
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            IOUtils.closeQuietly(reader);
        }

        return arrayList;
    }
}
