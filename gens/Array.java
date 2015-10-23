package es.urjc.ist.gens;

import java.util.Iterator;

public class Array<T> implements Iterable<T>, Secuencia<T>{
	//Protected
	int len;
	Object[] array;
	
	public Array(){
		len = 0;
		array = new Object[4];
	}
	
	//Iterator for the array
	protected class ArrayIterator implements Iterator<T> {
		public int position;
		
		public ArrayIterator(){
			position = 0;
		}
		
		
		public boolean hasNext() {
			if(array.length > position){
				return true;
			}else {
				return false;
			}
		}

		public T next() {
			position++;
			return (T) array[position-1];
		}

		public void remove() {
			throw new UnsupportedOperationException("Not Supported");		
		}
	}
	
	public Iterator<T> iterator() {
		Iterator<T> it = new ArrayIterator();
		
		return it;
	}
	
	protected Object[] grow(Object[] array){
		Object[] new_array = new Object[len+array.length];
		
		for(int i = 0; i < len; i++){
			new_array[i] = array[i];
		}
		array = new_array;
		return array;
	}
	
	public void put(T value) {
		if(len < array.length)
			//array = grow(array);
			array[len] = value;
			len++;
	}
	
	public T get(int pos) {
		if(pos >= 0 && pos < array.length){
			return (T) array[pos];
		}else{
			return null;
		}
	}
	
	public int length() {
		return len;
	}
	
	public int arraylength(){
		return array.length;
	}
}
