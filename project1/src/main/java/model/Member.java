package model;
/*
 * Bean 클래스 
 * 프로퍼티(property) 
 *   get 프로퍼티 : getId() -> id (get 프로퍼티)
 *                getXxx => xxx
 *   set 프로퍼티 : setId(Object) -> id(set 프로퍼티)
 *                setAbc => abc
 */
public class Member {
	private String id;
	private String pass;
	private String name;
	private String tel;
	private String email;
	//getter,setter,toString
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", pass=" + pass + ", name=" + name + ", gender=" +  ", tel=" + tel
				+ ", email=" + email + ", picture=" +  "]";
	}
	
}
