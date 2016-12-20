import java.lang.Math; //for max function used in finding height
class BinaryTree{

  //sub class to define the data structure of each element in tree
  class Node{
    int key;  //contains data
    Node left;
    Node right;
    Node(int x){
      key=x;
      left=right=null;
    }

  }

  Node root; // for global use

  BinaryTree(){
    root=null;  //structure starts from null
  }


  void insert(int y){
  root = insertNode(root,y);
  }

  Node insertNode(Node troot, int y){

    if(troot==null){
      Node temp= new Node(y);
      troot=temp;
    }
    else if(y>troot.key){
    troot.right =  insertNode(troot.right,y);
    }
    else if (y<troot.key) {
      troot.left = insertNode(troot.left, y);
    }


    return troot;
  }

  void display(Node troot){ // same as inorder
      if(troot!=null){
        display(troot.left);
        System.out.print(troot.key + " ");
        display(troot.right);
      }
    }

    void preOrder(Node troot){
        if(troot!=null){
          System.out.println(troot.key);
          preOrder(troot.left);
          preOrder(troot.right);
        }
      }
      void postOrder(Node troot){
          if(troot!=null){
            postOrder(troot.left);
            postOrder(troot.right);
            System.out.println(troot.key);
          }
        }


  int max(Node n){

    if(n.right!=null){
    return  max(n.right);
    }
    else{
      return n.key;
    }

  }
  int min(Node n){
    if(n.left!=null){
    return  min(n.left);
    }
    else{
      return n.key;
    }
  }

  boolean search(Node n,int x){
    if(n==null){
      return false;
    }
    else{
      if(n.key == x){
        return true;
      }
      else if(x<n.key){
        return search(n.left,x);
      }
      else if(n.key<x){
        return search(n.right,x);
      }
    }
    return false;
  }

  int maxHeight(Node n){
    if(n==null){return -1;}

    return Math.max(maxHeight(n.left),maxHeight(n.right))+1;
  }


  void printGivenLvl(Node troot, int lvl){
    if(troot==null)return;
    if(lvl == 0){
      System.out.println(troot.key);
    }
    else if(lvl > 0){
      printGivenLvl(troot.left, lvl-1);
      printGivenLvl(troot.right, lvl-1);
    }
  }

  void lvlOrder(Node troot){
    int h= maxHeight(troot);
    for(int i=0; i<=h; i++){
      printGivenLvl(troot, i);
    }
  }

  void printGivenLvl2(Node troot, int lvl){
    if(troot==null)return;
    if(lvl == 0){
      System.out.print(troot.key + "  ");
    }
    else if(lvl > 0){
      printGivenLvl2(troot.left, lvl-1);
      printGivenLvl2(troot.right, lvl-1);
    }
  }

  void lvlOrder2(Node troot){
    int h= maxHeight(troot);
    for(int i=0; i<=h; i++){
      printGivenLvl2(troot, i);
      System.out.println(" ");
    }
  }

  //best one
  void LevelOrder3(Node root)
      {
        Queue<Node> que = new LinkedList<Node>();
         que.add(root);
         while(!que.isEmpty()){
             Node x = que.poll();
             System.out.print(x.data + " ");
             if(x.left!=null)que.add(x.left);

             if(x.right!=null)que.add(x.right);
         }

      }
  void topView(Node troot){
     //static Node temp = troot;
    if(troot==null) return;
    topView(troot.left);
    System.out.println(troot.key);
    if(troot==root){
      troot=troot.right; //so root elemnet is not printed twice
      while(troot!=null){
          System.out.println(troot.key);
          troot=troot.right;

      }
    }
  }




// string containing one or zero is passed
// 1 means right
//0 means left
// hackerrank
void huffmanDecode(String str ,Node root)
    {
        int i=0;
        Node temp=root;
        while(i < str.length() )
        {
             temp=root;

            while(i < str.length() )
            {
                if( str.charAt(i) == '1' )
                {
                    if(temp.right==null){
                        System.out.print(temp.key);
                       break;
                    }
                    else{
                    temp=temp.right;
                    }
                }
                else
                {
                    if(temp.left==null){
                        System.out.print(temp.key );
                        break;
                    }
                    else{
                    temp=temp.left;
                    }
                }
                i++;
            }


        }

     System.out.print(temp.key);

    }

