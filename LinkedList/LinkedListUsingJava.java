package DataStructure.LinkedList;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedListUsingJava {
    private Node first;
    private Node last;
    private int size;
    class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }
    public void addLast(int value){
        var node = new Node(value);
        if (first == null)
            first=last=node;
        else {
            last.next = node;
            last=node;
        }
        size++;
    }
    public void addFirst(int value){
        var node = new Node(value);
        if(first == null)
            first=last=node;
        else {
            node.next=first;
            first=node;
        }
        size++;
    }
    public void deleteFirst(){
        if(first==null)
            throw new NoSuchElementException();
        if(first==last){
            first=last=null;
            return;
        }
        Node second = first.next;
        first.next=null;
        first=second;
        size--;
    }
    public void deleteLast(){

        var previous = getPrevious(last);
        last=previous;
        last.next=null;

    }
    public Node getPrevious(Node node){
        Node current = first;
        while (node!=null){
            if(current.next==node) return current;
            current =current.next;
        }
        size--;
        return null;
    }
    public boolean contains(int value){
        if(first==null)
            throw new NoSuchElementException();
        int val = method(value);
        if(val!=-1)
            return true;
        return false;
    }
    public int indexOf(int value){
        if(first==null)
            throw new NoSuchElementException();
        int val = method(value);
        return val;
    }

    public int method(int value){
        int index=0;
        Node node = first;
        while(node.value!=value){
            if(node.next==null)
                break;
            else {
                node = node.next;
                index++;
            }
        }
        if(node.value==value)
            return index;
        return -1;
    }

    public void reverse(){
        Node reverseFirst=null;
        Node reverseLast=null;
        while (last!=null){
            Node tempLast = last;
            if(last==first){
                var node = new Node(tempLast.value);
                if(reverseFirst == null)
                    reverseFirst=reverseLast=node;
                else {
                    reverseLast.next=node;
                    reverseLast=node;
                    last=first=null;
                }
            }else{
                var previous = getPrevious(last);
                last=previous;
                last.next=null;
                var node = new Node(tempLast.value);
                if(reverseFirst == null)
                    reverseFirst=reverseLast=node;
                else {
                    reverseLast.next=node;
                    reverseLast=node;
                }
            }
        }
        first=reverseFirst;
        last=reverseLast;

    }
    public int [] toArray(){
        int [] array = new int[size];
        Node current = first;
        int index=0;
        while (current!=null){
            array[index++] = current.value;
            current=current.next;
        }
        return array;
    }

    public void findKthNode(int k){
        Node pointer1 = first;
        Node pointer2 = first;
        int j =1;
        while (j<= k-1){
            pointer2=pointer2.next;
            j++;
        }
        while (pointer2!=last){
            pointer1=pointer1.next;
            pointer2=pointer2.next;
        }
        System.out.println(pointer1.value);
    }

    public static void main(String[] args) {
        var LinkedList = new LinkedListUsingJava();
//        LinkedList.addLast(10);
//        LinkedList.addLast(20);
        LinkedList.addLast(30);
        LinkedList.addLast(40);
        LinkedList.addLast(50);
        LinkedList.addLast(60);
//        LinkedList.deleteLast();
        LinkedList.reverse();
        int[] array = LinkedList.toArray();
        System.out.println(Arrays.toString(array));
        LinkedList.reverse();
        array=LinkedList.toArray();
        System.out.println(Arrays.toString(array));
//        LinkedList.deleteLast();
//        LinkedList.deleteFirst();
//        System.out.println(LinkedList.contains(10));
//        System.out.println(LinkedList.indexOf(40));
    }
}

