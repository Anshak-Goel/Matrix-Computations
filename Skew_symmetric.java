package ap_Assignment3;

import java.util.ArrayList;

public class Skew_symmetric extends Square{
	Skew_symmetric(int rows, ArrayList<String> types,int[][] temp_matrix){
		this.sq_matrix = new int[rows][rows];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<rows;j++) {
				sq_matrix[i][j] = temp_matrix[i][j];
			}
		}
		this.order = rows;
		this.stored_type = "skew_symmetric";
		this.types = types;
		this.curr_id = id;
		id++;
	}
}
