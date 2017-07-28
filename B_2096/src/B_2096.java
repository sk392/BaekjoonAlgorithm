import java.util.Scanner;

public class B_2096 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner scan = new Scanner(System.in);
      CircularLinkedList list = new CircularLinkedList();
      
      int N = scan.nextInt();
      int M = scan.nextInt();
      
      
      Node a = new Node(10);
      
      
      for(int i=1;i<=N;i++){
         list.add(i);
      }
      
      
      Node temp = list.getFirstNode();
      Node removedNode;
      System.out.print("<");
      while(list.isEmpty()){
         
         for(int i=0;i<M-1;i++){
            temp.getNextNode();
         }
         removedNode = list.removeCurNode();
         System.out.print(removedNode.getData());
         if(!list.isEmpty())   System.out.print(", ");

      }
      System.out.print(">");

   }

}

class CircularLinkedList{
   
   Node curNode;
   Node firstNode;
   Node lastNode;
   int size;
   
   public CircularLinkedList(){
      curNode = null;
      firstNode = null;
      lastNode = null;
      size = 0;
   }
   
   public void add(int n){
      Node newNode = new Node(n);
      
      if(firstNode == null && curNode == null && lastNode == null){
         firstNode = newNode;
         curNode = newNode;
         lastNode = newNode;
      }else{
         lastNode.setNextNode(newNode);
         newNode.setPrevNode(lastNode);
         
         newNode.setNextNode(firstNode);
         firstNode.setPrevNode(newNode);
         
         lastNode = newNode;
      }
      
      size++;
      
   }
   
   public void add(Node n){

      if(firstNode == null && curNode == null && lastNode == null){
         firstNode = n;
         curNode = n;
         lastNode = n;
      }else{
         lastNode.setNextNode(n);
         n.setPrevNode(lastNode);
         
         n.setNextNode(firstNode);
         firstNode.setPrevNode(n);
         
         lastNode = n;
      }
      
      size++;
   }
   
   public Node removeCurNode(){
      
      Node temp = curNode;
      
      curNode.getPrevNode().setNextNode(curNode.getNextNode());
      curNode.getNextNode().setPrevNode(curNode.getPrevNode());
      
      curNode = curNode.getNextNode();
      
      size--;
      if(size == 0){
         curNode = null;
         firstNode = null;
         lastNode = null;
      }
      
      
      return temp;
   }
   
   public Node getCurNode(){
      return this.curNode;
   }
   public Node getFirstNode(){
      return this.firstNode;
   }
   public Node getLastNode(){
      return this.lastNode;
   }
   
   
   public int getCurNodeData(){
      return this.curNode.getData();
   }
   
   public boolean isEmpty(){
      if(size == 0){
         return true;
      }else{
         return false;
      }
   }
   
}

class Node{
   int data;
   Node prevNode;
   Node nextNode;
   
   public Node(){
      this.data = 0;
      prevNode = null;
      nextNode = null;
   }
   public Node(int n){
      this.data = n;
      prevNode = null;
      nextNode = null;
   }
   
   public int getData(){
      return this.data;
   }
   public void setData(int n){
      this.data = n;
   }
   
   public void setPrevNode(Node node){
      this.prevNode = node;
   }
   public void setNextNode(Node node){
      this.nextNode = node;
   }
   
   public Node getPrevNode(){
      return this.prevNode;
   }
   public Node getNextNode(){
      return this.nextNode;
   }
   
   
   
}