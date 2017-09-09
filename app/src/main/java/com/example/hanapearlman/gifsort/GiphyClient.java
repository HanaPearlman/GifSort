package com.example.hanapearlman.gifsort;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class GiphyClient {
    private String API_KEY = "05bfea6b7b75411d8f27c73622d8c0f6";
    private String BASE_URL = "http://api.giphy.com/v1/gifs/";

    public void getRandomGiphy(JsonHttpResponseHandler jsonHttpResponseHandler) {
        String url = BASE_URL + "random";
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("api_key", API_KEY);
        client.get(url, params, jsonHttpResponseHandler);
    }

    public void getRandomGiphyWithTag(String tag, JsonHttpResponseHandler jsonHttpResponseHandler) {
        String url = BASE_URL + "random";
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("api_key", API_KEY);
        params.put("tag", tag);
        client.get(url, params, jsonHttpResponseHandler);
    }
}
