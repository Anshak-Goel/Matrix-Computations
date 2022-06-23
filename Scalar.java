package ap_Assignment3;

import java.util.ArrayList;

public class Scalar extends Square{
	private int element;
	public int getElements() {
		return element;
	}
	public Scalar(int order, ArrayList<String> types,int element) {
		this.element = element;
		this.order = order;
		this.stored_type = "scalar";
		this.types = types;
		this.curr_id = id;
		id++;
	}
	public int[][] retrive_matrix(){
		int[][] ret = new int[order][order];
		for(int i=0;i<order;i++) {
			for(int j=0;j<order;j++) {
				if(i==j) {
					ret[i][j] = element;
				}else {
					ret[i][j] = 0;
				}
			}
		}
		return ret;
	}
}
