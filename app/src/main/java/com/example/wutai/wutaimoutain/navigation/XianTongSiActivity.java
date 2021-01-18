package com.example.wutai.wutaimoutain.navigation;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.wutai.wutaimoutain.R;
import com.example.wutai.wutaimoutain.Utils.AudioUtils;
import com.example.wutai.wutaimoutain.Utils.MyLogUtils;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SpeechUtility;

public class XianTongSiActivity extends AppCompatActivity implements View.OnClickListener,PopupMenu.OnMenuItemClickListener{
    private FloatingActionButton backNavigation;
    private ImageButton WLD;
    private Button DXBD,DWSD,GYD;
    private DrawerLayout drawer;
    private Context mContex;
    private TextView voiceContent;
    private String content;
    private SpeechSynthesizer mySynthesizer;
    private boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xian_tong_si);
        initView();
        flag = true;
    }

    public void initView(){
        // 初始化
        SpeechUtility.createUtility(XianTongSiActivity.this, SpeechConstant.APPID +"=5b63c383");  //=后面这里要替换成自己申请的 AppID
        WLD = (ImageButton) findViewById(R.id.wu_liang_dian);
        WLD.setOnClickListener(this);
        DXBD = (Button)findViewById(R.id.da_xiong_bao_dian);
        DXBD.setOnClickListener(this);
        DWSD = (Button)findViewById(R.id.da_wen_shu_dian);
        DWSD.setOnClickListener(this);
        GYD = (Button)findViewById(R.id.guan_yin_dian);
        GYD.setOnClickListener(this);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mContex = getApplicationContext();
        voiceContent = (TextView)findViewById(R.id.voice_content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.wu_liang_dian:
                //创建弹出式菜单对象（最低版本11）
                PopupMenu popup = new PopupMenu(this, v);//第二个参数是绑定的那个view
                //获取菜单填充器
                MenuInflater inflater = popup.getMenuInflater();
                //填充菜单
                inflater.inflate(R.menu.wu_liang_dian_item, popup.getMenu());
                //绑定菜单项的点击事件
                popup.setOnMenuItemClickListener(XianTongSiActivity.this);
                //显示(这一行代码不要忘记了)
                popup.show();

                break;
            case R.id.da_xiong_bao_dian:
                    PopupMenu popup2 = new PopupMenu(this, v);//第二个参数是绑定的那个view
                    //获取菜单填充器
                    MenuInflater inflater2 = popup2.getMenuInflater();
                    //填充菜单
                    inflater2.inflate(R.menu.da_xiong_bao_dian, popup2.getMenu());
                    //绑定菜单项的点击事件
                    popup2.setOnMenuItemClickListener(XianTongSiActivity.this);
                    //显示(这一行代码不要忘记了)
                    popup2.show();
                break;
            case R.id.da_wen_shu_dian:
                PopupMenu popup3 = new PopupMenu(this, v);//第二个参数是绑定的那个view
                //获取菜单填充器
                MenuInflater inflater3 = popup3.getMenuInflater();
                //填充菜单
                inflater3.inflate(R.menu.da_wen_shu_dian, popup3.getMenu());
                //绑定菜单项的点击事件
                popup3.setOnMenuItemClickListener(XianTongSiActivity.this);
                //显示(这一行代码不要忘记了)
                popup3.show();
                break;
            case R.id.guan_yin_dian:
                PopupMenu popup4 = new PopupMenu(this,v);
                MenuInflater inflater4 = popup4.getMenuInflater();
                inflater4.inflate(R.menu.guan_yin_dian,popup4.getMenu());
                popup4.setOnMenuItemClickListener(XianTongSiActivity.this);
                //显示(这一行代码不要忘记了)
                popup4.show();
                break;
            default:
                break;
        }
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case R.id.WL_voice_desc:
                flag = false;
                MyLogUtils.e("点击了无量殿语音讲解");
                content = mContex.getString(R.string.wu_liang_text);
                drawer.openDrawer(Gravity.START);
                AudioUtils.getInstance().init(XianTongSiActivity.this); //初始化语音对象
                //从string里面获取文本
                AudioUtils.getInstance().speakText(content); //播放语音
                break;
            case R.id.WL_yinglian_detail:
                MyLogUtils.e("点击了无量殿楹联");
                break;

            case R.id.DX_voice_desc:
                flag = false;
                MyLogUtils.e("点击了大雄语音讲解");
                content = mContex.getString(R.string.da_xiong_text);
                voiceContent.setText(content);
                drawer.openDrawer(Gravity.START);
                AudioUtils.getInstance().init(XianTongSiActivity.this); //初始化语音对象
                //从string里面获取文本
                AudioUtils.getInstance().speakText(content); //播放语音
                break;
            case R.id.DX_yinglian_detail:
                MyLogUtils.e("点击了大雄楹联");
                break;

            case R.id.DW_voice_desc:
                flag = false;
                MyLogUtils.e("点击了大文殊殿讲解");
                content = mContex.getString(R.string.wen_shu_text);
                voiceContent.setText(content);
                drawer.openDrawer(Gravity.START);
                AudioUtils.getInstance().init(XianTongSiActivity.this); //初始化语音对象
                //从string里面获取文本
                AudioUtils.getInstance().speakText(content); //播放语音
                break;
            case R.id.DW_yinglian_detail:
                MyLogUtils.e("点击了大文殊殿楹联");
                break;

            case R.id.GY_voice_desc:
                flag = false;
                MyLogUtils.e("点击了观音殿讲解");
                content = mContex.getString(R.string.guan_yin_text);
                drawer.openDrawer(Gravity.START);
                AudioUtils.getInstance().init(XianTongSiActivity.this); //初始化语音对象
                //从string里面获取文本
                AudioUtils.getInstance().speakText(content); //播放语音
                break;
            case R.id.GY_yinglian_detail:
                MyLogUtils.e("点击了观音殿楹联");
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(!flag){
            AudioUtils.getInstance().stopSpeack();
            MyLogUtils.e("退出当前页面XianTongSi");
        }
    }


    //    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//        if( null != mTts ){
//            mTts.stopSpeaking();
//            // 退出时释放连接
//            mTts.destroy();
//        }
//    }

}
