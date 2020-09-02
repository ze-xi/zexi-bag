package com.first;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import lx.DO.lx_conn;

public class Hello extends JavaPlugin implements Listener{
	
//----------------------------------------------------------	
	public void onLoad() {//加载服务器
		//保留
	}
//----------------------------------------------------------	
	@Override
	public void onEnable() {//服务器启动的方法
		//这个代码会自动判断插件配置文件里是不是有config.yml
		saveDefaultConfig();
		
		PluginManager pm=Bukkit
				.getServer()
				.getPluginManager();
		pm.registerEvents(this, this);
		getServer().getConsoleSender()
		.sendMessage("getServer.getConsoleSender.sendMessage"
				+ " MyPlugin 启动了-------------------------------------------Dbox_xi");
		System.out.println("§4可以吗喂喂喂喂喂喂喂喂喂喂喂喂喂喂喂喂");
	}
	@Override
	public void onDisable() {//服务器关闭的方法
		getServer().getConsoleSender()
		.sendMessage("onDisable.getServer.getConsoleSender.sendMessage"
				+ " MyPlugin 关闭了l---------------------------Dbox_xi");
	}
	
	@EventHandler
	
	public void onPlayerJoin(PlayerJoinEvent e) {
		//玩家加入
		SetScore(e);
		GetLoginPlayer(e);
		
	}
	/**
	 * 校验登录器
	 */
	public void GetLoginPlayer(PlayerJoinEvent e) {
		lx_conn lc=new lx_conn();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str="";
		try {
			System.out.println("Test:输入Playername");
			str=bf.readLine();
			Integer id_1=Integer.parseInt(str);
			lc.player_findall(id_1);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	/**
	 * 设置撸石头就能拿到分数
	 * @param e
	 */
	public void SetScore(PlayerJoinEvent e) {
		//在这里我们监听了PlayerJoinEvent，并操作'config.yml'
				//这是我们要获取的键名
				String key="Data."+e.getPlayer().getName()+".Score";
				int score;
				//先判断一下有没有这个键,有的话读取,没有就按0处理
				score=getConfig().contains(key)?
						getConfig().getInt(key):0;
				e.getPlayer().sendMessage("你的积分是："+score);
	}
	//如果你要真的写个插件，一定要小心，判断一下BlockBrekaEvent是否被其他
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		//判断类型，是石头
		if(e.getBlock().getType()==Material.STONE) {
			String key="Data."+e.getPlayer().getName()+".Score";
			int score=getConfig().contains(key)?
					getConfig().getInt(key):0;
			//如果你想删除Player3的数据
			//你应该写成
			//getConfig().set("Data.Player3",null);
			//也达到删除一个键的目的
			getConfig().set(key, score+10);
			//但是写到这里要小心！你只是修改了内存上的数据，
			//你没有修改硬盘上的config.yml文件里的数据！
			saveConfig();//所以要注意，修改数据要记得保存
			
		}
	}
	
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
//		//设置玩家退出的消息
//		e.setQuitMessage(e.getPlayer().getName()
//				+" | "+e.getPlayer().getEntityId()
//				+" | "+"退出了游戏啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
	}
//----------------------------------------------------------↓
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {//玩家移动
		//保留
	}
//----------------------------------------------------------↑
	

}
