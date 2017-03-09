import java.util.*;
import java.io.*;
public class BST<T extends Comparable<T>> implements Iterable<T>{
   BSTNode root;

   public BST(){
      root = null;
   }


	public BSTNode<T> search(T target) {
		return search(target, root);
	}
	
	private BSTNode<T> search(T target, BSTNode<T> p) {
		if(p == null)
			return null;
		int comp = target.compareTo(p.getData());
		if(comp == 0){
			return p;
		}
		if(comp < 0)
			return search(target, p.getLeft());
		if(comp > 0)
			return search(target, p.getRight());
		return null;
	}
	





	public boolean insert(T value) {
		if(isEmpty()) {
			root = new BSTNode<T>(value);
			return true;
		}
		return insert(value, root);
	}
	
	private boolean insert(T value, BSTNode<T> p) {
		int comp = value.compareTo(p.getData());
		if(comp == 0)
			return false;
		if(comp < 0) {
			if(p.getLeft() == null) {
				p.setLeft(new BSTNode<T>(value));
				return true;
			}
			return insert(value, p.getLeft());
		}
		if(comp > 0) {
			if(p.getRight() == null) {
				p.setRight(new BSTNode<T>(value));
				return true;
			}
			return insert(value, p.getRight());
		}
		return false;
	}
   
	public void delete(T value){
				root = delete(value, root);
	}
	
	public BSTNode<T> delete(T target, BSTNode<T> tRoot){
		if(tRoot == null)
			return null;
		else if (target.compareTo((T)tRoot.getData()) < 0)
			tRoot.setLeft(delete(target, tRoot.getLeft()));
		else if (target.compareTo((T)tRoot.getData()) > 0)
			tRoot.setRight(delete(target, tRoot.getRight()));

		else{
			if(tRoot.getLeft() == null)
				return tRoot.getRight();
			else if(tRoot.getRight() == null)
				return tRoot.getLeft();
			else {
					BSTNode pRoot = tRoot.getLeft();
					while(pRoot.getRight() != null)
						pRoot = pRoot.getRight();
					tRoot.setData((T)pRoot.getData());
					//tRoot.setData(getData(tRoot.getLeft()));
					tRoot.setLeft(delete((T)tRoot.getData(), tRoot.getLeft()));
				
				}
			}
			return tRoot;
		}
   
   public Iterator<T> iterator(){
		return new TreeIterator();
   }
   
   boolean isEmpty(){
      if (root == null)
         return true;
      else
         return false;
   }


	private class TreeIterator implements Iterator<T>{
	private Stack<BSTNode<T>> stackIt = new Stack<BSTNode<T>>();
	private BSTNode<T> cursor;
	private BSTNode<T> savedCursor;
	
	private TreeIterator(){
		cursor = root;
	}
	
	public boolean hasNext(){
		return(!stackIt.empty() || (cursor != null));
	}
	
	public T next(){
		while(cursor != null){
			stackIt.push(cursor);
			cursor = cursor.getLeft();
		}
		
		if(!stackIt.empty()){
			cursor = stackIt.pop();
			savedCursor = cursor;
			cursor = cursor.getRight();
		}
		
			return savedCursor.getData();
	}
		public void remove() {
			stackIt.remove(cursor);
		}
		
	}
}
	
