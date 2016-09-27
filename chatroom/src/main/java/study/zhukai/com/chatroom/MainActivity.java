package study.zhukai.com.chatroom;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import study.zhukai.com.adapter.MsgAdapter;
import study.zhukai.com.entity.Msg;

public class MainActivity extends Activity {
    private ListView msgListView;
    private EditText inputText;
    private Button send;
    private MsgAdapter adapter;
    private List<Msg> msgList =new ArrayList<Msg>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除标题框
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //选择布局文件
        setContentView(R.layout.activity_main);
        //初始化几个消息
        initMsgs();
        adapter=new MsgAdapter(MainActivity.this,R.layout.msg_item,msgList);
        inputText = (EditText) findViewById(R.id.input_text);
        send =(Button) findViewById(R.id.send);
        msgListView =(ListView) findViewById(R.id.msg_list_view);
        msgListView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if(!"".equals(content)){
                    //设置消息类型（接受或发送）
                    Msg msg =new Msg(content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    //向adapter通知数据更新
                    adapter.notifyDataSetChanged();
                    //向adapter通知数据更新滚动到最新位置
                    msgListView.setSelection(msgList.size());
                    inputText.setText("");
                }
            }
        });

    }





    private void initMsgs(){
        Msg msg1=new Msg("hello zhukai",Msg.TYPE_RECEIVED);
        Msg msg2=new Msg("nihao",Msg.TYPE_SENT);
        Msg msg3=new Msg("heihei",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        msgList.add(msg2);
        msgList.add(msg3);
    }
}
