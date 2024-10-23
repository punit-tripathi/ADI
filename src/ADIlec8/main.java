package ADIlec8;

import java.util.LinkedList;
import java.util.Queue;

public class main {
    public static void main(String[] args) {
        Binarytree tree=new Binarytree();
        tree.root=new Node(1);
        tree.root.left=new Node(2);
        tree.root.right=new Node(3);
        tree.root.left.left=new Node(5);
        tree.root.left.right=new Node(4);

        tree.inorder(tree.root);

    }
}
class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
class Binarytree{
    Node root;

    Binarytree(){
        this.root=null;
    }

    void inorder(Node root){
        if(root == null) return;

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    void preorder(Node root){
        if(root == null) return;

        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    void postorder(Node root){
        if(root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    void leftView(Node root){
        if(root == null) return;

        Queue<Node>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){

           int sz=q.size();
           for(int i=0;i<sz;i++){
               Node temp=q.poll();
               if(i==0){
                   System.out.println(temp.data);
               }


               if(temp.left  != null){
                   q.add(temp.left);
               }
               if(temp.right  != null){
                   q.add(temp.right);
               }
           }
        }
    }

    void delete(int key){
        if(root == null) return;

        if(root.left == null && root.right == null){
            if(root.data == key) {
                root=null;
                return;
            }

            Queue<Node>q=new LinkedList<>();
            q.add(root);
            Node keyNode=null;
            Node last=null;
            Node temp=null;
            while(!q.isEmpty()){
                temp=q.poll();
                if(temp.data == key){
                    keyNode = temp;
                }
                 if(temp.left != null){
                     last= temp;
                     q.add(temp.left);
                 }
                if(temp.right != null){
                    last= temp;
                    q.add(temp.right);
                }
            }
            if(keyNode != null){
                keyNode.data= temp.data;
                if(last.right != null){
                    last.right = null;

                }
                else{
                    last.left = null;
                }
            }
        }
    }
}

class BST{
    Node root;

    BST(){
        this.root=null;
    }

    void insert(int val){
        root=add(val);

    }

    Node add(int val){
        if(root == null){
            root=new Node(val);
            return root;
        }

        if(val < root.data){
            root.left=add(val);
        }
        if(val > root.data){
            root.right = add(val);

        }
        return root;
    }

    Node delete(int key){
        if(root == null)return null;

        if(root.data < key){
            root.right=delete(key);
        }
        if(root.data > key){
            root.left=delete(key);
        }
        else{
//            if(root.left == null && root.right==null)return null;
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            root.data=minVal(root.right);

            root.right = delete(root.data);
        }
        return root;
    }
    int minVal(Node temp){
        int val=temp.data;
        while(temp != null){
            val=temp.data;
            temp=temp.left;
        }
        return val;
    }

    Node LCAinBST(Node root,int n1,int n2){
        if(root == null) return null;

        if(n1 < root.data && n2 < root.data){
            return LCAinBST(root.left,n1,n2);
        }
        if(n1 > root.data && n2 > root.data){
            return LCAinBST(root.right,n1,n2);
        }

        return root;
    }

    int count =0;
    Node KthsmallestinBST(Node root,int k){
        if(root == null) return null;

        Node left=KthsmallestinBST(root.left,k);

        if(left != null){
            return left;
        }
        count++;
        if(count == k){
            return root;
        }

        return KthsmallestinBST(root.right,k);
    }
}

















































