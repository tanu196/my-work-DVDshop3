package customer;

public class Member {
	private final String memberId;
	private final String name;
	private int point;

	public Member(String memberId, String name) {
		this.memberId = memberId;
		this.name = name;
		this.point = 0;
	}
	
	public int getPoint() {
		return point;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getName() {
		return name;
	}

	public void addPoint(int p) {
		this.point += p;
	}
}
