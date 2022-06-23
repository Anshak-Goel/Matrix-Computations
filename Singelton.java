package ap_Assignment3;

import java.util.ArrayList;

public class Singelton extends Square{
	private int element;

	public int getElement() {
		return element;
	}
	public Singelton(ArrayList<String> types,int element) {
		this.element = element;
		this.order = 1;
		this.stored_type = "singelton";
		this.types = types;
		this.curr_id = id;
		id++;
	}
	public int[][] retrive_matrix(){
		int[][] ret = {{element}};
		return ret;
	}
	public void change_element(int[][] mat, ArrayList<String> types) {
		element = mat[0][0];
		this.types = types;
	}
}
