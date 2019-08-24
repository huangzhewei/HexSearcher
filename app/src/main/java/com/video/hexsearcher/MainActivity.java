package com.video.hexsearcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.video.hexsearcher.entity.test.KuYunVodEntity;
import com.walixiwa.vodhunter.tools.VodParser;
import com.walixiwa.vodhunter.tools.VodSearcher;
import com.walixiwa.vodhunter.vod.BaseVodDetailEntity;
import com.walixiwa.vodhunter.vod.BaseVodItemEntity;
import com.yanzhenjie.nohttp.NoHttp;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String linker = "linker://eyJuYW1lIjoiT0votYTmupDnvZEiLCJ2ZXJzaW9uIjoiMjAxOTA4MjQiLCJiYXNlVXJsIjoiaHR0cDpcL1wvd3d3Lm9renl3LmNvbSIsInNlYXJjaFVybCI6Imh0dHBzOlwvXC93d3cub2t6eXcuY29tXC9pbmRleC5waHA/bT12b2Qtc2VhcmNoLXBnLSVwYWdlLXdkLSVrZXlXb3Jkcy5odG1sIiwicmVxdWVzdENoYXJzZXQiOiIiLCJyZXN1bHRDaGFyc2V0IjoiIiwidXNlckFnZW50IjoiIiwicmVzdWx0TGlua0hlYWRlciI6Imh0dHA6XC9cL3d3dy5va3p5dy5jb20iLCJydWxlUmVzdWx0TGlzdCI6IjxsaT4uKj94aW5nX3ZiNC4qPzxcL2xpPiIsInJ1bGVSZXN1bHRUaXRsZSI6InRhcmdldD1cIl9ibGFua1wiPiguKj8pPFwvYT4iLCJydWxlUmVzdWx0TGluayI6IjxhIGhyZWY9XCIoLio/KVwiIiwicnVsZVJlc3VsdEV4dHJhMSI6IjxzcGFuIGNsYXNzPVwieGluZ192YjZcIj4oLio/KTxcL3NwYW4+IiwicnVsZVJlc3VsdEV4dHJhMiI6IjxzcGFuIGNsYXNzPVwieGluZ192YjVcIj4oLio/KTxcL3NwYW4+IiwicnVsZVJlc3VsdEV4dHJhMyI6IiIsInJ1bGVSZXN1bHRFeHRyYTQiOiIiLCJydWxlRGV0YWlsQ292ZXIiOiIiLCJydWxlRGV0YWlsRGVzYyI6IiIsInJ1bGVMaXN0TTNVOCI6IiIsInJ1bGVMaXN0U2hhcmUiOiIiLCJydWxlTGlzdERvd25MaXN0IjoiIiwicnVsZUxpc3RUaXRsZSI6IiIsInJ1bGVMaXN0TGluayI6IiIsIm5ld05hbWVKc29uIjpbXSwibmV3TGlua0pzb24iOltdLCJuZXdCbG9ja05hbWUiOlsi56aP5Yip54mHIiwi5Lym55CG54mHIl19";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NoHttp.initialize(this);
    }


    public void test(View v) {
        KuYunVodEntity okVodEntity = new KuYunVodEntity();
        Log.e("entity", "json: " + okVodEntity.toJsonString());
        Log.e("entity", "linker: " + okVodEntity.toBase64Linker());
        new VodSearcher().init(okVodEntity).with("钢铁侠", 1).setCallBack(new VodSearcher.OnRequestFinishListener() {
            @Override
            public void onRequestFinish(List<BaseVodItemEntity> baseVodItemEntities) {
                for (BaseVodItemEntity baseVodItemEntity : baseVodItemEntities) {
                    Log.e("result", "onRequestFinish: " + baseVodItemEntity.toString());
                }
            }
        }).start();
    }

    public void parse(View view) {
        KuYunVodEntity okVodEntity = new KuYunVodEntity();
        new VodParser().init(okVodEntity).with("http://www.kuyunzy.net/detail/?33433.html").setCallBack(new VodParser.OnParseFinishListener() {
            @Override
            public void onParseFinish(BaseVodDetailEntity vodDetailEntity) {
                Log.e("result", vodDetailEntity.toString());
            }
        }).start();
    }
}
