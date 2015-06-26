package com.algorithm.observer;

import com.algorithm.model.Element;

public interface Subject {
	void notifyObservers(Element element);
	public void addObserver(Observer obs);
}
