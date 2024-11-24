package com.github.overz.camel.modules.books.constants;

public interface Routes {
  String CONTEXT_BOOK = "context-book-property";
  String ROUTE_CREATE_BOOK = "direct:create-book";
  String ROUTE_UPDATE_BOOK = "direct:update-book";
  String ROUTE_DELETE_BOOK = "direct:delete-book";
  String ROUTE_LIST_BOOK = "direct:list-book";
}
