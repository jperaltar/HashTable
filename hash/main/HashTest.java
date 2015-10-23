package es.urjc.ist.hash.main;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import es.urjc.ist.hash.Hash;

public class HashTest {
	public static void test_hash(Hash<String, Integer> table){
		Random rand = new Random();
		int num = 0;
		String key;
		
		for(int i = 0; i < 10; i++){
			num = rand.nextInt(11);
			key = Integer.toString(num);
			table.put(key,num);
			if(!(table.get(key)).equals(num)){
				fail();
			}
		}
	}
	
	@Test(timeout=5000)
	public void test() {
		Hash<String, Integer> table = new Hash<String,Integer>();
		
		test_hash(table);
	}

}
