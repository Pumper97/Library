package ua.lib.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ua.lib.entity.Book;

@Repository
public interface BookDao {
	void save(Book book);

	List<Book> findAll();

	Book findOne(int id);

	void delete(int id);

	void deleteByName(String name);
	List<Book> findByName(String name);
	public void deleteBook(Book book);
	public void update(Book book);
}
