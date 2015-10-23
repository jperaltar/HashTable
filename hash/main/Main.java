package es.urjc.ist.hash.main;

import java.util.Random;
import java.util.Iterator;

import es.urjc.ist.hash.Hash;

public class Main {
	public static void make_list(Hash<String, Integer> table){
		Random rand = new Random();
		int num;
		String key;
		
		for(int i = 0; i < 10; i++){
			num = rand.nextInt(11);
			key = Integer.toString(num);
			table.put(key,num);
		}
	}
	
	public static void print_table(Hash<String, Integer> table){
		Integer value;
		String key;
		
		System.out.print("[ ");
		Iterator<String> itHash = table.iterator();
		while(itHash.hasNext()) {
			key = itHash.next();
			if(key != null){
				value = table.get(key);
				System.out.print(value + " ");
			}
		}
		System.out.print("]\n");
	}

	public static void main(String[] args) {
		Hash<String, Integer> table = new Hash<String,Integer>();
		
		make_list(table);
		print_table(table);
		System.out.println(table.toString());
	}
}