 Node lca(Node root,int v1,int v2)
    {
      if(v1==root.key || v2==root.key){
                return root;
            }
        else if(v1 <= root.key && v2 <= root.key){
           return  lca(root.left, v1, v2);
        }
        else if(v1 > root.key && v2 > root.key){
           return  lca(root.right, v1, v2);

        }
        else{
            return root;
        }


    }

    void printCurr(Node troot){
      System.out.println(troot.key);
    }

    int minDepth(Node root) {
     if(root==null){return 0;}
     if ((root.left==null) || (root.right==null)) {
           return 1+Math.max(minDepth(root.left),minDepth(root.right));
       }
       return 1+Math.min(minDepth(root.left),minDepth(root.right));
 }


  Node delete(Node n, int x){
    if(n==null)
    {return n;}
    if(n.key<x){
      n.right=delete(n.right,x);
    }
    else if(n.key>x){
      n.left=delete(n.left,x);
    }
    else{
      if(n.left==null){return n.right;}
      if(n.right==null){return n.left;}

      n.key=min(n.right);
      n.right=delete(n.right,n.key);
    }
    return n;
  }

   int isSameTree(Node a, Node b) {
    if(a==null && b==null){return 1;}
    else if(a==null && b!=null){return 0;}
    else if(a!=null && b==null){return 0;}

    int x = isSameTree(a.left,b.left);
    if(a.key!=b.key){return 0;}
    int y = isSameTree(a.right,b.right);

    if(x==1 && y==1){return 1;}
    else {return 0;}
}
//symmetric or not    mirror image
public int isSymmetric(TreeNode a) {
    return isSameTree(a.left,a.right);
}


int isSameTree(TreeNode a, TreeNode b) {
  if(a==null && b==null){return 1;}
  else if(a==null && b!=null){return 0;}
  else if(a!=null && b==null){return 0;}

  int x = isSameTree(a.left,b.right);
  if(a.val!=b.val){return 0;}
  int y = isSameTree(a.right,b.left);

  if(x==1 && y==1){return 1;}
  else {return 0;}
}
///////////////////////////////


boolean checkBST(Node root) {

  return  check(root,Integer.MIN_VALUE,Integer.MAX_VALUE);

}

    boolean check(Node root,int min,int max){
        if(root==null){return true;}

        if(root.data>max || root.data<min){
            return false;
        }

        return (check(root.left,min,root.data-1) && check(root.right,root.data+1,max));
    }



}
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    TreeNode root=null;

    void Insert1(int x){
        root = Insert(root,x);
    }
     TreeNode Insert(TreeNode troot,int y)
    {
    if(troot==null){

      return new TreeNode(y);
    }
    else if(y>troot.val){
    troot.right =  Insert(troot.right,y);
    }
    else {
      troot.left = Insert(troot.left, y);
    }


    return troot;

    }


	public TreeNode sortedArrayToBST(final List<Integer> a) {

	    split(a,0,a.size()-1);
	    return root;

	}

	  void split(List<Integer> a,int start, int end){

        if(start<=end){
            int mid=(start+end)/2;
            int ip = Integer.parseInt(a.get(mid).toString());
            Insert1(ip);

        split( a, start, mid-1);
        split( a, mid+1, end);


        }

	}

}

