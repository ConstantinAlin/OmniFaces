/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Constantin Alin
 */
@Named
@RequestScoped
public class MyBean {

	private String attr = "rendered";

	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}

}
