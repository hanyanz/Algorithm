package com.yanzi.otherTests;

import java.util.HashSet;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class Customer {
	 String name;  
	    int age;  
	    int id;  
	  Books books; 
	    @XmlElement  
	    public String getName() {  
	        return name;  
	    }  
	    public void setName(String name) {  
	        this.name = name;  
	    }  
	      
	    @XmlElement  
	    public int getAge() {  
	        return age;  
	    }  
	    public void setAge(int age) {  
	        this.age = age;  
	    }  
	      
	    @XmlAttribute  
	    public int getId() {  
	        return id;  
	    }  
	    public void setId(int id) {  
	        this.id = id;  
	    }  
	    
	    @XmlElement 
	    public Books getBooks() {  
	        return books;  
	    }  
	    public void setBooks(Books books) {  
	        this.books = books;  
	    } 
	    
	    @XmlRootElement 
	    public static class Books{
	    	HashSet<Book> book;
	    	@XmlElement 
		    public HashSet<Book> getBook() {  
		        return book;  
		    }  
		    public void setBook(HashSet<Book> book) {  
		        this.book = book;  
		    } 	    	
	    	
	    	@XmlRootElement
	    	public static class Book{
			 String name;  
			    int price;  
			    String id;  
			  
			    @XmlElement   
			    public String getName() {  
			        return name;  
			    }  
			    public void setName(String name) {  
			        this.name = name;  
			    }  
			      
			    @XmlElement   
			    public int getPrice() {  
			        return price;  
			    }  
			    public void setPrice(int price) {  
			        this.price = price;  
			    }  
			      
			    @XmlElement   
			    public String getId() {  
			        return id;  
			    }  
			    public void setId(String id) {  
			        this.id = id;  
			    }  
		    }
	    }
	    
	    @Override  
	    public String toString() {  
	        return "Customer [id=" + id + ",name=" + name + ",age=" + age + "]";  
	    }
		
}
