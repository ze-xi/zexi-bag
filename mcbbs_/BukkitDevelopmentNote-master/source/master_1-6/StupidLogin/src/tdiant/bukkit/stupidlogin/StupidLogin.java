package tdiant.bukkit.stupidlogin;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import tdiant.bukkit.stupidlogin.command.PlayerLoginCommand;
import tdiant.bukkit.stupidlogin.listener.PlayerLimitListener;
import tdiant.bukkit.stupidlogin.listener.PlayerTipListener;

public class StupidLogin extends JavaPlugin {
	public static StupidLogin instance;
	
	public void onEnable() {
		instance = this;
		
		//Configuration
		this.saveDefaultConfig();  //���Ĭ������
		//Listener
		Bukkit.getPluginManager().registerEvents(new PlayerLimitListener(), this);  //ע�������
		Bukkit.getPluginManager().registerEvents(new PlayerLoginCommand(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerTipListener(), this);
		//Commands
		CommandExecutor ce = new PlayerLoginCommand();  //ע��ָ���������ָ���ͬһ��Executor
		Bukkit.getPluginCommand("login").setExecutor(ce);
		Bukkit.getPluginCommand("register").setExecutor(ce);
		
		getLogger().info("StupidLogin���������");
	}

	public void onDisable() {
		getLogger().info("StupidLogin����Ѿ�ж��.");
	}
}
