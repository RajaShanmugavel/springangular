package com.abc.springmvc.bean;

public class OptionsSelected {

	private String optionId;
	private String optionText;
	private boolean selectedOptionId;

	public String getOptionId() {
		return optionId;
	}

	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	public boolean isSelectedOptionId() {
		return selectedOptionId;
	}

	public void setSelectedOptionId(boolean selectedOptionId) {
		this.selectedOptionId = selectedOptionId;
	}
	
//	@Override
//	public String toString(){
//		return "optionId:"+optionId+", optionText:"+optionText+", optionSelected:"+selectedOptionId;
//	}

}
