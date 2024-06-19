package com.example.demo.employee;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonFromLink {

    public static void getJsonFromHttpRequest() {
        try {
            JSONObject jsonObject1 = new JSONObject();
            // Create a URL object with the API endpoint
            URL url = new URL("https://dummyjson.com/products");

            //"https://dummyjson.com/products/1"

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // If the response code is OK, read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse the JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());
                  JSONArray jsonArray = jsonResponse.getJSONArray("products");

                //get json by id
                for (int i = 0; i < jsonArray.length(); i++) {
                    jsonObject1 = jsonArray.getJSONObject(i);
                    if (jsonObject1.get("id").equals(1)) {
                        break;
                    }
                    //String value1 = jsonObject1.optString("1");
                }

                //JSONArray jsonArray = new JSONArray(response.toString());

                // Print the JSON response
                //System.out.println(jsonArray.toString());
                System.out.println(jsonObject1.toString());
            } else {
                // If response code is not OK, print error message
                System.out.println("GET request failed with response code " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
