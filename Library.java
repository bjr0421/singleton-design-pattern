/**
 * Library, a Object
 * @author Brooks Robinson
 */
import java.util.HashMap;

public class Library {
    private HashMap<String,Integer> books = new HashMap<String,Integer>();
    private static Library library;

    /**
     * Constructor for Library Object
     */
    private Library() {}

    /**
     * Creates an instance of a Library
     * @return new instance of Library
     */
    public static Library getInstance() {
        if (library == null) {
            System.out.println("Creating our library. Time to begin reading");
            library = new Library();
        }
        return library;
    }

    /**
     * Allows a book to be checked out from the library
     * @param bookName name of the book being checked out
     */
    public void checkoutBook(String bookName) {
        if (books.containsKey(bookName) && books.get(bookName) > 0) {
            books.put(bookName, books.remove(bookName)-1);
            System.out.println(bookName + " was successfully checked out");
        } else {
            System.out.println("Sorry, " + bookName + " is not in stock");
        }
    }

    /**
     * Allows some book(s) to be checked into the library
     * @param bookName name of the book being checked in
     * @param numToAdd amount of books being checked in
     */
    public void checkInBook(String bookName, int numToAdd) {
        if (books.containsKey(bookName)) {
            books.put(bookName, books.remove(bookName)+numToAdd);
            System.out.println("A new copy of " + bookName + " was added to the library");
        } else {
            books.put(bookName, numToAdd);
            System.out.println(bookName + " was added to the library");
        }
        //System.out.println("A new copy of " + bookName + " was added to the library");
    }

    /**
     * Prints all of the books in the library and the number of copies available
     */
    public void displayBooks() {
        System.out.println("\nInventory:");
        for (String i : books.keySet()) {
            System.out.println("  - " + i + ", copies: " + books.get(i));
        }
    }
}
