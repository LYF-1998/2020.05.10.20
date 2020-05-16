package com.example.test3;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//import android.widget.Toast;

public class MainActivity  extends AppCompatActivity implements OnClickListener {
    private final String        DEBUG_TAG   = "Activity01";
    private TextView    mTextView = null;
    private EditText    mNumber = null;
    private Button      mButton1 = null;
    private Button      mButton2 = null;
    private Button      mButton3 = null;
    private Button      mButton4 = null;
    private Button      mButton5 = null;
    private Button      mButton6 = null;
    private Button      mButton7 = null;
    private Button      mButton8 = null;
    private Button      mButton9 = null;
    private Button btn_dialog_one;
    private Button btn_dialog_two;
    private Button btn_dialog_three;
    private Button btn_dialog_four;
   // private Button      mconfirm = null;
    private Button      mdelete  = null;
    private EditText    mNumber1 = null;
    private EditText    mNumber2 = null;
    private EditText    mNumber3 = null;
    private EditText    mNumber4 = null;
    private EditText    mNumber5 = null;
    private EditText    mNumber6 = null;
    private EditText    mNumber7 = null;
    private EditText    mNumber8 = null;
    private Context mContext;
   // private boolean[] checkItems;

    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;
    // private EditText    mIP = null;
    static private String      category1 = "";
    static private String      category2 = "";
    static private String      category3 = "";
    static private String      category4 = "";
    static private String      category5 = "";
    static private String      category6 = "";
    static private String      category7 = "";
    static private String      category8 = "";
    static private String      thenumberof ="";
    private String Number1="";
    private String Number2="";
    private String Number3="";
    private String Number4="";
    private String Number5="";
    private String Number6="";
    private String Number7="";
    private String Number8="";
   // static private String      message = "";
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
        mContext = MainActivity.this;
        bindView();

