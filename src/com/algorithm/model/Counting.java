package com.algorithm.model;

import java.util.HashMap;


public class Counting {
	
	private HashMap<Character, Integer> resultList;
	private HashMap<Character, Integer> auxiliarCountingList;
	
	public Counting(){
		
		resultList = new HashMap<Character, Integer>();
		resultList.put('A', 0);
		resultList.put('B', 0);
		resultList.put('C', 0);
		resultList.put('D', 0);
		resultList.put('E', 0);
		
		auxiliarCountingList = new HashMap<Character, Integer>();
		auxiliarCountingList.put('A', 1);
		auxiliarCountingList.put('B', 1);
		auxiliarCountingList.put('C', 1);
		auxiliarCountingList.put('D', 1);
		auxiliarCountingList.put('E', 1);
	}
	
	public boolean increaseAuxiliarList(char letter){
		boolean updateElements = false;
		Character c = Character.valueOf(letter);
		int value = auxiliarCountingList.get(c) + 1;
		auxiliarCountingList.put(c, value);
		if (value == 3){
			resultList.put(c, resultList.get(c) + 1);	
			auxiliarCountingList.put(c, 1);
			updateElements = true;
		}
		System.out.println("auxiliar vector: " + auxiliarCountingList);
		System.out.println("result vector: " + resultList);
		return updateElements;
	}
	
	public void makeDefaulAuxiliarList(char letter){
		Character c = Character.valueOf(letter);
		auxiliarCountingList.put(c, 1);
	}
	
	public HashMap<Character, Integer> getCountingList() {
		return resultList;
	}

	public void print() {
		resultList.forEach(( ch, i) -> System.out.println(ch + ":" + i));
	}
	
}
