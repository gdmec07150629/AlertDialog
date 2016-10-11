package cn.edu.gdmec.s07150629.work6;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private AlertDialog ad;
    private AlertDialog.Builder adb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)this.findViewById(R.id.textView);
        Button b1=(Button)this.findViewById(R.id.button);
        Button b2=(Button)this.findViewById(R.id.button2);
        Button b3=(Button)this.findViewById(R.id.button3);
        Button b4=(Button)this.findViewById(R.id.button4);
        Button b5=(Button)this.findViewById(R.id.button5);
        Button b6=(Button)this.findViewById(R.id.button6);
        Button b7=(Button)this.findViewById(R.id.button7);

        View.OnClickListener listener=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }
            }
        };
        b1.setOnClickListener(listener);
        b2.setOnClickListener(listener);
        b3.setOnClickListener(listener);
        b4.setOnClickListener(listener);
        b5.setOnClickListener(listener);
        b6.setOnClickListener(listener);
        b7.setOnClickListener(listener);


    }
    public void dialog1(){
        ad=new AlertDialog.Builder(this).create();
        ad.setTitle("提示");
        ad.setMessage("确认退出吗?");
        ad.setIcon(android.R.drawable.ic_dialog_alert);

        DialogInterface.OnClickListener listenter=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == DialogInterface.BUTTON_POSITIVE){
                    dialog.dismiss();
                    MainActivity.this.finish();
                }else if(which == DialogInterface.BUTTON_NEGATIVE){
                    dialog.dismiss();
                }
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listenter);
        ad.setButton(DialogInterface.BUTTON_NEUTRAL,"取消",listenter);
        ad.show();
    }

    public void dialog2() {
        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("调查");
        ad.setMessage("你平时忙吗");
        ad.setIcon(android.R.drawable.ic_dialog_info);

        DialogInterface.OnClickListener listenter = new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "";
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        str = "非常忙";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str = "忙";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str = "很忙";
                        break;
                }
                tv.setText(str);
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"非常忙",listenter);
        ad.setButton(DialogInterface.BUTTON_NEUTRAL,"忙",listenter);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"很忙",listenter);
        ad.show();
    }

    public void dialog3(){
        ad=new AlertDialog.Builder(this).create();
        ad.setTitle("请输入");
        ad.setMessage("你平时忙吗");
        ad.setIcon(android.R.drawable.ic_dialog_info);
        final EditText tEdit=new EditText(this);
        ad.setView(tEdit);

        DialogInterface.OnClickListener listenter = new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv.setText("输入的是:"+tEdit.getText().toString());
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listenter);
        ad.show();
    }

    public void dialog4(){
        final String item[]=new String[]{"A","B","C","D"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mListenter= new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which]=isChecked;
            }
        };
        adb=new AlertDialog.Builder(this);
        adb.setMultiChoiceItems(item,null,mListenter);

        ad= adb.create();
        ad.setTitle("复选框");

        DialogInterface.OnClickListener listenter = new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了:";
                for(int i=0;i<bSelect.length;i++){
                    if (bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tv.setText(str);
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listenter);
        ad.show();
    }

    public void dialog5(){
        final String item[]=new String[]{"A","B","C","D"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener sListenter= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        };
        adb=new AlertDialog.Builder(this);
        adb.setSingleChoiceItems(item,-1,sListenter);

        ad= adb.create();
        ad.setTitle("单选框");

        DialogInterface.OnClickListener listenter= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了:";
                for(int i=0;i<bSelect.length;i++){
                    if (bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tv.setText(str);
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listenter);
        ad.show();
    }

    public void dialog6(){
        final String item[]=new String[]{"A","B","C","D"};
        final boolean bSelect[]=new boolean[item.length];

        DialogInterface.OnClickListener sListenter = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了:"+item[which];
                tv.setText(str);
            }
        };
        adb=new AlertDialog.Builder(this);
        adb.setItems(item,sListenter);

        ad= adb.create();
        ad.setTitle("列表框");

        DialogInterface.OnClickListener listenter= new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                ad.dismiss();
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listenter);
        ad.show();
    }

    public void dialog7(){
        LayoutInflater inflater=getLayoutInflater();
        View layout=inflater.inflate(R.layout.diydialog,null);
        final EditText tEdit= (EditText) layout.findViewById(R.id.editText1);
        ad=new AlertDialog.Builder(this).create();
        ad.setTitle("自定义布局");
        ad.setView(layout);
        DialogInterface.OnClickListener listener= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv.setText("输入的是:"+tEdit.getText().toString());
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        ad.show();
    }
}
