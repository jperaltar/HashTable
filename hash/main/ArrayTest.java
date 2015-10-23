package es.urjc.ist.hash.main;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import es.urjc.ist.gens.ArrayAleatorio;
import es.urjc.ist.gens.ArrayOrdenado;

public class ArrayTest {
	public static void test_randarray(ArrayAleatorio<Integer> array) {
		Random rand = new Random();
		Integer num;
		
		for(int i = 0; i < 10; i++){
			num = rand.nextInt(11);
			array.put(num);
			if(array.get(i) != num)
				fail();
		}
	}
	
	public static void test_sortedarray(ArrayOrdenado<Integer> sarray) {
		Random rand = new Random();
		Integer num;
		
		for(int i = 0; i < 10; i++){
			num = rand.nextInt(11);
			sarray.put(num);
			if(sarray.get(num) == false)
				fail();
		}
		for(int i = 0; i < 9; i++){
			if(sarray.get(i).compareTo(sarray.get(i+1)) > 0){
				fail();
			}
		}
	}
	
	@Test(timeout=5000)
	public void test() {
		ArrayOrdenado<Integer> sortedarray = new ArrayOrdenado<Integer>();
		ArrayAleatorio<Integer> randarray = new ArrayAleatorio<Integer>();
		
		test_randarray(randarray);
		test_sortedarray(sortedarray);
	}
}
