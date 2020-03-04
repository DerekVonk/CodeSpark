package main;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SinglyLinkedList {
    SinglyLinkedListNode head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void insertNode(int llistItem) {
        /* 1 & 2: Allocate the Node &
              Put in the data*/
        SinglyLinkedListNode new_node = new SinglyLinkedListNode(llistItem);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedList linkedList, int data) {
        if (linkedList.head == null) {
            return new SinglyLinkedListNode(data);
        }
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        newNode.next = linkedList.head;
        return newNode;
    }

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        if (Objects.isNull(head)){
            return new SinglyLinkedListNode(data);
        }

        SinglyLinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new SinglyLinkedListNode(data);
        return head;
    }

    public void reversePrint(SinglyLinkedListNode head) {
        if (head == null) {
            return;
        }

        reversePrint(head.next);
        System.out.println(head.data);
    }

    public void printList() {
        SinglyLinkedListNode node = this.head;
        while (node != null) {
            System.out.println(node.data + " ");
            node = node.next;
        }
    }

    static boolean hasCycle(SinglyLinkedListNode head) {
        if (head.next == null) {
            return false;
        }

        Set<SinglyLinkedListNode> nodeSet = new HashSet<>();
        while (head.next != null) {
            if (!nodeSet.add(head)){
                return true;
            }
            head = head.next;
        }

        return false;
    }

}
