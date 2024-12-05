package com.file.directory.search;


import com.file.directory.Entry;

import java.util.List;

public class ApplySearchFilter implements SearchCriteria {

    private final SearchByFileName searchByFileName;
    private final SearchByFormat searchByFormat;
    private final SearchBySize searchBySize;

    public ApplySearchFilter() {
        searchByFileName = new SearchByFileName();
        searchByFormat = new SearchByFormat();
        searchBySize = new SearchBySize();
    }

    @Override
    public SearchResponse search(SearchRequest searchRequest, List<Entry> entries) {
        SearchResponse searchResponse = searchByFileName.search(searchRequest, entries);
        searchResponse = searchBySize.search(searchRequest, searchResponse != null ? searchResponse.result() : entries);
        searchResponse = searchByFormat.search(searchRequest, searchResponse != null ? searchResponse.result() : entries);
        return searchResponse;
    }
}
