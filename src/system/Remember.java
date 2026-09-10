package system;

import Item.Dvd;
import customer.Member;

//借りるときに名前と借りたものを記録するクラス
public class Remember {
	private final Member member;
	private final Dvd dvd;

	public Remember(Member member, Dvd dvd) {
		this.member = member;
		this.dvd = dvd;
	}

	public Member getMember() {
		return member;
	}

	public Dvd getDvd() {
		return dvd;
	}

}
