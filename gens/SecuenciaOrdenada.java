package es.urjc.ist.gens;

public interface SecuenciaOrdenada<T> extends Secuencia<T>{
	public abstract void put(T val);
	
	public abstract boolean get(T val);
	
	public abstract T get(int pos);
	
	public abstract int length();
}
