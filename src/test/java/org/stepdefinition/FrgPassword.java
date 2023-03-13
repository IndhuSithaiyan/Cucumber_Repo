package org.stepdefinition;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrgPassword extends BaseClass{
	/**

	 * All WebElements are identified by @FindBy annotation

	 */

	public FrgPassword() {
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()='Forgotten password?']")
	private WebElement btnFrgPass;

	@FindBy(id="identify_email")
	private WebElement txtSearchBox;

	@FindBy(id="did_submit")
	private WebElement btnSearch;

	public WebElement getBtnFrgPass() {
		return btnFrgPass;
	}

	public WebElement getTxtSearchBox() {
		return txtSearchBox;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}
}
