package es.urjc.ist.gens;

import java.util.Iterator;

public class Lista<T> implements Iterable<T>, Secuencia<T> {
	
	//Protected
	int len;
	Node<T> first_node;
	
	static class Node<T> {
		public T value;
		public Node<T> next;
		
		public Node(T new_value, Node<T> nod){
			value = new_value;
			next = nod;
		}
	}
	
	public Lista(){
		len = 0;
		first_node = null;
	}
	
	//Iterator for the list
	protected class ListIterator implements Iterator<T> {
		public Node<T> aux;
			
		public ListIterator(){
			aux = first_node;
		}
			
		public boolean hasNext() {
			if(aux == null){
				return false;
			}else{
				return true;
			}
		}
	
		public T next() {
			Node<T> prev;
			T aux_val;
			
			if(aux != null){
				prev = aux;
				aux = aux.next;
				aux_val = prev.value;
			}else{
				aux_val = null;
			}
			return aux_val;
		}
	
		public void remove() {
			throw new UnsupportedOperationException("Not Supported");
		}	
	}
	
	public Iterator<T> iterator() {
		ListIterator it = new ListIterator();
		return it;
	}
	
	public void put(T val) {
		Node<T> aux = first_node;
		Node<T> new_node = new Node<T>(val, null);
		
		//Go to the last node and inserts 
		//the new node after this one
		if(aux != null){
			for(int i = 0; i < len-1; i++){
				aux = aux.next;
			}
			aux.next = new_node;
		}else{
			first_node = new_node;
		}
		//Add one to total length
		len++;
	}
	
	public T get(int pos) {
		Node<T> aux = first_node;
		
		if(pos >= 0 && pos < len){
			for(int i = 0; i < pos; i++){
				aux = aux.next;
			}
			return aux.value;
		}else{
			return null;
		}	
	}
	
	public boolean delete(int pos) {
		Node<T> aux = first_node;
		
		if(pos > 0 && pos < len){
			for(int i = 0; i < pos-1; i++){
				aux = aux.next;
			}
			aux.next = aux.next.next;
			len--;
			return true;
		}else if(pos == 0) {
			first_node = aux.next;
			len--;
			return true;
		}else {
			return false;
		}
	}
	
	public String toString(){
		String str = "";
		Node<T> aux = first_node;
		
		while(aux != null){
			str = str + aux.value.toString() + " ";
			aux = aux.next;
		}
		return str;
	}
	
	public int length() {
		return len;
	}
}
