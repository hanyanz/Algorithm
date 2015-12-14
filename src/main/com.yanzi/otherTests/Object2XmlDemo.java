package com.yanzi.otherTests;

import java.io.File;
import java.util.HashSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Object2XmlDemo {
	 public static void main(String[] args) {  
		  
	        Customer customer = new Customer();  
	        customer.setId(100);  
	        customer.setName("suo");  
	        customer.setAge(29);  
	          
	        Customer.Books.Book book = new Customer.Books.Book();  
	        book.setId("1");  
	        book.setName("นþตร");  
	        book.setPrice(100);  
	          
	        Customer.Books.Book book2 = new Customer.Books.Book();  
	        book2.setId("2");  
	        book2.setName("เล฿ท");  
	        book2.setPrice(50);  
	          
	        HashSet<Customer.Books.Book> bookSet = new HashSet<Customer.Books.Book>();  
	        bookSet.add(book);  
	        bookSet.add(book2);  
	        
	        Customer.Books books = new  Customer.Books();
	        books.setBook(bookSet);
	        customer.setBooks(books);  
	          
	        try {  
	            File file = new File("D:\\file1.xml");  
	            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);  
	            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();  
	            // output pretty printed  
	            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK");
	            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
	            jaxbMarshaller.marshal(customer, file); 
	            jaxbMarshaller.marshal(customer, System.out);  
	        } catch (JAXBException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	 
}
