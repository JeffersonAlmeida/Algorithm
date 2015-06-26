package com.algorithm.filereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.algorithm.model.Element;

public class ReadMatrix {

	private Element matrix[][];
	int x = 0;
	int y = 0;
	private BufferedReader br;
	private static final String INPUT = "../Algorithm/inputs/input.txt";
	
	public ReadMatrix() {
		try {
			FileReader fr = new FileReader(INPUT); 
			br = new BufferedReader(fr); 
		} catch (FileNotFoundException e) {
			e.printStackTrace(); 
		}
		this.matrix = new Element[5][5];
	}
	
	public Element[][] createMatrix() throws IOException{
		String line = "";
		while ( (line = br.readLine()) != null){
			createElemets(line);
			x++;
			y = 0;
		}
		return matrix;
	}
	
	private void createElemets(String line) throws IOException {
		String[] array = line.split(" ");
		for (int i = 0; i < array.length; i++){
			char c = array[i].charAt(0);
			this.matrix [x][y] = new Element(c, x, y);
			y++;
		}
	}

	public static void printArray(Element matrix [][]) {
	    for (Element[] row : matrix) 
	        System.out.println(Arrays.toString(row));       
	} 

	
	public static void main(String [] args) throws IOException{
		Element[][] matrix = new ReadMatrix().createMatrix(); 
		printArray(matrix);
	}
	
	
}