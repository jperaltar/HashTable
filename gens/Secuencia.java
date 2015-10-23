package es.urjc.ist.gens;

public interface Secuencia<T> {
	public abstract void put(T val);
	
	public abstract T get(int pos);
	
	public abstract int length();
}
