package ap_Assignment3;

import java.util.ArrayList;

public class Rectangular extends Matrix {
	protected int rows;
	protected int columns;
	private int[][] rect_matrix;
	public int getRows() {
		return rows;
	}
	public int getColumns() {
		return columns;
	}
	public int[][] retrive_matrix() {
		return rect_matrix;
	}
	Rectangular(){
		
	}
	Rectangular(int rows,int columns,ArrayList<String> types,int[][] temp_matrix){
		rect_matrix = new int[rows][columns];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				rect_matrix[i][j] = temp_matrix[i][j];
			}
		}
		this.rows = rows;
		this.columns = columns;
		this.stored_type = "rectangular";
		this.types = types;
		this.curr_id = id;
		id++;
	}
	public void change_element(int[][] mat, ArrayList<String> types) {
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				rect_matrix[i][j] = mat[i][j];
			}
		}
		this.types = types;
	}
	public static void element_wise_multiply(Rectangular m1, Rectangular m2) {
		int r1 = m1.getRows();
		int c1 = m1.getColumns();
		int r2 = m2.getRows();
		int c2 = m2.getColumns();
		if(r1==r2 && c1==c2) {
			int[][] ma1 = m1.retrive_matrix();
			int[][] ma2 = m2.retrive_matrix();
			for(int i=0;i<r1;i++) {
				for(int j=0;j<c1;j++) {
					System.out.print(ma1[i][j]*ma2[i][j]+" ");
				}
				System.out.println();
			}
		}else {
			System.out.println("Cant perform element wise op on these matrices ");
		}
	}
	public static void element_wise_devide(Rectangular m1, Rectangular m2) {
		int r1 = m1.getRows();
		int c1 = m1.getColumns();
		int r2 = m2.getRows();
		int c2 = m2.getColumns();
		if(m2 instanceof Null_matrix) {
			return;
		}
		if(r1==r2 && c1==c2) {
			int[][] ma1 = m1.retrive_matrix();
			int[][] ma2 = m2.retrive_matrix();
			for(int i=0;i<r1;i++) {
				for(int j=0;j<c1;j++) {
					System.out.print((float)ma1[i][j]/(float)ma2[i][j]+" ");
				}
				System.out.println();
			}
		}else {
			System.out.println("Cant perform element wise op on these matrices ");
		}
	}
	public static int[][] transpose(int row,int column,int[][] rect_matrix){
		int[][] transposed = new int[column][row];
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				transposed[j][i] = rect_matrix[i][j];
			}
		}
		return transposed;
	}
	@Override
	float[] row_wise_mean(Matrix m) {
		Rectangular s = (Rectangular) m;
		int[][] mat = s.retrive_matrix();
		int r = s.getRows();
		int c = s.getColumns();
		float[] ret = new float[s.getRows()];
		int index =0;
		int value =0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				value+=mat[i][j];
			}
			ret[index] = (float)value/(float)c;
			index++;
			value=0;
		}
		return ret;
	}
	@Override
	float[] column_wise_mean(Matrix m) {
		Rectangular s = (Rectangular) m;
		int[][] mat = s.retrive_matrix();
		int r = s.getRows();
		int c = s.getColumns();
		float[] ret = new float[s.getColumns()];
		int index =0;
		int value =0;
		for(int i=0;i<c;i++) {
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
		Rectangular s = (Rectangular) m;
		int[][] mat = s.retrive_matrix();
		int r = s.getRows();
		int c = s.getColumns();
		float ret=0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				ret+=mat[i][j];
			}
		}
		return ret/(float)(r*c);
	}
}
