package def.threadexample;

import def.threadexample.components.Book;
import def.threadexample.components.Person;

import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        Stack<Book> list = new Stack<>();

        Book b1 = new Book("Learn Java");
        Book b2 = new Book("Learn Python");
        Book b3 = new Book("Learn C++");
        Book b4 = new Book("Learn GoLang");

        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);

        String par1 = "Learn Java";
        String par2 = "Learn GoLang";

        Runnable task1 = () -> {
            Person person1 = new Person("Roman");
            Stack<String> stack1 = person1.searchBooks(list,par1);
            System.out.println(person1.getName() + ":" + stack1);
        };

        Runnable task2 = () -> {
            Person person2 = new Person("Marina");
            Stack<String> stack2 = person2.searchBooks(list,par2);
            System.out.println(person2.getName() + ":" + stack2);
        };

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(task1);
        service.submit(task2);

    }
}

