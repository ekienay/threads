package def.threadexample.components;

import java.util.Stack;

public class Person{

    private String name;

    public Person(){

    }

    public String getName() {
        return name;
    }

    public Person(String name){
        this.name = name;
    }


    public Stack<String> searchBooks(Stack<Book> bookHeap, String searchParm){
        Stack<String> box = new Stack<>();
        for (Book book : bookHeap){
            if (book.getBookName().equals(searchParm)){
                box.add(book.getBookName());
            }
        }
        return box;
    }
}
