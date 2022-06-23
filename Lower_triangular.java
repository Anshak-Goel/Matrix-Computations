package ap_Assignment3;

import java.util.ArrayList;

public class Lower_triangular extends Square{
	private int[] elements;

	public int[] getElements() {
		return elements;
	}
	Lower_triangular(int rows, ArrayList<String> types,int[][] temp_matrix){
		if(rows==2) {
			elements = new int[3];
		}else {
			elements = new int[6];
		}
		int counter = 0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<=i;j++) {
				elements[counter] = temp_matrix[i][j];
				counter++;
			}
		}
		
		this.order = rows;
		this.stored_type = "lower_triangular";
		this.types = types;
		this.curr_id = id;
		id++;
	}
	@Override
	public void change_element(int[][] mat, ArrayList<String> types) {
		int counter = 0;
		for(int i=0;i<order;i++) {
			for(int j=0;j<=i;j++) {
				elements[counter] = mat[i][j];
				counter++;
			}
		}
		this.types = types;
	}
	public int[][] retrive_matrix(){
		int[][] ret = new int[order][order];
		int counter =0;
		for(int i=0;i<order;i++) {
			for(int j=0;j<order;j++) {
				if(i>=j) {
					ret[i][j] = elements[counter];
					counter++;
				}else {
					ret[i][j] = 0;
				}
			}
		}
		return ret;
	}
}
