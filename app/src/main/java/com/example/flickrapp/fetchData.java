package com.example.flickrapp;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchData extends AsyncTask<Void,Void,Void> {

    String data = "";
    String dataParsed = "";
    String singleParsed = "";
    @Override
    protected Void doInBackground(Void... voids) {


        try {
            URL url = new URL("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=035a4f62b1537a0c672501f0d778739e&text=car&per_page=3&format=json&nojsoncallback=1\n");
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();

            InputStream inputStream = connect.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;

            }

            JSONArray JA = new JSONArray(data);

            //JSONObject JsonObject = new JSONObject(data);
            //JSONObject Json_photos = JsonObject.getJSONObject("photos");
            //JSONArray JsonArray_photo = Json_photos.getJSONArray("photo");


            for(int i = 0; i < JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed =  "(Photos: " + JO.get("photo") + "\n"+
                                "(id: " + JO.get("id") + "\n"+
                                "(owner: " + JO.get("owner") + "\n"+
                                "(secret: " + JO.get("secret") + "\n"+
                                "(server: " + JO.get("server") + "\n"+
                                "(farm: " + JO.get("farm") + "\n"+
                                "(title: " + JO.get("title") + "\n";

                dataParsed = dataParsed + singleParsed;
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.data.setText(this.data);
    }






}
