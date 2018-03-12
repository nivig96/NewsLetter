package com.example.nivgoel.newsletter;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by nivgoel on 07-03-2018.
 */

public class ListActivity extends AppCompatActivity {
    ListView list;
    AdapterList adapter;
    ProgressBar loader;
//    private List<Articles> articlesList;
    //    String BASE_URL="https://newsapi.org/";
//    String TYPE = "v2/top-headlines?sources=";
//    String NEWSFROM = "usa-today";
//    String APIKEY = "d63a0f48d3564a02b866c7b7c1058e2d";
    ArrayList<Articles> dataList = new ArrayList<Articles>();
    static final String KEY_AUTHOR = "author";
    static final String KEY_TITLE = "title";
    static final String KEY_DESCRIPTION = "description";
    static final String KEY_URL = "url";
    static final String KEY_URLTOIMAGE = "urlToImage";
    static final String KEY_PUBLISHEDAT = "publishedAt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_list);

        list = (ListView) findViewById(R.id.list);
        loader = (ProgressBar) findViewById(R.id.loader);
        list.setEmptyView(loader);
        if (FetchApi.isNetworkAvailable(getApplicationContext())) {
            FetchNews newsTask = new FetchNews();
            newsTask.execute();
        } else {
            Toast.makeText(getApplicationContext(), "Turn on the Internet Connection", Toast.LENGTH_LONG).show();
        }

        // list.setAdapter(adapter);

    }

    class FetchNews extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String xml = "";

            String urlParameters = "";
//            String BASE_URL="https://newsapi.org/";
//            String TYPE = "v2/top-headlines?sources=";
//            String NEWSFROM = "usa-today";
//            String APIKEY = "d63a0f48d3564a02b866c7b7c1058e2d";
            xml = FetchApi.excuteGet(LinkingWebsite.BASE_URL + LinkingWebsite.TYPE + LinkingWebsite.NEWSFROM + "&apiKey=" + LinkingWebsite.APIKEY, urlParameters);
            return xml;
        }

        @Override
        protected void onPostExecute(String xml) {
            if (xml.length() > 10) { // Just checking if not empty

                try {
                    JSONObject jsonResponse = new JSONObject(xml);
                    JSONArray jsonArray = jsonResponse.optJSONArray("articles");
                    String bmp = null;

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//                        HashMap<String, String> map = new HashMap<String, String>();
//                        map.put(KEY_AUTHOR, jsonObject.optString(KEY_AUTHOR).toString());
//                        map.put(KEY_TITLE, jsonObject.optString(KEY_TITLE).toString());
//                        map.put(KEY_DESCRIPTION, jsonObject.optString(KEY_DESCRIPTION).toString());
//                        map.put(KEY_URL, jsonObject.optString(KEY_URL).toString());
//                        map.put(KEY_URLTOIMAGE, jsonObject.optString(KEY_URLTOIMAGE).toString());

                            Articles temp = new Articles(jsonObject.optString(KEY_TITLE).toString(),
                                    jsonObject.optString(KEY_DESCRIPTION).toString(),
                                    jsonObject.optString(KEY_URL).toString(),
                                    jsonObject.optString(KEY_URLTOIMAGE).toString()
                            );
                            dataList.add(temp);




                    }
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "Unexpected error", Toast.LENGTH_SHORT).show();
                }

                adapter = new AdapterList(ListActivity.this, dataList);
                list.setAdapter(adapter);
                adapter.notifyDataSetChanged();

                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                        Intent i = new Intent(getApplicationContext(), ArticleActivity.class);
                        i.putExtra("url", dataList.get(position).getUrl());
                        startActivity(i);
                        // Toast.makeText(ListActivity.this, "You clicked at" + web[+position], Toast.LENGTH_SHORT).show();
                    }
                });

            } else {
                Toast.makeText(getApplicationContext(), "No news found", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
