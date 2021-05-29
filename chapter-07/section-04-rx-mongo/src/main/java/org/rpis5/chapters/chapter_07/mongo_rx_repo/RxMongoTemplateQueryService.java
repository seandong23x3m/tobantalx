/**
 * Copyright (C) Zoomdata, Inc. 2012-2018. All rights reserved.
 */
package org.rpis5.chapters.chapter_07.mongo_rx_repo;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class RxMongoTemplateQueryService {
   private static final String BOOK_COLLECTION = "book";

   private final ReactiveMongoTemplate mongoTemplate;

   public Flux<Book> findBooksByTitle(String title) {
      Query query = Query.query(new Criteria("title")
         .regex(".*" + title + ".*"));
      return mongoTemplate.find(query, Book.class, BOOK_COLLECTION);
   }
}
