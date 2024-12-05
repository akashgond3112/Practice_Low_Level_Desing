package com.file.directory.search;

import com.file.directory.Entry;

import java.util.List;

public interface SearchCriteria {
    public SearchResponse search(SearchRequest searchRequest, List<Entry> directory);
}
