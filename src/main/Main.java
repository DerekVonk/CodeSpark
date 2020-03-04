package main;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static main.SinglyLinkedList.hasCycle;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("src/resources/hasCycle_testcase.txt"));

//        System.out.println("Reading number of tests:");
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
//            System.out.println("Reading number of index:");
            int index = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            SinglyLinkedList llist = new SinglyLinkedList();

//            System.out.println("Reading linkedList count/size:");
            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
//                System.out.println("Reading data for listItem '" + i + "'");
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            SinglyLinkedListNode extra = new SinglyLinkedListNode(-1);
            SinglyLinkedListNode temp = llist.head;

            for (int i = 0; i < llistCount; i++) {
                if (i == index) {
                    extra = temp;
                }

                if (i != llistCount - 1) {
                    temp = temp.next;
                }
            }

            temp.next = extra;

            boolean result = hasCycle(llist.head);

            System.out.println((result ? 1 : 0));
        }

        scanner.close();
    }
}