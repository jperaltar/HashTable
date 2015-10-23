package es.urjc.ist.hash;

import java.util.Iterator;

import es.urjc.ist.gens.ArrayAleatorio;
import es.urjc.ist.gens.ListaAleatoria;

/**
 * Generic hash table.
 * Significant methods:
 * 		Put(Key,Value)
 * 		-- Adds new element to the table with the indicated key and value.
 * 		Get(Key) 
 * 		-- Gets value associated to the indicated key. If it's not in the table, null is returned.
 * 
 * @author jperalta
 */
public class Hash<K, V> implements Iterable<K>{
	//Protected
	int len;
	ArrayAleatorio<ListaAleatoria<Hashelem<K,V>>> hasharray;
	
	static class Hashelem<K, V> {
		K key;
		V val;
		
		public Hashelem(K k, V v){
			key = k;
			val = v;
		}
		
		public Hashelem(){
			this(null,null);
		}
		
		public String toString(){
			return key.toString() + ":" + val.toString();
		}
	}
	
	/*Iterador de la tabla hash, compuesto de dos iteradores
	 * Uno para el array y otro para la lista de desbordamiento.
	 */
	protected class HashIterator implements Iterator<K> {
		public Iterator<ListaAleatoria<Hashelem<K,V>>> arrayit = hasharray.iterator();
		public ListaAleatoria<Hashelem<K,V>> aux;
		public Iterator<Hashelem<K,V>> listit;
		int position;
		
		public HashIterator(){
			position = 0;
		}
		
		public boolean hasNext() {
			boolean found = false;
			
			if(arrayit.hasNext()){
				found = true;
			}else {
				if(listit.hasNext())
					found = true;
			}
			return found;
		}

		public K next() {
			Hashelem<K,V> aux_elem = null;
			K aux_key = null;
			
			if(aux != null){
				if(listit == null)
					listit = aux.iterator();
				if(!listit.hasNext()){
					aux = arrayit.next();
					if(aux != null){
						listit = aux.iterator();
						aux_key = null;
					}
				}else {
					aux_elem = listit.next();
					aux_key = aux_elem.key;
				}
			}else{
				aux = arrayit.next();
				if(aux != null)
					listit = aux.iterator();
				aux_key = null;
			}
			position++;
			return aux_key;			
		}

		public void remove() {
			throw new UnsupportedOperationException("Not Supported");
		}
	}
	
	public Iterator<K> iterator() {
		Iterator<K> i = new HashIterator();
		
		return i;
	}
	
	private int hashfunction(K key){
		int index;
		
		index = key.hashCode();
		index = index % hasharray.arraylength();
		
		return index;
	}

	public Hash() {
		hasharray = new 
			ArrayAleatorio<ListaAleatoria<Hashelem<K,V>>>();
		len = hasharray.length();
	}
	
	public void put(K key, V val) {
		int index = hashfunction(key);
		ListaAleatoria<Hashelem<K,V>> list;
		Hashelem<K,V> elem = new 
				Hashelem<K, V>(key,val);
		Hashelem<K,V> auxelem;
		
		if ((list = hasharray.get(index)) == null){
			list = new ListaAleatoria<Hashelem<K,V>>();
		}
		for(int i = 0; i < list.length(); i++){
			auxelem = list.get(i);
			if(auxelem.key.equals(key)){
				list.delete(i);
				len--;
			}
		}
		
		list.put(elem);
		len++;
		hasharray.put(index, list);
	}
	
	public V get(K key) {
		int index = hashfunction(key);
		ListaAleatoria<Hashelem<K,V>> list;
		Hashelem<K,V> elem;
		
		if((list = hasharray.get(index)) == null)
			return null;
		for(int i = 0; i < list.length(); i++){
			elem = list.get(i);
			if(elem.key.equals(key))
				return elem.val;
		}
		
		return null;
	}
	
	public String toString(){
		int pos = 0;
		ListaAleatoria<Hashelem<K,V>> list;
		String str = "";
		
		while(pos < hasharray.arraylength()) {
			list = hasharray.get(pos);
			if(list != null){
				str = str + list.toString(); 
			}
			pos++;
		}
		
		return str;
	}
	
	public int length(){
		return len;
	}
}
