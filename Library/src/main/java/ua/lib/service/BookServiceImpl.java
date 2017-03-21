package ua.lib.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lib.dao.BookDao;
import ua.lib.entity.Book;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao dao;

	@Override
	public Book findOne(int id) {

		return dao.findOne(id);
	}

	@Override
	public List<Book> findAll() {

		return dao.findAll();
	}

	@Override
	public void save(Book book) {
		dao.save(book);

	}

	@Override
	public void delete(int id) {
		dao.delete(id);

	}

	@Override
	public void deleteByName(String name) {
		Scanner sc = new Scanner(System.in);
		List<Book> bookList = dao.findByName(name);
		if (bookList.size() > 1) {
			int i = 1;
			for (Book book : bookList) {
				System.out.print(book);
				System.out.println(i);
				i++;
			}
			int a = sc.nextInt();

			dao.delete(bookList.get(a - 1).getId());

		} else {
			dao.delete(bookList.get(0).getId());
		}

	}

	@Override
	public List<Book> findByName(String name) {
		
		return dao.findByName(name);
	}

	@Override
	public void update(Book book) {
	dao.update(book);
		
	}

}
