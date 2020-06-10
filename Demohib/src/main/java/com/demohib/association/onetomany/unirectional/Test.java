package com.demohib.association.onetomany.unirectional;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Test {
	
	private static SessionFactory sf;
	static {
		Configuration conf = new Configuration()
				.addAnnotatedClass(Book.class)
				.addAnnotatedClass(Author.class)
				.configure();
		sf = conf.buildSessionFactory();
	}
	@Entity @Table(name = "tbl_book")
	@Data @NoArgsConstructor @AllArgsConstructor
	static class Book {
		@Id
		private int id;
		private String name;
		@OneToMany
		@JoinColumn(name = "fk_book")
		private List<Author> authors;
	}
	

	@Entity @Table(name = "tbl_author")
	@Data @NoArgsConstructor @AllArgsConstructor
	static class Author {
		@Id
		private int id;
		private String name;
	}
	
	
	
	public static void main(String[] args) {
		Author a1 = new Author(1, "Jao"),
				a2 = new Author(2, "Jao"),
				a3 = new Author(3, "Jao"),
				a4 = new Author(4, "Jao");
		Book b1 = new Book(1, "bookaa", Arrays.asList(a1, a2, a3)),
				b2 = new Book(2, "bookaa", Arrays.asList(a4, a1));
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.save(a1);
		session.save(a2);
		session.save(a3);
		session.save(a4);
		session.save(b1);
		session.save(b2);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	
}
