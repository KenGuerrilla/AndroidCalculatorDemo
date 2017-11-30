package kenguerrilla.itl.androidcalculatordemo;

public class Calculator {

	private Double sum;
	private String keyingLog="";
	private actionMode mode;

	public enum actionMode{	Plus,Sub,Mul,Div,None; }
	
	Calculator(){
		sum = 0.0;
		mode = actionMode.None;
	}
	
	public Double checkIn(Double num,actionMode newMode){
		
		if(num.isNaN()){
			mode = newMode;
			return Double.NaN;
		}
		else{
			calculate(num);
			mode = newMode;
			return sum;
		}		
	}
	
	public String checkIn(String num,actionMode newMode){
		
		if(num.equals("")){
			mode = newMode;
			return checkType(sum);
		}
		else{
			calculate(Double.valueOf(num));
			mode = newMode;
			return checkType(sum);
		}
	}
	
	private String checkType(Double sum){
		
		if(sum%1==0){
			return String.valueOf(sum.intValue());
		}
		else{
			return String.valueOf(sum);
		}
	}
		
	private void calculate(Double d){
	
		switch(mode){
		
			case None:
				keyingRecord(checkType(d));
				sum = d;
				break;
				
			case Plus:
				keyingRecord("+"+checkType(d));
				sum += d;
				break;				
				
			case Sub:
				keyingRecord("-"+checkType(d));
				sum -= d;
				break;
				
			case Mul:
				keyingRecord("*"+checkType(d));
				sum *= d;
				break;	
				
			case Div:
				keyingRecord("/"+checkType(d));
				sum /= d;
				break;
		}
	}
	
	private void keyingRecord(String s){
		
		keyingLog += s;
		
	}
	
	public void reset(){
		
        sum = 0.0;
        keyingLog ="";
        mode = actionMode.None;

	}
	
	public String getKeyingLog(){
		
		return keyingLog;
	}
	
	public actionMode getMode(){

		return mode;
	}
	
	public String getResult(){
		
		mode = actionMode.None;
		return checkType(sum);
	}

}
