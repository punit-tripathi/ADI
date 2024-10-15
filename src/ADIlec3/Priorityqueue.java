package ADIlec3;

public class Priorityqueue {
    public static void main(String[] args) {

    }
}
class Node{
    int data;
    int priority;
    Node next;

    Node(int data,int priority){
        this.data=data;
        this.priority=priority;
        this.next=null;
    }
}

class Priorityque{
    Node head;
     Priorityque(){
         head=null;
     }
     void enque(int data,int priority){
         Node newNode=new Node(data,priority);

         if(head == null || head.priority > newNode.priority){
             newNode.next=head;
             head=newNode;
         }
         else{
             Node temp=head;
             Node prev=null;

             while(temp != null && temp.priority < newNode.priority){
                 prev=temp;
                 temp=temp.next;
             }
             prev.next=newNode;
             newNode=temp;
         }

     }
    int deque(){
        int res= head.data;
        head=head.next;
        return res;
    }

    int peek(){
         return head.data;
    }
}
