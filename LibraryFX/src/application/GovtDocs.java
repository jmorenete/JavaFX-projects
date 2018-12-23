package application;

import java.util.Scanner;

public class GovtDocs extends Items{
	private String type;
	private String govtDocId;


	public GovtDocs(String name, String type, int pageNo, double location) {
		super(name, pageNo, location);
		this.type = type;
		this.govtDocId =("G" + Items.itemNo);
		items.add(this);
	}

	@Override
	public int loanTime() {
		return 5;
	}

	public String getGovtDocId() {
		return govtDocId;
	}

	public void setGovtDocId(String govtDocId) {
		this.govtDocId = govtDocId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
