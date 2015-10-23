package es.urjc.ist.gens;

public class ListaOrdenada<T extends Comparable<T>> extends Lista<T> 
				implements Iterable<T>, SecuenciaOrdenada<T> {
	public ListaOrdenada(){
		super();
	}
	
	public void put(T val) {
		Node<T> aux = first_node;
		Node<T> new_node = new Node<T>(val, null);
		int i;
		
		if(aux != null){
			//Go to the node which string is
			//directly bigger than str
			for(i = 0; i < len; i++){
				if(aux.value.compareTo(val) > 0){
					break;
				}
				aux = aux.next;
			}

			if(i != 0){
				aux = first_node;

				for(int j = 0; j < i-1; j++){
					aux = aux.next;
				}
				new_node.next = aux.next;
				aux.next = new_node;
			}else if(i == len){
				aux.next = new_node;
			}else{
				new_node.next = first_node;
				first_node = new_node;
			}
			len++;
		}else{
			first_node = new_node;
			len++;
		}
	}
	
	public boolean get(T val) {
		Node<T> aux = first_node;
		
		//Go to the matching str in the list
		for(int i = 0; i < len; i++){
			if(aux.value.equals(val)){
				return true;
			}
			aux = aux.next;
		}
			return false;	
	}
}
