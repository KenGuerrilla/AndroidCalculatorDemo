package kenguerrilla.itl.androidcalculatordemo;

public class CalculatorModel {

	private Double sum;
	private String keyingLog="";
	private ActionMode mode;
	public enum actionModeCa {PLUS,SUB,MUL,DIV,NONE}
	private static CalculatorModel instance;


	public actionModeCa getAct(){
		return actionModeCa.SUB;
	}


	private CalculatorModel(){
		sum = 0.0;
		mode = ActionMode.NONE;
	}

	public static CalculatorModel getInstance(){

		if(instance == null){
			instance = new CalculatorModel();
		}
		return instance;
	}
	
	public Double checkIn(Double num,ActionMode newMode){
		
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
	
	public String checkIn(String num,ActionMode newMode){
		
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
		
			case NONE:
				keyingRecord(checkType(d));
				sum = d;
				break;
				
			case PLUS:
				keyingRecord("+"+checkType(d));
				sum += d;
				break;				
				
			case SUB:
				keyingRecord("-"+checkType(d));
				sum -= d;
				break;
				
			case MUL:
				keyingRecord("*"+checkType(d));
				sum *= d;
				break;	
				
			case DIV:
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
        mode = ActionMode.NONE;

	}
	
	public String getKeyingLog(){
		
		return keyingLog;
	}

}
