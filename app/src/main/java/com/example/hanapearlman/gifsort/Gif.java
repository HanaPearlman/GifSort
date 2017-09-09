package com.example.hanapearlman.gifsort;

import java.util.Set;

public class Gif {

    private String url;
    private Set<String> tags;

    public Gif(String url, Set<String>tags){
        this.url = url;
        this.tags = tags;
    }

    public boolean doesTagExist(String tag){
        return tags.contains(tag);
    }

    public String getUrl(){
        return url;
    }

}
