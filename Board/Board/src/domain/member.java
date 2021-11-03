package domain;

public class member {
	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_email;
	private int m_point;
	
	public member() {
	}

	public member(String m_id, String m_pw, String m_name, String m_email, int m_point) {
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_point = m_point;
	}

	public member(String m_id, String m_pw, String m_name, String m_email) {
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_point = 1500;
	}

	public member(String m_id, String m_pw) {
		this.m_id = m_id;
		this.m_pw = m_pw;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public int getM_point() {
		return m_point;
	}

	public void setM_point(int m_point) {
		this.m_point = m_point;
	}
	
	
	
	
	
	
	
	
	
	
}
