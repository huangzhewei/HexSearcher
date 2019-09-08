package com.video.hexsearcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.video.hexsearcher.entity.test.A156VodEntity;
import com.video.hexsearcher.entity.test.HaKuVodEntity;
import com.video.hexsearcher.entity.test.OKVodEntity;
import com.video.hexsearcher.entity.thunder.DyttEntity;
import com.video.hexsearcher.entity.thunder.PiaoHuaEntity;
import com.walixiwa.vodhunter.thunder.BaseMagDetailEntity;
import com.walixiwa.vodhunter.tools.MagParser;
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
        keyWords = findViewById(R.id.keyWords);
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
       /* HaKuVodEntity okVodEntity = new HaKuVodEntity();
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

        DyttEntity magVodEntity = new DyttEntity();
        Log.e("entity", "linker: " + magVodEntity.toBase64Linker().replaceAll("\n", "").trim());
        key.setText(magVodEntity.toBase64Linker().replaceAll("\n", "").trim());
        new MagSearcher().init(magVodEntity).with(keyWords.getText().toString(), 1).setCallBack(new MagSearcher.OnRequestFinishListener() {
            @Override
            public void onRequestFinish(List<BaseMagItemEntity> baseVodItemEntities) {
                for (BaseMagItemEntity baseVodItemEntity : baseVodItemEntities) {
                    Log.e("result", "onRequestFinish: " + baseVodItemEntity.toString());
                }
            }
        }).start();
    }

    public void parse(View view) {
        /*HaKuVodEntity okVodEntity = new HaKuVodEntity();
        new VodParser().init(okVodEntity).with("http://www.666zy.com/?m=vod-detail-id-30493.html").setCallBack(new VodParser.OnParseFinishListener() {
            @Override
            public void onParseFinish(BaseVodDetailEntity vodDetailEntity) {
                Log.e("result", vodDetailEntity.toString());
            }
        }).start();*/
        DyttEntity magVodEntity = new DyttEntity();
        new MagParser()
                .init(magVodEntity)
                .with("http://walixiwa.club:455/curl/c.php?url=https://www.ygdy8.com/html/gndy/jddy/20190623/58756.html")
                .setCallBack(new MagParser.OnParseFinishListener() {
                    @Override
                    public void onParseFinish(List<BaseMagDetailEntity> links) {
                        for (int i = 0; i < links.size(); i++) {
                            Log.e("link", "onParseFinish: " + links.get(i).getTitle());
                            Log.e("link", "onParseFinish: " + links.get(i).getLink());
                        }
                    }
                })
                .start();

    }
}
