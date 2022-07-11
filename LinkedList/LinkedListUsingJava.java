package DataStructure.LinkedList;

import java.util.*;

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
    public int deleteFirst(){
        if(first==null)
            throw new NoSuchElementException();
        int temp = first.value;
        if(first==last){
            first=last=null;
            return temp;
        }
        Node second = first.next;
        first.next=null;
        first=second;
        size--;
        return temp;
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

    public void reversesecond(LinkedListUsingJava list, LinkedListUsingJava list2){
        int size=list.size;
        for(int i=0;i<size;i++){
            int temp = list.deleteFirst();
            list2.addFirst(temp);
        }
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

    public void reverseB(){
        reverseB(first);
    }

    private Node reverseB(Node first){
        Node pre = null;
        Node curr = first;
        Node next = null;
        while(curr!=null){
            next = curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        first=pre;
        return first;
    }

    public void reverseInGroupOfGivenSize(){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        reverseInGroupOfGivenSize(first, k);
    }

    private Node reverseInGroupOfGivenSize(Node first, int k){
        if(first==null){
            return null;
        }

        Node curr = first;
        Node pre = null;
        Node next = null;
        int count=0;
        while(curr != null && count < k){
            next = curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
            count++;
        }

        if(next != null){
            first.next = reverseInGroupOfGivenSize(next,k);
        }
        return pre;
    }

    public void detectLoop(){
        boolean ans = detectLoop(first);
    }

    private boolean detectLoop(Node first){
        Node temp = first;
        while(temp.next!=null){
            if(temp.value==0) return true;
            temp.value=0;
            temp=temp.next;
        }
        return false;
    }

    public void removeLoop(){
        removeLoop(first);
    }
    private void removeLoop(Node first){
        HashSet<Node> set = new HashSet<>();
        Node pre = null;
        Node curr = pre;
        while (curr!=null){
            if(set.contains(curr)){
                pre.next=null;
                return;
            }else{
                set.add(curr);
                pre=curr;
                curr=curr.next;
            }
        }

    }
    public void removeDuplicates(){
        removeDuplicates(first);

    }
    private void removeDuplicates(Node first){
        Node pre = first;
        Node curr = first.next;
        Node next = first.next;
        while(curr!=null){
            if(curr.value== pre.value){
                curr=curr.next;
                next=null;
                next=curr;
                if(curr==null){
                    pre.next=null;
                }
            }else{
                pre.next=curr;
                pre=curr;
                curr=curr.next;
                next=curr;
            }
        }
    }

    public void removeDuplicateUnSorted(){
        removeDuplicateUnSorted(first);
    }
    private void removeDuplicateUnSorted(Node head){
        HashSet<Integer> set = new HashSet<>();
        Node curr = head;
        Node temp=curr;
        Node next = curr.next;
        set.add(curr.value);
        while (next!=null){
            if(set.contains(next.value)){
                next=next.next;
                temp.next=null;
                curr.next=next;
                temp=curr;
                if(curr.next==null) break;
            }else{
                set.add(next.value);
                curr.next=next;
                curr=curr.next;
                temp=temp.next;
                next=curr.next;
            }
        }
    }

    public void moveLastToFirst(){
        Node head = moveLastToFirst(first);
    }
    private Node moveLastToFirst(Node head){
        Node curr = head;
        Node temp = head.next;
        while(temp.next!=null){
            temp=temp.next;
            curr=curr.next;
        }
        temp.next=head;
        curr.next=null;
        head=temp;
        return head;
    }

    public void add1ToNumber(){
        Node head = reverseB(first);
        Node temp=head;
        int carry=1;
        while(temp!=null){
            int num = temp.value;
            if(num==9 && carry==1){
                if(temp.next==null){
                    temp.value=10;
                    temp=temp.next;
                    break;
                }
                temp.value=0;
                carry=1;
                temp=temp.next;
            }else{
                num+=carry;
                temp.value=num;
                carry=0;
                break;
            }
        }
        reverseB(head);
    }

    public void palindrome(){
        boolean ans = palindrome(first);
        System.out.println(ans);
    }

    private boolean palindrome(Node head){
        Node temp = head;
        int count=1;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp=head;
        Node pre=null;
        for(int i=0;i<count/2;i++){
            // pre=temp;
            temp=temp.next;
        }
        if(count%2==0){
            pre = reverseB(temp);
        }else{
            pre = reverseB(temp.next);
        }
        temp=head;
        while(pre!=null){
            if(temp.value!=pre.value){
                return false;
            }
            temp=temp.next;
            pre=pre.next;
        }
        return true;
    }

    public Node deleteNode(Node head,int d)
    {
        //Add your code here.
        Node temp = head;
        Node pre = null;
        if(head.value==d){
            head=head.next;
            return head;
        }
        while (true){
            if(temp.value==d){
                pre.next=temp.next;
                break;
            }
            pre=temp;
            temp=temp.next;
        }
        return head;

    }
    public void deleteNode(){
        Scanner sc= new Scanner(System.in);
        int d=sc.nextInt();
        Node ans = deleteNode(first, d);
        reverseB(ans);
    }
//    public void addTwoNumbers(){
//        addTwoNumbers(first);
//    }
//
//    public



    public static void main(String[] args) {
        var LinkedList = new LinkedListUsingJava();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            LinkedList.addLast(sc.nextInt());
        }
        LinkedList.deleteNode();
//        LinkedList.palindrome();
//        LinkedList.addTwoNumbers();
//        LinkedList.add1ToNumber();
//        LinkedList.moveLastToFirst();
//        LinkedList.removeDuplicateUnSorted();
//        LinkedList.removeDuplicates();
//        LinkedList.removeLoop();
//        LinkedList.detectLoop();
//        LinkedList.reverseInGroupOfGivenSize();
//        LinkedList.reverseB();
//        LinkedList.deleteLast();
//        LinkedList.reverse();
//        int[] array = LinkedList.toArray();
//        System.out.println(Arrays.toString(array));
//        LinkedList.reverse();
//        array=LinkedList.toArray();
//        System.out.println(Arrays.toString(array));
//        LinkedList.findKthNode(2);
//        LinkedList.deleteLast();
//        LinkedList.deleteFirst();
//        System.out.println(LinkedList.contains(10));
//        System.out.println(LinkedList.indexOf(40));
//        LinkedList.reversesecond(LinkedList, List2);
    }
}

