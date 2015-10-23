package es.urjc.ist.gens;

public class ArrayAleatorio<T> extends Array<T>
					implements Iterable<T>, SecuenciaAleatoria<T> {
	public ArrayAleatorio() {
		super();
	}

	public boolean put(int pos, T value) {

		if (pos >= 0 && pos < array.length) {
			array[pos] = value;
			len++;
			return true;
		} else if (pos == len) {
			this.put(value);
			return true;
		} else {
			return false;
		}
	}
}
