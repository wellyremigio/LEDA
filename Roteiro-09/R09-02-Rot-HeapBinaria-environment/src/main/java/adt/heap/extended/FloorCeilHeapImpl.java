package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;
import util.Util;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer result = null;
		if(array != null) {
			for(Integer n: array) {
				insert(n);
			}
			result = recursiveFloor(numero, result);
		}
		return result;
	}
	
	private Integer recursiveFloor(Double numero, Integer floor) {
		Integer root = extractRootElement();
		
		if(root != null) {
			if(numero >= root && (floor == null || root >= floor)) {
				floor = recursiveFloor(numero, root);
				
			}else {
				floor = recursiveFloor(numero, floor);
			}
		}
		return floor;
		
	}

	
	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer ceil = null;
		
		if(array != null) {
			for(Integer n: array) {
				insert(n);
			}
			ceil = recursiveCeil(numero, ceil);
		}
		return ceil;
	}
	
	private Integer recursiveCeil(Double numero, Integer ceil) {
		Integer root = extractRootElement();
		
		if(root != null) {
			if(numero <= root && (ceil == null || root <= ceil)) {
				ceil = recursiveCeil(numero, root);
				
			}else {
				ceil = recursiveCeil(numero, ceil);
			}
		}
		return ceil;
	}
	
	
	/*
	 * if(position >= 0 && position < this.size()) {
			int largest = position;
			int left = left(position);
			int right = right(position);
			
			if(left <= index && comparator.compare(getHeap()[left], getHeap()[position]) > 0) {
				largest = left;
			}
			
			if(right <= index && comparator.compare(getHeap()[right], getHeap()[largest]) > 0) {
				largest = right;
			}
			
			if(largest != position) {
				Util.swap(getHeap(), position, largest);
				heapify(largest);
			}
		}
		
		
		if(element != null) {
			int i = ++index;
			while(i > 0 && comparator.compare(array[parent(i)], element) < 0){
				array[i] = array[parent(i)];
				i = parent(i);
			}
			array[i] = element;
		}
	 */
}
