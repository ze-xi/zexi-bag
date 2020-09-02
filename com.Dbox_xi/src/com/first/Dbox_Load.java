package com.first;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;




/**
 * 测试版注册
 * 测试版登陆
 * 登陆之前要注册
 * 要登陆两次(重复输入一次)
 * @author Dbox_xi
 *
 */
public class Dbox_Load {
	
	private boolean Register_state=false;//注册状态
	private boolean Load_state = false;
	private Integer Load_level;
	private String root="Player_login_information";
	
	/**
	 * 创建文件txt存明文,暂时
	 * @param pathname
	 * @return txt文件的路径
	 */
	public void File_inspect(String Playname) {
		//完整路径
		String fileString=root+"\\"+Playname+".txt";
		System.out.println(fileString);
		File file=new File(fileString);
		isRegister_state(file);
		File_mkdir(fileString);
	}
	/**
	 * 判断文件是否为null和注册状态
	 * @param fileString 文件路径
	 * 
	 */
	public void File_mkdir(String fileString) {
		File file=new File(fileString);
		if (file!=null&&Register_state) {
			System.out.println("这个账号已存在");
			File_read(file);
		}else if(file!=null&&(Register_state==false)){
			System.out.println("这个账号从未注册过");
			System.out.println("File:"+file.mkdirs());
			
		}

	}
	/**
	 * 读取文件中的内容
	 */
	private String[] File_read(File file) {
		try {
			FileInputStream fis=new FileInputStream(file);
			InputStreamReader isr=new InputStreamReader(fis);
			BufferedReader br=new BufferedReader(isr);
			
			String[] txt=new String[3];
			//[0]->明文Actual[1]->secret key [2]->Encrypted
			String text=null;
			for (int i=0;(text=br.readLine())!=null;i++) {
				txt[i]=text;
			}
			return txt;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * @param File->文件
	 * @return 设置注册状态并返回
	 */
	public boolean isRegister_state(File file2) {
		
		File file=file2;
		if(file.exists()) {
			setRegister_state(true);
		}else {
			setRegister_state(false);
		}
		return Register_state;
	}
	/**
	 * 
	 * @param Playname玩家名字
	 * @return 是否允许登陆
	 */
	public boolean isRegister_state(String Playname) {
		if(Playname.equals("Dbox_xi")) {
			return true;
		}else {
			return false;
		}
	}
	public void setRegister_state(boolean register_state) {
		Register_state = register_state;
	}

	public boolean isLoad_state() {
		return Load_state;
	}

	public void setLoad_state(boolean load_state) {
		Load_state = load_state;
	}

	public Integer getLoad_level() {
		return Load_level;
	}

	public void setLoad_level(Integer load_level) {
		Load_level = load_level;
	}

	public Dbox_Load() {
		
	}
//---------------------------------------MD5类似加密算法---------------------------------------------
	
//---------------------------------------MD5类似加密算法---------------------------------------------
}
