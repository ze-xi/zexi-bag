package lx.POJO;

public class MCplayer {
	private int id;
	private String MCname;
	private String MCpwd;
	private Integer MC_ban;
	private String MC_ip;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMCname() {
		return MCname;
	}
	public void setMCname(String mCname) {
		MCname = mCname;
	}
	public String getMCpwd() {
		return MCpwd;
	}
	public void setMCpwd(String mCpwd) {
		MCpwd = mCpwd;
	}
	public Integer getMC_ban() {
		return MC_ban;
	}
	public void setMC_ban(Integer mC_ban) {
		MC_ban = mC_ban;
	}
	public String getMC_ip() {
		return MC_ip;
	}
	public void setMC_ip(String mC_ip) {
		MC_ip = mC_ip;
	}
	@Override
	public String toString() {
		return "player [id=" + id + ", MCname=" + MCname + ", MCpwd=" + MCpwd + "]";
	}
	
}
