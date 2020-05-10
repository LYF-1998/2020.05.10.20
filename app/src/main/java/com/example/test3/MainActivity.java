package com.example.test3;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity
{
    private final String        DEBUG_TAG   = "Activity01";

    private TextView    mTextView = null;
    private EditText    mNumber = null;
    private Button      mButton1 = null;
    private Button      mButton2 = null;
    private Button      mButton3 = null;
    private Button      mButton4 = null;
    private Button      mButton5 = null;
    private Button      mconfirm = null;
    private Button      mdelete  = null;
    private EditText    mNumber1 = null;
    private EditText    mNumber2 = null;
    private EditText    mNumber3 = null;
    private EditText    mNumber4 = null;
   // private EditText    mIP = null;
    static private String      category1 = "";
    static private String      category2 = "";
    static private String      category3 = "";
    static private String      category4 = "";
    static private String      message = "";
   // static private String      IP="";
    //static private String      message1=null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton1 = (Button)findViewById(R.id.Button01);
        mTextView = (TextView)findViewById(R.id.TextView01);
        mNumber = (EditText)findViewById(R.id.EditText02);
        mNumber1 = (EditText)findViewById(R.id.editText2);
        mNumber2 = (EditText)findViewById(R.id.editText3);
        mNumber3 = (EditText)findViewById(R.id.editText4);
        mNumber4= (EditText)findViewById(R.id.editText5);
        mButton2=(Button)findViewById(R.id.button02);
        mButton3=(Button)findViewById(R.id.button03);
        mButton4=(Button)findViewById(R.id.button04);
        mButton5=(Button)findViewById(R.id.button05);
        mdelete=(Button)findViewById(R.id.delete);
       // mIP=(TextView)findViewById(R.id.IP);
        //mconfirm=(Button)findViewById(R.id.confirm);


        //登陆

        mButton1.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v1)
            {
                Socket socket = null;

                try
                {
                    //创建Socket
                    socket = new Socket("192.168.1.100",5000);
                    //向服务器发送消息
                    PrintWriter out = new PrintWriter( new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())),true);
                    out.println(mNumber.getText().toString()+"号桌 "+MainActivity.category1+mNumber1.getText().toString()+"份，"+MainActivity.category2+mNumber2.getText().toString()+"份，"+MainActivity.category3+mNumber3.getText().toString()+"份，"+MainActivity.category4+mNumber4.getText().toString()+"份。");

                    //接收来自服务器的消息
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String msg = br.readLine();
                    if ( msg != null )
                    {
                        mTextView.setText(msg);
                    }
                    else
                    {
                        mTextView.setText("数据错误!");
                    }
                    //关闭流
                    out.close();
                    br.close();
                    //关闭Socket
                    socket.close();
                }
                catch (Exception e)
                {
                    // TODO: handle exception
                    Log.e(DEBUG_TAG, e.toString());
                }
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v2){
                MainActivity.category1=mButton2.getText().toString();
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v3){
                MainActivity.category2=mButton3.getText().toString();
            }
        });
         mButton4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v4){
                MainActivity.category3=mButton4.getText().toString();
            }
        });
        mButton5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v5){
                MainActivity.category4=mButton5.getText().toString();
            }
        });
        mdelete.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v6){

            }
        });
       /* mconfirm.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v6){
                MainActivity.IP=mIP.getText().toString();
        }
    });*/
    }

}