package com.algorithm.adjacencymatrix;

import java.util.ArrayList;
import java.util.List;

import com.algorithm.model.Element;

public class AdjacencyMatrix {
	
	private List<AdjacencyMatrixItem> adjacencyMatrix;
	private Element[][] matrix;

	public AdjacencyMatrix (Element[][] matrix){
		this.adjacencyMatrix = new ArrayList<AdjacencyMatrixItem>();
		this.matrix = matrix;
		create();
	}
	
	private void create() {
		for (int x = 0; x < matrix.length; x++){
			for (int y = 0; y < matrix.length; y++){
				Element element = matrix[x][y];
				List<Element> adj = getAdjList(x, y);
				this.adjacencyMatrix.add(new AdjacencyMatrixItem(element, adj));
			}
		}
	}
	
	private List<Element> getAdjList(int x, int y) {
		List<Element> adjList = new ArrayList<Element>();
		Element north = null, south = null, east = null, west = null; 
		try{
			north = this.matrix[x-1][y];
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			south = this.matrix[x+1][y];
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			east = this.matrix[x][y+1];
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			west = this.matrix[x][y-1];
		}catch(ArrayIndexOutOfBoundsException e){}

		if (north != null)
			adjList.add(north);
		if (south != null)
			adjList.add(south);
		if (east != null)
			adjList.add(east);
		if (west != null)
			adjList.add(west);
		
		return adjList;
	}

	public List<AdjacencyMatrixItem> getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	public void setAdjacencyMatrix(List<AdjacencyMatrixItem> adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}
	
	public void print() {
		System.out.println("Print");
		this.adjacencyMatrix.forEach((ami) -> System.out.println(ami));
	}
	
}
