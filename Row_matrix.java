package ap_Assignment3;

import java.util.ArrayList;

public class Row_matrix extends Rectangular{
	private int[] elements;
	public int[] getElements() {
		return elements;
	}
	public Row_matrix(int columns, ArrayList<String> types,int[][] temp_matrix) {
		elements = new int[columns];
		for(int i=0;i<columns;i++) {
			elements[i] = temp_matrix[0][i];
		}
		this.columns = columns;
		this.rows = 1;
		this.stored_type = "row_matrix";
		this.types = types;
		this.curr_id = id;
		id++;
	}
	public int[][] retrive_matrix() {
		int[][] ret = new int[rows][columns];
		int pointer=0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				ret[i][j] = elements[pointer];
				pointer++;
			}
		}
		return ret;
	}
	@Override
	public void change_element(int[][] mat, ArrayList<String> types) {
		for(int i=0;i<columns;i++) {
			elements[i] = mat[0][i];
		}
		this.types = types;
	}
}
