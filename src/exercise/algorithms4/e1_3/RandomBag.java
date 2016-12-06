package exercise.algorithms4.e1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomBag<T> implements Iterable<T>{

	private int n;
	private T[] bag;
	public RandomBag(int cap){
		bag = (T[]) new Object[cap];
		n = 0;
	}
	public boolean isEmpty(){
		return n == 0;
	}
	public int size(){
		return n;
	}
	public void add(T value){
		if(n == bag.length) resize(bag.length * 2);;
		bag[n++] = value;
	}
	private void resize(int newCap){
		T[] newBag = (T[]) new Object[newCap];
		for(int i = 0; i < n; i++){
			newBag[i] = bag[i];
		}
		bag = newBag;
	}
	@Override
	public Iterator<T> iterator() {
		return new RandomBagIterator();
	}
	
	private class RandomBagIterator implements Iterator<T>{

		int i = 0;
		T[] randomBag;
		public RandomBagIterator(){
			randomBag = (T[]) new Object[n];
			for(int i = 0; i < n; i++){
				randomBag[i] = bag[i];
			}
			for(int i = 0; i < n; i++){
				int j = StdRandom.uniform(i, n);
				T temp = randomBag[i];
				randomBag[i] = randomBag[j];
				randomBag[j] = temp;
			}
		}
		
		@Override
		public boolean hasNext() {
			return i < n;
		}

		@Override
		public T next() {
			if(!hasNext()) throw new NoSuchElementException();
			return randomBag[i++];
		}
		
	}
}
