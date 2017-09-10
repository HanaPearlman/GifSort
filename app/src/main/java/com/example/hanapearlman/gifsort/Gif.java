package com.example.hanapearlman.gifsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Gif {

    public String url;
    public List<String> tags;
    public int width;
    public int height;

    public Gif(String url, List<String> tags, int width, int height){
        this.url = url;
        this.tags = tags;
        this.width = width;
        this.height = height;
    }

    public boolean doesTagExist(String tag){
        return tags.contains(tag);
    }

    public String getUrl(){
        return url;
    }

}
