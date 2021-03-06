/*	
 * 	Copyright 2015 Jacob Knaup
 * 
 * 	This file is part of PROS Sensors Setup Wizard.
 * 
 * 	PROS Sensors Setup Wizard is free software: you can redistribute it and/or modify
 * 	it under the terms of the GNU General Public License as published by
 * 	the Free Software Foundation, either version 3 of the License, or
 * 	(at your option) any later version.
 * 
 * 	PROS Sensors Setup Wizard is distributed in the hope that it will be useful,
 * 	but WITHOUT ANY WARRANTY; without even the implied warranty of
 * 	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * 	GNU General Public License for more details.
 * 	You should have received a copy of the GNU General Public License
 * 	along with PROS Sensors Setup Wizard.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package prossensorssetupwizard;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

import prossensorssetupwizard.performconfiguration.PerformEdits;

public class SetupWizard extends Wizard {

	//public static Composite container;

	//add protected methods for each page class
	protected PageEncoder encoder;
	protected PageInitial initial;
	protected PageGyro gyro;
	protected PageUltrasonic ultrasonic;
	protected PageIme ime;
	protected PageLcd lcd;
	protected PageDigitalIn input;
	protected PageDigitalOut output;
	protected PageEnd end;

	//<finish> disabled by default
	boolean canFinish = false;
	//initialize page count
	public static int pages=1;

	//standard for wizards
	public SetupWizard() {
		super();
		setNeedsProgressMonitor(true);
		pages=1;
	}

	//set window title
	@Override
	public String getWindowTitle() {
		return "PROS Sensors Setup Wizard";
	}

	//add all possible pages
	@Override
	public void addPages() {
		initial = new PageInitial();
		encoder = new PageEncoder();
		gyro = new PageGyro();
		ultrasonic = new PageUltrasonic();
		ime = new PageIme();
		lcd = new PageLcd();
		input = new PageDigitalIn();
		output = new PageDigitalOut();
		end = new PageEnd();
		addPage(initial);
		addPage(encoder);
		addPage(gyro);
		addPage(ultrasonic);
		addPage(ime);
		addPage(lcd);
		addPage(input);
		addPage(output);
		addPage(end);
	}

	//get next page based on checks & current page
	@Override
	public IWizardPage getNextPage(IWizardPage currentPage) {
		if(pages < 1){
			pages=1;
			return initial;
		}
		if (PageInitial.getCheckSelection(PageInitial.checkEncoder) && pages < 2){
			pages=2;
			return encoder;
		}
		else if (PageInitial.getCheckSelection(PageInitial.checkGyro)
				 && pages<3){
			pages=3;
			return gyro;
		}
		else if (PageInitial.getCheckSelection(PageInitial.checkUlt)
				 && pages<4){
			pages=4;
			return ultrasonic;
		}
		else if (PageInitial.getCheckSelection(PageInitial.checkIme) && pages < 5){
			pages=5;
			return ime;
				}
		else if (PageInitial.getCheckSelection(PageInitial.checkLcd)
				&&  pages<6){
			pages=6;
			return lcd;
		}
		else if (PageInitial.getCheckSelection(PageInitial.checkInput)
				&&  pages<7){
			pages=7;
			return input;
		}
		else if (PageInitial.getCheckSelection(PageInitial.checkOutput)
				&& pages < 8){
			pages=8;
			return output;
		}
		else {
			pages = 9;
			canFinish = true;
			return end;
		}
	}

	//update status of <finish> button
	@Override
	public boolean canFinish() {
		return canFinish;
	}

	//run performConfiguration() when <finish> is clicked
	//edits code
	@Override
	public boolean performFinish() {

		PerformEdits.performConfiguration();

		return true;
	}

}
