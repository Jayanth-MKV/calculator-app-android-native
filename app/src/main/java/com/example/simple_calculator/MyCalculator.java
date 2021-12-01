package com.example.simple_calculator;
import java.util.Stack;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyCalculator extends AppCompatActivity implements View.OnClickListener {

    TextView c,X,one,two,three,four,five,six,seven,eight,nine,zero,dzero,perc,div,mul,add,sub,dot,equal,res,display;
    String s1="",s2="",s3="",s4="",s5="",s6="",s7="",s8="",s9="",s0="",s00="",sp="",sa="",ss="",sd="",sm="",sdot="";
    String r3="";
    boolean is=false;
    boolean set=false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal_ui);
        c=findViewById(R.id.c);
        X=findViewById(R.id.x);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.t4);
        five=findViewById(R.id.t5);
        six=findViewById(R.id.t6);
        seven=findViewById(R.id.t7);
        eight=findViewById(R.id.t8);
        nine=findViewById(R.id.t9);
        zero=findViewById(R.id.t0);
        dzero=findViewById(R.id.t00);
        perc=findViewById(R.id.p);
        div=findViewById(R.id.d);
        mul=findViewById(R.id.m);
        add=findViewById(R.id.a);
        sub=findViewById(R.id.s);
        dot=findViewById(R.id.dot);
        equal=findViewById(R.id.e);
        res=findViewById(R.id.res);
        display=findViewById(R.id.dis);

       c.setOnClickListener(this);
       X.setOnClickListener(this);
       one.setOnClickListener(this);
       two.setOnClickListener(this);
        three.setOnClickListener(this);
       add.setOnClickListener(this);
       equal.setOnClickListener(this);
       four.setOnClickListener(this);
       five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        dzero.setOnClickListener(this);
        perc.setOnClickListener(this);
        div.setOnClickListener(this);
        mul.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        dot.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.one:
                s1="";
                s1 = s1 + 1;
                r3=r3+s1;
                display.setText(r3);
                break;
            case R.id.two:
                s2="";
                s2 = s2 + 2;
                r3=r3+s2;
                display.setText(r3);
                break;
            case R.id.x:
                String a3=new String();
                for (int i = 0; i < r3.length()-1; i++) {
                          a3= a3+ r3.charAt(i);
                     }
                //r3.charAt(r3.length()-1)="";
                r3=a3;
                display.setText(r3);
                break;
            case R.id.c:
                display.setText("");
                res.setText("0");
                s1="";
                s2="";
                s3="";
                s4="";
                s5="";
                s6="";
                s7="";
                s8="";
                s9="";
//                s1="";
                s0="";
                s00="";
                r3="";
                sdot="";
