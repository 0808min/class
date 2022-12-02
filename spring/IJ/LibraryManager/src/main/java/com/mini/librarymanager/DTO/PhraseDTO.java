package com.mini.librarymanager.DTO;

public class PhraseDTO {
	private int phraseId;
	private String phraseString;

	public PhraseDTO(int phraseId, String phraseString) {
		super();
		this.phraseId = phraseId;
		this.phraseString = phraseString;
	}

	public int getPhraseId() {
		return phraseId;
	}

	public void setPhraseId(int phraseId) {
		this.phraseId = phraseId;
	}

	public String getPhraseString() {
		return phraseString;
	}

	public void setPhraseString(String phraseString) {
		this.phraseString = phraseString;
	}

	@Override
	public String toString() {
		return "PhraseDTO [phraseId=" + phraseId + ", phraseString=" + phraseString + "]";
	}

}
