package ua.lib.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.lib.entity.Book;
import ua.lib.service.BookService;
import ua.lib.service.BookServiceImpl;

public class Menu {
	ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
			"/META-INF/appContext.xml");
	BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	private BookService service = context.getBean(BookServiceImpl.class);
	Scanner scan = new Scanner(System.in);

	public void menu() throws IOException {
		while (true) {
			System.out.println("Enter 1 to add book");
			System.out.println("Enter 2 to remove book");
			System.out.println("Enter 3 to edit book");
			System.out.println("Enter 4 to view all books");
			switch (sc.readLine()) {
			case "1":
				System.out.println("Enter book name");

				String name = sc.readLine();
				System.out.println("Enter author name");
				String author = sc.readLine();
				Book book = new Book(name, author);
				service.save(book);
				System.out.println(book + " was added");
				break;
			case "2":
				System.out.println("Enter book name");
				service.deleteByName(sc.readLine());
				break;
			case "3":
				System.out.println("Enter book name");
				List<Book> books = service.findByName(sc.readLine());
				int i = 1;
				for (Book book1 : books) {
					System.out.print(book1);
					System.out.println(i);
					i++;
				}
				if (books.size() > 1) {
					int a = scan.nextInt();
                    
					System.out.println("Enter new book name");
                    Book bookk = service.findOne(books.get(a-1).getId());
                    
                    bookk.setName(sc.readLine());
                    System.out.println(bookk);
					service.update(bookk);
				} else {
					Book oneBook = service.findOne(books.get(0).getId());
					System.out.println("Enter new book name");
					oneBook.setName(sc.readLine());
					service.update(oneBook);
				}

				break;
			case "4":
				List<Book> bookList = service.findAll();

				for (Book book2 : bookList) {
					System.out.println(book2);
				}
				break;

			}
		}

	}
}
