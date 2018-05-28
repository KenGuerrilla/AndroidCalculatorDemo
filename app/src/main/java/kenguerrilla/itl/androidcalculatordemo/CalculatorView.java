package kenguerrilla.itl.androidcalculatordemo;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class CalculatorView extends AppCompatActivity implements ICalculatorView, OnClickListener{

    private TextView btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    private TextView btnPlus, btnSub, btnMul, btnDiv;
    private TextView btnClear, btnEqual, btnDot;
    public TextView viewProcess, viewResult;

    private IPresenter ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_ayout);

        findView();
        setOnListener();
        ip = Presenter.getInstance(this); // 記得將Activity傳出去，new要是new一個新的那就不對了

        clearVIew();



    }

    public void onClick(View arg0) {

        int id = arg0.getId();

        switch (id){

            // 向Presenter回應Button事件
            case R.id.view_btn_zero:
                ip.keyingNumber("0");
                break;

            case R.id.view_btn_1:
                ip.keyingNumber("1");
                break;

            case R.id.view_btn_2:
                ip.keyingNumber("2");
                break;

            case R.id.view_btn_3:
                ip.keyingNumber("3");
                break;

            case R.id.view_btn_4:
                ip.keyingNumber("4");
                break;

            case R.id.view_btn_5:
                ip.keyingNumber("5");
                break;

            case R.id.view_btn_6:
                ip.keyingNumber("6");
                break;

            case R.id.view_btn_7:
                ip.keyingNumber("7");
                break;

            case R.id.view_btn_8:
                ip.keyingNumber("8");
                break;

            case R.id.view_btn_9:
                ip.keyingNumber("9");
                break;

            case R.id.view_btn_dot:
                ip.keyingNumber(".");
                break;

            case R.id.view_btn_plus:
                ip.setMode(ActionMode.PLUS);
                break;

            case R.id.view_btn_sub:
                ip.setMode(ActionMode.SUB);
                break;

            case R.id.view_btn_mul:
                ip.setMode(ActionMode.MUL);
                break;

            case R.id.view_btn_div:
                ip.setMode(ActionMode.DIV);
                break;

            case R.id.view_btn_equal:
                ip.setMode(ActionMode.NONE);
                break;

            case R.id.view_btn_clear:
                ip.clearStatus();
                break;

        }
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

        btnPlus.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        btnDot.setOnClickListener(this);


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

    @Override
    public void clearVIew() {
        setResultToView("0.");
        setProcessToView("0.");
    }

    @Override
    public void setResultToView(String s) {
        viewResult.setText(s);
    }

    @Override
    public void setProcessToView(String s) {
        viewProcess.setText(s);
    }

}
