package com.video.hexsearcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.video.hexsearcher.entity.test.HDVodEntity;
import com.video.hexsearcher.entity.test.MagVodEntity;
import com.video.hexsearcher.entity.test.OKVodEntity;
import com.walixiwa.vodhunter.tools.MagSearcher;
import com.walixiwa.vodhunter.tools.VodParser;
import com.walixiwa.vodhunter.tools.VodSearcher;
import com.walixiwa.vodhunter.vod.BaseMagItemEntity;
import com.walixiwa.vodhunter.vod.BaseVodDetailEntity;
import com.walixiwa.vodhunter.vod.BaseVodItemEntity;
import com.yanzhenjie.nohttp.NoHttp;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView key;
    private EditText keyWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NoHttp.initialize(this);
        keyWords=findViewById(R.id.keyWords);
        key = findViewById(R.id.key);
        key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                assert clipboardManager != null;
                clipboardManager.setPrimaryClip(ClipData.newPlainText(null, key.getText().toString()));
                Toast.makeText(MainActivity.this, "已复制Linker", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void test(View v) {
        /*OKVodEntity okVodEntity = new OKVodEntity();
        //生成json
        Log.e("entity", "json: " + okVodEntity.toJsonString());
        //生成链接
        Log.e("entity", "linker: " + okVodEntity.toBase64Linker().replaceAll("\n", "").trim());
        key.setText(okVodEntity.toBase64Linker().replaceAll("\n", "").trim());

        new VodSearcher()
                .init(okVodEntity)
                .with(keyWords.getText().toString(), 1)
                .setCallBack(new VodSearcher.OnRequestFinishListener() {
                    @Override
                    public void onRequestFinish(List<BaseVodItemEntity> baseVodItemEntities) {
                        for (BaseVodItemEntity baseVodItemEntity : baseVodItemEntities) {
                            Log.e("result", "onRequestFinish: " + baseVodItemEntity.toString());
                        }
                    }
                })
                .start();*/

        MagVodEntity magVodEntity = new MagVodEntity();
        Log.e("entity", "linker: " + magVodEntity.toBase64Linker().replaceAll("\n", "").trim());
        key.setText(magVodEntity.toBase64Linker().replaceAll("\n", "").trim());
        new MagSearcher().init(magVodEntity).with("猎场",1).setCallBack(new MagSearcher.OnRequestFinishListener() {
            @Override
            public void onRequestFinish(List<BaseMagItemEntity> baseVodItemEntities) {
                for (BaseMagItemEntity baseVodItemEntity : baseVodItemEntities) {
                    Log.e("result", "onRequestFinish: " + baseVodItemEntity.toString());
                }
            }
        }).start();
    }

    public void parse(View view) {
        OKVodEntity okVodEntity = new OKVodEntity();
        new VodParser().init(okVodEntity).with("http://www.okzyw.com/?m=vod-detail-id-38622.html").setCallBack(new VodParser.OnParseFinishListener() {
            @Override
            public void onParseFinish(BaseVodDetailEntity vodDetailEntity) {
                Log.e("result", vodDetailEntity.toString());
            }
        }).start();
    }
}
