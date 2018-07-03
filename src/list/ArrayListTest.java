package list;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest {

    public static void main(String[] args) {

        final Library library = new Library();

        final Book book1 = new Book("三国演义", 58, "aaa", 50);
        final Book book2 = new Book("水浒传", 55, "aaa", 42);
        final Book book3 = new Book("西游记", 60, "bbb", 20);
        final Book book4 = new Book("红楼梦", 50, "ccc", 17);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        final  Scanner sc = new Scanner(System.in);
        System.out.println("请输入书的出版社名称：");

        String bookPublisher = sc.next();
        library.findBooksByPublisher(bookPublisher);

    }
}

class Library {

    private ArrayList<Book> books = new ArrayList<>();

    /*public ArrayList<Book> getBooks(){
        return books;
    }*/
    /**
     * 向图书馆中添加一本书
     * @param book
     */
    public void addBook(Book book) {
        books.add(book);

    }

    /**
     * 根据书名查找书的基本信息
     * @param bookName
     */
    public void findBookByName(String bookName) {
        for (final Book book : books) {
            if (book.getName().equals(bookName)) {
                System.out.println("出版社: " + book.getPublisher()
                        + "\t价格: " + book.getPrice()
                        + "\t数量: " + book.getNum());
                break;
            }
        }
    }

    /**
     * 根据出版社查找该出版社所有的书
     * @param publisher
     */
    public void findBooksByPublisher(String publisher) {
        for (final Book book : books) {
            if (book.getPublisher().equals(publisher)) {
                System.out.println("书名: " + book.getName()
                        + "\t价格: " + book.getPrice()
                        + "\t数量: " + book.getNum());
            }
        }
    }
}

class Book {

    private String name;

    private Integer price;

    private String publisher;

    private int num;

    Book(String name, Integer price, String publisher, int num) {
        this.name = name;
        this.price = price;
        this.publisher = publisher;
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}