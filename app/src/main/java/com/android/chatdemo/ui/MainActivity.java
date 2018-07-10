package com.android.chatdemo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.chatdemo.R;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());
    }


    public native String stringFromJNI();

    public void messenger(View view) {
        startActivity(new Intent(this, MessengerActivity.class));
    }

    public void socket(View view) {
        startActivity(new Intent(this, SocketClientActivity.class));

    }

    public void aidl(View view) {
        startActivity(new Intent(this, AIDLActivity.class));

    }

    public void ContentProvider(View view) {
        startActivity(new Intent(this, ContentProviderActivity.class));

    }
}
/**
 * 为何开启android应用要开启多进程，主要有以下几点：
 * 单进程所分配的内存不够，需要更多的内存。在早期android系统只为一个单进程的应用分配了16M的可用内存，随着手机的硬件的提升和android系统的改进，虽然可分配内存越来越多，但仍旧可以通过开启多进程来获取更多的内存来处理自己App的业务
 * 独立运行的组件，比如个推，它的服务会另开一个进程。
 * 运行一些”不可见人”的操作，比如获取用户的隐私数据，比如双守护进程来防止被用户杀掉
 * <p>
 * 在AIDL文件中支持的数据类型包括
 * 基本数据类型
 * String和CharSequence
 * List:只支持ArrayList,里面的元素都必须被AIDL支持
 * Map:只支持HashMap,里面的元素必须被AIDL 支持
 * 实现Parcelable接口的对象
 * 所有AIDL接口
 */

/**
 在AIDL文件中支持的数据类型包括
 基本数据类型
 String和CharSequence
 List:只支持ArrayList,里面的元素都必须被AIDL支持
 Map:只支持HashMap,里面的元素必须被AIDL 支持
 实现Parcelable接口的对象
 所有AIDL接口
 * */