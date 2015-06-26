package com.algorithm.adjacencymatrix;

import java.util.List;

import com.algorithm.model.Element;

public class AdjacencyMatrixItem {
	
	private Element element;
	private List<Element> adjMatrixElement;
	
	public AdjacencyMatrixItem(Element element, List<Element> adjMatrixElement) {
		super();
		this.element = element;
		this.adjMatrixElement = adjMatrixElement;
	}
	public Element getElement() {
		return element;
	}
	public void setElement(Element element) {
		this.element = element;
	}
	public List<Element> getAdjMatrixElement() {
		return adjMatrixElement;
	}
	public void setAdjMatrixElement(List<Element> adjMatrixElement) {
		this.adjMatrixElement = adjMatrixElement;
	}
	@Override
	public String toString() {
		return  element
				+ " -> " + adjMatrixElement + "]";
	}
	
}