public class Solution {

int height(TreeNode root)
    {
    if(root==null) return -1; //might give one lesser

    return Math.max(height(root.right), height(root.left)) +1;
}

ArrayList<Integer> printgivenlevelL(ArrayList arr, TreeNode root,int level)
    {
      if(root==null) return arr;
    if(level==1)
        {
        arr.add(root.val);
        return arr;
    }
    else if(level>1)
        {
        if(root.left!=null) arr = printgivenlevelL(arr, root.left,level-1);
        if(root.right!=null) arr = printgivenlevelL(arr,root.right,level-1);
    }

    return arr;
}


ArrayList<Integer> printgivenlevelR(ArrayList arr, TreeNode root,int level)
    {
      if(root==null) return arr;
    if(level==1)
        {
        arr.add(root.val);
        return arr;
    }
    else if(level>1)
        {
              if(root.right!=null) arr = printgivenlevelR(arr,root.right,level-1);
              if(root.left!=null) arr = printgivenlevelR(arr, root.left,level-1);

    }

    return arr;
}

public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root)
{
    ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
  if(root==null) return arr;
    int h=height(root)+1;


  for(int i=1;i<=h;i++)
      {
          if(i%2==1){ arr.add( printgivenlevelL(new ArrayList<Integer>(), root, i) );}
          else{
         arr.add( printgivenlevelR(new ArrayList<Integer>(), root, i) );
          }

    }


    return arr;
}
}
public class Solution {



int height(TreeNode root)
    {
    if(root==null) return 0;

    return Math.max(height(root.left),height(root.right))+1;
}

ArrayList printgivenlevel(ArrayList a,TreeNode root,int level)
    {
      if(root==null) return a;
    if(level==1)
        {
        a.add(root.val);
    }
    else if(level>1)
        {
        if(root.left!=null) a =  printgivenlevel(a,root.left,level-1);
        if(root.right!=null) a = printgivenlevel(a,root.right,level-1);
    }
    return a;
}

	public int isBalanced(TreeNode a) {
	    if(a==null) return 1;
    int h=height(a);
  for(int i=1;i<h;i++)
      {
       ArrayList ar = printgivenlevel(new ArrayList(), a, i);
       long x=Math.round(Math.pow(2,i-1));
       long y = ar.size();

       if(y != x)
       {
        //System.out.println(y + " "+ x);
        return 0;
       }
  }
	    return 1;
	}
}


public class Solution {



int height(TreeNode root)
    {
    if(root==null) return 0;

    return Math.max(height(root.left),height(root.right))+1;
}


	public int isBalanced(TreeNode a) {
	    if(a==null) return 1;
	    int x = isBalanced(a.left);
	     int y = isBalanced(a.right);
	     if(x==1 && y==1){
	         int h1=height(a.left);
             int h2=height(a.right);
             int z=h1-h2;
             if( z==1 || z==0 || z==-1){
                 return 1;
             }
             else return 0;

	     }

         return 0;
	}
}

public class Solution {


      ArrayList display(TreeNode troot,int k,ArrayList a){

      if(troot != null){

         a= display(troot.left,k,a);
         a.add(troot.val);
         a=display(troot.right,k,a);
      }

      return a;
    }
    public int kthsmallest(TreeNode root, int k) {

    ArrayList a = display(root,k,new ArrayList<Integer>());
    return Integer.parseInt(a.get(k-1).toString());
    }
}

class bst{

  public static void main(String args[]){
    BinaryTree  x = new BinaryTree();
    // x.insert(5);
    // x.insert(3);
    // x.insert(10);
    // x.insert(2);
    // x.insert(20);
    // x.insert(4);
    // x.insert(1);
    // x.insert(8);
    // x.insert(9);
    // x.insert(0);
    x.insert(23);
    x.insert(16);
    x.insert(15);
    x.insert(9);
    x.insert(6);
    x.insert(17);
    x.insert(10);
    x.insert(13);
    x.insert(8);
    x.insert(26);
    x.insert(18);
    x.insert(2);
    x.insert(22);
    x.insert(24);
    x.insert(12);
    x.insert(5);
    x.insert(20);
    x.insert(25);
    x.insert(21);
    x.insert(4);
    x.insert(19);
    x.insert(1);
    x.insert(3);
    x.insert(14);
    x.insert(7);

    x.display(x.root);
    System.out.println(" ");
  //  System.out.println("Max & Min element in the tree are : " + x.max(x.root) + " & " + x.min(x.root) + "respectively");
  //   if(x.search(x.root, 10)){
  //     System.out.println("found");
  //    }
  //   else{
  //     System.out.println("not found");
  //   }
  //  x.delete(x.root, 10);
  //  System.out.println(x.maxHeight(x.root));
  //  x.lvlOrder(x.root);
  //  x.topView(x.root);
  //  x.printCurr( x.lca(x.root,23,3) );
//  x.lvlOrder2(x.root);
    x.delete(x.root,5);
    x.display(x.root);

  }
}
