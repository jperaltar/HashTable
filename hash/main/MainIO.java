package es.urjc.ist.hash.main;

import java.util.Random;

import es.urjc.ist.hashio.HashStringInt;

public class MainIO {
	public static void make_list(HashStringInt table){
		Random rand = new Random();
		int num;
		String key;
		
		for(int i = 0; i < 10; i++){
			num = rand.nextInt(11);
			key = Integer.toString(num);
			table.put(key,num);
		}
	}
	
	public static void main(String[] args) {
		HashStringInt table = new HashStringInt();
		HashStringInt aux = new HashStringInt();
		
		make_list(table);
		table.writeTo("/tmp/hash.out");
		System.out.println("Tabla: " + table.toString());
		aux = HashStringInt.readFrom("/tmp/hash.out");
		System.out.println("Tabla: " + aux.toString());
	}
}
