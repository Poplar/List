import java.util.*;
import java.io.*;
public class Set<T extends Comparable<T>> implements Iterable<T>, Comparable <Set<T>>{
   BST tree;
   
   public Set(){
      tree = new BST();
   }
   public Set(T[] setElements){
   	tree = new BST();
		for(int i = 0; i < setElements.length; i++)
			tree.insert(setElements[i]);
   }
   
   public T search(T target){
		//System.out.println(target);
      return (T)(tree.search(target).getData());
   }
   
   public boolean elementOf(T t){
      if(tree.search(t) == null)
         return false;
      else
         return true;
   }
   
   public boolean insert(T value){
      return tree.insert(value);
   }
	  
   public boolean delete(T target){
      /*return*/ tree.delete(target);
		return false;
   
   }
   
   public Set copy(){
	Set setCopy = new Set();
	copy(setCopy, tree.root);
	return setCopy;
   }
 
   public void copy(Set setIn, BSTNode head){
		if(head == null)
			return;
		setIn.insert(head.getData());
		copy(setIn,head.getLeft());
		copy(setIn,head.getRight());
	}
	
	
	
   public Set union(Set s){
   Set newSet = this.copy();
	for(Iterator i = s.iterator(); i.hasNext(); )
		newSet.insert((Comparable)i.next());
	return newSet;
   }
   
   public Set intersection(Set s){
	Set newSet = this.copy();
	for(Iterator i = s.iterator(); i.hasNext(); ){
		T temp = (T)i.next();
		if(s.search(temp) != null /*&& this.search(temp) != null*/)
			newSet.insert((Comparable)temp);
	}
	return newSet;
   }
   
   public boolean subsetOf(Set s){
	boolean subset = true;
	for(Iterator i = this.iterator(); i.hasNext(); ){
		T temp = (T)i.next();
		if (s.tree.search(temp) == null){
			subset = false;
			break;
		}
	}
   return subset;
   }



   public Iterator<T> iterator(){
   	return tree.iterator();
   }
   
   public String toString(){
   //TODO
	String temp = "{";
	for(Iterator i = this.iterator(); i.hasNext(); )
		temp += i.next().toString() + ", ";
	if(temp.length() > 2)
		temp = temp.substring(0, (temp.length() - 2));
	temp += "}";
	return temp;
   }

   public int compareTo(Set s){		
		Iterator<T> temp1 = tree.iterator();
		Iterator<T> temp2 = s.tree.iterator();
		while(temp1.hasNext() && temp2.hasNext()){
			T item1 = temp1.next();
			T item2 = temp2.next();
			if(item1.compareTo(item2) == -1) 
				return -1;
			if(item1.compareTo(item2) == 1)
				return 1;
		}
		if(temp1.hasNext())
			return 1;
		if(temp2.hasNext())
			return -1;
			
		return 0;
		
   }	


}