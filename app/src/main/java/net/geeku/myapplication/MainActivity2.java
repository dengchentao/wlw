package net.geeku.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity2 extends ActionBarActivity {

    Button btnCal;
    EditText etInput;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        //获取布局内的元素
        btnCal   = (Button) findViewById(R.id.btnCal);
        etInput  = (EditText) findViewById(R.id.etInput);
        tvResult = (TextView) findViewById(R.id.tvResult);

        //按钮监听事件
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //获取编辑框内容
                String input  = etInput.getText().toString();
                double result = 0.0;

                //正则表达式匹配内容
                Pattern pattern = Pattern.compile("(\\d+)([\\+\\-\\*/])(\\d+)");
                Matcher matcher = pattern.matcher(input);

                //如果格式正确
                if(matcher.find()){

                    System.out.println(matcher.group(0));

                    //分别获取两个数字和运算符
                    String firstNum  = matcher.group(1);
                    String operater  = matcher.group(2);
                    String secondNum = matcher.group(3);

                    //判断运算符执行不同的运算
                    switch (operater) {
                        case "+":
                            result = Double.parseDouble(firstNum) + Double.parseDouble(secondNum);
                            break;
                        case "-":
                            result = Double.parseDouble(firstNum) - Double.parseDouble(secondNum);
                            break;
                        case "*":
                            result = Double.parseDouble(firstNum) * Double.parseDouble(secondNum);
                            break;
                        case "/":
                            result = Double.parseDouble(firstNum) / Double.parseDouble(secondNum);
                            break;
                        default:
                            result = 0.0;
                            break;
                    }

                    //显示结果
                    tvResult.setText(String.valueOf(result));
                }
            }
        });

    }

}
