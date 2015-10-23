package es.urjc.ist.gens;

public interface SecuenciaAleatoria<T> extends Secuencia<T>{
	public abstract void put(T val);
	
	public abstract boolean put(int pos, T val);
	
	public abstract T get(int pos);
	
	public abstract int length();
}