//                a1="";
//                a2="";
//                a3="";
                is=false;
                break;
            case R.id.three:
                s3="";
                s3 = s3 + 3;
                r3=r3+s3;
                display.setText(r3);
                break;
            case R.id.t4:
                s4="";
                s4 = s4 + 4;
                r3=r3+s4;
                display.setText(r3);
                break;
            case R.id.t5:
                s5="";
                s5 = s5 + 5;
                r3=r3+s5;
                display.setText(r3);
                break;
            case R.id.t6:
                s6="";
                s6 = s6 + 6;
                r3=r3+s6;
                display.setText(r3);
                break;
            case R.id.t7:
                s7="";
                s7 = s7+ 7;
                r3=r3+s7;
                display.setText(r3);
                break;
            case R.id.t8:
                s8="";
                s8 = s8 + 8;
                r3=r3+s8;
                display.setText(r3);
                break;
            case R.id.t9:
                s9="";
                s9 = s9 + 9;
                r3=r3+s9;
                display.setText(r3);
                break;
            case R.id.t0:
                s0="";
                s0 = s0 + 0;
                r3=r3+s0;
                display.setText(r3);
                break;
            case R.id.t00:
                s00="";
                s00 = s00 + "00";
                r3=r3+s00;
                display.setText(r3);
                break;
            case R.id.a:
                if (r3.length()!=0){
                    if(r3.charAt(r3.length()-1)!='+'&&r3.charAt(r3.length()-1)!='-'&&r3.charAt(r3.length()-1)!='/'&&r3.charAt(r3.length()-1)!='*'&&r3.charAt(r3.length()-1)!='%') {
                        r3 = r3 + "+";
                    }
                    display.setText(r3);
                }
                else{
                    display.setText(r3);
                }
                is=false;
                break;
            case R.id.p:
                if (r3.length()!=0){
                    if(r3.charAt(r3.length()-1)!='+'&&r3.charAt(r3.length()-1)!='-'&&r3.charAt(r3.length()-1)!='/'&&r3.charAt(r3.length()-1)!='*'&&r3.charAt(r3.length()-1)!='%') {
                        r3 = r3 + "%";
                    }
                    display.setText(r3);
                }
                else{
                    display.setText(r3);
                }
                is=false;
                break;
            case R.id.m:
                if (r3.length()!=0){
                    if(r3.charAt(r3.length()-1)!='+'&&r3.charAt(r3.length()-1)!='-'&&r3.charAt(r3.length()-1)!='/'&&r3.charAt(r3.length()-1)!='*'&&r3.charAt(r3.length()-1)!='%') {
                        r3 = r3 + "*";
                    }
                    display.setText(r3);
                }
                else{
                    display.setText(r3);
                }
                is=false;
                break;
            case R.id.d:
                if (r3.length()!=0){
                    if(r3.charAt(r3.length()-1)!='+'&&r3.charAt(r3.length()-1)!='-'&&r3.charAt(r3.length()-1)!='/'&&r3.charAt(r3.length()-1)!='*'&&r3.charAt(r3.length()-1)!='%') {
                        r3 = r3 + "/";
                    }
                    display.setText(r3);
                }
                else{
                    display.setText(r3);
                }
                is=false;
                break;
            case R.id.s:
                if (r3.length()!=0){
                    if(r3.charAt(r3.length()-1)!='+'&&r3.charAt(r3.length()-1)!='-'&&r3.charAt(r3.length()-1)!='/'&&r3.charAt(r3.length()-1)!='*'&&r3.charAt(r3.length()-1)!='%') {
                        r3 = r3 + "-";
                    }
                    display.setText(r3);
                }
                else{
                    display.setText(r3);
                }
                is=false;
                break;
            case R.id.dot:
                sdot="";

                for (int i = r3.length()-1; i >0;i--){
                          if (r3.charAt(i)=='.') {
                              set = true;
                              break;
                          }
                         else if (r3.charAt(i)=='+'||r3.charAt(i)=='-'||r3.charAt(i)=='*'||r3.charAt(i)=='/'||r3.charAt(i)=='%'){
                              set=false;
                              break;
                          }
                      }
                if(!set) {
                    sdot = sdot + ".";

                    }
                    r3 = r3 + sdot;

                display.setText(r3);
                break;

            case R.id.e:
                if (!is) {
                    if(r3.charAt(r3.length()-1)=='+') {
                        r3 = r3 + 0;
                        // display.setText(s3);
                    }
                    if(r3.charAt(r3.length()-1)=='-') {
                        r3 = r3 + 0;
                        // display.setText(s3);
                    }
                    if(r3.charAt(r3.length()-1)=='*') {
                        r3 = r3 + 1;
                        // display.setText(s3);
                    }
                    if(r3.charAt(r3.length()-1)=='%') {
                        r3 = r3 + 1;
                        // display.setText(s3);
                    }
                    if(r3.charAt(r3.length()-1)=='/') {
                        r3 = r3 + 1;
                        // display.setText(s3);
                    }
                    if (r3.charAt(r3.length()-1)=='0'&&r3.charAt(r3.length()-2)=='/'){
//                        r3 = String.valueOf(evaluate(r3));
                        r3="ERROR";
                        display.setText(r3);
                        is = true;
                        r3 = "";
                    }
                    else {
                        Log.e("r3", r3);
                        r3 = String.valueOf(evaluate(r3));
                        res.setText(r3);
                        display.setText(r3);
                        is = true;
                        r3 = "";
                    }
                }
                else{

                }

        }

    }

