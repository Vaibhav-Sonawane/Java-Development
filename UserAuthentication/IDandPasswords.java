package UserAuthentication;

import java.util.HashMap;

public class IDandPasswords {

	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	IDandPasswords(){
		
		logininfo.put("Vaibhav","pizza");
		logininfo.put("Om","PASSWORD");
		logininfo.put("Ram","abc123");
	}
	
	public HashMap getLoginInfo(){
		return logininfo;
	}
}