package com.algorithm.main;

import java.io.IOException;

import com.algorithm.adjacencymatrix.AdjacencyMatrix;
import com.algorithm.filereader.ReadMatrix;
import com.algorithm.model.Element;
import com.algorithm.solver.ProblemSolver;

public class Main {
	
	public static void main(String[] args) {
		Element[][] matrix = null;
		AdjacencyMatrix adjMatrix = null;
		try {
			matrix = new ReadMatrix().createMatrix();
			adjMatrix = new AdjacencyMatrix(matrix);
			adjMatrix.print();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		ProblemSolver problemSolver = new ProblemSolver(adjMatrix.getAdjacencyMatrix());
		System.out.println("\n\nSOLUTION: "+ problemSolver.solution()+"\n\n");
		problemSolver.getCounting().print();
	}
}
