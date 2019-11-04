package com.walixiwa.vodhunter.tools;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VodLinkManager {
    private static SQLiteDatabase database;
    private static VodLinkManager instance;
    private static final String LINK_TABLE = "CREATE TABLE IF NOT EXISTS link ( id integer PRIMARY KEY,linkName text,linkValue text,linkStatus text,linkFrom text)";
    private static final String BLOCK_TABLE = "CREATE TABLE IF NOT EXISTS block ( id integer PRIMARY KEY,keyWords text)";

    public static VodLinkManager getInstance(Context context) {
        if (instance == null) {
            instance = new VodLinkManager();
            initDataBase(context);
        }
        return instance;
    }

    private static void initDataBase(Context context) {
        File file = new File(getDataBaseFile(context) + File.separator + "link.db");
        if (!file.exists()) {
            try {
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file.exists()) {
            database = context.openOrCreateDatabase(getDataBaseFile(context) + File.separator + "link.db", 0, null);//创建数据库文件
            database.execSQL(LINK_TABLE);//创建表
            database.execSQL(BLOCK_TABLE);//屏蔽内容
        }
    }

    public void addOrUpdateLinksFromNetWork(String address, final MutiRequest.OnRequestFinishListener onRequestFinishListener) {
        new MutiRequest()
                .setUrl(address)
                .setCallBack(new MutiRequest.OnRequestFinishListener() {
                    @Override
                    public void onRequestFinish(final boolean status, final String response) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (status) {
                                    parseLinkResource(response);
                                }
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                        onRequestFinishListener.onRequestFinish(status, response);
                                    }
                                });
                            }
                        }).start();
                    }
                })
                .start();
    }

    private void parseLinkResource(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray list = jsonObject.getJSONArray("list");
            String linkFrom = jsonObject.getString("from");
            if (list.length() > 0) {//防止为空
                clearLink(linkFrom, "and linkStatus = '1'");
                for (int i = 0; i < list.length(); i++) {
                    JSONObject object = list.getJSONObject(i);
                    String linkName = object.getString("linkName");
                    String linkValue = object.getString("linkValue");
                    if (isExists(linkName, linkFrom)) {
                        updateLink(linkName, linkValue);
                    } else {
                        Log.e("info", "parseLinkResource: add");
                        addLink(linkName, linkValue, "1", linkFrom);
                    }
                }
            }

            JSONArray block = jsonObject.getJSONArray("block");
            for (int i = 0; i < block.length(); i++) {
                addBlock(block.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public boolean isExists(String linkName, String linkFrom) {
        int count = 0;
        if (database != null) {
            Cursor cursor = database.rawQuery("SELECT count(*) FROM link WHERE linkName = '" + linkName + "' and linkFrom = '" + linkFrom + "'", null);
            if (cursor.moveToNext()) {
                count = cursor.getInt(0);
            }
            cursor.close();
        }
        return count != 0;
    }

    public boolean isBlockExists(String keyWords) {
        int count = 0;
        if (database != null) {
            Cursor cursor = database.rawQuery("SELECT count(*) FROM block WHERE keyWords = '" + keyWords + "'", null);
            if (cursor.moveToNext()) {
                count = cursor.getInt(0);
            }
            cursor.close();
        }
        return count != 0;
    }

    public void addBlock(String keyWords) {
        if (database != null) {
            if (!isBlockExists(keyWords)) {
                database.execSQL("INSERT INTO block VALUES (null,'" + keyWords + "')");
            }
        }
    }

    public void deleteBlock(String keyWords) {
        if (database != null) {
            database.execSQL("delete from bolock where keyWords = '" + keyWords + "'");
        }
    }

    public void clearBlock() {
        if (database != null) {
            database.execSQL("delete from block");
        }
    }

    public List<String> getBlocks() {
        String sql = "SELECT * FROM block";
        List<String> links = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = database.rawQuery(sql, null);
            if (cursor.moveToFirst()) {
                do {
                    links.add(cursor.getString(1));
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((null != cursor) && (!cursor.isClosed())) {
                cursor.close();
            }
        }
        return links;
    }
    ////////////////////////

    public String getLinkStatus(String linkName) {
        String status = "0";
        Cursor cursor = null;
        try {
            cursor = database.rawQuery("SELECT * FROM link where linkName = '" + linkName + "'", null);
            if (cursor.moveToFirst()) {
                do {
                    status = cursor.getString(3);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((null != cursor) && (!cursor.isClosed())) {
                cursor.close();
            }
        }
        return status;
    }

    /**
     * 导入搜索源
     *
     * @param linkName   搜索源链接
     * @param linkValue  搜索源名称
     * @param linkStatus 搜索源来源
     * @param linkFrom   搜索源开启状态 1为开启，0为关闭
     */
    public void addLink(String linkName, String linkValue, String linkStatus, String linkFrom) {
        if (database != null) {
            if (!isExists(linkName, linkFrom)) { //跳过已存在的源
                database.execSQL("INSERT INTO link VALUES (null,'" + linkName + "','" + linkValue + "','" + linkStatus + "','" + linkFrom + "')");
            }
        }
    }

    /**
     * 更新引擎规则文件
     *
     * @param linkName  规则名称
     * @param linkValue 新规则
     */
    public void updateLink(String linkName, String linkValue) {
        if (database != null) {
            database.execSQL("update link set linkValue = '" + linkValue + "' where linkName = '" + linkName + "'");
        }
    }

    /**
     * 更新引擎状态
     */
    public void updateLinkStatus(String linkName, String linkStatus) {
        if (database != null) {
            database.execSQL("update link set linkStatus = '" + linkStatus + "' where linkName = '" + linkName + "'");
        }
    }

    /**
     * 通过引擎名称获取引擎规则
     *
     * @param linkName
     * @return
     */
    public String getLink(String linkName) {
        String linkValue = "";
        Cursor cursor = null;
        try {
            cursor = database.rawQuery("SELECT * FROM link where linkName = '" + linkName + "'", null);
            if (cursor.moveToFirst()) {
                do {
                    linkValue = cursor.getString(2);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((null != cursor) && (!cursor.isClosed())) {
                cursor.close();
            }
        }
        return linkValue;
    }

    /**
     * 清空指定来源的引擎
     *
     * @param linkFrom 引擎来源
     * @param hz       附加条件
     */
    public void clearLink(String linkFrom, String hz) {
        if (database != null) {
            Log.e("info", "sql: " + "delete from link where linkFrom = '" + linkFrom + "' " + hz);
            database.execSQL("delete from link where linkFrom = '" + linkFrom + "' " + hz);
        }
    }

    /**
     * 删除指定引擎
     *
     * @param linkName 引擎名称
     * @param hz       附加条件
     */
    public void deleteLink(String linkName, String hz) {
        if (database != null) {
            database.execSQL("delete from link where linkName = '" + linkName + "' " + hz);
        }
    }

    /**
     * 根据来源和表达式获取引擎列表
     *
     * @param linkFrom
     * @param hz
     * @return
     */
    public List<String> getLinks(@Nullable String linkFrom, @Nullable String hz) {
        String sql = "SELECT * FROM link ";
        if (linkFrom != null && hz == null) {
            sql = sql + "WHERE linkFrom = '" + linkFrom + "' ";
        }
        if (hz != null && linkFrom == null) {
            sql = sql + hz;
        }
        if (hz != null && linkFrom != null) {
            sql = sql + "WHERE linkFrom = '" + linkFrom + "' and " + hz;
        }
        sql = sql + " ORDER BY id ASC";
        List<String> links = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = database.rawQuery(sql, null);
            if (cursor.moveToFirst()) {
                do {
                    links.add(cursor.getString(2));
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((null != cursor) && (!cursor.isClosed())) {
                cursor.close();
            }
        }
        return links;
    }

    private static String getDataBaseFile(Context context) {
        String path = context.getFilesDir().getAbsolutePath() + File.separator + "hunter" + File.separator;
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;
    }
}
