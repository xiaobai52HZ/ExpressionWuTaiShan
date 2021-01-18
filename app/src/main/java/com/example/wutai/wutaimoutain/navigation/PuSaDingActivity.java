package com.example.wutai.wutaimoutain.navigation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import com.example.wutai.wutaimoutain.R;
import com.example.wutai.wutaimoutain.TaYuanSiVoice.DaBaiTaActivity;
import com.example.wutai.wutaimoutain.TaYuanSiVoice.DaCangJingGeActivity;
import com.example.wutai.wutaimoutain.TaYuanSiVoice.DaCiYanShouBaoDianActivity;
import com.example.wutai.wutaimoutain.TaYuanSiVoice.TianWangDianActivity;
import com.example.wutai.wutaimoutain.jianjie_new.Jianjie_dadian_actiivty;
import com.example.wutai.wutaimoutain.yinglian.YinglianShowActivity;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

public class PuSaDing extends AppCompatActivity implements View.OnClickListener,PopupMenu.OnMenuItemClickListener{
    private Button SS,WGT,WSD,DXBD,TWD;
    private String content;
    private Context mContex;
    private String name = "菩萨顶";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_sa_ding);
        initView();
    }
    public void initView(){
        //初始化声音设置
        SpeechUtility.createUtility(PuSaDing.this, SpeechConstant.APPID +"=5b63c383");  //=后面这里要替换成自己申请的 AppID
        SS = (Button)findViewById(R.id.pu_sa_ding_seng_she);
        SS.setOnClickListener(this);
        WGT = (Button)findViewById(R.id.pu_sa_ding_wu_guan_tang);
        WGT.setOnClickListener(this);
        WSD = (Button)findViewById(R.id.pu_sa_ding_wen_shu_dian);
        WSD.setOnClickListener(this);
        TWD = (Button)findViewById(R.id.pu_sa_ding_tian_wang_dian);
        TWD.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.da_cang_jing_ge:
                //创建弹出式菜单对象（最低版本11）
                PopupMenu popup = new PopupMenu(this, v);//第二个参数是绑定的那个view
                //获取菜单填充器
                MenuInflater inflater = popup.getMenuInflater();
                //填充菜单
                inflater.inflate(R.menu.da_cang_jing_ge_menu, popup.getMenu());
                //绑定菜单项的点击事件
                popup.setOnMenuItemClickListener(TaYuanSiActivity.this);
                //显示(这一行代码不要忘记了)
                popup.show();
                break;
            case R.id.da_bai_ta:
                PopupMenu popup2 = new PopupMenu(this,v);
                MenuInflater inflater2 = popup2.getMenuInflater();
                inflater2.inflate(R.menu.da_bai_ta_menu,popup2.getMenu());
                popup2.setOnMenuItemClickListener(TaYuanSiActivity.this);
                popup2.show();
                break;
            case R.id.da_ci_bao_dian:
                PopupMenu popup3 = new PopupMenu(this,v);
                MenuInflater inflater3 = popup3.getMenuInflater();
                inflater3.inflate(R.menu.da_ci_yan_shou_bao_dian_menu,popup3.getMenu());
                popup3.setOnMenuItemClickListener(TaYuanSiActivity.this);
                popup3.show();
                break;
            case R.id.tian_wang_dian:
                PopupMenu popup4 = new PopupMenu(this,v);
                MenuInflater inflater4 = popup4.getMenuInflater();
                inflater4.inflate(R.menu.tian_wang_dian_menu,popup4.getMenu());
                popup4.setOnMenuItemClickListener(TaYuanSiActivity.this);
                popup4.show();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.DCJG_yinglian_detail:
                YinglianShowActivity.actionstart(TaYuanSiActivity.this,name,"大藏经阁");
                break;
            case R.id.DCJG_voice_desc:
                startActivity(new Intent(TaYuanSiActivity.this, DaCangJingGeActivity.class));
                break;
            case R.id.DCJG_content:
                Jianjie_dadian_actiivty.actionstart1(TaYuanSiActivity.this,name,"藏经阁");
                break;
            case R.id.DBT_yinglian_detail:
                YinglianShowActivity  .actionstart(TaYuanSiActivity.this,name,"大白塔");
                break;
            case R.id.DBT_voice_desc:
                startActivity(new Intent(TaYuanSiActivity.this, DaBaiTaActivity.class));
                break;
            case R.id.DBT_content:
                Jianjie_dadian_actiivty.actionstart1(TaYuanSiActivity.this,name,"大白塔");
                break;
            case R.id.DCBD_yinglian_detail:
                YinglianShowActivity  .actionstart(TaYuanSiActivity.this,name,"大慈延寿宝殿");
                break;
            case R.id.DCBD_voice_desc:
                startActivity(new Intent(TaYuanSiActivity.this, DaCiYanShouBaoDianActivity.class));
                break;
            case R.id.DCBD_content:
                Jianjie_dadian_actiivty.actionstart1(TaYuanSiActivity.this,name,"大慈延寿宝殿");
                break;
            case R.id.TWD_yinglian_detail:
                YinglianShowActivity  .actionstart(TaYuanSiActivity.this,name,"天王殿");
                break;
            case R.id.TWD_voice_desc:
                startActivity(new Intent(TaYuanSiActivity.this, TianWangDianActivity.class));
                break;
            case R.id.TWD_content:
                Jianjie_dadian_actiivty.actionstart1(TaYuanSiActivity.this,name,"天王殿");
                break;
            default:
                break;
        }
        return true;
    }

}
