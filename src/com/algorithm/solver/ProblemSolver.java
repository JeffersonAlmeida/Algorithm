package com.algorithm.solver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.algorithm.adjacencymatrix.AdjacencyMatrixItem;
import com.algorithm.model.Counting;
import com.algorithm.model.Element;

public class ProblemSolver {
	
	private Counting counting;
	private List<AdjacencyMatrixItem> adjMatrix;
	
	public ProblemSolver(List<AdjacencyMatrixItem> adjMatrix) {
		this.counting = new Counting();
		this.adjMatrix = adjMatrix;
	}
	
	public Counting getCounting() {
		return counting;
	}

	public int solution (){
		System.out.println("\nSolution: \n");
		Iterator it = adjMatrix.iterator();
		while (it.hasNext()){
			AdjacencyMatrixItem matrixItem = (AdjacencyMatrixItem) it.next();
			System.out.println(matrixItem.getElement() + " -> " + matrixItem.getAdjMatrixElement());
			recursiveSolution(matrixItem);
			System.out.println("---------------------------");
		}
		return sum();
	}

	private int sum() {
		int sum = 0 ;
		for (Integer value : this.counting.getCountingList().values())
		    sum += value.intValue();
		return sum;
	}

	private void recursiveSolution(AdjacencyMatrixItem matrixItem) {
		System.out.println("\nElement: " + matrixItem+"\n");
		Element currentE = matrixItem.getElement();
		currentE.setExploring(true);
		if (!matrixItem.getElement().isVisited()){
			ArrayList<Element> reducedAdjList = onlyNotExplored(matrixItem);
			Iterator<Element> iterator = reducedAdjList.iterator();
			while(iterator.hasNext()){
				Element adjE = iterator.next();
				if (currentE.getLetter()==adjE.getLetter() && currentE.isTripleEnvolved()){
					adjE.setTripleEnvolved(true);
				}else if (currentE.getLetter()==adjE.getLetter() && !currentE.isTripleEnvolved()){
					currentE.addObserver(adjE);
					adjE.addObserver(currentE);
					boolean update = counting.increaseAuxiliarList(currentE.getLetter());
					if (update){
						currentE.setTripleEnvolved(true);
						adjE.setTripleEnvolved(true);
					}
					AdjacencyMatrixItem adjElementItem = getNextItem(adjE);
					System.out.println("Recursive Solution for element: " + adjElementItem.getElement());
					recursiveSolution(adjElementItem);
				}else if (currentE.getLetter()!=adjE.getLetter()){
					counting.makeDefaulAuxiliarList(currentE.getLetter());
				}
			}
			currentE.setVisited(true);
		}
	}

	private AdjacencyMatrixItem getNextItem(Element adjElement) {
		Iterator<AdjacencyMatrixItem> i = adjMatrix.iterator();
		AdjacencyMatrixItem item = null;
		while (i.hasNext()){
			item = i.next();
			Element element = item.getElement();
			if (element.getX()==adjElement.getX() && element.getY()==adjElement.getY()){
				break;
			}
		}
		return item;
	}

	private ArrayList<Element> onlyNotExplored(AdjacencyMatrixItem matrixItem) {
		ArrayList<Element> reducedAdjList = new ArrayList<>();
		Iterator<Element> adjElements = matrixItem.getAdjMatrixElement().iterator();
		while (adjElements.hasNext()){
			Element e = adjElements.next();
			if (!e.isExploring()){
				reducedAdjList.add(e);
			}
		}
		System.out.println("\nElement: " + matrixItem.getElement() + " reduceAdJList : " + reducedAdjList);
		return reducedAdjList;
	}

}
