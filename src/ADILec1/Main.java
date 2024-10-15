package ADILec1;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        //linearprobing
        HashtablelinearProb h1=new HashtablelinearProb(10);
        h1.insert("hello");
        h1.insert("hi");
        h1.insert("java");
        h1.insert("java2");
        h1.insert("java3");

        h1.display();

        //quadraticprobing
        HashtablequadraticProb h2=new HashtablequadraticProb(10);
        h2.insert("hello");
        h2.insert("hi");
        h2.insert("java");
        h2.insert("java2");
        h2.insert("java3");

        h2.display();


    }
}
class HashtablequadraticProb{
    String[] hashtable;
    int capacity;

    HashtablequadraticProb(int cap){
        hashtable=new String[cap];
        capacity=cap;
    }

    int hash(String key){
        return key.hashCode() % capacity;
    }

    void insert(String key){
        int hashIdx=hash(key);
        int i=1;

        while(hashtable[hashIdx] !=  null){
            hashIdx=(hashIdx+i*i)%capacity;
            i++;

        }
        hashtable[hashIdx]=key;
    }

    void display(){
        for(int i=0;i<capacity;i++){
            if(hashtable[i] != null)
            {
                System.out.println(i +"  "+hashtable[i]);
            }
            else{
                System.out.println(i+"  " + "null");
            }
        }
    }

}

class HashtablelinearProb{
    String[] hashtable;
    int capacity;

    HashtablelinearProb(int cap){
        hashtable=new String[cap];
        capacity=cap;
    }

    int hash(String key){
        return key.hashCode() % capacity;
    }

    void insert(String key){
        int hashIdx=hash(key);

        while(hashtable[hashIdx] !=  null){
            hashIdx=(hashIdx+1)%capacity;

        }
        hashtable[hashIdx]=key;
    }

    void display(){
        for(int i=0;i<capacity;i++){
            if(hashtable[i] != null)
            {
                System.out.println(i +"  "+hashtable[i]);
            }
            else{
                System.out.println(i+"  " + "null");
            }
        }
    }

}

class Hashtableseperatechain{
    LinkedList<String>[] hashtable;
    int capacity;

    Hashtableseperatechain(int cap){
        hashtable=new LinkedList[cap];
        capacity=cap;
        for(int i=0;i<capacity;i++){
            hashtable[i]=new LinkedList<>();
        }
    }
    int hash(String key){
        return key.hashCode() % capacity;
    }

    void insert(String key){
        int hashIdx=hash(key);
        hashtable[hashIdx].add(key);


    }
    void display(){
        for(int i=0;i<capacity;i++){
            System.out.print(i +" ");
            for(String s:hashtable[i]){
                System.out.print(s);
            }
            System.out.println();
        }
    }

}