        mButton1 = (Button)findViewById(R.id.Button01);
        mTextView = (TextView)findViewById(R.id.TextView01);
        mNumber = (EditText)findViewById(R.id.EditText02);
        mNumber1 = (EditText)findViewById(R.id.editText2);
        mNumber2 = (EditText)findViewById(R.id.editText3);
        mNumber3 = (EditText)findViewById(R.id.editText4);
        mNumber4= (EditText)findViewById(R.id.editText5);
        mNumber5= (EditText)findViewById(R.id.editText6);
        mNumber6= (EditText)findViewById(R.id.editText7);
        mNumber7= (EditText)findViewById(R.id.editText8);
        mNumber8= (EditText)findViewById(R.id.editText9);
        mButton2=(Button)findViewById(R.id.button02);
        mButton3=(Button)findViewById(R.id.button03);
        mButton4=(Button)findViewById(R.id.button04);
        mButton5=(Button)findViewById(R.id.button05);
        mButton6=(Button)findViewById(R.id.button06);
        mButton7=(Button)findViewById(R.id.button07);
        mButton8=(Button)findViewById(R.id.button08);
        mButton9=(Button)findViewById(R.id.button09);
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
                    socket = new Socket("192.168.1.105",5000);
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter( new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())),true);
                   // BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                        //向服务器发送消息
                    if(!(mNumber1.getText().toString().equals("")))
                        Number1=mNumber1.getText().toString()+"份 ";
                    if(!(mNumber2.getText().toString().equals("")))
                        Number2=mNumber2.getText().toString()+"份 ";
                    if(!(mNumber3.getText().toString().equals("")))
                        Number3=mNumber3.getText().toString()+"份 ";
                    if(!(mNumber4.getText().toString().equals("")))
                        Number4=mNumber4.getText().toString()+"份 ";
                    if(!(mNumber5.getText().toString().equals("")))
                        Number5=mNumber5.getText().toString()+"份 ";
                    if(!(mNumber6.getText().toString().equals("")))
                        Number6=mNumber6.getText().toString()+"份 ";
                    if(!(mNumber7.getText().toString().equals("")))
                        Number7=mNumber7.getText().toString()+"份 ";
                    if(!(mNumber8.getText().toString().equals("")))
                        Number8=mNumber8.getText().toString()+"份 ";


                   // while(true){
                    out.println(mNumber.getText().toString()  +"$"+ MainActivity.category1 +mNumber1.getText().toString()+ MainActivity.category2 +mNumber2.getText().toString() + MainActivity.category3 + mNumber3.getText().toString() + MainActivity.category4 + mNumber4.getText().toString() + MainActivity.category5 + mNumber5.getText().toString() + MainActivity.category6 + mNumber6.getText().toString() + MainActivity.category7 + mNumber7.getText().toString() + MainActivity.category8 + mNumber8.getText().toString());
                   // out.write(mNumber.getText().toString() + "号桌 " + MainActivity.category1 + mNumber1.getText().toString() + "份，" + MainActivity.category2 + mNumber2.getText().toString() + "份，" + MainActivity.category3 + mNumber3.getText().toString() + "份，" + MainActivity.category4 + mNumber4.getText().toString() + "份。");
                    //接收来自服务器的消息
                       // String msg = br.readLine();
                   String msg=mNumber.getText().toString() + "号桌 "+thenumberof + MainActivity.category1 + Number1 + MainActivity.category2 + Number2 + MainActivity.category3 + Number3 + MainActivity.category4 +Number4+ MainActivity.category5 + Number5+ MainActivity.category6 + Number6+ MainActivity.category7 + Number7+ MainActivity.category8 + Number8;
                      if (msg != null) {
                            mTextView.setText(msg);
                        } else {
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
        mButton6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v6){
                MainActivity.category5=mButton6.getText().toString();
            }
        });
        mButton7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v7){
                MainActivity.category6=mButton7.getText().toString();
            }
        });
        mButton8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v8){
                MainActivity.category7=mButton8.getText().toString();
            }
        });
        mButton9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v9){
                MainActivity.category8=mButton9.getText().toString();
            }
        });

      mdelete.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v10) {
                category1="";category2="";category3="";category4="";
                category5="";category6="";category7="";category8="";
                mNumber1.setText("");mNumber2.setText("");mNumber3.setText("");
                mNumber4.setText("");mNumber5.setText("");mNumber6.setText("");
                mNumber7.setText("");mNumber8.setText("");
            }
            });

    }

    private void bindView() {
        btn_dialog_one = (Button) findViewById(R.id.btn_dialog_one);
        btn_dialog_two = (Button) findViewById(R.id.btn_dialog_two);
        btn_dialog_one.setOnClickListener(this);
        btn_dialog_two.setOnClickListener(this);
    }


    @Override
    public void onClick(View v11) {
        switch (v11.getId()) {
            //普通对话框
            case R.id.btn_dialog_one:
                alert = null;
                builder = new AlertDialog.Builder(mContext);
                alert = builder.setIcon(R.mipmap.q)
                        .setTitle("系统提示：")
                        .setMessage("您确定要退出软件吗？")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(mContext, "你点击了取消按钮~", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(mContext, "你点击了确定按钮~", Toast.LENGTH_SHORT).show();
                                android.os.Process.killProcess(android.os.Process.myPid());
                            }
                        })
                        .create();             //创建AlertDialog对象
                alert.show();                    //显示对话框
                break;
            //单选列表对话框
            case R.id.btn_dialog_two:
                final String[] number = new String[]{"1", "2", "3", "4", "5", "6"};
                alert = null;
                builder = new AlertDialog.Builder(mContext);
                alert = builder.setIcon(R.mipmap.q)
                        .setTitle("请选择您的用餐人数~")
                        .setSingleChoiceItems(number, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "您的用餐人数为" + number[which]+"人", Toast.LENGTH_SHORT).show();
                                thenumberof="用餐人数为"+number[which]+"人，";
                            }
                        }).create();
                alert.show();
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public static class MyButton {
    }
}


