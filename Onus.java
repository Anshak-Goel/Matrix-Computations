package ap_Assignment3;

import java.util.ArrayList;

public class Onus extends Rectangular{
	private int element; 
	public int getElement() {
		return element;
	}
	public Onus(int rows, int columns, ArrayList<String> types) {
		element = 1;
		this.rows = rows;
		this.columns = columns;
		this.stored_type = "onus";
		this.types = types;
		this.curr_id = id;
		id++;
	}
	public int[][] retrive_matrix(){
		int[][] ret = new int[rows][columns];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				ret[i][j] = 1;
			}
		}
		return ret;
	}

}
