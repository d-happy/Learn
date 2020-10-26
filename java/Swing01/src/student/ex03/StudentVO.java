package student.ex03;

public class StudentVO {
	
	private String s_no;
	private String s_name;
	private String s_major;
	private int    s_score;
	private String p_no;
	private String p_name;
	private String s_gender;
	
	
	public StudentVO() { }

	public StudentVO(String s_no, String s_name, String s_major, int s_score, String p_no, String p_name, String s_gender) {
		super();
		this.s_no = s_no;
		this.s_name = s_name;
		this.s_major = s_major;
		this.s_score = s_score;
		this.p_no = p_no;
		this.p_name = p_name;
		this.s_gender = s_gender;
	}

	public String getS_no() {
		return s_no;
	}

	public void setS_no(String s_no) {
		this.s_no = s_no;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_major() {
		return s_major;
	}

	public void setS_major(String s_major) {
		this.s_major = s_major;
	}

	public int getS_score() {
		return s_score;
	}

	public void setS_score(int s_score) {
		this.s_score = s_score;
	}

	public String getP_no() {
		return p_no;
	}

	public void setP_no(String p_no) {
		this.p_no = p_no;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getS_gender() {
		return s_gender;
	}

	public void setS_gender(String s_gender) {
		this.s_gender = s_gender;
	}
	
	@Override
	public String toString() {
		return "StudentFrame [s_no=" + s_no + ", s_name=" + s_name + ", s_major=" + s_major + ", s_score=" + s_score
				+ ", p_no=" + p_no + ", p_name=" + p_name + ", s_gender=" + s_gender +"]";
	}
	

}//class
