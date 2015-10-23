package es.urjc.ist.hash.main;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import es.urjc.ist.hash.Hash;
import es.urjc.ist.hashio.HashStringInt;

public class IOTest {
	public void make_list(Hash<String, Integer> table){
		Random rand = new Random();
		int num;
		String key;
		
		for(int i = 0; i < 10; i++){
			num = rand.nextInt(11);
			key = Integer.toString(num);
			table.put(key,num);
		}
	}
	
	public void compare_tables(HashStringInt tab1, HashStringInt tab2){
		for(Integer i = 0; i < 11; i++){
			if(tab1.get(i.toString()) != null){
				if(tab2.get(i.toString()) == null)
					fail();
			}
		}
	}

	@Test(timeout=5000)
	public void test() {
		HashStringInt table = new HashStringInt();
		HashStringInt aux = new HashStringInt();
		
		make_list(table);
		table.writeTo("/tmp/b");
		aux = HashStringInt.readFrom("/tmp/b");
		compare_tables(table,aux);
	}

}
