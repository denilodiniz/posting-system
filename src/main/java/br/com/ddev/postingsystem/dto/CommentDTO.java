package br.com.ddev.postingsystem.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class CommentDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private LocalDate date;
	private String text;
	private AuthorDTO author;

	public CommentDTO() {
	}

	public CommentDTO(AuthorDTO author, LocalDate date, String text) {
		this.author = author;
		this.date = date;
		this.text = text;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
