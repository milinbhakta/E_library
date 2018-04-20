

public class BookBean {
private String bookno,name,author,publisher;
private int quantity,issued;
public BookBean() {
	super();
	// TODO Auto-generated constructor stub
}
public BookBean(String bookno, String name, String author, String publisher, int quantity) {
	super();
	this.bookno = bookno;
	this.name = name;
	this.author = author;
	this.publisher = publisher;
	this.quantity = quantity;
}
public String getbookno() {
	return bookno;
}
public void setbookno(String bookno) {
	this.bookno = bookno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getIssued() {
	return issued;
}
public void setIssued(int issued) {
	this.issued = issued;
}

}
