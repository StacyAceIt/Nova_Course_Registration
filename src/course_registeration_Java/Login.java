package course_registeration_Java;

class Login {
	private String username;
	private String password;
	
	Login(String _username, String _password){
		this.username = _username;
		this.password = _password;
	}
	
	String getUsername() {
		return this.username;
	}
	
	String getPassword() {
		return this.password;
	}
	
	
}
