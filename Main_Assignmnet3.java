package ap_Assignment3;
import java.util.*;

public class Main_Assignmnet3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Matrix> matrices = new ArrayList<Matrix>();
		while(true) {
			menu();
			System.out.println("Which query do you want to perform: ");
			int query_code = sc.nextInt();
			if(query_code==1) {
				System.out.println("Enter the numner of rows in your matrix: ");
				int rows = sc.nextInt();
				System.out.println("Enter the numner of columns in your matrix: ");
				int columns = sc.nextInt();
				int[][] temp_matrix = new int[rows][columns];
				for(int i=0;i<rows;i++) {
					System.out.println("Enter the elements of Row "+(i+1));
					for(int j=0;j<columns;j++) {
						temp_matrix[i][j] = sc.nextInt();
					}
				}
				ArrayList<String> labels = assign_labels(rows,columns,temp_matrix);
				if(labels.contains("singelton")) {
					Matrix temp = new Singelton(labels,temp_matrix[0][0]);
					matrices.add(temp);
				}else if(labels.contains("null")) {
					Matrix temp = new Null_matrix(rows, columns, labels);
					matrices.add(temp);
				}else if(labels.contains("identity")) {
					Matrix temp = new Identity(rows, labels);
					matrices.add(temp);
				}else if(labels.contains("scalar")) {
					Matrix temp = new Scalar(rows, labels,temp_matrix[0][0]);
					matrices.add(temp);
				}else if(labels.contains("diagonal")) {
					Matrix temp = new Diagonal(rows, labels,temp_matrix);
					matrices.add(temp);
				}else if(labels.contains("onus")) {
					Matrix temp = new Onus(rows, columns, labels);
					matrices.add(temp);
				}else if(labels.contains("row_matrix")) {
					Matrix temp = new Row_matrix(columns, labels, temp_matrix);
					matrices.add(temp);
				}else if(labels.contains("column_matrix")) {
					Matrix temp = new Column_matrix(rows, labels, temp_matrix);
					matrices.add(temp);
				}else if(labels.contains("upper_triangular")) {
					Matrix temp = new Upper_triangular(rows, labels, temp_matrix);
					matrices.add(temp);
				}else if(labels.contains("lower_triangular")) {
					Matrix temp = new Lower_triangular(rows, labels, temp_matrix);
					matrices.add(temp);
				}else if(labels.contains("symmetric")) {
					Matrix temp = new Symmetric(rows, labels,temp_matrix);
					matrices.add(temp);
				}else if(labels.contains("skew_symmetric")) {
					Matrix temp = new Skew_symmetric(rows, labels,temp_matrix);
					matrices.add(temp);
				}else if(labels.contains("singular")) {
					Matrix temp = new Singular(rows, labels,temp_matrix);
					matrices.add(temp);
				}else if(labels.contains("square")) {
					Matrix temp = new Square(rows, labels,temp_matrix);
					matrices.add(temp);
				}else {
					Matrix temp = new Rectangular(rows,columns, labels,temp_matrix);
					matrices.add(temp);
				}
			}else if(query_code==2) {
				matrix_menu();
				System.out.println("Which of the following type of matrix you want to create: ");
				int matrix_id = sc.nextInt();
				if(matrix_id==1) {
					int rows =2;
					int columns =3;
					ArrayList<String> labels = new ArrayList<String>();
					labels.add("rectangular");
					int[][] temp_matrix = {{1,2,3},{4,5,6}};
					Matrix temp = new Rectangular(rows,columns, labels,temp_matrix);
					matrices.add(temp);
				}else if(matrix_id==2) {
					int columns = 2;
					ArrayList<String> labels = new ArrayList<String>();
					labels.add("rectangular");
					labels.add("row_matrix");
					int[][] temp_matrix = {{1,2}};
					Matrix temp = new Row_matrix(columns, labels, temp_matrix);
					matrices.add(temp);
				}else if(matrix_id==3) {
					int rows = 2;
					ArrayList<String> labels = new ArrayList<String>();
					labels.add("rectangular");
					labels.add("column_matrix");
					int[][] temp_matrix = {{1},{2}};
					Matrix temp = new Column_matrix(rows, labels, temp_matrix);
					matrices.add(temp);
				}else if(matrix_id==4) {
					int rows =2;
					ArrayList<String> labels = new ArrayList<String>();
					labels.add("rectangular");
					labels.add("square");
					int[][] temp_matrix = {{1,2},{3,4}};
					Matrix temp = new Square(rows, labels,temp_matrix);
					matrices.add(temp);
				}else if(matrix_id==5) {
					int rows =2;
					ArrayList<String> labels = new ArrayList<String>();
					labels.add("rectangular");
					labels.add("square");
					labels.add("symmetric");
					int[][] temp_matrix = {{5,3},{3,7}};
					Matrix temp = new Symmetric(rows, labels,temp_matrix);
					matrices.add(temp);
				}else if(matrix_id==6) {
					int rows =2;
					ArrayList<String> labels = new ArrayList<String>();
					labels.add("rectangular");
					labels.add("square");
					labels.add("skew_symmetric");
					int[][] temp_matrix = {{0,3},{-3,0}};
					Matrix temp = new Skew_symmetric(rows, labels,temp_matrix);
					matrices.add(temp);
				}else if(matrix_id==7) {
					int rows =2;
					ArrayList<String> labels = new ArrayList<String>();
					labels.add("rectangular");
					labels.add("square");
					labels.add("upper_triangular");
					int[][] temp_matrix = {{2,3},{0,4}};
					Matrix temp = new Upper_triangular(rows, labels,temp_matrix);
					matrices.add(temp);
				}else if(matrix_id==8) {
					int rows =2;
					ArrayList<String> labels = new ArrayList<String>();
					labels.add("rectangular");
					labels.add("square");
					labels.add("lower_triangular");
					int[][] temp_matrix = {{2,0},{3,4}};
					Matrix temp = new Lower_triangular(rows, labels,temp_matrix);
					matrices.add(temp);
				}else if(matrix_id==9) {
					int rows =2;
					ArrayList<String> labels = new ArrayList<String>();
					labels.add("rectangular");
					labels.add("square");
					labels.add("singular");
					int[][] temp_matrix = {{6,4},{3,2}};
					Matrix temp = new Singular(rows, labels,temp_matrix);
					matrices.add(temp);
				}else if(matrix_id==10) {
					int rows =2;
					ArrayList<String> labels = new ArrayList<String>();
					labels.add("rectangular");
					labels.add("square");
					labels.add("symmetric");
					labels.add("diagonal");
					int[][] temp_matrix = {{3,0},{0,5}};
					Matrix temp = new Diagonal(rows, labels,temp_matrix);
					matrices.add(temp);
				}else if(matrix_id==11) {
					int rows =2;
					ArrayList<String> labels = new ArrayList<String>();
					labels.add("rectangular");
					labels.add("square");
					labels.add("symmetric");
					labels.add("diagonal");
					labels.add("scalar");
					int[][] temp_matrix = {{5,0},{0,5}};
					Matrix temp = new Scalar(rows, labels,temp_matrix[0][0]);
					matrices.add(temp);
				}else if(matrix_id==12) {
					int rows =2;
					ArrayList<String> labels = new ArrayList<String>();
					labels.add("rectangular");
					labels.add("square");
					labels.add("diagonal");
					labels.add("scalar");
					labels.add("symmetric");
					labels.add("identity");
					Matrix temp = new Identity(rows, labels);
					matrices.add(temp);
				}else if(matrix_id==13) {
					ArrayList<String> labels = new ArrayList<String>();
					labels.add("rectangular");
					labels.add("square");
					labels.add("symmetric");
					labels.add("diagonal");
					labels.add("scalar");
					labels.add("upper_triangular");
					labels.add("lower_triangular");
					labels.add("singelton");
					Matrix temp = new Singelton( labels,8);
					matrices.add(temp);
				}else if(matrix_id==14) {
					int rows =2;
					int columns =3;
					ArrayList<String> labels = new ArrayList<String>();
					labels.add("rectangular");
					labels.add("onus");
					Matrix temp = new Onus(rows,columns, labels);
					matrices.add(temp);
				}else if(matrix_id==15) {
					int rows =2;
					int columns =3;
					ArrayList<String> labels = new ArrayList<String>();
					labels.add("rectangular");
					labels.add("null");
					Matrix temp = new Null_matrix(rows,columns, labels);
					matrices.add(temp);
				}else {
					System.out.println("Not a valid code! ");
				}
			}else if(query_code==3) {
				System.out.println("Enter the matrix id ranging form 0 to "+(matrices.size()-1)+" whose element you want to change: ");
				int which_matrix = sc.nextInt();
				int[][] mat = matrices.get(which_matrix).retrive_matrix();
				String which_type = matrices.get(which_matrix).getStored_type();
				if(matrices.get(which_matrix) instanceof Square) {
					Square m = (Square) matrices.get(which_matrix);
					System.out.println("The choosen matrix is of order: "+m.getOrder()+"*"+m.getOrder());
					System.out.println("Choose the row you want to change element of: ");
					int ro = sc.nextInt();
					System.out.println("Choose the column you want to change element of: ");
					int co = sc.nextInt();
					int save = mat[ro-1][co-1];
					System.out.println("Enter the element you want to replace with: ");
					int rep = sc.nextInt();
					mat[ro-1][co-1] = rep;
					ArrayList<String> temp_types = assign_labels(m.getOrder(),m.getOrder(),mat);
					if(temp_types.contains(which_type)) {
						m.change_element(mat, temp_types);
					}else {
						mat[ro-1][co-1] = save;
						System.out.println("Element cant be changed as it will change the matrix type ");
					}
				}else {
					Rectangular m = (Rectangular) matrices.get(which_matrix);
					System.out.println("The choosen matrix is of order : "+m.getRows()+"*"+m.getColumns());
					System.out.println("Choose the row you want to change element of: ");
					int ro = sc.nextInt();
					System.out.println("Choose the column you want to change element of: ");
					int co = sc.nextInt();
					int save = mat[ro][co];
					System.out.println("Enter the element you want to replace with: ");
					int rep = sc.nextInt();
					mat[ro][co] = rep;
					ArrayList<String> temp_types = assign_labels(m.getRows(),m.getColumns(),mat);
					if(temp_types.contains(which_type)) {
						m.change_element(mat, temp_types);
					}else {
						mat[ro][co] = save;
						System.out.println("Element cant be changed as it will change the matrix type ");
					}
				}
				
			}else if(query_code==4) {
				System.out.println("Enter the matrix id ranging form 0 to "+(matrices.size()-1)+" whose types you want to know: ");
				int which_matrix = sc.nextInt();
				if(which_matrix>=0 && which_matrix<matrices.size()) {
					System.out.println("Matrix id "+which_matrix+" belong to these matrix types: ");
					ArrayList<String> matrix_label = matrices.get(which_matrix).getTypes();
					for(int k=0;k<matrix_label.size();k++) {
						System.out.println(matrix_label.get(k));
					}
				}else {
					System.out.println("Not a valid matrix id !");
				}
			}else if(query_code==5) {
				System.out.println("What type of operation do you want to perform: ");
				System.out.println("1. Addition");
				System.out.println("2. Subtraction");
				System.out.println("3. Multiplication");
				System.out.println("4. Division");
				int op_code = sc.nextInt();
				if(op_code==1 || op_code==2) {
					System.out.println("Enter 2 matrix id's ranging form 0 to "+(matrices.size()-1)+" upon which operation shall be performed: ");
					int id1 = sc.nextInt();
					int id2 = sc.nextInt();
					Matrix mat1 = matrices.get(id1);
					Matrix mat2 = matrices.get(id2);
					int[][] m1 = mat1.retrive_matrix();
					int[][] m2 = mat2.retrive_matrix();
					int r1 = m1.length;
					int c1 = m1[0].length;
					int r2 = m2.length;
					int c2 = m2[0].length;
					if(r1==r2 && c1==c2) {
						for(int g=0;g<r1;g++) {
							for(int h=0;h<c1;h++) {
								if(op_code==1) {
									System.out.print(m1[g][h]+m2[g][h]+" ");
								}else {
									System.out.print(m1[g][h]-m2[g][h]+" ");
								}
							}
							System.out.println();
						}
					}else {
						System.out.println("Not possible as dimensions are not same ");
					}
				}else if(op_code==3) {
					System.out.println("Enter 2 matrix id's ranging form 0 to "+(matrices.size()-1)+" upon which multiplication shall be performed: ");
					int id1 = sc.nextInt();
					int id2 = sc.nextInt();
					Matrix mat1 = matrices.get(id1);
					Matrix mat2 = matrices.get(id2);
					int[][] m1 = mat1.retrive_matrix();
					int[][] m2 = mat2.retrive_matrix();
					int r1 = m1.length;
					int c1 = m1[0].length;
					int r2 = m2.length;
					int c2 = m2[0].length;
					if(c1==r2) {
						if(mat1 instanceof Null_matrix || mat2 instanceof Null_matrix) {
							for(int g=0;g<r1;g++) {
								for(int h=0;h<c2;h++) {
									System.out.print(0+" ");
								}
								System.out.println();
							}
						}else {
							float[][] ret = Matrix.multiply_matrices(type_cast(m1), type_cast(m2), r1, r2, c2);
							for(int g=0;g<r1;g++) {
								for(int h=0;h<c2;h++) {
									System.out.print(ret[g][h]+" ");
								}
								System.out.println();
							}
						}
					}else {
						System.out.println("These 2 matrices cannot be multiplied ");
					}
				}else if(op_code==4) {
					System.out.println("Enter 2 matrix id's ranging form 0 to "+(matrices.size()-1)+" upon which division shall be performed: ");
					int id1 = sc.nextInt();
					int id2 = sc.nextInt();
					Matrix mat1 = matrices.get(id1);
					Matrix mat2 = matrices.get(id2);
					int[][] m1 = mat1.retrive_matrix();
					if(!(mat2 instanceof Square)) {
						System.out.println("Cant perform division on these 2 matrices ");
					}else {
						if(!(mat2 instanceof Singular)) {
							float[][] m2 = Square.inverse((Square)mat2);
							int r1 = m1.length;
							int c1 = m1[0].length;
							int r2 = m2.length;
							int c2 = m2[0].length;
							if(c1==r2) {
								if(mat1 instanceof Null_matrix) {
									for(int g=0;g<r1;g++) {
										for(int h=0;h<c2;h++) {
											System.out.print(0+" ");
										}
										System.out.println();
									}
								}else {
									float[][] ret = Matrix.multiply_matrices(type_cast(m1), m2, r1, r2, c2);
									for(int g=0;g<r1;g++) {
										for(int h=0;h<c2;h++) {
											System.out.print(ret[g][h]+" ");
										}
										System.out.println();
									}
								}
							}else {
								System.out.println("These 2 matrices cannot be multiplied ");
							}
						}else {
							System.out.println("Cant perform division on these 2 matrices ");
						}
					}
				}
			}else if(query_code==6) {
				System.out.println("What type of operation do you want to perform: ");
				System.out.println("1. Multiplication");
				System.out.println("2. Division");
				int op_code = sc.nextInt();
				if(op_code==1 || op_code==2) {
					System.out.println("Enter 2 matrix id's ranging form 0 to "+(matrices.size()-1)+" upon which operation shall be performed: ");
					int id1 = sc.nextInt();
					int id2 = sc.nextInt();
					Matrix mat1 = matrices.get(id1);
					Matrix mat2 = matrices.get(id2);
					if(mat1 instanceof Square && mat2 instanceof Square) {
						Square m1 = (Square) mat1;
						Square m2 = (Square) mat2;
						if(op_code==1) {
							Square.element_wise_multiply(m1,m2);
						}else {
							Square.element_wise_devide(m1,m2);
						}
					}else if(!(mat1 instanceof Square) && !(mat2 instanceof Square)) {
						Rectangular m1 = (Rectangular) mat1;
						Rectangular m2 = (Rectangular) mat2;
						if(op_code==1) {
							Rectangular.element_wise_multiply(m1,m2);
						}else {
							Rectangular.element_wise_devide(m1,m2);
						}
					}else {
						System.out.println("Cant perform operation ");
					}
				}else {
					System.out.println("Not a valid operation code ");
				}
			}else if(query_code==7) {
				System.out.println("Enter the matrix id ranging form 0 to "+(matrices.size()-1)+" which shall be transposed: ");
				int which_matrix = sc.nextInt();
				if(matrices.get(which_matrix) instanceof Square) {
					Square mat = (Square)matrices.get(which_matrix);
					int[][] trans = Square.transpose(mat.getOrder(), mat.retrive_matrix());
					for(int g=0;g<mat.getOrder();g++) {
						for(int l=0;l<mat.getOrder();l++) {
							System.out.print(trans[g][l]+" ");
						}
						System.out.println();
					}
				}else {
					Rectangular mat = (Rectangular)matrices.get(which_matrix);
					int[][] trans = Rectangular.transpose(mat.getRows(),mat.getColumns(), mat.retrive_matrix());
					for(int g=0;g<mat.getColumns();g++) {
						for(int l=0;l<mat.getRows();l++) {
							System.out.print(trans[g][l]+" ");
						}
						System.out.println();
					}
				}
			}else if(query_code==8) {
				System.out.println("Enter the matrix id ranging form 0 to "+(matrices.size()-1)+" which shall be inverted: ");
				int which_matrix = sc.nextInt();
				if(matrices.get(which_matrix) instanceof Square && !(matrices.get(which_matrix) instanceof Singular)) {
					Square mat = (Square)matrices.get(which_matrix);
					float[][] invert = Square.inverse(mat);
					for(int g=0;g<mat.getOrder();g++) {
						for(int l=0;l<mat.getOrder();l++) {
							System.out.print(invert[g][l]+" ");
						}
						System.out.println();
					}
				}else {
					System.out.println("This matrix cannot be inverted ");
				}
			}else if(query_code==9) {
				System.out.println("Enter the matrix id ranging form 0 to "+(matrices.size()-1)+" on which operation shall be performed: ");
				int which_matrix = sc.nextInt();
				System.out.println("Choose operation: ");
				System.out.println("1. Row wise mean ");
				System.out.println("2. Column wise mean ");
				System.out.println("3. Mean of all elements ");
				int op_code = sc.nextInt();
				if(op_code==1) {
					Matrix m = matrices.get(which_matrix);
					float[] ans = m.row_wise_mean(m);
					for(int k=0;k<ans.length;k++) {
						System.out.print(ans[k]+" ");
					}
					System.out.println();
				}else if(op_code==2) {
					Matrix m = matrices.get(which_matrix);
					float[] ans = m.column_wise_mean(m);
					for(int k=0;k<ans.length;k++) {
						System.out.print(ans[k]+" ");
					}
					System.out.println();
				}else if(op_code==3) {
					Matrix m = matrices.get(which_matrix);
					float ans = m.all_element_mean(m);
					System.out.println(ans);
				}else {
					System.out.println("Not a valid Operation code ");
				}
			}else if(query_code==10) {
				System.out.println("Enter the matrix id ranging form 0 to "+(matrices.size()-1)+" whose determinant to be calculated: ");
				int which_matrix = sc.nextInt();
				if(matrices.get(which_matrix) instanceof Square) {
					Square mat = (Square)matrices.get(which_matrix);
					if(mat instanceof Diagonal) {
						Diagonal mat_d = (Diagonal) mat;
						int[] elements = mat_d.getElements();
						int val = 1;
						for(int i=0;i<elements.length;i++) {
							val=val*elements[i];
						}
						System.out.println(val);
					}else if(mat instanceof Scalar) {
						Scalar mat_s = (Scalar) mat;
						int val =1;
						int v = mat_s.getElements();
						for(int i=0;i<mat.getOrder();i++) {
							val=val*v;
						}
						System.out.println(val);
					}else {
						int val = Square.determinant(mat.getOrder(), mat.retrive_matrix());
						System.out.println(val);
					}
				}else {
					System.out.println("This matrix cannot be inverted ");
				}
			}else if(query_code==11) {
				System.out.println("From ids 0 to "+(matrices.size()-1)+" choose a singelton matirix id which shall be used as a scalar: ");
				int id_s = sc.nextInt();
				if(matrices.get(id_s) instanceof Singelton) {
					Singelton t = (Singelton) matrices.get(id_s);
					int value = t.getElement();
					System.out.println("Choose another matrix id now: ");
					int id_mat = sc.nextInt();
					System.out.println("Choose operation: ");
					System.out.println("1. Multiplication ");
					System.out.println("2. Division");
					int op = sc.nextInt();
					if(op==1 || op==2) {
						if(matrices.get(id_mat) instanceof Square) {
							Square mat = (Square) matrices.get(id_s);
							int[][] m = mat.retrive_matrix();
							for(int i=0;i<mat.getOrder();i++) {
								for(int j=0;j<mat.getOrder();j++) {
									if(op==1) {
										System.out.print(value*m[i][j]+" ");
									}else {
										System.out.print((float)value/(float)m[i][j]+" ");
									}
								}
								System.out.println();
							}
						}else {
							Rectangular mat = (Rectangular) matrices.get(id_mat);
							int[][] m = mat.retrive_matrix();
							for(int i=0;i<mat.getRows();i++) {
								for(int j=0;j<mat.getColumns();j++) {
									if(op==1) {
										System.out.print(value*m[i][j]+" ");
									}else {
										System.out.print((float)value/(float)m[i][j]+" ");
									}
								}
								System.out.println();
							}
						}
					}else {
						System.out.println("Not a valid operation code ");
					}
				}else {
					System.out.println("You have not entered the id of a Singelton matrix ");
				}
			}else if(query_code==12) {
				System.out.println("Enter the matrix id ranging form 0 to "+(matrices.size()-1)+" for which A+AT shall be calculated: ");
				int which_matrix = sc.nextInt();
				if(matrices.get(which_matrix) instanceof Square) {
					Square mat = (Square)matrices.get(which_matrix);
					int[][] added = Square.add_transpose(mat.getOrder(), mat.retrive_matrix(), Square.transpose(mat.getOrder(), mat.retrive_matrix()));
					for(int g=0;g<mat.getOrder();g++) {
						for(int l=0;l<mat.getOrder();l++) {
							System.out.print(added[g][l]+" ");
						}
						System.out.println();
					}
				}else {
					System.out.println("This matrix cannot be inverted ");
				}
			}else if(query_code==13) {
				System.out.println("Enter the matrix id ranging form 0 to "+(matrices.size()-1)+" for which you want eigen vector and value: ");
				int which_matrix = sc.nextInt();
				Matrix mat = matrices.get(which_matrix);
				if(mat instanceof Square) {
					Square m = (Square) mat;
					if(m.getOrder()==1) {
						System.out.println("Eigen value: "+m.retrive_matrix()[0][0]);
						System.out.println("Eigen vector can be any singelton matrix here ");
					}else if(m.getOrder()==2) {
						int[][] sq = m.retrive_matrix();
						int[] quad = new int[3];
						quad[0] =1;
						quad[1] = sq[0][0]+sq[1][1];
						quad[2] = sq[0][0]*sq[1][1]-sq[1][0]*sq[0][1];
						float[] ans = quadratic(quad);
						if(ans[2]==0) {
							System.out.println("For Eigen value: "+(-ans[0]));
							float a1 = sq[0][0]+ans[0];
							float b1 = sq[0][1];
							float a2 = sq[1][0];
							float b2 = sq[1][1]+ans[0];	
							if(a1+b1==0) {
								System.out.println("Eigen vector: ");
								System.out.println(-b1+" "+a1);
							}else if(a2+b2==0) {
								System.out.println("Eigen vector: ");
								System.out.println(-b2+" "+a2);
							}else if(a1/b1==a2/b2) {
								System.out.println("Eigen vector: ");
								System.out.println(-b1+" "+a1);	
							}						
							if(ans[1]!=ans[0]) {
								System.out.println("For Eigen value: "+(-ans[1]));
								float k1 = sq[0][0]+ans[1];
								float m1 = sq[0][1];
								float k2 = sq[1][0];
								float m2 = sq[1][1]+ans[1];
								if(k1+m1==0) {
									System.out.println("Eigen vector: ");
								    System.out.println(-m1+" "+k1);
								}else if(k2+m2==0) {
									System.out.println("Eigen vector: ");
								    System.out.println(-m2+" "+k2);
								}else if(k1/m1==k2/m2) {
								    System.out.println("Eigen vector: ");
								    System.out.println(-m1+" "+k1);
								}
							}
						}
					}else {
						System.out.println("Not of appropriate order ");
					}
				}else {
					System.out.println("Eigen vector or value is not possible here ");
				}
			}else if(query_code==14) {
				System.out.println("Solve a set of linear equation ");
				System.out.println("Choose a square matrix from matrix ids ranging from 0 to "+(matrices.size()-1));
				int sid = sc.nextInt();
				if(matrices.get(sid) instanceof Square) {
					Square smat = (Square) matrices.get(sid);
					System.out.println("Choose a column matrix from matrix ids ranging from 0 to "+(matrices.size()-1));
					System.out.println("Note: this should have same number of rows as the one you\r\n"
							+ "entered just now ");
					int cid = sc.nextInt();
					if(matrices.get(cid) instanceof Column_matrix) {
						Rectangular cmat = (Rectangular) matrices.get(cid);
						if(cmat.getRows()==smat.getOrder()) {
							if(!(smat instanceof Singular)){
								float[][] invert = Square.inverse(smat);
								float[][] ans = Matrix.multiply_matrices(invert, type_cast(matrices.get(cid).retrive_matrix()),smat.getOrder(),smat.getOrder(),cmat.getColumns());
								print_matrix(ans,cmat.getColumns(),cmat.getRows());
							}else {
								System.out.println("Cant do it for a singular matrix ");
							}
						}else {
							System.out.println("Chosen matrix id is not appropriate for the operation ");
						}
					}else {
						System.out.println("Chosen matrix id is not appropriate for the operation ");
					}
				}else {
					System.out.println("Chosen matrix id is not of a square matrix type ");
				}
			}else if(query_code==15) {
				System.out.println("Choose the matrix type which should be retrived: ");
				matrix_menu();
				int op_code = sc.nextInt();
				if(op_code==1) {
					for(int i=0;i<matrices.size();i++) {
						if(matrices.get(i).getTypes().contains("rectangular")) {
							Rectangular mat = (Rectangular) matrices.get(i);
							print_matrix(mat.retrive_matrix(),mat.getColumns(),mat.getRows());
							System.out.println();
						}
					}
				}else if(op_code==2) {
					for(int i=0;i<matrices.size();i++) {
						if(matrices.get(i).getTypes().contains("row_matrix")) {
							Rectangular mat = (Rectangular) matrices.get(i);
							print_matrix(mat.retrive_matrix(),mat.getColumns(),mat.getRows());
							System.out.println();
						}
					}
				}else if(op_code==3) {
					for(int i=0;i<matrices.size();i++) {
						if(matrices.get(i).getTypes().contains("column_matrix")) {
							Rectangular mat = (Rectangular) matrices.get(i);
							print_matrix(mat.retrive_matrix(),mat.getColumns(),mat.getRows());
							System.out.println();
						}
					}
				}else if(op_code==4) {
					for(int i=0;i<matrices.size();i++) {
						if(matrices.get(i).getTypes().contains("square")) {
							Square mat = (Square) matrices.get(i);
							print_matrix(mat.retrive_matrix(),mat.getOrder(),mat.getOrder());
							System.out.println();
						}
					}
				}else if(op_code==5) {
					for(int i=0;i<matrices.size();i++) {
						if(matrices.get(i).getTypes().contains("symmetric")) {
							Square mat = (Square) matrices.get(i);
							print_matrix(mat.retrive_matrix(),mat.getOrder(),mat.getOrder());
							System.out.println();
						}
					}
				}else if(op_code==6) {
					for(int i=0;i<matrices.size();i++) {
						if(matrices.get(i).getTypes().contains("skew_symmetric")) {
							Square mat = (Square) matrices.get(i);
							print_matrix(mat.retrive_matrix(),mat.getOrder(),mat.getOrder());
							System.out.println();
						}
					}
				}else if(op_code==7) {
					for(int i=0;i<matrices.size();i++) {
						if(matrices.get(i).getTypes().contains("upper_triangular")) {
							Square mat = (Square) matrices.get(i);
							print_matrix(mat.retrive_matrix(),mat.getOrder(),mat.getOrder());
							System.out.println();
						}
					}
				}else if(op_code==8) {
					for(int i=0;i<matrices.size();i++) {
						if(matrices.get(i).getTypes().contains("lower_triangular")) {
							Square mat = (Square) matrices.get(i);
							print_matrix(mat.retrive_matrix(),mat.getOrder(),mat.getOrder());
							System.out.println();
						}
					}
				}else if(op_code==9) {
					for(int i=0;i<matrices.size();i++) {
						if(matrices.get(i).getTypes().contains("singular")) {
							Square mat = (Square) matrices.get(i);
							print_matrix(mat.retrive_matrix(),mat.getOrder(),mat.getOrder());
							System.out.println();
						}
					}
				}else if(op_code==10) {
					for(int i=0;i<matrices.size();i++) {
						if(matrices.get(i).getTypes().contains("diagonal")) {
							Square mat = (Square) matrices.get(i);
							print_matrix(mat.retrive_matrix(),mat.getOrder(),mat.getOrder());
							System.out.println();
						}
					}
				}else if(op_code==11) {
					for(int i=0;i<matrices.size();i++) {
						if(matrices.get(i).getTypes().contains("scalar")) {
							Square mat = (Square) matrices.get(i);
							print_matrix(mat.retrive_matrix(),mat.getOrder(),mat.getOrder());
							System.out.println();
						}
					}
				}else if(op_code==12) {
					for(int i=0;i<matrices.size();i++) {
						if(matrices.get(i).getTypes().contains("identity")) {
							Square mat = (Square) matrices.get(i);
							print_matrix(mat.retrive_matrix(),mat.getOrder(),mat.getOrder());
						}
					}
				}else if(op_code==13) {
					for(int i=0;i<matrices.size();i++) {
						if(matrices.get(i).getTypes().contains("singelton")) {
							Square mat = (Square) matrices.get(i);
							print_matrix(mat.retrive_matrix(),mat.getOrder(),mat.getOrder());
							System.out.println();
						}
					}
				}else if(op_code==14) {
					for(int i=0;i<matrices.size();i++) {
						if(matrices.get(i).getTypes().contains("onus")) {
							Rectangular mat = (Rectangular) matrices.get(i);
							print_matrix(mat.retrive_matrix(),mat.getColumns(),mat.getRows());
							System.out.println();
						}
					}
				}else if(op_code==15) {
					for(int i=0;i<matrices.size();i++) {
						if(matrices.get(i).getTypes().contains("null")) {
							Rectangular mat = (Rectangular) matrices.get(i);
							print_matrix(mat.retrive_matrix(),mat.getColumns(),mat.getRows());
							System.out.println();
						}
					}
				}else {
					System.out.println("Not valid Operation code ");
				}
				
			}else if(query_code==16) {
				break;
			}else {
				System.out.println("Please Enter a Valid query code only ! ");
			}
		}

	}

	public static void menu() {
		System.out.println("What operation you want to perform : ");
		System.out.println("1. Enter a Matrix of your own choice ");
		System.out.println("2. Create a Matrix of specific type ");
		System.out.println("3. Change the elements of a matrix ");
		System.out.println("4. Display matrix type lables of a matrix ");
		System.out.println("5. Perform addition, subtraction, multiplication & division.\r\n"
				+ "6. Perform element-wise operations.\r\n"
				+ "7. Transpose matrices.\r\n"
				+ "8. Inverse matrices.\r\n"
				+ "9. Compute means: row-wise mean, column-wise mean, mean of all the elements.\r\n"
				+ "10. Compute determinants.\r\n"
				+ "11. Use singleton matrices as scalars.\r\n"
				+ "12. Compute A+AT for a matrix A.\r\n"
				+ "13. Compute Eigen vectors and values.\r\n"
				+ "14. Solve sets of linear equations using matrices.");
		System.out.println("15. Retrieve all the matrices of a perticular matrix type ");
		System.out.println("16. Exit ");
	}
	public static void matrix_menu() {
		System.out.println("1. Rectangular Matrix\r\n"
				+ "2. Row Matrix\r\n"
				+ "3. Column Matrix\r\n"
				+ "4. Square Matrix\r\n"
				+ "5. Symmetric Matrix\r\n"
				+ "6. Skew-symmetric Matrix\r\n"
				+ "7. Upper-triangular Matrix\r\n"
				+ "8. Lower-triangular Matrix\r\n"
				+ "9. Singular Matrix\r\n"
				+ "10. Diagonal Matrix\r\n"
				+ "11. Scalar Matrix\r\n"
				+ "12. Identity Matrix\r\n"
				+ "13. Singleton Matrix\r\n"
				+ "14. Ones Matrix\r\n"
				+ "15. Null Matrix");
	}
	public static ArrayList<String> assign_labels(int rows,int columns,int[][] temp_matrix) {
		ArrayList<String> types = new ArrayList<String>();
		if(rows==columns) {
			if(rows==1) {
				types.add("singelton");
			}
			int[][] transposed_matrix = Square.transpose(rows, temp_matrix);
			int det_value = Square.determinant(rows, temp_matrix);
			if(det_value==0) {
				types.add("singular");
			}
			if(are_equal(temp_matrix,transposed_matrix)) {
				types.add("symmetric");
			}
			int[][] summed_matrix = Square.add_transpose(rows, transposed_matrix, temp_matrix);
			boolean skew_symmetric = true;
			boolean check_null = true;
			boolean check_onus = true;
			boolean upper_triangular = true;
			boolean lower_triangular = true;
			boolean diagonal = true;
			boolean scalar = true;
			boolean identity = true;
			for(int i=0;i<rows;i++) {
				for(int j=0;j<columns;j++) {
					if(i==j) {
						if(temp_matrix[i][j]==temp_matrix[0][0]) {
							if(temp_matrix[i][j]!=1) {
								identity = false;
							}
						}else {
							scalar = false;
							identity = false;
						}
					}else {
						if(temp_matrix[i][j]!=0) {
							scalar = false;
							identity = false;
							diagonal = false;
						}
					}
					if(summed_matrix[i][j]!=0) {
						skew_symmetric = false;
					}
					if(temp_matrix[i][j]==0) {
						check_onus = false;
					}else if(temp_matrix[i][j]==1) {
						check_null = false;
					}else {
						check_null = false;
						check_onus = false;
					}
					if(i<j) {
						if(temp_matrix[i][j]!=0) {
							lower_triangular = false;
						}
					}if(i>j) {
						if(temp_matrix[i][j]!=0) {
							upper_triangular = false;
						}
					}
				}
			}
			if(diagonal) {
				types.add("diagonal");
			}
			if(identity) {
				types.add("identity");
			}
			if(scalar) {
				types.add("scalar");
			}
			if(upper_triangular) {
				types.add("upper_triangular");
			}
			if(lower_triangular) {
				types.add("lower_triangular");
			}
			if(check_onus) {
				types.add("onus");
			}
			if(check_null) {
				types.add("null");
			}
			if(skew_symmetric) {
				types.add("skew_symmetric");
			}
			types.add("square");
			types.add("rectangular");
		}else {
			if(rows==1) {
				types.add("row_matrix");
			}
			if (columns==1){
				types.add("column_matrix");
			}
				boolean check_null = true;
				boolean check_onus = true;
				for(int i=0;i<rows;i++) {
					for(int j=0;j<columns;j++) {
						if(temp_matrix[i][j]==0) {
							check_onus = false;
						}else if(temp_matrix[i][j]==1) {
							check_null = false;
						}else {
							check_null = false;
							check_onus = false;
						}
					}
				}
				if(check_null) {
					types.add("null");
				}else if(check_onus) {
					types.add("onus");
				}
				types.add("rectangular");
			
		}
		return types;
	}
	public static boolean are_equal(int[][] ary1, int[][] ary2) {
		for(int i=0;i<ary1.length;i++) {
			for(int j=0;j<ary2.length;j++) {
				if(ary1[i][j]!=ary2[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	public static float[][] type_cast(int[][] mat){
		float[][] fmat = new float[mat.length][mat[0].length];
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				fmat[i][j] = mat[i][j];
			}
		}
		return fmat;
	}
	public static void print_matrix(int[][] matrix,int c,int r) {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void print_matrix(float[][] matrix,int c,int r) {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static float[] quadratic(int[] mat) {
		int dis = mat[1]*mat[1]-4*mat[0]*mat[2];
		if(dis>=0) {
			float v = (float) Math.sqrt(dis);
			float val1 = (float)(-mat[1]+v)/(float)(2*mat[0]);
			float val2 = (float)(-mat[1]-v)/(float)(2*mat[0]);
			float[] ans = new float[3];
			ans[2] =0;
			ans[0] = val1;
			ans[1] = val2;
			return ans;
		}else {
			System.out.println("Cant compute as will have complex eigen values ");
			float[] ans = new float[3];
			ans[0] =-1;
			ans[1] =-1;
			ans[2] =-1;
			return ans;
		}
	}
	
}
