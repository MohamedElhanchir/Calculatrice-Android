package ma.enset.calculatrice;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    private TextView previousCal;
    private EditText display;
    private boolean isPortrait = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCal = findViewById(R.id.previCal);
        display = findViewById(R.id.display);
        display.setShowSoftInputOnFocus(false);
    }

    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }

    public void zeroBtn(View v) {
        updateText(getResources().getString(R.string.zeroText));
    }

    public void oneBtn(View v) {

        updateText(getResources().getString(R.string.oneText));

    }

    public void twoBtn(View v) {

        updateText(getResources().getString(R.string.twoText));

    }

    public void threeBtn(View v) {
        updateText(getResources().getString(R.string.threeText));
    }

    public void foureBtn(View v) {

             updateText(getResources().getString(R.string.fourText));

    }

    public void fiveBtn(View v) {

        updateText(getResources().getString(R.string.fiveText));

    }

    public void sixBtn(View v) {

updateText(getResources().getString(R.string.sixText));

    }

    public void sevenBtn(View v) {

updateText(getResources().getString(R.string.sevenText));

    }

    public void eightBtn(View v) {

updateText(getResources().getString(R.string.eightText));

    }

    public void nineBtn(View v) {
                 updateText(getResources().getString(R.string.nineText));
    }


    public void parOpenBtn(View v) {
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }

    public void parcloseBtn(View v) {

updateText(getResources().getString(R.string.parenthesesCloseText));

    }

    public void divideBtn(View v) {

        updateText(getResources().getString(R.string.divideText));

    }

    public void multiplyBtn(View v) {

updateText(getResources().getString(R.string.multiplyText));

    }

    public void subtractBtn(View v) {

updateText(getResources().getString(R.string.subtractText));

    }

    public void decimalBtn(View v) {

updateText(getResources().getString(R.string.decimalText));

    }

    public void addBtn(View v) {

        updateText(getResources().getString(R.string.addText));

    }

    public void equalsBtn(View v) {
        String userExp = display.getText().toString();
        previousCal.setText(userExp);
        userExp = userExp.replace(getResources().getString(R.string.divideText), "/");
        userExp = userExp.replace(getResources().getString(R.string.multiplyText), "*");
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }

    public void clearBtn(View v) {
        display.setText("");
        previousCal.setText("");
    }

    public void trigSinBtn(View v) {
        updateText("sin(");
    }

    public void trigCosBtn(View v) {
        updateText("cos(");
    }

    public void trigtanBtn(View v) {
        updateText("tan(");
    }

    public void trigArcSinBtn(View v) {
        updateText("arcsin(");
    }

    public void trigArcCosBtn(View v) {
        updateText("arccos(");
    }

    public void trigArcTanBtn(View v) {
        updateText("arctan(");
    }

    public void logBtn(View v) {
        updateText("log(");
    }

    public void naturalLogBtn(View v) {
        updateText("ln(");
    }

    public void absBtn(View v) {
        updateText("abs(");
    }

    public void piBtn(View v) {
        updateText("pi");
    }

    public void eBtn(View v) {
        updateText("e");
    }

    public void sqrtBtn(View v) {
        updateText("sqrt(");
    }

    public void xSquaredBtn(View v) {
        updateText("^(2)");
    }

    public void xPowerYBtn(View v) {
        updateText("^(");
    }

    public void primeBtn(View v) {
        updateText("ispr(");
    }

    public void backSpaceBtn(View v) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();
        if (cursorPos != 0 && textLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }

    public void rotateBtn(View v) {
        setRequestedOrientation(isPortrait ?
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE :
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        isPortrait = !isPortrait;
    }
}

