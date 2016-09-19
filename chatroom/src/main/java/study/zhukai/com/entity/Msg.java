package study.zhukai.com.entity;

/**
 * Created by zhukai on 2016/9/19.
 */
public class Msg {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT =1 ;
    private String content;
    private int type;
    public Msg(String content,int type){
        this.content=content;
        this.type=type;
    }
    public String getContent(){
        return content;
    }

    public int getType() {
        return type;
    }
}
