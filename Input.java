import java.util.*;

public class Input {

	/* All functions here */

	private String Q; //gets dividend
	private String M; //gets divisor
	private String M_twos; 
	private String A; //pass divisor
	private String A_after;
	private int A_len;
	private int Cycle;
	private int A_added; 
	private String A_shift;
	private String Q_shift;

	public Input(String dend, String sor){
		createA(sor);
		setQ(dend);
		setM(sor);
		cycleLoop(dend);
	}
	
	public String toBinary(String i){
		double temp = Double.parseDouble(i);
		if (temp == 0) {
	           return "0";
	       }
	       String binary = "";
	       while (temp > 0) {
	           int rem = (int) (temp % 2);
	           binary = rem + binary;
	           temp = temp / 2;
	       }
	       return binary;
	}

	public String toDecimal(String i){
		double decimal = 0;
		for(int x=0; x < i.length(); x++){
		   if(i.charAt(x)== '1')
		     decimal = decimal + Math.pow(2, i.length()-1-x);
		}
		return Integer.toString((int)decimal, 10);
	}

	public void cycleLoop(String q){
		//number of cycles depends on # of bits Q
		Cycle = q.length() - 1;
	}

	public void createA(String i){
		A_len = i.length();
		StringBuilder Atemp = new StringBuilder();

		for(int x = 0; x < A_len + 1; x++){
			Atemp.append("0");
		}

		A = Atemp.toString();
	}

	public void setQ(String d){
		Q = d;
	}

	public void setM(String d){
		M = d;
		while(M.length() == A_len)
			M = "0" + M;
	}

	public String getA(){
		return A;
	}


	public String getQ(){
		return Q;
	}
	
	public String getAshift(){
		return A_shift;
	}


	public String getQshift(){
		return Q_shift;
	}

	public String getM(){
		return M;
	}
	
	public int getCycle(){
		return Cycle;
	}

	public void process(){
		/*
		 -shift aq
		 -subtract A-M
		 -checkrestore
		 -add return of checkrestore to q lsb
		 -print to gui
		 */
		
		shiftAQ();
		getComplement();
		subtract();
		checkRestore();
	}

	public void shiftAQ(){
		/*remove msb A, add msb of Q to lsb A
		 *and check @ checkRestore if 1 or 0
		 *add digit to lsb Q*/

		/*
		String test_a = "00000000";
		String test_q = "100010010";

		System.out.println(test_a + "//" + test_q);
		test_a = test_a.substring(1);
		test_a = test_a + test_q.substring(0, 1);
		test_q = test_q.substring(1);
		test_q = test_q + "x";
		System.out.println(test_a + "//" + test_q);
		*/

		A = A.substring(1) + Q.substring(0, 1);
		Q = Q.substring(1);
		A_shift = A;
		Q_shift = Q + "_";

	}

	public void getComplement(){
		int slength = M.length();
		String reversed = null, temp;
		
        // Reverse
				for(int i = 0; i<slength; i++){
            temp = M.substring(i, i+1);
            if(i == 0){
                if(temp.equals("1"))
                    reversed = "0";
								else
                    reversed = "1";
				}
            else{
								if(temp.equals("1"))
                    reversed = reversed + "0";
								else
                    reversed = reversed + "1";
            }
				}

        String complement = null;
        int flag = 0;
        boolean carry = true;

        // +1

        for(int i = slength; i>0; i--){
            temp = reversed.substring(i-1, i);
            if(i == slength){
                if(temp.equals("1") ){
                    complement = "0";
                    carry = true;
                }
                else{
                    complement = "1";
                    carry = false;
                }
            }
            else{
                if(carry){
                    if(temp.equals("1")){
                        complement = complement + "0";
                        carry = true;
                    }
                    else{
                        complement = complement + "1";
                        carry = false;
                    }
                }
                else{
                    complement = complement + temp;
                }
            }

        }
        String ctemp = null;
        // Reverse final answer
        for(int i = complement.length(); i>0; i--){
            temp = complement.substring(i-1, i);
            if(i == complement.length())
                ctemp = temp;
            else
                ctemp = ctemp + temp;

        }
        complement = ctemp;

       // variable complement is 2s complemented of input variable

			 M_twos = complement;
	}

	public void subtract(){
		/*
		//2's complement M then add to A
		String tempComp = "0" + M_twos,
           tempA = A,
           x, y,
	         result = null;
		int lengthC = tempComp.length(),
	    	lengthA = tempA.length();
	  boolean carry = true;
	  int ctr = 0;
		for(int i=lengthA; i>0; i--){
			x = tempComp.substring(i-1, i);
      y = tempA.substring(i-1, i);
			if(i == lengthA){
				if(x.equals("1") && y.equals("1")){
					result = "0";
					carry = true;
				}
        else if((x.equals("1") && y.equals("0")) || (x.equals("0") && y.equals("1"))){
					result = "1";
					carry = false;
				}
        else if(x.equals("0") && y.equals("0")){
        	result = "0";
          carry = false;
        }
			}
			else{
				if(carry){
					if( x.equals("1") && y.equals("1") ){
						result = "1" + result;
						carry = true;
					}
        	else if((x.equals("1") && y.equals("0")) || (x.equals("0") && y.equals("1"))){
						result = "0" + result;
						carry = true;
					}
          else if(x.equals("0") && y.equals("0")){
            result = "1" + result;;
            carry = false;
          }
				}
				else{
					if(x.equals("1") && y.equals("1")){
						result = "0" + result;
						carry = true;
					}
          else if((x.equals("1") && y.equals("0")) || (x.equals("0") && y.equals("1"))){
						result = "1" + result;
						carry = false;
					}
          else if(x.equals("0") && y.equals("0")){
            result = "0" + result;
            carry = false;
          }
				}
			}
		}
		//FINAL ANSWER IS IN RESULT VARIABLE
		A_after = result;
		*/
		
		String A_temp = A, M_temp = M_twos;
		StringBuilder sb = new StringBuilder();
		int x = A.length()-1, y = M.length()-1;
		int carry = 0, sum;
		
		while(x >= 0 || y >= 0){
			sum = 0;
			if(x >= 0 && A_temp.charAt(x)=='1')
	            sum++;    
	 
	        if(y >= 0 && M_temp.charAt(y)=='1')
	            sum++;

	        sum += carry;
	 
	        if(sum>=2)
	            carry=1;
	        else
	            carry=0;
	 
	        sb.insert(0, (char)((sum%2) + '0'));
	 
	        x--;
	        y--;
		}
		
		//if(carry==1)
	    //    sb.insert(0, '1');
		
		A_after = sb.toString();
	}

	public void checkRestore(){
		/*store orig A to temp then check
		 * if subtract neg, restore orig and shiftaq lsb 0
		 * if subtract pos, remain with subtracted and shiftaq lsb 1
		 */

		 String check = A_after.substring(0,1);
		 if(check.equals("1")){
			 Q = Q + "0";
		 }
		 else if(check.equals("0")){
			 Q = Q + "1";
			 A = A_after;
		 }
	}
	
	public String getMtwo(){
		return M_twos;
	}
	
	public String getAsub(){
		return A_after;
	}
	
	public int rest(){
		String check = A_after.substring(0,1);
		 return Integer.parseInt(check);
	}
	
	public void reset(){
		Q = null;
		M = null;
		M_twos = null;
		A = null;
		A_after = null;
		A_len = (Integer) null;
		Cycle = (Integer) null;
		A_added = (Integer)null; 
		A_shift = null;
		Q_shift = null;
	}

}
