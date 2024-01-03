import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;

import com.kodilla.stream.forumUser.Forum;
import com.kodilla.stream.forumUser.ForumUsers;
import com.kodilla.stream.immutable.ForumUser;
import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()  // [1]
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n", "<<", ">>"));                    // [2]

        System.out.println(theResultStringOfBooks);

// 7.1 Zadanie - Upiększacz tekstów =======================================================================================================================
        System.out.println("Zadanie 7.1");

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        String textToBeautify = "Mateusz Chojnacki";

        poemBeautifier.beautify(textToBeautify, String::toUpperCase);
        poemBeautifier.beautify(textToBeautify, String::toLowerCase);
        poemBeautifier.beautify(textToBeautify, s -> "ABC " + s + " ABC");
        poemBeautifier.beautify(textToBeautify, s -> s.replaceAll("Chojnacki", "Ch"));
// 7.3 Zadanie -

        Forum forum = new Forum();

        // Dodajemy użytkowników do forum
        forum.addUser(new ForumUsers(1, "User1", 'M', LocalDate.of(2000, 5, 15), 5));
        forum.addUser(new ForumUsers(2, "User2", 'F', LocalDate.of(1995, 3, 20), 0));
        // Dodaj więcej użytkowników

        // Strumień operacji na użytkownikach forum
        Map<Integer, ForumUsers> filteredUsers = forum.getUserList().stream()
                .filter(user -> user.getGender() == 'M')
                .filter(user -> user.getBirthDate().plusYears(20).isBefore(LocalDate.now()))
                .filter(user -> user.getPosts() >= 1)
                .collect(Collectors.toMap(ForumUsers::getUserId, user -> user));

        // Wyświetlanie otrzymanej mapy wynikowej
        filteredUsers.forEach((id, user) -> System.out.println("ID: " + id + ", User: " + user));
    }
}













