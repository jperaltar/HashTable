package es.urjc.ist.hash.main;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import es.urjc.ist.gens.ListaAleatoria;
import es.urjc.ist.gens.ListaOrdenada;

public class ListaTest {
	public static void test_randlist(ListaAleatoria<Integer> list) {
		Random rand = new Random();
		Integer num;
		
		for(int i = 0; i < 10; i++){
			num = rand.nextInt(11);
			list.put(num);
			if(list.get(i) != num)
				fail();
		}
	}
	
	public static void test_sortedlist(ListaOrdenada<Integer> slist) {
		Random rand = new Random();
		Integer num;
		
		for(int i = 0; i < 10; i++){
			num = rand.nextInt(11);
			slist.put(num);
			if(slist.get(num) == false)
				fail();
		}
		for(int i = 0; i < 9; i++){
			if(slist.get(i).compareTo(slist.get(i+1)) > 0){
				fail();
			}
		}
	}

	@Test(timeout=5000)
	public void test() {
		ListaAleatoria<Integer> randlist = new ListaAleatoria<Integer>();
		ListaOrdenada<Integer> sortedlist = new ListaOrdenada<Integer>();
		
		test_randlist(randlist);
		test_sortedlist(sortedlist);
	}

}
