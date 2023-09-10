/*
 * 2.Implement the class MovieDAO (DAO - Data Access Object). It should perform basic database 
 * operations for the MOVIES table, the structure of which is described in task 1. Assume that an
 *  object representing an open database connection comes in the constructor of this class. Remember
 *   to use PreparedStatement where possible and close objects (use try-with-resources). Also 
 *   implement a Movie class that represents a single row in the MOVIES table that you will use in 
 *   implementing the MovieDAO class.
Implement the following operations. Each of them should be represented by a separate public method:
•	adding a record 
•	delete record by identifier
•	update of the movie title with id data
•	searching for a movie by ID
•	to display all the records

 */

// Movie class  to represent single row

package com.jdbc.demo;

public class Movie {
	private int id;
	private String title;
	private String genre;
	private int yearOfRelease;

	public Movie(int id, String title, String genre, int yearOfRelease) {
		super();
		this.setId(id);
		this.setTitle(title);
		this.setGenre(genre);
		this.setYearOfRelease(yearOfRelease);
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String title, String genre, int yearOfRelease) {
		super();
		this.setTitle(title);
		this.setGenre(genre);
		this.setYearOfRelease(yearOfRelease);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", genre=" + genre + ", yearOfRelease=" + yearOfRelease + "]";
	}

}
