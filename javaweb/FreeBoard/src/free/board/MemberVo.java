package free.board;

public class MemberVo {
	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_image;
	
	public MemberVo() {
		super();
	}

	/*public MemberVo(String m_id, String m_pw, String m_name) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
	}*/

	public MemberVo(String m_id, String m_pw, String m_name, String m_image) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_image = m_image;
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

	public String getM_image() {
		return m_image;
	}

	public void setM_image(String m_image) {
		this.m_image = m_image;
	}

	@Override
	public String toString() {
		return "MemberVo [m_id=" + m_id + ", m_pw=" + m_pw + ", m_name=" + m_name + ", m_image=" + m_image + "]";
	}
	
}//MemberVo
