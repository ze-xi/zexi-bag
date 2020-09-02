package tdiant.bukkit.stupidlogin.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import tdiant.bukkit.stupidlogin.LoginManager;

public class PlayerLoginCommand implements Listener, CommandExecutor {
	@EventHandler //�������س��˵�¼��������ָ��
	public void onPlayerCommand(PlayerCommandPreprocessEvent e) {
		if( LoginManager.isLogin(e.getPlayer().getName()) )
			return;
		
		e.setCancelled(true);
		if( e.getMessage().split(" ")[0].contains("login") 
				|| e.getMessage().split(" ")[0].contains("register") )
			e.setCancelled(false);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		if(!(sender instanceof Player)) 
			return false;
		
		Player p = (Player)sender;
		
		if(cmd.getName().equalsIgnoreCase("login"))
			loginCommand(p,arg);
		else if(cmd.getName().equalsIgnoreCase("register"))
			registerCommand(p,arg);
		return true;
	}
	
	private void loginCommand(Player p, String[] args) {
		if(LoginManager.isLogin(p.getName())) {
			p.sendMessage("���Ѿ���¼�ˣ�");
			return;
		}
		if(LoginManager.isRegister(p.getName())) {
			p.sendMessage(ChatColor.RED+"�㻹û��ע�ᣡ");
			return;
		}
		if(args.length!=1) {
			p.sendMessage(ChatColor.RED+"��¼ָ��ʹ�ô���");
			return;
		}
		if(LoginManager.isCorrectPassword(p.getName(), args[0])) {
			p.sendMessage(ChatColor.GREEN+"��¼�ɹ���");
			LoginManager.setPlayerLogin(p.getName(), true);
		}
	}
	
	private void registerCommand(Player p, String[] args) {
		if(LoginManager.isLogin(p.getName())) {
			p.sendMessage("���Ѿ���¼�ˣ�");
			return;
		}
		if(LoginManager.isRegister(p.getName())) {
			p.sendMessage("���Ѿ���¼�ˣ�");
			return;
		}
		if(args.length!=1) {
			p.sendMessage(ChatColor.RED+"ע��ָ��ʹ�ô���");
			return;
		}
		LoginManager.register(p.getName(), args[0]);
		p.sendMessage(ChatColor.GREEN+"ע��ɹ������¼��");
	}
}
