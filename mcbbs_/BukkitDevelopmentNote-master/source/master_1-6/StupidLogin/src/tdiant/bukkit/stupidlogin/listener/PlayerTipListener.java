package tdiant.bukkit.stupidlogin.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import tdiant.bukkit.stupidlogin.LoginManager;

public class PlayerTipListener implements Listener {
	
	//��ҽ����������ġ�������¼����ʾ��
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		e.getPlayer().sendMessage(
					LoginManager.isRegister(e.getPlayer().getName())?
							"��ӭ������������/login ���� ��¼��������":
							"��ӭ��һ����������������������/register ���� ע���˺ţ�"
				);
	}

}
