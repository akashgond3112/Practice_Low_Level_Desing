package com.file.directory.search;

import com.file.directory.Directory;
import com.file.directory.Entry;
import com.file.directory.File;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchBySize implements SearchCriteria {

    @Override
    public SearchResponse search(SearchRequest searchRequest, List<Entry> entries) {
        SearchResponse searchResponse = new SearchResponse(new ArrayList<>());
        if(searchRequest.getMinSize()==null)
            return searchResponse;

        search(searchRequest.getMinSize(), entries, searchResponse);
        return searchResponse;
    }

    public void search(Double minSize, List<Entry> entries, SearchResponse searchResponse) {

        for (Entry e : entries) {
            if (e instanceof Directory) {
                for (Entry en : ((Directory) e).getEntries()) {
                    if (en instanceof File) {
                        if (en.getSize() >= minSize) {
                            searchResponse.result().add(en);
                        }
                    } else {
                        search(minSize, Collections.singletonList(en), searchResponse);
                    }
                }
            } else {
                if (e.getSize()>=minSize) {
                    searchResponse.result().add(e);
                }
            }
        }
    }
}
