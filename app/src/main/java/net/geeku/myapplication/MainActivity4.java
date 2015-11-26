package net.geeku.myapplication;

import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity4 extends ActionBarActivity implements View.OnClickListener{

    private TextView tvScreen;
    private List<Item> items = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4);

        tvScreen = (TextView) findViewById(R.id.tvScreen);

        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnSub).setOnClickListener(this);
        findViewById(R.id.btnMul).setOnClickListener(this);
        findViewById(R.id.btnDiv).setOnClickListener(this);
        findViewById(R.id.btnClear).setOnClickListener(this);
        findViewById(R.id.btnequal).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn0:
                tvScreen.append("0");
                break;
            case R.id.btn1:
                tvScreen.append("1");
                break;
            case R.id.btn2:
                tvScreen.append("2");
                break;
            case R.id.btn3:
                tvScreen.append("3");
                break;
            case R.id.btn4:
                tvScreen.append("4");
                break;
            case R.id.btn5:
                tvScreen.append("5");
                break;
            case R.id.btn6:
                tvScreen.append("6");
                break;
            case R.id.btn7:
                tvScreen.append("7");
                break;
            case R.id.btn8:
                tvScreen.append("8");
                break;
            case R.id.btn9:
                tvScreen.append("9");
                break;
            case R.id.btnAdd:
                items.add(new Item(Double.parseDouble(tvScreen.getText().toString()), Type.NUM));
                checkAndComputer();
                items.add(new Item(0, Type.ADD));
                tvScreen.setText("");
                break;
            case R.id.btnDiv:
                items.add(new Item(Double.parseDouble(tvScreen.getText().toString()), Type.NUM));
                checkAndComputer();
                items.add(new Item(0, Type.DIV));
                tvScreen.setText("");
                break;
            case R.id.btnSub:
                items.add(new Item(Double.parseDouble(tvScreen.getText().toString()), Type.NUM));
                checkAndComputer();
                items.add(new Item(0, Type.SUB));
                tvScreen.setText("");
                break;
            case R.id.btnMul:
                items.add(new Item(Double.parseDouble(tvScreen.getText().toString()), Type.NUM));
                checkAndComputer();
                items.add(new Item(0, Type.MUL));
                tvScreen.setText("");
                break;
            case R.id.btnClear:
                tvScreen.setText("");
                items.clear();
                break;
            case R.id.btnequal:
                items.add(new Item(Double.parseDouble(tvScreen.getText().toString()), Type.NUM));
                checkAndComputer();
                tvScreen.setText(items.get(0).value + "");
                items.clear();
                break;
            default: break;
        }
    }

    public void checkAndComputer() {

        if(items.size() >= 3) {
            double a = items.get(0).value;
            double b = items.get(2).value;
            int type = items.get(1).type;

            items.clear();

            switch (type) {
                case Type.ADD:
                    items.add(new Item(a+b, Type.NUM));
                    break;
                case Type.DIV:
                    items.add(new Item(a/b, Type.NUM));
                    break;
                case Type.MUL:
                    items.add(new Item(a*b, Type.NUM));
                    break;
                case Type.SUB:
                    items.add(new Item(a-b, Type.NUM));
                    break;
            }
        }

    }
}
