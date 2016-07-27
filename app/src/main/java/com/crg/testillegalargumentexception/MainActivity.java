package com.crg.testillegalargumentexception;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mButton = (Button) findViewById(R.id.insert_contacts);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("content://com.android.contacts/raw_contacts");
                ContentResolver resolver=mContext.getContentResolver();
                ContentValues values=new ContentValues();

                long contactid= ContentUris.parseId(resolver.insert(uri, values));

                //正确 uri
                //uri= Uri.parse("content://com.android.contacts/data");

                //错误 uri
                uri= Uri.parse(" com.android.contacts");

                //添加姓名
                values.put("raw_contact_id", contactid);
                values.put("mimetype", "vnd.android.cursor.item/name");
                values.put("data2", "王超");
                resolver.insert(uri, values);

                //添加电话
                values.put("raw_contact_id", contactid);
                values.put("mimetype", "vnd.android.cursor.item/phone_v2");
                values.put("data2", "2");
                values.put("data1", "4399101");
                resolver.insert(uri, values);

                //Email
                values.put("raw_contact_id", contactid);
                values.put("mimetype", "vnd.android.cursor.item/email_v2");
                values.put("data2", "2");
                values.put("data1", "1424246406@qq.com");
                resolver.insert(uri, values);
            }
        });
    }
}
