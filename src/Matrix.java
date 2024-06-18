import java.util.Scanner; 


/** Matrix class is used to 
 * create a matrix and
 * have methods allowing
 * operations with matrices
 */
public class Matrix {
	
	private double[][] x; // 2D array
	int n;        // number of rows
	int m;		  // number of columns
	
	
	/** Constructor made to 
	 * initialize a matrix
	 */
	public Matrix(int row, int column){ // row is the number of rows, column is the number of column
		
		this.n = row; // Initialize the number of rows of the matrix
		this.m = column; // Initialize the number of columns of the matrix
		this.x = new double[n][m]; // Initialize the 2D array assimilated to a matrix
		
	}
	
	
	/** Display a matrix
	 */
	public void disp(){
		
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.m; j++) {
				System.out.print(this.x[i][j] + " "); // Display the cell of the matrix of coordinates (i,j)
			}
			System.out.println();
		}
		
		System.out.println();
		
	}
	
	
	/** Return the number of rows 
	 * chosen by the user for
	 * their matrix
	 */
	public static int rowsChoice() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Choose the number of rows of your matrix: n = ");
		int n = sc.nextInt(); // Allow the user to enter the number of rows 
		return n;
		
	}
	
	
	/** Return the number of columns
	 * chosen by the user for
	 * their matrix
	 */
	public static int columnsChoice() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Choose the number of columns of your matrix: m = ");
		int m = sc.nextInt(); // Allow the user to enter the number of columns
		return m;
		
	}
	
	
	/** Set all the coefficients
	 * of a matrix  
	 */
	private void setNormalMatrix(){
		
		Scanner sc = new Scanner(System.in);
			
			for (int i = 0; i < this.n; i++) {
				for (int j = 0; j < this.m; j++) {
					System.out.print("Please give in a value for row " + (i+1) +" and column " + (j+1) + " : " );
					this.x[i][j] = sc.nextDouble(); // Allow the user to enter the coefficients of the matrix of coordinates (i,j)
				}
			}
		
	}
	
	
	/** Set a diagonal matrix 
	 */
	private void setDiagonal(){
		
		Scanner sc = new Scanner(System.in);
		
			for (int i = 0; i < this.n; i++) {
				for (int j = 0; j < this.m; j++) {
					if(j == i){ // Condition to only take into account the coefficient in the diagonal of the matrix
						System.out.print("Please give in a value for row " + (i+1) +" and column " + (j+1) + " : " );
						this.x[i][j] = sc.nextDouble(); // Allow the user to enter the coefficients of the matrix of coordinates (i,j)
					}
				}
			}
		
	}
	
	
	/** Set an identity matrix 
	 */
	private void setIdentity(){
			
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.m; j++) {
				if(j == i){
					this.x[i][j] = 1;
				} else {
					this.x[i][j] = 0;
				}
			}
		}
				
	}
	
	
	/** Set an upper triangular matrix 
	 */
	public void setUpperTriangular(){
		
		Scanner sc = new Scanner(System.in);
		
			for(int i=0; i<this.n; i++){
				for(int j=0; j<this.m; j++){
					if(j >= i){ // Condition to only take into account the coefficient in upper triangular part of the matrix
						System.out.print("Please give in a value for row " + (i+1) +" and column " + (j+1) + " : " );
						this.x[i][j]=sc.nextDouble(); // Allow the user to enter the coefficients of the matrix of coordinates (i,j)
					}
				}
			}
		
	}
	
	
	/** Return the letter chosen by the
	 * user as a function of the operation
	 * they want to perform
	 */
	public static String operationChoice() {
		
		System.out.println();
		Scanner sc = new Scanner(System.in);
		String a = "a"; // Initialize the input for the user
		boolean t = false; // Initialize the checker
		
		System.out.println("- Press 's' to sum 2 matrices" 
				+ "\n" + "- Press 'u' to subtract 2 matrices" 
				+ "\n" + "- Press 'l' to multiply a matrix by a scalar" 
				+ "\n" + "- Press 'm' to multiply 2 matrices" 
				+ "\n" + "- Press 'p' to raise a square matrix to a chosen power" 
				+ "\n" + "- Press 't' to transpose a matrix" 
				+ "\n" + "- Press 'd' to compute the determinant of a square matrix" 
				+ "\n" + "- Press 'g' to solve a system using the Gauss method" 
				+ "\n" + "- Press 'i' to compute the inverse of a square matrix");
		System.out.println();
		
			while (t == false) { // Start again the loop if the checker is not validated
				a = sc.nextLine(); // Allow the user to enter a letter
				if (a. equals ("s") || a. equals ("u") || a. equals ("l") || a. equals ("m") || a. equals ("p")
						|| a. equals ("t") || a. equals ("d") || a. equals ("g") || a. equals ("i")){            // Conditions to validate the checker
					t = true; // Validate the checker
				}else{
					System.out.println();
					System.out.println("Please enter one of the letters above");
					System.out.println();
				}
			}
			
		System.out.println();	
		return a;
		
	}
	
	
	/** Return the letter chosen by the
	 * user as a function of the type
	 * of square matrix they want to use
	 */
	public String matrixChoice() {
		
		Scanner sc = new Scanner(System.in);
		String a = "n"; // Initialize the input for the user
		boolean t = false; // Initialize the checker
		
			if (this.n == this.m){ 
				System.out.println("- Press 'n' to create an ordinary matrix" 
									+ "\n" + "- Press 'd' to create a diagonal matrix" 
									+ "\n" + "- Press 'u' to create an upper triangular matrix"
									+ "\n" + "- Press 'i' to create an identity matrix");
				System.out.println();
				
					while (t == false) { // Start again the loop if the checker is not validated
						a = sc.nextLine(); // Allow the user to enter a letter
						if (a. equals ("n") || a. equals ("d") || a. equals ("u") || a. equals ("i")){  // Conditions to validate the checker
							t = true; // Validate the checker
						}else {
							System.out.println();
							System.out.println("Please enter one of the letters above");
							System.out.println();
						}
					}
			}
			
		return a;
		
	}
	
	
	/** Set a matrix of the type
	 * chosen by the user beforehand
	 */
	public void matrixSetter(String x) { // x is a letter defined by the user beforehand
		
		if (x.equals("n") && this.n !=this.m) { // Case of a non specific matrix
			this.setNormalMatrix();
		}else if (x.equals("n") && this.n ==this.m){ // Case of an ordinary matrix
			System.out.println();
			this.setNormalMatrix();
		}else if (x.equals("d")) { // Case of a diagonal matrix
			System.out.println();
			this.setDiagonal();
		}else if (x.equals("u")) { // Case of an upper triangular matrix
			System.out.println();
			this.setUpperTriangular();
		}else if (x.equals ("i")) { // Case of the identity matrix
			this.setIdentity();
		}
		
	}

	
	/** Verify if a matrix
	 * is a square matrix
	 */
	public boolean isSquare(){
		
		if(this.m == this.n){ // Condition to have a square matrix
			return true;
		}else {
			return false;
		}
		
	}
	
	
	/** Verify if 2 matrices
	 * can be multiplied each other
	 */
	public boolean isMultiPoss(Matrix y){ // y is a matrix
		
		if(this.m == y.n){ // Condition to have 2 matrices which can be multiplied each other
			return true;
		}else {
			return false;
		}
		
	}
	
	
	/** Verify if a number is null 
	 */
	public boolean isDetNull(double det){ // det is the number that the method checks the nullity
		
		if(det == 0){
			return false;
		}else {
			return true;
		}
		
	}


	/** Redefine 2 matrices as long as
	 * they don't respect the condition
	 * to multiply 2 matrices together
	 */
	public static void multiChangeMatrix(Matrix m1m, Matrix m2m, boolean t){ // m1m and m2m are 2 matrices that the method verifies, t is the checker
			
		while(t == false){ // Start again the loop if the checker is not validated
					
			System.out.println("Your matrices can't be multiplied. Please, enter again the dimensions for each matrix so" + "\n"
							   + "the number of columns of the first matrix is equal to the number of rows of the second matrix.");
			System.out.println();
					
			System.out.println("Enter again the dimensions of the first matrix");			   
			m1m.n = Matrix.rowsChoice(); // Allow the user to enter the number of rows of the matrix m1m
			m1m.m =Matrix.columnsChoice(); // Allow the user to enter the number of columns of the matrix m1m
			System.out.println();
					
			System.out.println("Enter again the dimensions of the first matrix");
			m2m.n = Matrix.rowsChoice(); // Allow the user to enter the number of rows of the matrix m2m
			m2m.m =Matrix.columnsChoice(); // Allow the user to enter the number of columns of the matrix m2m
			System.out.println();
					
			t = m1m.isMultiPoss(m2m); // Reset the checker
						
				if(t){ // Condition to validate the checker
					t = true; // Validate the checker
				}
			}	
		
	}
	
	
	/** Redefine a matrix as long as
	 * the condition to raise a matrix 
	 * to a power isn't respected
	 */
	public static void powerChangeMatrix(Matrix m1p, boolean t){ // m1p is the matrix that the method checks, t is the checker
		
		while(t == false){ // Start again the loop if the checker is not validated
					
			System.out.println("Your matrices can't be raised to any power since it's not a square matrix. Please, enter again" + "\n"  
							   + "the dimensions of your matrix so the number of rows of your matrix is equal to its number of columns");
			System.out.println();
					
			System.out.println("Enter again the dimensions of your matrix");			   
			m1p.n = Matrix.rowsChoice(); // Allow the user to enter the number of rows of the matrix m1p
			m1p.m = Matrix.columnsChoice(); // Allow the user to enter the number of columns of the matrix m1p
			System.out.println();
					
			t = m1p.isSquare(); // Reset the checker
						
				if(t){ // Conditions to validate the checker
					t = true; // Validate the checker
				}
			}	
			
	}
	
	
	/** Redefine a matrix as long as
	 * the condition to compute the 
	 * determinant isn't respected
	 */
	public static void detChangeMatrix(Matrix m1d, boolean t){ // m1d is the matrix that the method checks, t is the checker
		
		while(t == false){ // Start again the loop if the checker is not validated
					
			System.out.println("The determinant can't be determined since it's not a square matrix. Please, enter again" + "\n"  
							   + "the dimensions of your matrix so the number of rows of your matrix is equal to its number of columns");
			System.out.println();
					
			System.out.println("Enter again the dimensions of your matrix");			   
			m1d.n = Matrix.rowsChoice(); // Allow the user to enter the number of rows of the matrix m1d
			m1d.m = Matrix.columnsChoice(); // Allow the user to enter the number of columns of the matrix m1d
			System.out.println();
					
			t = m1d.isSquare(); // Reset the checker
						
				if(m1d.isSquare()){ // Conditions to validate the checker
					t = true; // Validate the checker
				}
			}	
			
	}
	
	
	/** Redefine a matrix as long as
	 * the condition to inverse a 
	 * matrix isn't respected
	 */
	public static void invChangeMatrix(Matrix m1i, boolean t){ // m1i is the matrix that the method checks, t is the checker
		
		while(t == false){ // Start again the loop if the checker is not validated
					
			System.out.println("The inverse of your matrix can't be determined since your matrix isn't a square matrix. Please, enter again" + "\n"  
							   + "the dimensions of your matrix so the number of rows of your matrix is equal to its number of columns");
			System.out.println();
					
			System.out.println("Enter again the dimensions of your matrix");			   
			m1i.n = Matrix.rowsChoice(); // Allow the user to enter the number of rows of the matrix m1i
			m1i.m = Matrix.columnsChoice(); // Allow the user to enter the number of columns of the matrix m1i
			System.out.println();
					
			t = m1i.isSquare(); // Reset the checker
						 
				if(m1i.isSquare()){ // Conditions to validate the checker
					t = true; // Validate the checker
				}
			}	
			
	}
	 
	
	/** Redefine a matrix as long as
	 * the determinant of the matrix 
	 * is null
	 */ 
	public static void detNullChangeMatrix(Matrix m1i, boolean v){ // m1i is the matrix that the method checks, v is the checker
		
		while(v == false){ // Start again the loop if the checker is not validated
					
			System.out.println("The inverse of your matrix can't be determined since the determinant of your matrix is null. Please, enter again" + "\n"  
							   + "the coefficient of your matrix so that the determinant of your matrix isn't null");
			System.out.println();
					
			System.out.println("Choose the type of your matrix");
			String b = m1i.matrixChoice(); // Allow the user to define the wanted type of matrix 
			m1i.matrixSetter(b); // Set the matrix 
			
			System.out.println();
			int N = m1i.n; // Dimension of the matrix N x N
					
			v = m1i.isDetNull(m1i.det(m1i.n, N)); // Reset the checker
						
				if(v == false){ // Conditions to validate the checker
					v = true; // Validate the checker
				}
			}
				
	}
	
	
	/** Return the result of 
	 * the addition of 2 matrices
	 */
	public Matrix sum(Matrix y){ // y is the added matrix
		
		Matrix s = new Matrix(this.n, this.m); // Initialize the result matrix
			
			for (int i = 0; i < y.n; i++) {
				for (int j = 0; j < y.m; j++) {
					s.x[i][j] = this.x[i][j] + y.x[i][j]; // Define the coefficients of the result matrix
				}
			}

		return s;
		
	}

	
	/** Return the result of 
	 * the subtraction of 2 matrices
	 */ 
	public Matrix difference(Matrix y){ // y is the subtracted matrix
		
		Matrix s = new Matrix(this.n, this.m); // Initialize the result matrix
			
			for (int i = 0; i < y.n; i++) {
				for (int j = 0; j < y.m; j++) {
					s.x[i][j] = this.x[i][j] - y.x[i][j]; // Define the coefficients of the result matrix
				}
			}

		return s;
		
	}
	
	
	/** Return the result of 
	 * a matrix multiply by a scalar
	 */ 
	public Matrix scalar(double a){ // a is the scalar
		
		Matrix s = new Matrix(this.n, this.m); // Initialize the result matrix
				
			for(int i = 0; i < this.n; i++){
				for(int  j = 0; j < this.m; j++){
					s.x[i][j] = a*this.x[i][j]; // Define the coefficients of the result matrix
				}
			}

		System.out.println();
		return s;
		
	}
	
	
	/** Return the result of 
	 * the multiplication of 
	 * 2 matrices
	 */ 
	public Matrix multiplication(Matrix y){ // y is the multiplied matrix
		
		Matrix s = new Matrix(this.n, y.m); // Initialize the result matrix
			 
			for(int i = 0; i<this.n; i++){
				for(int k=0; k<y.m; k++){
					s.x[i][k] = 0.0; 
					for(int  j = 0; j<this.m; j++){
						s.x[i][k] += this.x[i][j]*y.x[j][k]; // Define the coefficients of the result matrix
					}
				}
			}
		
		return s;
		
	}

	
	/** Return the result of 
	 * a square matrix raised to
	 * a power
	 */
	public Matrix  power(int a){ // a is the power
	
		Matrix s1 = this; // Initialize the result matrix
		Matrix s2 = this; // Initialize the auxiliary matrix
		
			if(a==0){ // case when the power is null 
				s1.setIdentity(); // Set an identity matrix
			} else { // Case when the power isn't null 
				for(int i = 0; i<a-1; i++){
					s1 = s1.multiplication(s2); // Define the coefficients of the result matrix
				}
			}		
		
		return s1;

	}
	
	
	/** Return the result of 
	 * the transposition of a
	 * matrix
	 */
	public Matrix transpose(){
 
		Matrix s = new Matrix(this.m, this.n); // Initialize the result matrix
			
			for ( int i = 0; i<this.n; i ++){
				for ( int j = 0; j<this.m ; j ++){
					s.x[j][i] = this.x[i][j]; // Define the coefficients of the result matrix
				}
			}
			
		return s;
		
	}

	
    /** Get cofactor of the matrix this
     *  of dimension f x g in the matrix t2
     */
	private void Cofactor(Matrix t2, int f, int g, int n){ // n is the current dimension of the matrix this
        
        int r = 0; 
        int c = 0;
 
			for (int i=0; i < n; i++){
				for (int j=0; j < n; j++){
					if (i!=f && j!=g){
						t2.x[r][c++] = this.x[i][j]; // Define the coefficients of the matrix t2
						if (c == n-1){
							c = 0;
							r++;
						}
					}
				}
			}
			
    }
	
	
	/** Return the determinant of 
	 * a matrix
     */
	public double det(int n, int N){ // n is the current dimension of the matrix, N is the initial dimension
        
        double D = 0; // Initialize the determinant
			
			if (n == 1){ // Case when the matrix is of dimension 1 x 1
				return this.x[0][0];
			}
 
        Matrix t2 = new Matrix(N,N); // Initialize the auxiliary matrix
		int sign = 1;
 
			for (int i = 0; i < n; i++){
				this.Cofactor( t2, 0, i, n);
				D += sign * this.x[0][i]* t2.det(n-1, N); // Determine the determinant
				sign = -sign;
			}
			
		return D;
		
    }
    

	/** Set the coefficient of
	 * a system of equations
	 * in a matrix 
	 */
    public void coeffSystem(){
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<this.n; i++){ 
			for(int j = 0; j<this.m; j++){ 
				if(j == this.m -1){ // Define the results of each equation
					System.out.print("Enter the result of the equation n°" + (i+1) + " : ");
					this.x[i][j] = sc.nextDouble(); 
				} else { // Define the coefficients of each equation 
					System.out.print("Enter the coefficient n°" + (j+1) + " of the equation n°" + (i+1) + " : ");
					this.x[i][j] = sc.nextDouble();
				}
			}
		}
		
	}
    
    
    /** Return a number indicating 
     * the way to solve a system.
     * Also redefine the matrix 
     * associated to the system
     * by using the gaussian elimination
     */
    public int gauss(){
		
		int c = 0; // Initialize an auxiliary value
		int flag = 0; // Initialize the indicator

			for (int i = 0; i < this.n; i++){ // Perform elementary operations in the matrix
				if (this.x[i][i] == 0){
					c = 1;
						while (((i + c) < this.n) && (this.x[i + c][i] == 0)){ 
							c++;
						}         
						if ((i + c) == this.n){
							flag = 1;
							break;
						}
						for (int k = 0; k <= this.n; k++){
							double temp = this.x[i][k];
							this.x[i][k] = this.x[i+c][k];
							this.x[i+c][k] = temp;
						}
				}
				
				for (int j = 0; j < this.n; j++){
					if (i != j){ 
						double p = this.x[j][i] / this.x[i][i];
						for (int k = 0; k <= this.n; k++){                
							this.x[j][k] = this.x[j][k] - (this.x[i][k]) * p;     
						}        
					}
				}
			}
			
		return flag;
		
	}
	
	
	/** Verify whether the system
	 * has no solution or
	 * infinite solutions
	 */
	public int optionsPossible(int flag){
		
		int i;
		int j;
		double sum;
		  
		flag = 3; // Case there is no solution
			for (i = 0; i < this.n; i++){
				sum = 0;
					for (j = 0; j < this.n; j++){     
						sum = sum + this.x[i][j];
					}
					if (sum == this.x[i][j]){ 
						flag = 2;// Case there are infinite solutions  
					}
			}
			
		return flag;
		
	}
	
	
	/** Display the results 
	 * of the system if 
	 * unique solutions exist. 
	 * Otherwise, display that
	 * therer is no solution
	 * or there are infinite 
	 * solutions
	 */
    public void resultSystem(int flag){
		
			if (flag == 2){ // Case there are infinite solutions   
				System.out.println("There are infinite solutions "); 
			} else if (flag == 3){ // Case there is no solution 
				System.out.println("There is no solution"); 
			} else { // Case there are defined solutions
				System.out.print("The solutions are : ");
					for (int i = 0; i < this.n; i++){         
						System.out.print(this.x[i][this.n] / this.x[i][i] +"   "); 
					}   
				System.out.println(); 
			}
			
			System.out.println(); 
			
	}
	

	/** Perform the partial-pivoting Gaussian
	 * elimination on a matrix
	 */
	private void pivotGauss( int [] index){ // Initialize the array index[] that stores the pivoting order
        
        double t[] = new double[index.length];
 
			for (int i=0; i<index.length; ++i){  
				index[i] = i; // Initialize the index
			}

			for (int i=0; i<index.length; ++i){  // Find the rescaling factors, one from each row
				double u = 0;
					for (int j=0; j<index.length; ++j){
						double v = Math.abs(this.x[i][j]);
							if (v > u){
								u = v;
							}
					}
					t[i] = u;
			}
 
        int k = 0;
			
			for (int j=0; j<index.length-1; ++j){  // Search the pivoting element from each column
				double p = 0;
					for (int i=j; i<index.length; ++i){
						double m = Math.abs(this.x[index[i]][j]);
						m /= t[index[i]];
							if (m > p){
								p = m;
								k = i;
							}
					}
 
				// Interchange rows according to the pivoting order
				int q = index[j];
				index[j] = index[k];
				index[k] = q;
				
					for (int i=j+1; i<n; ++i){  // Interchange rows according to the pivoting order
						double f = this.x[index[i]][j]/this.x[index[j]][j];
						this.x[index[i]][j] = f;  // Record pivoting ratios below the diagonal
						for (int l=j+1; l<index.length; ++l){  // Modify other elements accordingly
							this.x[index[i]][l] -= f*this.x[index[j]][l];
						}
					}
				}
				
	}
	
	
	/** Return the inverse 
	 * of a matrix
	 */
	public Matrix inverse(){
        
        Matrix y = new Matrix (this.n,this.n); // Initialize the result matrix
        Matrix b = new Matrix (this.n,this.n); // Initialize an auxiliary matrix
        int [] index = new int[this.n]; // Initialize the array index[] that stores the pivoting order
	
			for (int i=0; i<this.n; ++i){ 
				b.x[i][i] = 1;
			}
			
        this.pivotGauss(index); // Perform the partial-pivoting Gaussian elimination on the matrix this
 
			for (int i=0; i<this.n-1; ++i){ 
				for (int j=i+1; j<this.n; ++j){
					for (int k=0; k<this.n; ++k){
						b.x[index[j]][k]-= this.x[index[j]][i]*b.x[index[i]][k]; // Define the coefficients of the an auxiliary matrix
					}
				}
			}

			// Define the coefficients of the result matrix
			for (int i=0; i<this.n; ++i){ 
				y.x[this.n-1][i] = b.x[index[this.n-1]][i]/this.x[index[this.n-1]][this.n-1];
					for (int j=this.n-2; j>=0; --j){
						y.x[j][i] = b.x[index[j]][i];
							for (int k=j+1; k<this.n; ++k){ 
								y.x[j][i] -= this.x[index[j]][k]*y.x[k][i];
							}
						y.x[j][i] /= this.x[index[j]][j];
					}
			}
			
		return y;
			
    }
    
}




