//bipartial
//cycle detection
//directed
//reverse a graph // opp adjacency list //in dorected
//external sort
//topological sort
//strongly connected componentes
//graph is a binary tree
//shortest path
//hashing  - linear probing and double hashing and chaining
//chain hashing
//collections.sort
//volleyball que pascals triangle

import java.util.*;
class Bag implements Iterable<Integer> {
    Node first, last;
    int size;

    Bag() {
        size = 0;
    }


  class Node {
      int val;
       Node next;

      Node(int item) {
          this.val = item;
          this.next = null;
      }
  }
    public void enqueue(int n) {
        Node curr = last;
        last = new Node(n);

        if(size == 0) {
            first = last;
        }
        else {
            curr.next = last;
        }
        size++;
    }



    public Iterator<Integer> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Integer> {

        Node curr = first;

        public boolean hasNext() {
            return curr != null;
        }


        public Integer next() {
            Integer temp = curr.val;
            curr = curr.next;
            return temp;
        }


        public void remove() {
            //do nothing.
        }
    }

}

class Graph{


  Bag[] ver ;
  int size;
  boolean[] visited;
  boolean[] marked;
   Graph(int x){
     visited = new boolean[x];
     marked = new boolean[x];
     size = x;
    ver = new Bag[x];
    for(int i=0; i < x; i++){
      ver[i] = new Bag();
    }
  }

  void createEdge(int x,int y){
    ver[x].enqueue(y);
    ver[y].enqueue(x);
  }


  void DFS(int x){
    visited[x] = true;
    System.out.println(x);
    Iterator ite = ver[x].iterator();
    while(ite.hasNext()){
      int    next = (int)ite.next();
      if(!visited[next]){
        DFS(next);
      }
    }
  }

  void BFS(int x){
    if(!visited[x]){

      visited[x] = true;
      if(!marked[x]){
        System.out.println(x);
        marked[x]=true;
      }
    }
    Iterator it = ver[x].iterator();
      while(it.hasNext()){
          int  next = (int)it.next();
          if(!marked[next]){
            System.out.println(next);
            marked[next] = true;
          }
      }

      Iterator ite = ver[x].iterator();
    while(ite.hasNext()){
      int    next = (int)ite.next();
      if(!visited[next]){
        BFS(next);
      }
    }
  }


  public static void main(String args[]){

    Graph gr = new Graph(7);
    gr.createEdge(1,2);
    gr.createEdge(2,5);
    gr.createEdge(1,5);
    gr.createEdge(1,3);
    gr.createEdge(2,4);
    //gr.BFS(1);
    Connected is = new Connected(gr);

  }

}


class Connected{

  boolean[]  visited;
  int[] islandNo;
  Graph gr;
  boolean occupied;
  int size;
  Connected(Graph fr){
    size = gr.size;
    visited = new boolean[size];
    gr=fr;
    occupied = false;
  }

  void connected(int x){
    int j=0;
    for(int i=0; i<size ; i++){
       if(visited[i] == false){
           DFS(i,++j);
         }
       }

  }

  void DFS(int x, int y){
    visited[x] = true;
    islandNo[x] = y;
    Iterator ite = gr.ver[x].iterator();
    while(ite.hasNext()){
      int    next = (int)ite.next();
      if(!visited[next]){
        DFS(next,y);
      }
    }
  }

}
