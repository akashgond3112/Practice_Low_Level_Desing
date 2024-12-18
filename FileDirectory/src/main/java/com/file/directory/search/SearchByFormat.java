package com.file.directory.search;

import com.file.directory.Directory;
import com.file.directory.Entry;
import com.file.directory.File;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchByFormat implements SearchCriteria {

    @Override
    public SearchResponse search(SearchRequest searchRequest, List<Entry> entries) {
        SearchResponse searchResponse = new SearchResponse(new ArrayList<>());
        if(searchRequest.getFormat()==null)
            return searchResponse;
        search(searchRequest.getFormat(), entries, searchResponse);
        return searchResponse;
    }

    public void search(String format, List<Entry> entries, SearchResponse searchResponse) {
        for (Entry e : entries) {
            if (e instanceof Directory) {
                for (Entry en : ((Directory) e).getEntries()) {
                    if (en instanceof File) {
                        if (((File) en).getFormat().endsWith(format)) {
                            searchResponse.result().add(en);
                        }
                    } else {
                        search(format, Collections.singletonList(en), searchResponse);
                    }
                }
            } else {
                if (((File) e).getFormat().endsWith(format)) {
                    searchResponse.result().add(e);
                }
            }
        }
    }
}
