package ap_Assignment3;

import java.util.ArrayList;

public class Diagonal extends Square{
	private int[] elements;
	public int[] getElements() {
		return elements;
	}
	public Diagonal(int rows, ArrayList<String> types,int[][] temp_matrix) {
		elements = new int[rows];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<rows;j++) {
				if(i==j) {
					elements[i] = temp_matrix[i][j];
				}
			}
		}
		this.order = rows;
		this.stored_type = "diagonal";
		this.types = types;
		this.curr_id = id;
		id++;
	}
	public void change_element(int[][] mat, ArrayList<String> types) {
		for(int i=0;i<order;i++) {
			for(int j=0;j<order;j++) {
				if(i==j) {
					elements[i] = mat[i][j];
				}
			}
		}
		this.types = types;
	}
	
	public int[][] retrive_matrix() {
		int[][] ret = new int[order][order];
		int pointer=0;
		for(int i=0;i<order;i++) {
			for(int j=0;j<order;j++) {
				if(i==j) {
					ret[i][j] = elements[pointer];
					pointer++;
				}else {
					ret[i][j] = 0;
				}
			}
		}
		return ret;
	}
}
