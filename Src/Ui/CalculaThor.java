import java.util.Scanner;
import java.lang.Math;



public class CalculaThor{
	/**
		*This is a array that contains the memory of the last 10 operations	</br>
	*/
	public static double memory[] = new double[10];
	/**
		*This is a integer cont, is used to know when the array is full
	*/
	public static int contMemory = 0;
	
	public static void	 main(String args[]){
	String operator;
	double num1;
	String string1;
	boolean a = true;
	boolean menu = true;
	String result;
	
	
	Scanner inNum = new Scanner(System.in);
	Scanner in = new Scanner(System.in);
	
	while (menu){
	
		System.out.println("");
		System.out.println("							CALCULATHOR");
		System.out.println("");
		System.out.println("					             _.gd8888888bp._				");
		System.out.println("					          .g88888888888888888p.				");
		System.out.println("					        .d8888P\"\"	\"\"Y8888b.		");
		System.out.println("					        \"Y8P\" 	             \"Y8P\'	");
		System.out.println("					           `. 		     ,\'			");
		System.out.println("						     \\	    .-.	    /				");
		System.out.println("						      \\    (___)   /				");
		System.out.println("	 .------------------.__________________________:__________j					");
		System.out.println("	/ 		    |			       |	  |`-.,_			");
		System.out.println("	\\###################|##########################|##########|,-\'`	");
		System.out.println("	 `------------------'	   		       :    ___   l					");
		System.out.println("						      /    (   )   \\				");
		System.out.println("						     / 	    `-'	    \\				");
		System.out.println("					           ,\'   	     `.				");
		System.out.println("					        .d8b. 		     .d8b.			");
		System.out.println("					        \"Y8888p.. 	,.d8888P\"			");
		System.out.println("					          \"Y88888888888888888P\"			");
		System.out.println("					   	      \"\"YY8888888PP\"\"			");
		System.out.println("");
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		System.out.println("");
		System.out.println("Welcome to CalculaThor, the calculator for the Gods!");
		System.out.println("");
		System.out.println("Type 1 to the one by one operation");
		System.out.println("Type 2 to the operations flow");
		System.out.println("Type 3 to exit");
		System.out.println("");
		System.out.print("-->");
		int modeOperation = inNum.nextInt();
		System.out.println("");
		
		switch (modeOperation){
			//one bye one Mode
			case 1:
				System.out.print(">");
				string1 = in.next();
				System.out.print(">");
				operator=in.next();
				
				string1=identifyMemory(string1);
				System.out.println(identifyOperator(operator,string1,inNum));
				
				System.out.println("Type # to continue...");
				in.next();
			break;
			
			//flow operations
			case 2:
				System.out.print(">");
				string1 = in.next();
				System.out.print(">");
				operator=in.next();
				string1=identifyMemory(string1);
				result = identifyOperator(operator,string1,inNum);
				System.out.println(" =");
				System.out.println(">"+result);
				while(a){
					string1 = result;
					System.out.print(">");
					operator=in.next();
					if(operator.equalsIgnoreCase("#")) {
						a=false;
					}else {
						result = identifyOperator(operator,string1,in);
						System.out.println(" =");
						System.out.println(">"+result);
					}
				}
			break;
			case 3:
				menu = false;
			break;
			case 100:
				System.out.println("");
				System.out.println("					             _.gd8888888bp._				");
				System.out.println("					          .g88888888888888888p.				");
				System.out.println("					        .d8888P\"\"	\"\"Y8888b.		");
				System.out.println("					        \"Y8P\" 	             \"Y8P\'	");
				System.out.println("					           `. 		     ,\'			");
				System.out.println("						     \\	    .-.	    /				");
				System.out.println("						      \\    (___)   /				");
				System.out.println("	 .------------------.__________________________:__________j					");
				System.out.println("	/ 		    |			       |	  |`-.,_			");
				System.out.println("	\\###################|##########################|##########|,-\'`	");
				System.out.println("	 `------------------'	   		       :    ___   l					");
				System.out.println("						      /    (   )   \\				");
				System.out.println("						     / 	    `-'	    \\				");
				System.out.println("					           ,\'   	     `.				");
				System.out.println("					        .d8b. 		     .d8b.			");
				System.out.println("					        \"Y8888p.. 	,.d8888P\"			");
				System.out.println("					          \"Y88888888888888888P\"			");
				System.out.println("					   	      \"\"YY8888888PP\"\"			");
				System.out.println("");
				System.out.println("-----------------------------------------------------------------------------------------------------------");
				System.out.println("");
				System.out.println("Type RAGNAROK to begin the battle");
				in.next();
			break;
			default:
			System.out.println("Type a valid option");
			System.out.println("Type # to continue");
			in.next();
		}
		
		//borrar pantalla
		 try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
        }
	}
	}
	
	/**
		*This method recieves a double number that is saved in a global array, if the array is full 					</br>
		*the values of the array are moved and the new value remplaces the value of the position 0 of the array 		</br>
		
		*<b>Pre:</b>	The variable num1 that is passed like param needs to be declared before, needs to contain a	</br>
		*				correct type of value.																		</br>
		
		*<b>Post:</b>	The number num1 is added to the global double array memory, if the array is full			</br>
		*				the numbers in the array are moved, the first number added is erased, and is added the num1.</br>
		*				The global variable contMemory is increased by one											</br>
		
		*@param num1 	this is a double number num1!=null && num1 == (number)
	*/
	public static void	 SaveMemory(double num1){
		
		if(CalculaThor.contMemory<10){
			CalculaThor.memory[CalculaThor.contMemory] = num1;
		}else{
			for(int i = 0; i < 9;i++){
				CalculaThor.memory[i]=CalculaThor.memory[i+1];
			}
			CalculaThor.memory[9]=num1;
		}
		CalculaThor.contMemory++;
	}
	
	/**
		*This method recieve a string, and compare the string with the cases of a switch; return a memory, or the value of PI,		</br>
		*or the same string, depending the contain of the string																	</br>
		
		*<b>Pre:</b>	The variable num1 that is passed like parameter need to be declared before, need to contain 				</br>
		*				a number or an option available to choose. The array Memory need to be declared before.						</br>
		
		*<b>Post:</b>	Return a number of a array Memory, the value of PI, or if the string isn't a option return 					</br>
		*				the number on the string. This number was transform to a string												</br>
		
		*@param num1 this is a string that could have a number or a valid option of the switch	num1 ==(switch case)||num1==number	</br>
		*@return mem, tht is the string with the corresponding value
	*/
	public static String identifyMemory(String num1){
		String mem;
		num1 = num1.toLowerCase();
		
		switch(num1){
			case "mem1":
				mem = Double.toString(CalculaThor.memory[0]);
			break;
			case "mem2":
				mem = Double.toString(CalculaThor.memory[1]);
			break;
			case "mem3":
				mem = Double.toString(CalculaThor.memory[2]);
			break;
			case "mem4":
				mem = Double.toString(CalculaThor.memory[3]);
			break;
			case "mem5":
				mem = Double.toString(CalculaThor.memory[4]);
			break;
			case "mem6":
				mem = Double.toString(CalculaThor.memory[5]);
			break;
			case "mem7":
				mem = Double.toString(CalculaThor.memory[6]);
			break;
			case "mem8":
				mem = Double.toString(CalculaThor.memory[7]);
			break;
			case "mem9":
				mem = Double.toString(CalculaThor.memory[8]);
			break;
			case "mem10":
				mem = Double.toString(CalculaThor.memory[9]);
			break;
			case "pi":
				mem=Double.toString(Math.PI);
			break;
			default:
				mem = num1;
		}
		return mem;
	}
	
	/**
		*This method recieve a 2 strings and a scanner, the first string is the operator, and the second is a number on a string;	</br>
		*compares the operator with the cases of a switch, if the operation needs 2 numbers the method use the scanner to get the	</br>
		*second; calls the method of the corresponding case that returns the result													</br>
		*of the operation. After this, calls the method saveMemory that save the result on a global array.							</br>
		
		*<b>Pre:</b>	The variable operator that is passed like parameter needs to be declared before, needs to contain a correct </br>
		*				type of value. The variable num needs to be declared before, needs to contain a number on a string, 		</br>
		*				or a hex, or binary numbers. The Scanner in needs to be daclared before. All the methods need to exist.		</br>
		*				The library Math need to be imported.																		</br>
		*
		*<b>Post:</b>	the result value is saved in the array memory, the result is in the variable result, that after is returned	</br>
		
		*@param num this is a string that have a number, a hex number, or a binary num.	num ==(hex)||num==(binary)||num==number && num!=null	</br>
		*@param operator this is a string that contains one of the options of the switch. operator!=null									</br>
		*@param in this is a scanner object, this need to be declared before														</br>
		*@return result, is the final value of the operation made.																	</br>
	*/
	public static String identifyOperator(String operator, String num,Scanner in){
		
	double num1 = 0;
	String result = "null";
	String string2;
	double num2=0;
	boolean chooseOperator = false;
	operator = operator.toLowerCase();
	
	do{
		
		switch(operator){
			case "+":
				num1 = Double.parseDouble(num);
				System.out.print(">");
				string2 = in.next();
				num2=Double.parseDouble(identifyMemory(string2));
				result = Double.toString(Sum(num1,num2));
				chooseOperator=false;
			break;
			case "-":
				num1 = Double.parseDouble(num);
				System.out.print(">");
				string2 = in.next();
				num2=Double.parseDouble(identifyMemory(string2));
				result = Double.toString(Substraction(num1,num2));
				chooseOperator=false;
			break;
			case "*":
				num1 = Double.parseDouble(num);
				System.out.print(">");
				string2 = in.next();
				num2=Double.parseDouble(identifyMemory(string2));
				result = Double.toString(Multiplication(num1,num2));
				chooseOperator=false;
			break;
			case "/":
				num1 = Double.parseDouble(num);
				System.out.print(">");
				string2 = in.next();
				num2=Double.parseDouble(identifyMemory(string2));
				result = Double.toString(Division(num1,num2));
				chooseOperator=false;
			break;
			case "%":
				num1 = Double.parseDouble(num);
				System.out.print(">");
				string2 = in.next();
				num2=Double.parseDouble(identifyMemory(string2));
				result = Double.toString(Modular(num1,num2));
				chooseOperator=false;
			break;
			case "log":
				num1 = Double.parseDouble(num);
				result = Double.toString(Math.log10(num1));
				chooseOperator=false;
			break;
			case "logx":
				num1 = Double.parseDouble(num);
				System.out.print(">");
				string2 = in.next();
				num2=Double.parseDouble(identifyMemory(string2));
				result = Double.toString(Math.log(num1)/Math.log(num2));
				chooseOperator=false;
			break;
			case "root":
				num1 = Double.parseDouble(num);
				result = Double.toString(Root(num1));
				chooseOperator=false;
			break;
			case "rootx":
				num1 = Double.parseDouble(num);
				System.out.print(">");
				string2 = in.next();
				num2=Double.parseDouble(identifyMemory(string2));
				result = Double.toString(Math.pow(num1,(1/num2)));
				chooseOperator=false;
			break;
			case "fact":
				num1 = Double.parseDouble(num);
				result = Double.toString(Factorial((int)num1));
				chooseOperator=false;
			break;
			case "sen":
				num1 = Double.parseDouble(num);
				result = Double.toString(Math.sin(num1));
				chooseOperator=false;
			break;
			case "cos":
				num1 = Double.parseDouble(num);
				result = Double.toString(Math.cos(num1));
				chooseOperator=false;
			break;
			case "tan":
				num1 = Double.parseDouble(num);
				result = Double.toString(Math.tan(num1));
				chooseOperator=false;
			break;
			case "pow":
				num1 = Double.parseDouble(num);
				System.out.print(">");
				string2 = in.next();
				num2 = Double.parseDouble(identifyMemory(string2));
				int num3 = (int)num2;
				result = Double.toString(Power(num1,num3));
				chooseOperator=false;
			break;
			case "htd":
				result = Double.toString(HexToDec(num));
				chooseOperator = false;
			break;
			case "dth":
				num1 = Double.parseDouble(num);
				result = DecToHex(num1);
				chooseOperator = false;
			break;
			case "htb":
				result = HexToBin(num);
				chooseOperator = false;
			break;
			case "dtb":
				num1 = Double.parseDouble(num);
				result = DecToBin(num1);
				chooseOperator = false;
			break;
			case "bth":
				result = BinToHex(num);
				chooseOperator = false;
			break;
			case "btd":
				result = Double.toString(BinToDec(num));
				chooseOperator = false;
			break;
			case "dtr":
				num1 = Double.parseDouble(num);
				result = Double.toString(DegToRad(num1));
				chooseOperator = false;
			break;
			case "rtd":
				num1 = Double.parseDouble(num);
				result = Double.toString(RadToDeg(num1));
				chooseOperator = false;
			break;
			case "b10":
				num1 = Double.parseDouble(num);
				result = Base10(num1);
				chooseOperator = false;
			break;
			default:
			System.out.println("Type a valid operator:");
			System.out.print(">");
			operator = in.next();
			chooseOperator=true;
		}	
	}while(chooseOperator);
	
	switch(operator){
		case "dth":
			SaveMemory(num1);
		break;
		case "bth":
			SaveMemory(BinToDec(num));
		break;
		case "htb":
			SaveMemory(HexToDec(num));
		break;
		case "dtb":
			SaveMemory(num1);
		break;
		case "b10":
			SaveMemory(num1);
		break;
	default:
		SaveMemory(Double.parseDouble(result));
	}
	
	return result;
	}
	
	/**
		*This method recieve 2 numbers, do a sum and returns the result				</br>
		
		*<b>Pre:</b>	the num1 and num2 variables need to be declared before.			</br>
		
		*<b>Post:</b>	the result is saved in the variable sum, that after is returned	</br>
		
		*@param num1 this is a double number. num1!=null&&num1==(number)				</br>
		*@param num2 this is a double number. num2!=null&&num2==(number)				</br>
		*@return sum, is the final value of the operation made.						</br>
	*/
	public static double Sum(double num1,double num2){
		double sum = num1+num2;
	return sum;
	}
	
	/**
		*This method recieve 2 numbers, do a substraction and returns the result				</br>
		
		*<b>Pre:</b>	the num1 and num2 variables need to be declared before.			</br>
		
		*<b>Post:</b>	the result is saved in the variable substraction, that after is returned	</br>
		
		*@param num1 this is a double number. num1!=null&&num1==(number)				</br>
		*@param num2 this is a double number. num2!=null&&num2==(number)				</br>
		*@return substraction, is the final value of the operation made.				</br>
	*/
	public static double Substraction(double num1,double num2){
		double substraction = num1-num2;
	return substraction;
	}
	
	/**
		*This method recieve 2 numbers, do a division and returns the result				</br>
		
		*<b>Pre:</b>	the num1 and num2 variables need to be declared before.			</br>
		
		*<b>Post:</b>	the result is saved in the variable div, that after is returned	</br>
		
		*@param num1 this is a double number. num1!=null&&num1==(number)				</br>
		*@param num2 this is a double number. num2!=null&&num2==(number)&&num2!=0		</br>
		*@return division, is the final value of the operation made.						</br>
	*/
	public static double Division(double num1,double num2){
		double division = num1/num2;
	return division;
	}
	
	/**
		*This method recieve 2 numbers, do a multiplication and returns the result	</br>
		
		*<b>Pre:</b>	the num1 and num2 variables need to be declared before.			</br>
		
		*<b>Post:</b>	the result is saved in the variable mult, that after is returned</br>
		
		*@param num1 this is a double number. num1!=null&&num1==(number)				</br>
		*@param num2 this is a double number. num2!=null&&num2==(number)				</br>
		*@return mult, is the final value of the operation made.						</br>
	*/
	public static double Multiplication(double num1,double num2){
		double mult = num1*num2;
	return mult;
	}
	
	/**
		*This method recieve 2 numbers, do a modular(the remainder) and returns the result	</br>
		
		*<b>Pre:</b>	the num1 and num2 variables need to be declared before.					</br>
		
		*<b>Post:</b>	the result is saved in the variable modular, that after is returned			</br>
		
		*@param num1 this is a double number. num1!=null&&num1==(number)						</br>
		*@param num2 this is a double number. num2!=null&&num2==(number)&&num2!=0				</br>
		*@return modular, is the final value of the operation made.								</br>
	*/
	public static double Modular(double num1,double num2){
		double modular = num1%num2;
	return modular;
	}
	
	/**
		*This method recieve a number, do a square root and returns the result		</br>
		
		*<b>Pre:</b>	the num1 variable needs to be declared before.			</br>
		
		*<b>Post:</b>	the result is saved in the variable root, that after is returned</br>
		
		*@param num1 this is a double number. num1!=null&&num1==(number)				</br>
		*@return root, is the final value of the operation made.						</br>
	*/	
	public static double Root(double num1){
		int cont = 30;
		double root = 50 ;
		double root2;
		if (num1==0){
			root = 0;
		}else{
		do{
			root2=root;
			root=((root2)/2)+((num1)/(2*root2));
			cont--;
		}while(root2!=root&&cont!=0);
		}
	return root;
	}
	
	/**
		*This method recieve 2 numbers, do a power and returns the result				</br>
		
		*<b>Pre:</b>	the num1 and num2 variables need to be declared before.			</br>
		
		*<b>Post:</b>	the result is saved in the variable pow, that after is returned	</br>
		
		*@param num1 this is a double number. num1!=null&&num1==(number)				</br>
		*@param num2 this is a int number. num2!=null&&num2==(number)					</br>
		*@return pow, is the final value of the operation made.							</br>
	*/
	public static double Power(double num1,int num2){
		double pow = num1;
		if (num2==0){
			pow = 1;
		}else{
		for (int i = 1; i<num2;i++)	pow *=num1;
		}
	return pow;
	}
	
	/**
		*This method recieve a number, do a factorial and returns the result			</br>
		
		*<b>Pre:</b>	the num1 variable needs to be declared before.					</br>
		
		*<b>Post:</b>	the result is saved in the variable fact, that after is returned</br>
		
		*@param num1 this is a int number. num1!=null&&num1==(number)&&num1>=0			</br>
		*@return fact, is the final value of the operation made.						</br>
	*/
	public static int	 Factorial(int num1){
		int fact = 1;
		if (num1!=0){
			for(int i = 1;i<=num1;i++) fact*=i;
		}
	return fact;
	}
	
	/**
		*This method recieve a string that contains a hex number, converts the string in a array 								</br>
		*make the conversion to the decimal number, transform the array in a number and returns it								</br>
		
		*<b>Pre:</b>	the num1 variables need to be declared before.															</br>
		
		*<b>Post:</b>	the result is saved in the variable dec, that after is returned											</br>
		
		*@param num1 this is a string that contains a hexadecimal number. num1!=null&&num1==(hex number)&&num1!=double number	</br>
		*@return dec, is the equivalent value of the hexadecimal number in decimal number.										</br>
	*/
	public static double HexToDec(String num1){
		System.out.println(num1);
		int cont = 0;
		int [] array = new int[num1.length()];
		double dec = 0;
		for(int i = num1.length()-1;i>=0;i--){
			switch (num1.charAt(i)){
				case 'a':
					array [i] = 10;
				break;
				case 'b':
					array[i] = 11;
				break;
				case 'c':
					array[i] = 12;
				break;
				case 'd':
					array[i] = 13;
				break;
				case 'e':
					array[i] = 14;
				break;
				case 'f':
					array[i] = 15;
				break;
				default:
				array [i] = Character.getNumericValue(num1.charAt(i));
			}
			array[i]*=Power(16,cont);
			dec +=array[i];
			cont++;
		}
		for(int i = 0;i<num1.length();i++){
			
		}
		return dec;
	}
	
	/**
		*This method recieve a string that contains a hex number, calls the methods HexToDec and DecToBin and return the 		</br>
		*corresponding value																									</br>
		
		*<b>Pre:</b>	the num1 variables need to be declared before, the methods HexToDec and DecToBin need to be created		</br>															</br>
		
		*<b>Post:</b>	the result is saved in the variable bin, that after is returned											</br>
		
		*@param num1 this is a string that contains a hexadecimal number. num1!=null&&num1==(hex number)&&num1!=double number	</br>
		*@return bin, is the equivalent value of the hexadecimal number in binary number.										</br>
	*/
	public static String HexToBin(String num1){
		String bin = "";
		bin = DecToBin(HexToDec(num1));
		return bin;
	}
	
	/**
		*This method recieve a double that contains a decimal number, converts the double in a array 							</br>
		*make the conversion to the hexadecimal number, transform the array in a String and returns it							</br>
		
		*<b>Pre:</b>	the num1 variables need to be declared before.															</br>
		
		*<b>Post:</b>	the result is saved in the variable hex, that after is returned											</br>
		
		*@param num1 this is a double that contains a decimal number. num1!=null&&num1==(number)								</br>
		*@return hex, is the equivalent value of the decimal number in hexdecimal number.										</br>
	*/
	public static String DecToHex(double num1){
		String hex = "";
		int length=0;
		int div=(int)num1;
		int mod = 0;
		do{
			div = div/16;
			length++;
		}while(div!=0);
		
		div = (int)num1;
		
		String array[] = new String[length];
		
		for (int i = array.length-1; i >= 0;i--){
			mod = div%16;
			div = div/16;
			
			switch (mod){
				case 10:
					array[i] = "A";
				break;
				case 11:
					array[i] = "B";
				break;
				case 12:
					array[i] = "C";
				break;
				case 13:
					array[i] = "D";
				break;
				case 14:
					array[i] = "E";
				break;
				case 15:
					array[i] = "F";
				break;
				default:
					array [i] = Integer.toString(mod);
			}
			
		}
		for (int i = 0;i<array.length;i++){
			hex=hex+array[i];
		}

		return hex;		
	}
	
	/**
		*This method recieve a double that contains a decimal number, converts the double in a array to							</br>
		*make the conversion to the binary number, transform the array in a String and returns it								</br>
		
		*<b>Pre:</b>	the num1 variables need to be declared before.															</br>
		
		*<b>Post:</b>	the result is saved in the variable bin, that after is returned											</br>
		
		*@param num1 this is a double that contains a decimal number. num1!=null&&num1==(number)								</br>
		*@return hex, is the equivalent value of the decimal number in binary number.											</br>
	*/
	public static String DecToBin(double num1){
		String bin = "";
		int length=0;
		int div=(int)num1;
		int mod = 0;
		
		do{
			div = div/2;
			length++;
		}while(div!=0);
		
		div = (int)num1;
		
		String array[] = new String[length];
		
		for (int i = array.length-1; i >= 0;i--){
			mod = div%2;
			div = div/2;
			array [i] = Integer.toString(mod);
		}
		for (int i = 0;i<array.length;i++){
			bin=bin+array[i];
		}
	return bin;
	}
	
	/**
		*This method recieve a string that contains a binary number, converts it in a binary number and returns it				</br>
		
		*<b>Pre:</b>	the num1 variables need to be declared before, the method power need to be created						</br>
		
		*<b>Post:</b>	the result is saved in the variable dec, that after is returned											</br>
		
		*@param num1 this is a string that contains a binary number. num1!=null&&num1==(binary number)							</br>
		*@return dec, is the equivalent value of the binary number in decimal number.											</br>
	*/
	public static double BinToDec(String num1){
		int cont = 0;
		double dec = 0;
		for (int i = num1.length()-1;i >=0;i--){
			dec += Character.getNumericValue(num1.charAt(i))*Power(2,cont);
			cont++;
			}
		return dec;
	}
	
	/**
		*This method recieve a string that contains a binary number, calls the methods BinToDec and DecToHex to make the 		</br>
		*conversion to the hexadecimal number, and returns it																	</br>
		
		*<b>Pre:</b>	the num1 variable need to be declared before, the methods BinToDec and DecToHex need to be created		</br>
		
		*<b>Post:</b>	the result is saved in the variable hex, that after is returned											</br>
		
		*@param num1 this is a string that contains a binary number. num1!=null&&num1==(binary number)							</br>
		*@return hex, is the equivalent value of the binary number in hexadecimal number.										</br>
	*/
	public static String BinToHex(String num1){
		String hex = "";
		hex = DecToHex(BinToDec(num1));
		return hex;
	}
	
	/**
		*This method recieve a number, do a conversion to radians and returns the result</br>
		
		*<b>Pre:</b>	the num1 variable need to be declared before.					</br>
		
		*<b>Post:</b>	the result is saved in the variable rad, that after is returned	</br>
		
		*@param num1 this is a double number. num1!=null&&num1==(number)				</br>
		*@return rad, is the equivalent to the degradian number to the radian number.	</br>
	*/
	public static double DegToRad(double num1){
		double rad = num1*Math.PI/180;
		return rad;
	}
	
	/**
		*This method recieve a number, do a conversion to degradians and returns the result</br>
		
		*<b>Pre:</b>	the num1 variable need to be declared before.						</br>
		
		*<b>Post:</b>	the result is saved in the variable deg, that after is returned		</br>
		
		*@param num1 this is a double number. num1!=null&&num1==(number)				</br>
		*@return deg, is the equivalent to the radian number to the degradian number.	</br>
	*/
	public static double RadToDeg(double num1){
		double deg = num1*180/Math.PI;
		return deg;
	}
	
	public static String Base10(double num1){
		double base10 = num1;
		String base10S = "";
		int contExp=0;
		if(num1 > 0){
			do{
				base10/=10;
				contExp++;
			}while((int)base10<10);
			base10S=base10+"*10^"+contExp;
		}else if(num1<0){
			do{
				base10*=10;
				contExp++;
				System.out.println(base10);
			}while((int)base10>0);
			
			contExp*=-1;
			base10S=base10+"*10^"+contExp;
			
		}else	base10S = "0*10^0";
		
		return base10S;
	}
} //End Class
