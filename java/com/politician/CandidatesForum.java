package com.politician;

public class CandidatesForum {

	private int id_Number = 0;
	private String first_name = null;
	private String last_name= null;
	private String state = null;
	private String  party_affiliation= null;
	private String religion = null;
	private String occupation = null;
	private String alignment = null;
	
	public CandidatesForum(){
		super();
	}
	
	
	
	public String getAlignment() {
		return alignment;
	}



	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}



	public String getOccupation() {
		return occupation;
	}



	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}



	public int getId_Number() {
		return id_Number;
	}
	public void setId_Number(int id_Number) {
		this.id_Number = id_Number;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getParty_affiliation() {
		return party_affiliation;
	}
	public void setParty_affiliation(String party_affiliation) {
		this.party_affiliation = party_affiliation;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}


	@Override
	public String toString() {
		return "CandidatesForum [id_Number=" + id_Number + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", state=" + state + ", party_affiliation=" + party_affiliation + ", religion=" + religion + "]";
	}

	
	
} // end of class

