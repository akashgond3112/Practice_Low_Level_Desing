package com.file.directory.search;

import com.file.directory.Entry;

import java.util.List;

public record SearchResponse(List<Entry> result) {


    @Override
    public String toString() {
        return "SearchResponse{" + "result=" + result + '}';
    }
}
