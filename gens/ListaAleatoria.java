package es.urjc.ist.gens;

public class ListaAleatoria<T> extends Lista<T>
				implements Iterable<T>, SecuenciaAleatoria<T> {
	public ListaAleatoria(){
		super();
	}
	
	public boolean put(int pos, T value) {
		Node<T> aux = first_node;
		Node<T> new_node = new Node<T>(value, null);
		
		if(pos > 0 && pos < len){
			for(int i = 0; i < pos-1; i++){
				aux = aux.next;
			}
			new_node.next = aux.next;
			aux.next = new_node;
			
			return true;
		}else if(pos == 0){
			new_node.next = first_node;
			first_node = new_node;
		
			return true;
		}else if(pos == len){
			this.put(value);
			
			return true;
		}else{
			return false;
		}
	}
}
