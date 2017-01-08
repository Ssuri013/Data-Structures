
//class bag implements iterable, too long of code for test

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
