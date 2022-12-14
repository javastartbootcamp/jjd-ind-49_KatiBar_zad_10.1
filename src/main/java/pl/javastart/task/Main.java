package pl.javastart.task;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Book[] books = new Book[3];
        System.out.println("Podaj informację o trzech unikalnych książkach");
        fillBooksArray(books);
        showBooksArray(books);
    }

    private static void showBooksArray(Book[] books) {
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    public static void fillBooksArray(Book[] books) {
        int count = 0;
        do {
            Book newBook = createAndGetBook();
            if (!checkIfAlreadyExist(books, count, newBook)) {
                count = insertBookAndReturnBooksCounter(books, count, newBook);
            }
        } while (count < 3);
    }

    private static boolean checkIfAlreadyExist(Book[] books, int count, Book newBook) {
        boolean ifDuplicate = false;
        for (int i = 0; i < count; i++) {
            if (newBook.equals(books[i])) {
                System.out.println("Duplikat");
                ifDuplicate = true;
                break;
            }
        }
        return ifDuplicate;
    }

    private static int insertBookAndReturnBooksCounter(Book[] books, int count, Book newBook) {
        books[count] = newBook;
        count++;
        return count;
    }

    private static Book createAndGetBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj tytuł");
        String title = scanner.nextLine();
        System.out.println("Podaj ilość stron");
        int pages = scanner.nextInt();
        scanner.nextLine();
        Book newBook = new Book(title, pages);
        return newBook;
    }
}
