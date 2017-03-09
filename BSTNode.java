import java.util.*;
import java.io.*;
public class BSTNode<T extends Comparable<T>> /*implements Iterable<T>*/{
   T data;
	BSTNode left, right;
	
	BSTNode (T valIn, BSTNode leftIn, BSTNode rightIn){
		data = valIn;
		left = leftIn;
		right = rightIn;
	}
	
	BSTNode(T dataIn){
		data = dataIn;
		left = null;
		right = null;
	}
	
	   
   public String toString(){
      return data.toString();
   }
	
	public int compareTo(BSTNode<T> dataIn){
		return this.getData().compareTo(dataIn.getData());
	
	}
	public BSTNode getLeft(){
		return left;
	}
	public BSTNode getRight(){
		return right;
	}
	public T getData(){
		return data;
	}
	public void setLeft(BSTNode in){
		left = in;
	}
	public void setRight(BSTNode in){
		right = in;
	}
	public void setData(T in){
		data = in;
	}
	
}/* */