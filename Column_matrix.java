package ap_Assignment3;

import java.util.ArrayList;

public class Column_matrix extends Rectangular{
	private int[] elements;
	public int[] getElements() {
		return elements;
	}
	public Column_matrix(int rows, ArrayList<String> types,int[][] temp_matrix) {
		elements = new int[rows];
		for(int i=0;i<rows;i++) {
			elements[i] = temp_matrix[i][0];
		}
		this.rows = rows;
		this.columns = 1;
		this.stored_type = "column_matrix";
		this.types = types;
		this.curr_id = id;
		id++;
	}
	@Override
	public void change_element(int[][] mat, ArrayList<String> types) {
		for(int i=0;i<rows;i++) {
			elements[i] = mat[i][0];
		}
		this.types = types;
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
}
