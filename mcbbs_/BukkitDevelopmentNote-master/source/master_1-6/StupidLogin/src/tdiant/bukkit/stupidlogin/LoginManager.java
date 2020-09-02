package tdiant.bukkit.stupidlogin;

import java.util.ArrayList;
import java.util.List;

public class LoginManager {
	private static List<String> unloginList = new ArrayList<>();

	//��ȡ����Ƿ��¼
	public static boolean isLogin(String playerName) {
		return !unloginList.contains(playerName);
	}
	
	//������ҵ�¼״̬��flag=trueΪ��¼, falseΪδ��¼
	public static void setPlayerLogin(String playerName, boolean flag) {
		if(flag) {
			unloginList.remove(playerName);
		} else {
			unloginList.add(playerName);
		}
	}
	
	//�ж�����Ƿ�ע���˺�
	public static boolean isRegister(String playerName) {
		return StupidLogin.instance.getConfig().contains("player_data."+playerName);
	}
	
	//�����ע���˺�
	public static boolean register(String playerName, String password) {
		if(isRegister(playerName))
			return false;
		StupidLogin.instance.getConfig().set("player_data."+playerName+".password", password);
		StupidLogin.instance.saveConfig();
		return true;
	}
	
	//�ж������Ƿ���ȷ
	public static boolean isCorrectPassword(String playerName, String password) {
		if(!isRegister(playerName))
			return false;
		
		String pass = StupidLogin.instance.getConfig().getString("player_data."+playerName+".password");
		return pass.equals(password);
	}
}
