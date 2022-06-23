package ap_Assignment3;

import java.util.ArrayList;

public class Null_matrix extends Rectangular{
	private int element;
	public int getElement() {
		return element;
	}
	public Null_matrix(int rows, int columns, ArrayList<String> types) {
		element = 0;
		this.rows = rows;
		this.columns = columns;
		this.stored_type = "null";
		this.types = types;
		this.curr_id = id;
		id++;
	}
public int[][] retrive_matrix(){
	int[][] ret = new int[rows][columns];
	for(int i=0;i<rows;i++) {
		for(int j=0;j<columns;j++) {
			ret[i][j] = 0;
		}
	}
	return ret;
}

}
