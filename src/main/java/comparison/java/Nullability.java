package comparison.java;

import static comparison.java.DTO.Author;

public class Nullability {
    public static Author findAuthorByTitle(String title) {
        //...

        return new Author("J.K. Rowling", "Robert Galbraith");
    }

    public static void main(String[] args) {

        Author author = findAuthorByTitle("...");

        if (author != null) {
            System.out.println(author.getName());
        }

    }
}
