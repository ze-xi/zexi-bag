package tdiant.bukkit.stupidlogin.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.*;

import tdiant.bukkit.stupidlogin.LoginManager;

public class PlayerLimitListener implements Listener {

	//����ֻ�ǰѼ���������������������أ����˵�������������������ƶ�.
	//����������ﰴ�������ķ�ʽ��Ӹ�������أ�ʹ����Ӱ�ȫ
	
	@EventHandler
	public void onPlayerChat(PlayerChatEvent e) {
		if(e.getMessage().substring(0, 0).equals("/"))
			return;
		e.setCancelled(needCancelled(e.getPlayer().getName()));
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		e.setCancelled(needCancelled(e.getPlayer().getName()));
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		e.setCancelled(needCancelled(e.getPlayer().getName()));
	}
	
	@EventHandler
	public void onPlayerInventory(InventoryOpenEvent e) {
		e.setCancelled(needCancelled(e.getPlayer().getName()));
	}
	
	private boolean needCancelled(String playerName) {
		return !LoginManager.isLogin(playerName);
	}
	
	// ������������������޸���ҵĵ�¼״̬
	
	@EventHandler
	private void onPlayerJoin(PlayerJoinEvent e) {
		LoginManager.setPlayerLogin(e.getPlayer().getName(), false);
	}
	
	@EventHandler
	private void onPlayerQuit(PlayerQuitEvent e) {
		LoginManager.setPlayerLogin(e.getPlayer().getName(), false);
	}
}
