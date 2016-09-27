package study.zhukai.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import study.zhukai.com.chatroom.R;
import study.zhukai.com.entity.Msg;

/**
 * Created by zhukai on 2016/9/19.
 */
//ListView的配套Adapter类
public class MsgAdapter extends ArrayAdapter<Msg> {

    private int resourceId;
    //resourceId=ListView聊天气泡布局的xml文件id
    public MsgAdapter(Context context, int textViewResourceId, List<Msg> objects) {
        super(context, textViewResourceId, objects);
        resourceId= textViewResourceId;
    }
    //该方法决定在新消息到达后采用哪种聊天气泡显示讯息
    public View getView(int position, View convertView, ViewGroup parent) {

        Msg msg =getItem(position);
        View view;
        //自定义类 存放消息显示位置参数
        ViewHolder viewHolder;
        if(convertView==null){
            //通过LayoutInflater的inflate方法制造显示消息的view
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder=new ViewHolder();
            //以下四句讲view的控件赋给viewHolder方便调用
            viewHolder.leftLayout = (LinearLayout) view.findViewById(R.id.left_layout);
            viewHolder.rightLayout = (LinearLayout) view.findViewById(R.id.right_layout);
            viewHolder.leftMsg=(TextView) view.findViewById(R.id.left_msg);
            viewHolder.rightMsg= (TextView) view.findViewById(R.id.right_msg);

            view.setTag(viewHolder);
        }else{
            view =convertView;
            viewHolder =(ViewHolder)view.getTag();
        }
        //以下两句判断改用哪种聊天气泡，不用的气泡设为不可见
        if(msg.getType()==Msg.TYPE_RECEIVED){
            viewHolder.leftLayout.setVisibility(View.VISIBLE);
            viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.leftMsg.setText(msg.getContent());
        }else if(msg.getType()==Msg.TYPE_SENT){
            viewHolder.rightLayout.setVisibility(View.VISIBLE);
            viewHolder.leftLayout.setVisibility(View.GONE);
            viewHolder.rightMsg.setText(msg.getContent());
        }
        return view;
    }


    class ViewHolder{
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
    }
}
