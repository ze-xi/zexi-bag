package com.login;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.first.Dbox_Load;

public class login extends JavaPlugin implements Listener{
	
//----------------------------------------------------------	
	public void onLoad() {//加载服务器
		//保留
	}
//----------------------------------------------------------	
	@Override
	public void onEnable() {//服务器启动的方法
		//这个代码会自动判断插件配置文件里是不是有config.yml, 
		//没有就会放入默认的config.yml
		saveDefaultConfig();
		
		PluginManager pm=Bukkit
				.getServer()
				.getPluginManager();
		pm.registerEvents(this, this);
		getServer().getConsoleSender()
		.sendMessage("getServer.getConsoleSender.sendMessage"
				+ " MyPlugin 启动了-------------------------------------------Dbox_xi");
		System.out.println("System.out.println"
				+ " MyPlugin 启动了l--------------------------------------------Dbox_xi");
		System.out.println("§4可以吗喂喂喂喂喂喂喂喂喂喂喂喂喂喂喂喂");
	}
	@Override
	public void onDisable() {//服务器关闭的方法
		getServer().getConsoleSender()
		.sendMessage("onDisable.getServer.getConsoleSender.sendMessage"
				+ " MyPlugin 关闭了l---------------------------Dbox_xi");
	}
	
	@EventHandler
	public void onPlayerJoin(AsyncPlayerPreLoginEvent e) {
		Dbox_Load dl=new Dbox_Load();
		String PlayName=e.getName();
		System.out.println(PlayName+"|------------------------------Dbox_xi");
		if(dl.isRegister_state(PlayName)) {
			e.allow();
		}else {
			e.disallow(
				AsyncPlayerPreLoginEvent.Result.KICK_OTHER,
				"你不是蔡徐坤");
		}
		dl.File_inspect(PlayName);
	}
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		//设置玩家退出的消息
		e.setQuitMessage(e.getPlayer().getName()
				+" | "+e.getPlayer().getEntityId()
				+" | "+"退出了游戏呢");
	}
//----------------------------------------------------------↓
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {//玩家移动
		//保留
	}
//----------------------------------------------------------↑
	

}
