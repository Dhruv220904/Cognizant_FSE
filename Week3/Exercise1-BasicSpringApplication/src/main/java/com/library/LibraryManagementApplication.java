package com.library;
import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class LibraryManagementApplication{
 public static void main(String[] args){
  ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
  BookService service=(BookService)context.getBean("bookService");
  BookRepository repo=(BookRepository)context.getBean("bookRepository");
  service.displayService();
  repo.displayRepository();
 }
}