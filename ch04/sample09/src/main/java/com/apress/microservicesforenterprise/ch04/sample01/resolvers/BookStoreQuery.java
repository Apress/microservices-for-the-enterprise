package com.apress.microservicesforenterprise.ch04.sample01.resolvers;

import com.apress.microservicesforenterprise.ch04.sample01.BookStoreManager;
import com.apress.microservicesforenterprise.ch04.sample01.model.Author;
import com.apress.microservicesforenterprise.ch04.sample01.model.Book;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
public class BookStoreQuery implements GraphQLQueryResolver {

    BookStoreManager bookStoreManager;

    public BookStoreQuery() {
       bookStoreManager = new BookStoreManager();
    }

    public List<Book> books() {
        return new ArrayList<>(bookStoreManager.getBooksMap().values());
    }


    public List<Author> findAuthor(String bookName) {
        Map<String, Book> booksMap = bookStoreManager.getBooksMap();
        Book b = booksMap.get(bookName);
        if (b != null) {
            return b.getAuthors();
        }
        return null;
    }
}
