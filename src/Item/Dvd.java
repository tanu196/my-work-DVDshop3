package Item;

public class Dvd {
	private final String title;
	private final int price;
	private final String dvdId;
	private boolean dvdJudge;
	
	
	public Dvd(String title ,int price , String number) {
		this.title = title;
		this.price = price;
		this.dvdId = number;
		this.dvdJudge = false;
	}
	
	public boolean isExist() {
		return dvdJudge;
	}
	
	public void dvdRental() {
		this.dvdJudge = true;
	}
	
	public void dvdReturn() {
		this.dvdJudge = false;
	}
	
	public int getPrice() {
		return price;
	}

	public String getTitle() {
		return title;
	}

	public String getDvdId() {
		return dvdId;
	}
	
	
}
