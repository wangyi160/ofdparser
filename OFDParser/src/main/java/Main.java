import mytest.ZipUtil;

public class Main {

	public static void main(String args[]) throws Exception
	{
		// 将文件解压		
		ZipUtil.unzip("ofdfiles/ReaderManual.ofd", "ofdunzipfiles", true);
		
		// 解析解压文件夹中的OFD.xml
				
	}
	
}
