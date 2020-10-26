package student.ex01;

public class StudentVO { //Value Object : ����ó�� Ȱ��
						 //���̺� Į�� ����, �ʵ� - �⺻ ������, �ʵ� ������, ���� ����, ����Ʈ��
	
	private String sno;
	private String sname;
	private String smajor;
	private int score;
	private String pno;
	private String pname;
	
	public StudentVO() { }

	public StudentVO(String sno, String sname, String smajor, int score, String pno, String pname) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.smajor = smajor;
		this.score = score;
		this.pno = pno;
		this.pname = pname;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSmajor() {
		return smajor;
	}

	public void setSmajor(String smajor) {
		this.smajor = smajor;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Override
	public String toString() {
		return "StudentVO [sno=" + sno + ", sname=" + sname + ", smajor=" + smajor + ", score=" + score + ", pno=" + pno
				+ ", pname=" + pname + "]";
	}
	

}//class
