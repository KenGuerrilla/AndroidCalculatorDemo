package kenguerrilla.itl.androidcalculatordemo;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class CalculatorMain extends AppCompatActivity implements OnClickListener {

    private TextView btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    private TextView btnPlus, btnSub, btnMul, btnDiv;
    private TextView btnClear, btnEqual, btnDot;
    private TextView viewProcess, viewResult;

    String resetProcess = "0.";

    String keyingBuffer="";
    String resultBuffer="";

    private Calculator cal = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_ayout);

        findView();
        setOnListener();
        reset();

    }

    public void onClick(View arg0) {

        int id = arg0.getId();

        switch (id){

            case R.id.view_btn_zero:
                keyingNumber("0");
                break;

            case R.id.view_btn_1:
                keyingNumber("1");
                break;

            case R.id.view_btn_2:
                keyingNumber("2");
                break;

            case R.id.view_btn_3:
                keyingNumber("3");
                break;

            case R.id.view_btn_4:
                keyingNumber("4");
                break;

            case R.id.view_btn_5:
                keyingNumber("5");
                break;

            case R.id.view_btn_6:
                keyingNumber("6");
                break;

            case R.id.view_btn_7:
                keyingNumber("7");
                break;

            case R.id.view_btn_8:
                keyingNumber("8");
                break;

            case R.id.view_btn_9:
                keyingNumber("9");
                break;

            case R.id.view_btn_dot:
                keyingNumber(".");
                break;

            case R.id.view_btn_plus:
                writer(Calculator.actionMode.Plus);
                break;

            case R.id.view_btn_sub:
                writer(Calculator.actionMode.Sub);
                break;

            case R.id.view_btn_mul:
                writer(Calculator.actionMode.Mul);
                break;

            case R.id.view_btn_div:
                writer(Calculator.actionMode.Div);
                break;

            case R.id.view_btn_equal:
                writer(Calculator.actionMode.None);
                break;

            case R.id.view_btn_clear:
                reset();
                break;

        }

    }


    private void keyingNumber(String s){

        keyingBuffer += s;
        viewResult.setText(keyingBuffer);

    }

    private void reset(){

        keyingBuffer = "";
        resultBuffer = "";
        viewProcess.setText(resetProcess);
        viewResult.setText("");
        cal.reset();

    }

    private void writer(Calculator.actionMode mode){

        resultBuffer = cal.checkIn(keyingBuffer,mode);
        viewResult.setText(resultBuffer);
        viewProcess.setText(cal.getKeyingLog());
        keyingBuffer = "";

    }

    private void setOnListener() {

        btnZero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);

        btnDot.setOnClickListener(this);

        btnPlus.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

        btnClear.setOnClickListener(this);
        btnEqual.setOnClickListener(this);

    }

    private void findView() {

        btnPlus = findViewById(R.id.view_btn_plus);
        btnSub = findViewById(R.id.view_btn_sub);
        btnMul = findViewById(R.id.view_btn_mul);
        btnDiv = findViewById(R.id.view_btn_div);
        btnEqual = findViewById(R.id.view_btn_equal);
        btnClear = findViewById(R.id.view_btn_clear);
        btnDot = findViewById(R.id.view_btn_dot);

        btnZero = findViewById(R.id.view_btn_zero);
        btnOne = findViewById(R.id.view_btn_1);
        btnTwo = findViewById(R.id.view_btn_2);
        btnThree = findViewById(R.id.view_btn_3);
        btnFour = findViewById(R.id.view_btn_4);
        btnFive = findViewById(R.id.view_btn_5);
        btnSix = findViewById(R.id.view_btn_6);
        btnSeven = findViewById(R.id.view_btn_7);
        btnEight = findViewById(R.id.view_btn_8);
        btnNine = findViewById(R.id.view_btn_9);

        viewProcess = findViewById(R.id.textView_process);
        viewResult = findViewById(R.id.textView_result);



    }
}
