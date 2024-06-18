import java.util.Scanner;
import java.util.InputMismatchException;

public class MatrixOperator {
	
	
	/** Create matrices
	* and perform
	* different kind of 
	* operations on matrices
	*/
	public static void main(String[] arg) {
		
		Scanner sc = new Scanner(System.in);
		int s = 0; // Initialize the checker number that the user will enter to stop or continue using the Matrix Operator
		boolean stopper = false; // Initialize the stopper
		
		System.out.println("Welcome to the Matrix operator !");
		
			do{ // Start again the loop if the user doesn't enter the word 'stop' after performing an operation
				
				boolean bol = false; // Initialize the type checker
				boolean t = false; // Initialize the checker
				boolean v = false; // Initialize the special checker for the inverse of a matrix 
				int flag = 0; // Initialize the indicator for the resolution of a system of equations
				
				String a = Matrix.operationChoice(); // Ask the user which operation they want to perform and define the letter chosen
													 // by the user and associated to an operation
		
					if (a.equals("s")){ // Case for the sum of 2 matrices
						
						System.out.println("Let's add your 2 matrices.");
						System.out.println();
						
						System.out.println("Enter the dimensions of the first matrix");
						Matrix m1s = new Matrix(1, 1); // Initialize the first matrix m1s
							while(!bol){ // Start again the loop if the entered values for the rows and columns aren't integers
								try{
									m1s = new Matrix(Matrix.rowsChoice(), Matrix.columnsChoice()); // Define the dimensions of the first matrix m1s
									System.out.println();
									bol = true;
								} catch (InputMismatchException e) {
									System.out.println();
									System.out.println("Your value isn't an integer. Please, start again with integers.");
									bol = false;
									System.out.println();
								}
							}
						bol = false;	
						
						System.out.print("Since 2 matrices can only be added if and only if they have the same dimension n X m," + "\n" +
										  "the second matrix is initialized with the same dimension as your first matrix.");
						System.out.println();
						
						Matrix m2s = new Matrix(m1s.n, m1s.m); // Define the dimensions of the second matrix m2s with the same dimension as the first matrix m2s
						
							if(m1s.isSquare()){ // Case the first matrix m1s and the second matrix m2s are square matrices
								while (!bol){ // Start again the loop if the entered values for the coefficients aren't real numbers
									try{
										System.out.println();
										System.out.println("Choose the type of the first matrix");
										String b = m1s.matrixChoice(); // Ask the user which type of matrix they want for m1s and define 
																	   // the letter chosen by the user and associated to a type of matrix
										m1s.matrixSetter(b); // Set the matrix m1s as a function of the letter chosen by the user
										System.out.println();
										
										System.out.println("Choose the type of the second matrix");
										String c = m2s.matrixChoice(); // Ask the user which type of matrix they want for m2s and 
																	   // define the letter chosen by the user and associated to a type of matrix
										m2s.matrixSetter(c); // Set the matrix m2s as a function of the letter chosen by the user
										System.out.println();
										bol = true;
									} catch (InputMismatchException e) {
										System.out.println();
										System.out.println("Your value isn't a real number. Please, start again with real numbers");
										bol = false;
									}
								}
							} else { // Case the first matrix m1s and the second matrix m2s aren't square matrices
								while (!bol){ // Start again the loop if the entered values for the coefficients aren't real numbers
									try{
										System.out.println();
										System.out.println("Define the coefficients of your first matrix");
										m1s.matrixSetter("n"); // Set the coefficients of the matrix m1s 
										System.out.println();
										
										System.out.println("Define the coefficients of your second matrix");
										String c = m2s.matrixChoice();
										m2s.matrixSetter("n"); // Set the coefficients of the matrix m2s 
										System.out.println();
										bol = true;
									} catch (InputMismatchException e) {
										System.out.println();
										System.out.println("Your value isn't a real number. Please, start again with real numbers");
										bol = false;
									}
								}
							}
						bol = false;	
						
						Matrix m3s = m1s.sum(m2s); // Define the result matrix m3s of the sum of the matrix m1s and the matrix m2s
						System.out.println("The final result is :");
						System.out.println(); 
						m3s.disp(); // Display the result matrix m3s 
						
						
					} else if (a.equals("u")){ // Case for the subtraction of 2 matrices
						
						System.out.println("Let's subtract your 2 matrices.");
						System.out.println();
						
						System.out.println("Enter the dimensions of the first matrix");
						Matrix m1u = new Matrix(1, 1); // Initialize the first matrix m1u
							while(!bol){ // Start again the loop if the entered values for the rows and columns aren't integers
								try{
									m1u = new Matrix(Matrix.rowsChoice(), Matrix.columnsChoice()); // Define the dimensions of the first matrix m1u
									System.out.println();
									bol = true;
								} catch (InputMismatchException e) {
									System.out.println();
									System.out.println("Your value isn't an integer. Please, start again with integers.");
									bol = false;
									System.out.println();
								}
							}
						bol = false;	
							
						System.out.print("Since 2 matrices can only be subtracted if and only if they have the same dimension n X m," + "\n" +
										  "the second matrix is initialized with the same dimension as your first matrix.");
						System.out.println();
						
						Matrix m2u = new Matrix(m1u.n, m1u.m); // Define the dimensions of the second matrix m2u with the same dimension as the first matrix m2u
						
							if(m1u.isSquare()){ // Case the first matrix m1u and the second matrix m2u are square matrices
								while (!bol){ // Start again the loop if the entered values for the coefficients aren't real numbers
									try{
										System.out.println();
										System.out.println("Choose the type of the first matrix");
										String b = m1u.matrixChoice(); // Ask the user which type of matrix they want for the matrix m1u and define
																	   // the letter chosen by the user and associated to a type of matrix
										m1u.matrixSetter(b); // Set the matrix m1u as a function of the letter chosen by the user
										System.out.println();
										
										System.out.println("Choose the type of the second matrix");
										String c = m2u.matrixChoice(); // Ask the user which type of matrix they want for m2u and define 
																	   // the letter chosen by the user and associated to a type of matrix
										m2u.matrixSetter(c); // Set the matrix m2u as a function of the letter chosen by the user
										System.out.println();
										bol = true;
									} catch (InputMismatchException e) {
										System.out.println();
										System.out.println("Your value isn't a real number. Please, start again with real numbers");
										bol = false;
									}
								} 	
							} else { // Case the first matrix m1u and the second matrix m2u aren't square matrices
								while (!bol){ // Start again the loop if the entered values for the coefficients aren't real numbers
									try{
										System.out.println();
										System.out.println("Define the coefficients of your first matrix");
										m1u.matrixSetter("n"); // Set the coefficients of the matrix m1u 
										System.out.println();
										
										System.out.println("Define the coefficients of your second matrix");
										String c = m2u.matrixChoice();
										m2u.matrixSetter("n"); // Set the coefficients of the matrix m2u 
										System.out.println();
										bol = true;
									} catch (InputMismatchException e) {
										System.out.println();
										System.out.println("Your value isn't a real number. Please, start again with real numbers");
										bol = false;
									}
								} 	
							}
						bol = false;
						
						Matrix m3u = m1u.difference(m2u); // Define the result matrix m3u of the subtraction of the matrix m1u and the matrix m2u
						System.out.println("The final result is :");
						System.out.println(); 
						m3u.disp(); // Display the result matrix m3u
						
						
					} else if (a.equals("l")){ // Case for the multiplication of a matrix by a scalar
						
						System.out.println("Let's multiply your matrix by a chosen scalar.");
						System.out.println();
						
						System.out.println("Enter the dimensions of your matrix");
						Matrix m1l = new Matrix(1, 1); // Initialize the matrix m1l
							while(!bol){ // Start again the loop if the entered values for the rows and columns aren't integers
								try{
									m1l = new Matrix(Matrix.rowsChoice(), Matrix.columnsChoice()); // Define the dimensions of the matrix m1l
									bol = true;
								} catch (InputMismatchException e) {
									System.out.println();
									System.out.println("Your value isn't an integer. Please, start again with integers.");
									bol = false;
									System.out.println();
								}
							}
						bol = false;	
							
							if(m1l.isSquare()){ // Case the matrix m1l is a square matrix
								while (!bol){ // Start again the loop if the entered values for the coefficients aren't real numbers
									try{
										System.out.println();
										System.out.println("Choose the type of your matrix");
										String b = m1l.matrixChoice(); // Ask the user which type of matrix they want for the matrix m1l and define
																	   // the letter chosen by the user and associated to a type of matrix
										m1l.matrixSetter(b); // Set the matrix m1l as a function of the letter chosen by the user
										System.out.println();
										bol = true;
									} catch (InputMismatchException e) {
										System.out.println();
										System.out.println("Your value isn't a real number. Please, start again with real numbers");
										bol = false;
									}
								}
							} else { // Case the matrix m1l is not a square matrix
								while (!bol){ // Start again the loop if the entered values for the coefficients aren't real numbers
									try{
										System.out.println();
										System.out.println("Define the coefficients of your matrix");
										m1l.matrixSetter("n"); // Set the coefficients of the matrix m1l
										System.out.println();
										bol = true;
									} catch (InputMismatchException e) {
										System.out.println();
										System.out.println("Your value isn't a real number. Please, start again with real numbers");
										bol = false;
									}
								}
							}
						bol = false;
						
						System.out.print("Enter the scalar you want to multiply your matrix : ");
						double lambda = 0;  // Initialize the scalar
							while (!bol){ // Start again the loop if the entered values for the coefficients aren't real numbers
								try{
									lambda = sc.nextDouble(); // Allow the user to enter a scalar;
									bol = true;
								} catch (InputMismatchException e) {
									System.out.println();
									System.out.print("Your value isn't a real number. Please, start again with a real number : ");
									bol = false;
									sc.nextLine();
								}
							}
						bol = false;
						
						Matrix m3l = m1l.scalar(lambda);  // Define the result matrix m3l of the multiplication of the matrix m1l y a scalar lambda
						System.out.println("The final result is :");
						System.out.println(); 
						m3l.disp(); // Display the result matrix m3l   
					
					} else if (a.equals("m")){ // Case for the multiplication of 2 matrices

						System.out.println("Let's multiply your 2 matrices.");
						System.out.println();
						
						System.out.println("Enter the dimensions of the first matrix");
						Matrix m1m = new Matrix(1, 1); // Initialize the first matrix m1m
							while(!bol){ // Start again the loop if the entered values for the rows and columns aren't integers
								try{
									m1m = new Matrix(Matrix.rowsChoice(), Matrix.columnsChoice()); // Define the dimensions of the first matrix m1m
									System.out.println();
									bol = true;
								} catch (InputMismatchException e) {
									System.out.println();
									System.out.println("Your value isn't an integer. Please, start again with integers.");
									bol = false;
									System.out.println();
								}
							}
						bol = false;
						
						System.out.println("Enter the dimensions of the second matrix");
						Matrix m2m = new Matrix(1, 1); // Initialize the second matrix m2m
							while(!bol){ // Start again the loop if the entered values for the rows and columns aren't integers
								try{
									m2m = new Matrix(Matrix.rowsChoice(), Matrix.columnsChoice()); // Define the dimensions of the second matrix m2m
									System.out.println();
									bol = true;
								} catch (InputMismatchException e) {
									System.out.println();
									System.out.println("Your value isn't an integer. Please, start again with integers.");
									bol = false;
									System.out.println();
								}
							}
						bol = false;
						
							while(!bol){ // Start again the loop if the entered values for the rows and columns aren't integers
								try{
									t = m1m.isMultiPoss(m2m); // Reset the checker
									Matrix.multiChangeMatrix(m1m,m2m,t); // Verify if the 2 matrices can be multiplied together
									bol = true;
								} catch (InputMismatchException e) {
									System.out.println();
									System.out.println("Your value isn't an integer. Please, start again with integers.");
									bol = false;
									System.out.println();
								}
							}
						bol = false;
						
							if(m1m.isSquare()){ // Case the first matrix m1m and the second matrix m2m are square matrices
								while(!bol){ // Start again the loop if the entered values for the coefficients aren't real numbers
									try{
										System.out.println("Choose the type of the first matrix");
										String b = m1m.matrixChoice(); // Ask the user which type of matrix they want for the matrix m1m and define
																	   // the letter chosen by the user and associated to a type of matrix 
										m1m.matrixSetter(b); // Set the matrix m1m as a function of the letter chosen by the user
										System.out.println(); 
										
										System.out.println("Choose the type of the second matrix");
										String c = m2m.matrixChoice(); // Ask the user which type of matrix they want for the matrix m2m and define
																	   // the letter chosen by the user and associated to a type of matrix 
										m2m.matrixSetter(c); // Set the matrix m2m as a function of the letter chosen by the user
										System.out.println();
										bol = true;
									} catch (InputMismatchException e) {
										System.out.println();
										System.out.println("Your value isn't a real number. Please, start again with real numbers");
										System.out.println();
										bol = false;
									}
								}
							} else { // Case the first matrix m1m and the second matrix m2m aren't square matrices
								while(!bol){ // Start again the loop if the entered values for the coefficients aren't real numbers
									try{
										System.out.println("Define the coefficients of your first matrix");
										m1m.matrixSetter("n"); // Set the coefficients of the matrix m1m
										System.out.println();
										
										System.out.println("Define the coefficients of your second matrix");
										m2m.matrixSetter("n"); // Set the coefficients of the matrix m1m
										System.out.println();
										bol = true;
									} catch (InputMismatchException e) {
										System.out.println();
										System.out.println("Your value isn't a real number. Please, start again with real numbers");
										System.out.println();
										bol = false;
									}
								}
							}
						bol = false;
						
						Matrix m3m = m1m.multiplication(m2m); // Define the result matrix m3m of the multiplication of the matrix m1m and the matrix m2m
						System.out.println("The final result is :");
						System.out.println(); 
						m3m.disp(); // Display the result matrix m3m  
					
					} else if (a.equals("p")){ // Case for a matrix raised to a power
						
						System.out.println("Let's raise your square matrix to a chosen power.");
						System.out.println();
						
						System.out.println("Enter the dimensions of your matrix");
						Matrix m1p = new Matrix(1, 1); // Initialize the matrix m1p
							while(!bol){ // Start again the loop if the entered values for the rows and columns aren't integers
								try{
									m1p = new Matrix(Matrix.rowsChoice(), Matrix.columnsChoice()); // Define the dimensions of the matrix m1p
									System.out.println();
									t = m1p.isSquare(); // Reset the checker
									Matrix.powerChangeMatrix(m1p, t); // Verify if the matrix m1p can be raised to any power
									bol = true;
								} catch (InputMismatchException e) {
									System.out.println();
									System.out.println("Your value isn't an integer. Please, start again with integers.");
									bol = false;
									System.out.println();
								}
							}
						bol = false;
						
							while(!bol){ // Start again the loop if the entered values for the coefficients aren't real numbers
								try{		
									System.out.println("Choose the type of your matrix");
									String b = m1p.matrixChoice(); // Ask the user which type of matrix they want for the matrix m1p and define
																   // the letter chosen by the user and associated to a type of matrix 
									m1p.matrixSetter(b); // Set the matrix m1p as a function of the letter chosen by the user
									System.out.println();
									bol = true;
								} catch (InputMismatchException e) {
									System.out.println();
									System.out.println("Your value isn't a real number. Please, start again with real numbers");
									System.out.println();
									bol = false;
								}
							}
						bol = false;

						System.out.print("Enter the power (a positive integer) you want to use : ");
						int pow = -1; // Initialize the power
							while (!bol) { // Start again the loop as long as the entered value is not an integer
								try{
									pow = sc.nextInt(); // Allow the user to enter the power
									System.out.println();
										while (pow <0) { // Start again the loop as long as the entered value is not a positive integer
											System.out.print("Your value isn't a positive integer. Please, start again with a positive integer : ");
											pow = sc.nextInt(); // Allow the user to enter the power
											System.out.println();
										}
									bol = true;
								} catch (InputMismatchException e) {
									System.out.println();
									System.out.print("Your value isn't a positive integer. Please, start again with a positive integer : ");
									bol = false;
									sc.nextLine();
								}
							}
						bol = false;
						
						Matrix m3p = m1p.power(pow); // Define the result matrix m3p set by the matrix m1p raised to the power pow
						System.out.println("The final result is :");
						System.out.println(); 
						m3p.disp();	// Display the result matrix m3p
						
					} else if (a.equals("t")){ // Case for the transposition of a matrix
						
						System.out.println("Let's transpose your matrix.");
						System.out.println();
						
						System.out.println("Enter the dimensions of your matrix");
						Matrix m1t = new Matrix(1, 1); // Initialize the matrix m1t
							while(!bol){ // Start again the loop if the entered values for the rows and columns aren't integers
								try{
									m1t = new Matrix(Matrix.rowsChoice(), Matrix.columnsChoice()); // Define the dimensions of the matrix m1t
									bol = true;
								} catch (InputMismatchException e) {
									System.out.println();
									System.out.println("Your value isn't an integer. Please, start again with integers.");
									bol = false;
									System.out.println();
								}
							}
						bol = false;

							if(m1t.isSquare()){ // Case the matrix m1p is a square matrix
								while(!bol){ // Start again the loop if the entered values for the coefficients aren't real numbers
									try{
										System.out.println();
										System.out.println("Choose the type of your matrix");
										String b = m1t.matrixChoice(); // Ask the user which type of matrix they want for the matrix m1t and define
																	   // the letter chosen by the user and associated to a type of matrix
										m1t.matrixSetter(b); // Set the matrix m1t as a function of the letter chosen by the user
										bol = true;
									} catch (InputMismatchException e) {
										System.out.println();
										System.out.println("Your value isn't a real number. Please, start again with real numbers");
										bol = false;
									}
								}
							} else { // Case the matrix m1t is not a square matrix
								while(!bol){ // Start again the loop if the entered values for the coefficients aren't real numbers
									try{
										System.out.println(); 
										System.out.println("Define the coefficients of your matrix"); 
										m1t.matrixSetter("n"); // Set the coefficients of the matrix m1t
										bol = true;
									} catch (InputMismatchException e) {
										System.out.println();
										System.out.println("Your value isn't a real number. Please, start again with real numbers");
										bol = false;
									}
								}	
							}
						bol = false;
						
						System.out.println();
						Matrix m3t = m1t.transpose(); // Define the result matrix m3t set by the transposition of the matrix m1t
						System.out.println("The final result is :");
						System.out.println(); 
						m3t.disp(); // Display the result matrix m3t
						
						
					} else if (a.equals("d")){ // Case for the determinant of a matrix
						
						System.out.println("Let's compute the determinant of your square matrix.");
						System.out.println();
						
						System.out.println("Enter the dimensions of your matrix");
						Matrix m1d = new Matrix(1, 1); // Initialize the matrix m1d
							while(!bol){ // Start again the loop if the entered values for the rows and columns aren't integers
								try{
									m1d = new Matrix(Matrix.rowsChoice(), Matrix.columnsChoice()); // Define the dimensions of the matrix m1d
									System.out.println();
									t = m1d.isSquare(); // Reset the checker
									Matrix.detChangeMatrix(m1d, t); // Verify if the determinant of the matrix m1d can be computed
									bol = true;
								} catch (InputMismatchException e) {
									System.out.println();
									System.out.println("Your value isn't an integer. Please, start again with integers.");
									bol = false;
									System.out.println();
								}
							}
						bol = false;
						

							while(!bol){ // Start again the loop if the entered values for the coefficients aren't real numbers
								try{
									System.out.println("Choose the type of your matrix");
									String b = m1d.matrixChoice(); // Ask the user which type of matrix they want for the matrix m1d and define
																   // the letter chosen by the user and associated to a type of matrix
									
									m1d.matrixSetter(b); // Set the matrix m1d as a function of the letter chosen by the user
									bol = true;
								} catch (InputMismatchException e) {
									System.out.println();
									System.out.println("Your value isn't a real number. Please, start again with real numbers");
									System.out.println();
									bol = false;
								}
							}
						bol = false;
						
						System.out.println();		
						int N = m1d.n; // Define the initial dimension N x N of the matrix m1d
						System.out.println("The final result is :");
						System.out.println(); 
						System.out.println(m1d.det(m1d.n, N)); // Display the determinant of the matrix m1d
						System.out.println(); 
						
						
					} else if (a.equals("g")){ // Case for the solutions of a system of equations
						
						System.out.println("Let's solve your system of equation in which the number of unknowns is" + "\n" 
											+ "non greater than the number of equations in the system.");
						System.out.println();
						
						System.out.print("How many equations have you in your system ? : ");
						int row = 0; // Initialize the number of equations of their system
							while(!bol){ // Start again the loop if the entered value for row isn't an integer
								try{
									row = sc.nextInt(); // Allow the user to enter the number of equations of their system
									System.out.println();
										while (row <0) { // Start again the loop as long as the entered value is not a positive integer
											System.out.print("Your value isn't a positive integer. Please, start again with a positive integer : ");
											row = sc.nextInt(); // Allow the user to enter the power
										}
									bol = true;
								} catch (InputMismatchException e) {
									System.out.println();
									System.out.print("Your value isn't a positive integer. Please, start again with a positive integer: ");
									bol = false;
									sc.nextLine();
								}
							}
						bol = false;
						
						Matrix m1g = new Matrix(row , row+1); // Define the matrix m1g associated to the system of equations
						
							while(!bol){ // Start again the loop if the entered values for the rows and columns aren't integers
								try{
									System.out.println("Before anything else, be sure that your system is ordered in such a way as the coefficient of the" + "\n"
														+ "first unknown of each equation appears one below the other, and so on.");
									System.out.println();
									m1g.coeffSystem(); // Allow the user to enter the coefficients and the results of their system of equations
									bol = true;
								} catch (InputMismatchException e) {
									System.out.println();
									System.out.println("Your value isn't an  real number. Please, start again with real numbers : ");
									System.out.println();
									bol = false;
								}
							}
						bol = false;
						
						System.out.println();
						flag = m1g.gauss(); // Reset the indicator
							
							if (flag == 1){     
								flag = m1g.optionsPossible(flag); 
							}
							
						m1g.resultSystem(flag); // Display the solutions of the system of equations
					
					} else if (a.equals("i")){ // Case for the inverse of a matrix
						
						System.out.println("Let's determine the inverse of your square matrix");
						System.out.println();
						
						System.out.println("Enter the dimensions of your matrix");
						Matrix m1i = new Matrix(1,1); // Initialize the matrix m1i 
							while(!bol){ // Start again the loop if the entered values for the rows and columns aren't integers
								try{
									m1i = new Matrix(Matrix.rowsChoice(), Matrix.columnsChoice()); // Define the dimensions of the matrix m1i
									System.out.println();
									t = m1i.isSquare(); // Reset the checker 
									Matrix.invChangeMatrix(m1i, t); // Verify if the matrix can be inverted
									bol = true;
								} catch (InputMismatchException e) {
									System.out.println();
									System.out.println("Your value isn't an integer. Please, start again with integers.");
									bol = false;
									System.out.println();
								}
							}
						bol = false;
						
							while(!bol){ // Start again the loop if the entered values for the coefficients aren't real numbers
								try{
									System.out.println("Choose the type of your matrix");
									String b = m1i.matrixChoice(); // Ask the user which type of matrix they want for the matrix m1i and define
																   // the letter chosen by the user and associated to a type of matrix
									m1i.matrixSetter(b); // Set the matrix m1i as a function of the letter chosen by the user
									System.out.println();
									int N = m1i.n; // Define the initial dimension N x N of the matrix m1i
									
									v = m1i.isDetNull(m1i.det(m1i.n, N)); // Reset the checker 
									Matrix.detNullChangeMatrix(m1i,v); // Verify if the determinant of the matrix is null 
									bol = true;
								} catch (InputMismatchException e) {
									System.out.println();
									System.out.println("Your value isn't a real number. Please, start again with real numbers");
									System.out.println();
									bol = false;
								}
							}
						bol = false;
								
						
						Matrix m3i = m1i.inverse(); // Define the result matrix m3i that is the inverse matrix of m1i
						System.out.println("The final result is :");
						System.out.println(); 
						m3i.disp(); // Display the matrix m3i
						
					}
				
			System.out.print("If you want to stop the Matrix operator, enter the integer '0'" +  "\n" 
								+  "Otherwise, enter the integer '1' to use the Matrix operator again : ");
				
				
				try { // Add a delay of 1000ms
					Thread.sleep(1000);

				} catch (InterruptedException ie){
					ie.printStackTrace();
				}
				
				boolean c = false; // Initialize the stopper checker
				while(!bol){ // Start again the loop if the entered values for the coefficients aren't real numbers
					try{
						s = sc.nextInt(); // Allow the user to use the Matrix operator again or to stop using the Matrix operator
						while (c==false){
							if(s==0){
								stopper = true;
								c = true;
							} else if ( s==1) {
								stopper = false; 
								c = true;
							} else if (s != 0 && s !=1){
								System.out.println();
								System.out.print("Please, enter the integer '0' or '1' : ");
								s = sc.nextInt();
								c = false;
							}
						}
						bol = true;
					} catch (InputMismatchException e) {
						System.out.println();
						System.out.print("Please, enter the integer '0' or '1' : ");
						bol = false;
						sc.nextLine();
					}
				}
				bol = false;
				
		} while (!stopper);
		
		System.out.println();
		System.out.println("Thank you for using the Matrix operator !");
		System.out.println();

	}
	
}






