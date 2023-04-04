/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package homework229.lab08code;

/**
 *
 * @author nyarachoudhury
 */
class Node {
   public int data;
   public Node next;

   public Node(int data) {
      this.data = data;
      this.next = null;
   }
}

class LinkedList {
   private Node head;
   private Node tail;
    
   public LinkedList() {
      head = null;
      tail = null;
   }
    
   public void append(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else {
         tail.next = newNode;
         tail = newNode;
      }
   }
   
   public void prepend(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else {
         newNode.next = head;
         head = newNode;
      }
   }
   

   
   public void insertAfter(Node currentNode, Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else if (currentNode == tail) {
         tail.next = newNode;
         tail = newNode;
      }
      else {
         newNode.next = currentNode.next;
         currentNode.next = newNode;
      }
   }
   

   public void removeAfter(Node currentNode) {
      if (currentNode == null && head != null) {
         // Special case: remove head
         Node succeedingNode = head.next;
         head = succeedingNode;
         if (succeedingNode == null) {
             // Last item was removed
             tail = null;
         }
      }
      else if (currentNode.next != null) {
         Node succeedingNode = currentNode.next.next;
         currentNode.next = succeedingNode;
         if (succeedingNode == null) {
            // Remove tail
            tail = currentNode;
         }
      }
   }

    boolean Sum() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void movethreeprimes(LinkedList list2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
public class Lab08code {

    public static boolean isPrime (int n) {
           if(n <= 1) {       
            return false;
        }
           else {
            for(int i = 2; i < (n / 2); i++){
                if(n % i == 0){               
                    return false;
                }
    }
            return true; 
           }
    }

    /**
     *
     * @param n
     * @param l
     */
    public static void primesList (int n, LinkedList l) {
        for (int i = 0;i < n; i++) {
            if(isPrime(i)) {
                Node newNode = new Node(i);
                l.append(newNode);
            }
        }
    }
    private Node head;
    
    /**
     *
     * @param holderlist
     */
    public void movethreeprimes (LinkedList holderlist) {
        Node node = this.head; 
        while (node != null) {
            if (hasThree(node.data)) {
               Node newNode = new Node(node.data);
               holderlist.append(newNode);
            }
            node = node.next;
        }
    }
    public static boolean hasThree (int n) { 
        while (n > 0) {
            if (n % 10 == 3) {
                return true;
            }
            n /= 10;
        }
        return false;
    }
    public int Sum () {
        int sum = 0; 
        Node n = this.head; 
        while (n != null) {
            sum += n.data;
            n = n.next;
        }
        return sum; 
    }
    @Override
   public String toString(){
       String str = "";
       Node e = this.head;
       while(e != null){
           str += e.data + " ";
           e = e.next;
       }
       return str;
   }
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(); 
        LinkedList list2 = new LinkedList();
        primesList (100, list1); 
        list1.movethreeprimes(list2);
        System.out.print(list2.Sum());
    }
}
