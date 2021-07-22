package def.threadexample;

import def.threadexample.components.Book;
import def.threadexample.components.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        List<Book> list = new Stack<>();

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
            List<String> stack1 = person1.searchBooks(list,par1);
            System.out.println(person1.getName() + ":" + stack1);
        };

        Runnable task2 = () -> {
            Person person2 = new Person("Marina");
            List<String> stack2 = person2.searchBooks(list,par2);
            System.out.println(person2.getName() + ":" + stack2);
        };

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(task1);
        service.submit(task2);

        int[][] arr = new int[5][5];
        int row = 5;
        int column = 5;
        int[] flat = new int[row*column];
        int index = 0;

        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                arr[i][j] = (int) (Math.random() * 15);
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                flat[index++] = arr[i][j];
            }
        }

        for (int i = 0; i < flat.length; i++){
            for (int j = i; j < flat.length; j++){
                if (flat[i] > flat[j]){
                    int tmp = flat[j];
                    flat[j] = flat[i];
                    flat[i] = tmp;

                }
            }
        }

        index = 0;

        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                arr[i][j] = flat[index++];
            }
        }

        for(int i = 0; i < row; i++){
            for (int j = 0; j < column;j++){
                System.out.println(arr[i][j]);
            }
        }

    }

}

