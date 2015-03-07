package edu.down.viking.activity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import edu.down.viking.R;
import edu.down.viking.service.DownloadService;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity 
{
	private Button button;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle  savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        button= (Button)findViewById(R.id.button01);
        button.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
		    	intent.setClass(MainActivity.this, TableActivity.class);
		    	startActivity(intent);
				
			}
		});
        showList();
    }
    
    /**
     * 将列表显示出来,为了方便,这里手动添加列表
     * **/
    private void showList()
    {
    	//创建一个list,用于存放所有Item
    	List<Map<String,String>> list = new ArrayList<Map<String,String>>();
    	//start:每一个map就是一行或者说是一个item
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("name", "jscb.exe");
    	list.add(map);
    	//end
    	map=new HashMap<String, String>();
    	map.put("name", "2.mp3");
    	list.add(map);
    	map=new HashMap<String, String>();
    	
    	SimpleAdapter adapter= new SimpleAdapter(this,list,R.layout.main_item,new String[]{"name"},new int[]{R.id.network_filename});
    	this.setListAdapter(adapter);
    }
    
    /**
     * 点击下载图片会执行这个方法
     * @param v 所点击的图片
     * 
     * **/
    public void startDownload(View v)
    {
    	//得到下载按鈕的父控件,也就是item的Linearlayou布局
    	LinearLayout layout =(LinearLayout)v.getParent();
    	//得到所点击Item上的TextView
    	TextView fileName=(TextView)layout.findViewById(R.id.network_filename);
    	
    	Intent intent = new Intent();
    	intent.setClass(MainActivity.this, DownloadService.class);
    	intent.putExtra("fileName", fileName.getText().toString());
    	intent.putExtra("flag", "startDownload");
    	this.startService(intent);//点击下载按钮，启动service进行下载
    }
    
    @Override
	protected void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	this.stopService(new Intent(MainActivity.this,DownloadService.class));//關閉Service
	}
    
}