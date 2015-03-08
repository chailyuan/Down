package edu.down.viking.constant;

public class AppConstant 
{
	public class MainConstant
	{
		//标签的名字
		public static final String netTabName="下載完成";
		public static final String localTabName="正在下载";
	}
	
	public class NetworkConstant
	{
		//downPath为下载地址
		public static final String downPath="http://123.57.37.51/2015-03-08.txt";
		//savePath为保存音频的路径
		public static final String savePath="/mnt/sdcard/localDown/";

	}
	
	public class AdapterConstant
	{
		public static final String down_over="下载完成";
		public static final String delete="文件已经删除！";
	}
	
	public class DownloadServiceConstant
	{
		public static final String downOverAction="down_over_action";
	}
	
	public class LocalActivityConstant
	{
		public static final String update_action="updateUI";
	}
}
