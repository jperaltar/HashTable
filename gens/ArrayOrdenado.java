package es.urjc.ist.gens;

public class ArrayOrdenado<T extends Comparable<T>> extends Array<T> 
					implements Iterable<T>, SecuenciaOrdenada<T> {
	public ArrayOrdenado(){
		super();
	}
	
	public void put(T value) {
		Object[] aux_array = new Object[array.length];
		int i;
		
		if(len >= array.length)
			array = grow(array);
			aux_array = new Object[array.length];
			
		for(i = 0; i < len; i++){
			if(((Comparable<T>) array[i]).compareTo(value) > 0){
				break;
			}
		}
		
		for(int j = 0; j < i; j++){
			aux_array[j] = array[j];
		}
		aux_array[i] = value;
		len++;
		for(int j = i+1; j < len; j++){
			aux_array[j] = array[j-1];
		}
		
		array = aux_array;
	}
	
	public boolean get(T value) {
		int start = 0;
		int end = len - 1;
		int mid;
		
		//Binary Search
		while(start <= end){
			mid = (end - start)/2 + start;
			if(((Comparable<T>) array[mid]).compareTo(value) > 0){
				end = mid - 1;
			}else if(((Comparable<T>) array[mid]).compareTo(value) < 0){
				start = mid + 1;
			}else{
				return true;
			}
		}
		return false;
	}
}
