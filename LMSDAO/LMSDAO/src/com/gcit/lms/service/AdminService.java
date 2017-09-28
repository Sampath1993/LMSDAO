package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.dao.BookLoansDAO;
import com.gcit.lms.dao.BorrowerDAO;
import com.gcit.lms.dao.GenreDAO;
import com.gcit.lms.dao.Library_BranchDAO;
import com.gcit.lms.dao.PublisherDAO;
import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookLoans;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.entity.Genre;
import com.gcit.lms.entity.Library_Branch;
import com.gcit.lms.entity.Publisher;

public class AdminService {
	
	public Utilities util = new Utilities();
	
	public void saveAuthor(Author author) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			if(author.getAuthorId()!=null){
				adao.updateAuthor(author);
			}else{
				adao.saveAuthor(author);
			}
			conn.commit();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public void deleteAuthor(Author author) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			adao.deleteAuthor(author);
			conn.commit();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public List<Author> readAuthors(String searchString) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			return adao.readAuthors(searchString);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		
		return null;
	}

	public void saveBook(Book book) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookDAO bdao = new BookDAO(conn);
			if(book.getBookId()!=null){
				bdao.updateBook(book);;
			}else{
				bdao.saveBook(book);;
			}
			conn.commit();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public void deleteBook(Book book) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookDAO bdao = new BookDAO(conn);
			bdao.deleteBook(book);
			conn.commit();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public List<Book> readBooks(String searchString) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookDAO bdao = new BookDAO(conn);
			return bdao.readBooksByTitle(searchString);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		
		return null;
	}
	
	public void saveLibraryBranch(Library_Branch libraryBranch) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			Library_BranchDAO ldao = new Library_BranchDAO(conn);
			if(libraryBranch.getBranchId() != null){
				ldao.updateBranch(libraryBranch);
			}else{
				ldao.saveLibraryBranch(libraryBranch);
			}
			conn.commit();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public void deleteLibraryBranch(Library_Branch libraryBranch) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			Library_BranchDAO ldao = new Library_BranchDAO(conn);
			ldao.deleteLibraryBranch(libraryBranch);
			conn.commit();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public List<Library_Branch> readLibraryBranch(String searchString) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			Library_BranchDAO ldao = new Library_BranchDAO(conn);
			return ldao.readBranch(searchString);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}

	public void savePublisher(Publisher publisher) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			PublisherDAO pdao = new PublisherDAO(conn);
			if(publisher.getPublisherId() != null){
				pdao.updatePublisher(publisher);
			}else{
				pdao.savePublisher(publisher);
			}
			conn.commit();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public void deletePublisher(Publisher publisher) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			PublisherDAO pdao = new PublisherDAO(conn);
			pdao.deletePublisher(publisher);
			conn.commit();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public List<Publisher> readPublisher(String searchString) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			PublisherDAO pdao = new PublisherDAO(conn);
			return pdao.readPublishers(searchString);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public void saveGenre(Genre genre) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			GenreDAO ldao = new GenreDAO(conn);
			if(genre.getGenreId() != null){
				ldao.updateGenre(genre);
			}else{
				ldao.saveGenre(genre);
			}
			conn.commit();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public void deleteGenre(Genre genre) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			GenreDAO gdao = new GenreDAO(conn);
			gdao.deleteGenre(genre);
			conn.commit();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public List<Genre> readGenre(String searchString) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			GenreDAO gdao = new GenreDAO(conn);
			return gdao.readGenres(searchString);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public void saveBorrower(Borrower borrower) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			BorrowerDAO bdao = new BorrowerDAO(conn);
			if(borrower.getCardNo() != null){
				bdao.updateBorrower(borrower);
			}else{
				bdao.saveBorrower(borrower);
			}
			conn.commit();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public void deleteBorrower(Borrower borrower) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			BorrowerDAO bdao = new BorrowerDAO(conn);
			bdao.deleteBorrower(borrower);
			conn.commit();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public List<Borrower> readBorrower(String searchString) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			BorrowerDAO gdao = new BorrowerDAO(conn);
			return gdao.readBorrowers(searchString);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	public void saveBookLoans(BookLoans bookLoans) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookLoansDAO bdao = new BookLoansDAO(conn);
			if(bookLoans.getDateIn() != null) {
				bdao.saveBookLoanComplete(bookLoans);
			}else {
				bdao.saveBookLoan(bookLoans);
			}
			conn.commit();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public void deleteBookLoans(BookLoans bookLoans) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookLoansDAO bdao = new BookLoansDAO(conn);
			bdao.deleteBookLoan(bookLoans);
			conn.commit();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public void overrideBookLoanDueDate(BookLoans bookLoans) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookLoansDAO bdao = new BookLoansDAO(conn);
			bdao.overrideDueDate(bookLoans);
			conn.commit();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public void updateBookLoanDueDate(BookLoans bookLoans) throws SQLException{
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookLoansDAO bdao = new BookLoansDAO(conn);
			bdao.updateBookLoanDueDate(bookLoans);
			conn.commit();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
	}
	
}
