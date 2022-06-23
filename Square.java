package ap_Assignment3;

import java.util.ArrayList;

public class Square extends Matrix{
	protected int order;
	protected int[][] sq_matrix;
	
	Square(){
		
	}
	Square(int rows, ArrayList<String> types,int[][] temp_matrix){
		this.sq_matrix = new int[rows][rows];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<rows;j++) {
				sq_matrix[i][j] = temp_matrix[i][j];
			}
		}
		this.order = rows;
		this.stored_type = "square";
		this.types = types;
		this.curr_id = id;
		id++;
	}

	public int[][] retrive_matrix() {
		return sq_matrix;
	}

	public int getOrder() {
		return order;
	}
	
	public static int[][] transpose(int order,int[][] sq_matrix){
		int[][] transposed = new int[order][order];
		for(int i=0;i<order;i++) {
			for(int j=0;j<order;j++) {
				transposed[j][i] = sq_matrix[i][j];
			}
		}
		return transposed;
	}
	
	
	public void change_element(int[][] mat, ArrayList<String> types) {
		for(int i=0;i<order;i++) {
			for(int j=0;j<order;j++) {
				sq_matrix[i][j] = mat[i][j];
			}
		}
		this.types = types;
	}
	
	public static int determinant(int order,int[][] sq_matrix) {
		if(order==1) {
			return sq_matrix[0][0];
		}else if(order ==2) {
			return (sq_matrix[0][0]*sq_matrix[1][1] - sq_matrix[1][0]*sq_matrix[0][1]);
		}else {
			return (sq_matrix[0][0]*(sq_matrix[1][1]*sq_matrix[2][2]-sq_matrix[2][1]*sq_matrix[1][2])
					-sq_matrix[0][1]*(sq_matrix[1][0]*sq_matrix[2][2]-sq_matrix[2][0]*sq_matrix[1][2])
					+sq_matrix[0][2]*(sq_matrix[1][0]*sq_matrix[2][1]-sq_matrix[2][0]*sq_matrix[1][1]));
		}
	}
	
	public static int[][] add_transpose(int order,int[][] sq_matrix,int[][] transpose_matrix){
		int[][] summed_matrix = new int[order][order];
		for(int i=0;i<order;i++) {
			for(int j=0;j<order;j++) {
				summed_matrix[i][j] = sq_matrix[i][j] + transpose_matrix[i][j];
			}
		}
		return summed_matrix;
	}
	public static void element_wise_multiply(Square m1, Square m2) {
		int r1 = m1.getOrder();
		int r2 = m2.getOrder();
		if(r1==r2) {
			int[][] ma1 = m1.retrive_matrix();
			int[][] ma2 = m2.retrive_matrix();
			for(int i=0;i<r1;i++) {
				for(int j=0;j<r2;j++) {
					System.out.print(ma1[i][j]*ma2[i][j]+" ");
				}
				System.out.println();
			}
		}else {
			System.out.println("Cant perform element wise op on these matrices ");
		}
	}
	public static void element_wise_devide(Square m1, Square m2) {
		int r1 = m1.getOrder();
		int r2 = m2.getOrder();
		if(r1==r2) {
			int[][] ma1 = m1.retrive_matrix();
			int[][] ma2 = m2.retrive_matrix();
			for(int i=0;i<r1;i++) {
				for(int j=0;j<r2;j++) {
					System.out.print((float)ma1[i][j]/(float)ma2[i][j]+" ");
				}
				System.out.println();
			}
		}else {
			System.out.println("Cant perform element wise op on these matrices ");
		}
	}
	public static float[][] inverse(Square matrix){
		int[][] mat = matrix.retrive_matrix();
		if(matrix.order==1) {
			float el = 1/mat[0][0];
			float[][] ret = {{el}};
			return ret;
		}else if(matrix.order==2) {
			int val = determinant(2,mat);
			float[][] ret = {{(float)mat[1][1]/(float)val,(float)-mat[0][1]/(float)val},{(float)-mat[1][0]/(float)val,(float)mat[0][0]/(float)val}};	
			return ret;
		}else {
			int val = determinant(3,mat);
			float[][] ret = new float[3][3];
			for(int i=0;i<3;i++){
			      for(int j=0;j<3;j++) {
			           ret[i][j]=(float)(mat[(i+1)%3][(j+1)%3] * mat[(i+2)%3][(j+2)%3]) -(mat[(i+1)%3][(j+2)%3]*mat[(i+2)%3][(j+1)%3])/(float) val;
			      }
			   }
			return ret;
		}
	}
	public int[][] getSq_matrix() {
		return sq_matrix;
	}
	@Override
	float[] row_wise_mean(Matrix m) {
		Square s = (Square) m;
		int[][] mat = s.retrive_matrix();
		int r = s.getOrder();
		float[] ret = new float[s.getOrder()];
		int index =0;
		int value =0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<r;j++) {
				value+=mat[i][j];
			}
			ret[index] = (float)value/(float)r;
			index++;
			value=0;
		}
		return ret;
	}
	@Override
	float[] column_wise_mean(Matrix m) {
		Square s = (Square) m;
		int[][] mat = s.retrive_matrix();
		int r = s.getOrder();
		float[] ret = new float[s.getOrder()];
		int index =0;
		int value =0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<r;j++) {
				value+=mat[j][i];
			}
			ret[index] = (float)value/(float)r;
			index++;
			value=0;
		}
		return ret;
	}
	@Override
	float all_element_mean(Matrix m) {
		Square s = (Square) m;
		int[][] mat = s.retrive_matrix();
		int r = s.getOrder();
		float ret=0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<r;j++) {
				ret+=mat[i][j];
			}
		}
		return ret/(float)(r*r);
	}
	
}
