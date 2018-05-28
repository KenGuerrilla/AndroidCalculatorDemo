package kenguerrilla.itl.androidcalculatordemo;


import android.util.Log;

/**
 * Created by KenGuerrilla on 2017/11/27.
 */

public class Presenter implements IPresenter{

    ICalculatorView ic; // 不能直接New一個新的，必須把Activity本身傳進來。

    static CalculatorModel cm = CalculatorModel.getInstance();

    private static Presenter instance;


    String keyingBuffer="";
    String resultBuffer="";

    public static Presenter getInstance(CalculatorView ic){



        if(instance == null){
            instance = new Presenter(ic);
        }
        return instance;
    }

    private Presenter(CalculatorView ic){
        this.ic = ic;
    }

    @Override
    public void clearStatus() {
        keyingBuffer = "";
        resultBuffer = "";
        cm.reset();
        ic.clearVIew();

    }

    @Override
    public void keyingNumber(String s) {

        Log.d("TAG", "KeyingNumber: "+ s);

        keyingBuffer += s;
        ic.setResultToView(keyingBuffer);

    }

    @Override
    public void setMode(ActionMode mode) {

        resultBuffer = cm.checkIn(keyingBuffer,mode);

        ic.setResultToView(resultBuffer);
        ic.setProcessToView(cm.getKeyingLog());

        clearBuffer();

    }

    private void clearBuffer() {
        keyingBuffer = "";
    }

}