//                    for (int i = 0; i < s3.length() && s3.charAt(i) != '+'; i++) {
//                        a1 = a1 + s3.charAt(i);
//                    }
//                    for (int i = s3.length() - 1; i >= 0 && s3.charAt(i) != '+'; i--) {
//                        a2 = a2 + s3.charAt(i);
//                    }
//                    for (int i = a2.length() - 1; i >= 0; i--) {
//                        a3 = a3 + a2.charAt(i);
//                    }
//
//                    Log.e("a1", a1);
//                    Log.e("a2", a2);
//                    Log.e("a3", a3);
//                    res.setText(String.valueOf(calculate(Integer.parseInt(a1), Integer.parseInt(a3))));



//    int calculate(int one,int two){
//
//        return one+two;
//
//       // Toast.makeText(this,String.valueOf((one+two)),Toast.LENGTH_LONG).show();
//
//    }


        public double evaluate(String expression)
        {
            char[] tokens = expression.toCharArray();

            // Stack for numbers: 'values'
            Stack<Double> values = new
                    Stack<Double>();

            // Stack for Operators: 'ops'
            Stack<Character> ops = new
                    Stack<Character>();

            for (int i = 0; i < tokens.length; i++)
            {

                // Current token is a
                // whitespace, skip it
                if (tokens[i] == ' ')
                    continue;

                // Current token is a number,
                // push it to stack for numbers
                if (tokens[i] >= '.' &&
                        tokens[i] <= '9' && tokens[i]!='/')
                {
                    StringBuffer sbuf = new
                            StringBuffer();

                    // There may be more than one
                    // digits in number
                    while (i < tokens.length &&
                            tokens[i] >= '.' &&
                            tokens[i] <= '9' && tokens[i]!='/'
                            )

                        sbuf.append(tokens[i++]);
                        values.push(Double.parseDouble(sbuf.
                                toString()));

                    // right now the i points to
                    // the character next to the digit,
                    // since the for loop also increases
                    // the i, we would skip one
                    //  token position; we need to
                    // decrease the value of i by 1 to
                    // correct the offset.
                    i--;
                }

                // Current token is an opening brace,
                // push it to 'ops'
                else if (tokens[i] == '(')
                    ops.push(tokens[i]);

                    // Closing brace encountered,
                    // solve entire brace
                else if (tokens[i] == ')')
                {
                    while (ops.peek() != '(')
                        values.push(applyOp(ops.pop(),
                                values.pop(),
                                values.pop()));
                    ops.pop();
                }

                // Current token is an operator.
                else if (tokens[i] == '+' ||
                        tokens[i] == '-' ||
                        tokens[i] == '*' ||
                        tokens[i] == '/'||  tokens[i] == '%')
                {
                    // While top of 'ops' has same
                    // or greater precedence to current
                    // token, which is an operator.
                    // Apply operator on top of 'ops'
                    // to top two elements in values stack
                    while (!ops.empty() &&
                            hasPrecedence(tokens[i],
                                    ops.peek()))
                        values.push(applyOp(ops.pop(),
                                values.pop(),
                                values.pop()));

                    // Push current token to 'ops'.
                    ops.push(tokens[i]);
                }
            }

            // Entire expression has been
            // parsed at this point, apply remaining
            // ops to remaining values
            while (!ops.empty())
                values.push(applyOp(ops.pop(),
                        values.pop(),
                        values.pop()));

            // Top of 'values' contains
            // result, return it
            return values.pop();
        }

        // Returns true if 'op2' has higher
        // or same precedence as 'op1',
        // otherwise returns false.
        public boolean hasPrecedence(
                char op1, char op2)
        {
            if (op2 == '(' || op2 == ')')
                return false;
            if ((op1 == '*' || op1 == '/' || op1 =='%') &&
                    (op2 == '+' || op2 == '-'))
                return false;
            else
                return true;
        }

        // A utility method to apply an
        // operator 'op' on operands 'a'
        // and 'b'. Return the result.
        public double applyOp(char op, double b, double a)
        {
            switch (op)
            {
                case '+':
                    return a + b;
                case '-':
                    return a - b;
                case '*':
                    return a * b;
                case '%':
                    return a%b;
                case '/':
                    if (b == 0)
                    {
                        return a/b+1;
                    }else
//                        throw new
//                                UnsupportedOperationException(
//                                "Cannot divide by zero");
                    return a/b;
            }
            return 0;
        }



}

