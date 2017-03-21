package ua.lib.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.lib.dao.BookDao;
import ua.lib.entity.Book;

@Repository
public class BookDaoImpl implements BookDao {
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Transactional
	@Override
	public void save(Book book) {
		manager.persist(book);

	}

	@Transactional
	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return manager.createQuery("select b from Book b ORDER BY name").getResultList();
	}

	@Transactional
	@Override
	public Book findOne(int id) {
		// TODO Auto-generated method stub
		return manager.find(Book.class, id);
	}

	@Transactional
	@Override
	public void delete(int id) {
		manager.remove(findOne(id));
	}

	@Transactional
	@Override
	public void deleteByName(String name) {
		manager.remove(findByName(name));

	}

	@Transactional
	@Override
	public List<Book> findByName(String name) {
		List<Book> bookList = manager
				.createQuery("select b  from Book b where b.name =:param")
				.setParameter("param", name).getResultList();
		return bookList;

	}

	@Transactional
	@Override
	public void deleteBook(Book book) {
		manager.remove(book);
		

	}
	@Transactional
	@Override
	public void update(Book book) {
		manager.merge(book);
		
	}

}
