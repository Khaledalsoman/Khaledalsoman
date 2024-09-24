


public class LL {

    public static void main(String[] args) {
        LinkedList1 linkedList = new LinkedList1();
        linkedList.insertFirst(20);
        linkedList.insertLast(30);
        linkedList.insertFirst(10);
        linkedList.insertLast(40);
        linkedList.print();
        linkedList.size();
    }
}

class LinkedList1 {

    Node head;

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public LinkedList1() {
        head = null;
    }

    public void insert(Object data) {
        if (isEmpty()) {
            head = new Node(data);
        }
        
    } 
    public void insertFirst(Object data){
        Node node=new Node(data);
        node.next=head;
        head=node;
    }
    public void insertLast(Object data){
        Node node= new Node(data);
        if(isEmpty()){
            head=node;
        }
        else{
            Node helptr=head;
            while(helptr.next!=null){
                helptr=helptr.next;
            }
            helptr.next=node;
        }
    }
     void print(){
        Node helptr=head;
        while(helptr!=null){
            System.out.println(helptr.data);
            helptr=helptr.next;
        }



    }
    public void size(){
        int count=0;
        Node helptr=head;
        while(helptr!=null){
            count++;
            helptr=helptr.next;
        }
        System.out.println(count);

    }
}

////////////////////////////////////////////////
class Node {
    Node next;
    Object data;
    Node previous;

    public Node(Object data) {

        this.data = data;

    }
    
}
