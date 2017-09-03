package th.vu.cs.nectec;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.widget.ArrayAdapter;
import android.widget.ListView;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ListView jsonLisview;
    public  ArrayList<String> exData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jsonLisview = (ListView)findViewById(R.id.Listview1);

        exData = new ArrayList<String>();


        new AsyncTask<Void, Void, Void>() {


            @Override
            protected Void doInBackground(Void... voids) {

                try {
                    URL url = new URL("http://api2.traffy.in.th/api/smartphuket/start_end_terminals/");
                    URLConnection urlConnection = url.openConnection();
                    HttpURLConnection httpURLConnection = (HttpURLConnection)urlConnection;
                    httpURLConnection.setAllowUserInteraction(false);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();

                    InputStream inputStream = null;

                    if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
                        inputStream = httpURLConnection.getInputStream();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"),8);

                    StringBuilder stringBuilder = new StringBuilder();
                    String line = null;

                    while ((line = reader.readLine()) != null){
                        stringBuilder.append(line + "\n");

                    }

                    inputStream.close();

                    Log.d("JSON REsult",stringBuilder.toString());



                        exData.add( "\u0e27\u0e34\u0e17\u0e22\u0e32\u0e25\u0e31\u0e22\u0e2d\u0e32\u0e0a\u0e35\u0e27\u0e28\u0e36\u0e01\u0e29\u0e32\u0e20\u0e39\u0e40\u0e01\u0e47\u0e15"+
                                "\u0e15\u0e25\u0e32\u0e14\u0e43\u0e2b\u0e21\u0e48\u0e21\u0e38\u0e21\u0e40\u0e21\u0e37\u0e2d\u0e07");

                         exData.add(" \u0e2b\u0e49\u0e32\u0e07\u0e2a\u0e23\u0e23\u0e1e\u0e2a\u0e34\u0e19\u0e04\u0e49\u0e32\u0e1a\u0e34\u0e4a\u0e01\u0e0b\u0e35" +
                                 "  \u0e27\u0e34\u0e17\u0e22\u0e32\u0e25\u0e31\u0e22\u0e2d\u0e32\u0e0a\u0e35\u0e27\u0e28\u0e36\u0e01\u0e29\u0e32\u0e20\u0e39\u0e40\u0e01\u0e47\u0e15");
                        exData.add("\u0e02\u0e19\u0e2a\u0e48\u0e07 1" +"\u0e02\u0e19\u0e2a\u0e48\u0e07 2");
                        exData.add("\u0e2a\u0e30\u0e1e\u0e32\u0e19\u0e2b\u0e34\u0e19" + "\u0e40\u0e01\u0e32\u0e30\u0e2a\u0e34\u0e40\u0e2b\u0e23\u0e48");

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,exData);
                jsonLisview.setAdapter(myAdapter);

            }
        }.execute();




    }








}
