package ua.lib.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.lib.entity.Book;

@Service
public interface BookService {
	void save(Book book);
	void deleteByName(String name);
	Book findOne(int id);
	List<Book> findByName(String name);
	void update(Book book);
	List<Book> findAll();



	void delete(int id);


}
