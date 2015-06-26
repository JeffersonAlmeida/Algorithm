package com.algorithm.model;

import java.util.ArrayList;
import java.util.List;

import com.algorithm.observer.Observer;
import com.algorithm.observer.Subject;

public class Element implements Subject , Observer{
	
	private List<Observer> elementObservers;
	
	private int x, y;
	private char letter;
	private boolean visited;
	private boolean exploring;
	
	private boolean tripleEnvolved;
	
	private int count;

	public Element(char c, int x, int y) {
		this.letter = c;
		visited = false;
		exploring = false;
		tripleEnvolved = false;
		count = 1;
		this.x = x;
		this.y = y;
		this.elementObservers = new ArrayList<Observer>();
	}

	public boolean isExploring() {
		return exploring;
	}

	public void setExploring(boolean exploring) {
		this.exploring = exploring;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		String t = letter + "(" + x + "," + y + ")";
		return t;
	}
	
	public boolean isTripleEnvolved() {
		return tripleEnvolved;
	}

	public void setTripleEnvolved(boolean tripleEnvolved) {
		this.tripleEnvolved = tripleEnvolved;
		notifyObservers(this);
	}

	@Override
	public void notifyObservers(Element element) {
		for (Observer o: elementObservers){
			Element e = ((Element)o);
			if (!e.tripleEnvolved){
				o.update(element);
				System.out.println("Updated Element: " + e.toString() + "envolved: " + e.tripleEnvolved);
			}
		}
	}

	@Override
	public void addObserver(Observer obs) {
		this.elementObservers.add(obs);
	}
	
	@Override
	public void update(Element element) {
		setTripleEnvolved(true);
	}

	public List<Observer> getObservers() {
		return elementObservers;
	}

}
