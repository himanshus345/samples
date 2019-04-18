package com.test.classes;

import javax.json.JsonArray;

public interface PersonDAO{
   JsonArray getRecords(String searchText, int limit, String sortType);
}