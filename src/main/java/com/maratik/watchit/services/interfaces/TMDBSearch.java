package com.maratik.watchit.services.interfaces;

import com.maratik.watchit.data_classes.SearchPage;

public interface TMDBSearch {

    SearchPage search(String query);

    SearchPage search(String query, String mediaType);

    SearchPage search(String query, int page);

    SearchPage search(String query, String mediaType, int page);

}
