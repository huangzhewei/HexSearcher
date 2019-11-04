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

import com.video.hexsearcher.entity.test.VodSeeVodEntity;
import com.video.hexsearcher.entity.thunder.Xl720Entity;
import com.walixiwa.vodhunter.thunder.BaseMagDetailEntity;
import com.walixiwa.vodhunter.tools.VodLinkManager;
import com.walixiwa.vodhunter.tools.MagParser;
import com.walixiwa.vodhunter.tools.MagSearcher;
import com.walixiwa.vodhunter.tools.MutiRequest;
import com.walixiwa.vodhunter.tools.VodParser;
import com.walixiwa.vodhunter.tools.VodSearcher;
import com.walixiwa.vodhunter.thunder.BaseMagItemEntity;
import com.walixiwa.vodhunter.vod.BaseVodDetailEntity;
import com.walixiwa.vodhunter.vod.BaseVodItemEntity;
import com.walixiwa.vodhunter.vod.BaseVodRegexEntity;
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
        VodLinkManager.getInstance(this)
                .addOrUpdateLinksFromNetWork("https://gitee.com/walixiwa/videohunter/raw/master/json/link0930/linker.json",
                        new MutiRequest.OnRequestFinishListener() {
                            @Override
                            public void onRequestFinish(boolean status, String response) {
                                Log.e("info", "onRequestFinish: " + status);
                                List<String> links = VodLinkManager.getInstance(getApplicationContext()).getLinks(null, null);
                                for (int i = 0; i < links.size(); i++) {
                                    Log.e("link", "link: " + new BaseVodRegexEntity(links.get(i)).getName());
                                }

                                List<String> block = VodLinkManager.getInstance(getApplicationContext()).getBlocks();
                                for (int i = 0; i < block.size(); i++) {
                                    Log.e("link", "block: " + block.get(i));
                                }
                            }
                        });
    }


    public void test(View v) {
        //testMag();
        testVod();
    }

    public void parse(View view) {
        //parseMag();
        parseVod();
    }

    private void testMag() {
        Xl720Entity magVodEntity = new Xl720Entity();
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

    private void parseMag() {
        Xl720Entity magVodEntity = new Xl720Entity();
        new MagParser()
                .init(magVodEntity)
                .with("https://www.xl720.com/thunder/36883.html")
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

    private void testVod() {
        VodSeeVodEntity okVodEntity = new VodSeeVodEntity();
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
                .start();
    }

    private void parseVod() {
        VodSeeVodEntity okVodEntity = new VodSeeVodEntity();
        new VodParser().init(okVodEntity).with("https://wolongzy.net/detail/161948.html").setCallBack(new VodParser.OnParseFinishListener() {
            @Override
            public void onParseFinish(BaseVodDetailEntity vodDetailEntity) {
                Log.e("result", vodDetailEntity.toString());
            }
        }).start();
    }
}
