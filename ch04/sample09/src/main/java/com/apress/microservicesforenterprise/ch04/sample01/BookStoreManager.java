package com.apress.microservicesforenterprise.ch04.sample01;

import com.apress.microservicesforenterprise.ch04.sample01.model.Author;
import com.apress.microservicesforenterprise.ch04.sample01.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BookStoreManager {

    Map<String, Book> booksMap = new HashMap<String, Book>();



    public BookStoreManager() {

        Book mfeBook = new Book();

        mfeBook.setId("777");
        mfeBook.setTitle("Microservices for Enterprise");
        mfeBook.setCategory("Software");


        mfeBook.addAuthor(new Author("100101", "Kasun Indrasiri", "San Jose, CA, USA"));
        mfeBook.addAuthor(new Author("100100", "Prabath Siriwardana", "San Jose, CA, USA"));
        booksMap.put(mfeBook.getTitle(), mfeBook);

        Book apiSecBook = new Book();
        apiSecBook.setId("778");
        apiSecBook.setTitle("Advanced API Security");
        apiSecBook.setCategory("Software");
        apiSecBook.addAuthor(new Author("100100", "Prabath Siriwardana", "San Jose, CA, USA") );

        booksMap.put(apiSecBook.getTitle(), apiSecBook);

        Book esbBook = new Book();
        esbBook.setId("779");
        esbBook.setTitle("Beginning WSO2 ESB");
        esbBook.setCategory("Software");
        esbBook.addAuthor(new Author("100101", "Kasun Indrasiri", "San Jose, CA, USA"));

        booksMap.put(esbBook.getTitle(), esbBook);
    }

    public Map<String, Book> getBooksMap() {
        return booksMap;
    }

}
