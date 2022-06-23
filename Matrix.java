package ap_Assignment3;

import java.util.ArrayList;

public abstract class Matrix {
	protected static int id = 0;
	protected int curr_id;
	public int getCurr_id() {
		return curr_id;
	}
	protected ArrayList<String> types;
	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}
	protected String stored_type;
	public static int getId() {
		return id;
	}
	public ArrayList<String> getTypes() {
		return types;
	}
	public String getStored_type() {
		return stored_type;
	}
	abstract int[][] retrive_matrix();
	public static float[][] multiply_matrices(float[][] m1, float[][] m2,int r1,int r2,int c2) {		
		float[][] ret = new float[r1][c2];
		for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < r2; k++)
                    ret[i][j] += m1[i][k] * m2[k][j];
            }
        }
		return ret;
	}
	abstract float[] row_wise_mean(Matrix m);
	abstract float[] column_wise_mean(Matrix m);
	abstract float all_element_mean(Matrix m);

}
