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
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

//this page is always displayed first
public class PageInitial extends WizardPage{
	
	private Composite container;
	//check buttons for each sensor type
	public static Button checkGyro;
	public static Button checkEncoder;
	public static Button checkUlt;
	public static Button checkIme;
	public static Button checkLcd;
	public static Button checkInput;
	public static Button checkOutput;
	
	//set page info
	public PageInitial(){
		super("Initial Page");
		setTitle("Welcome to the PROS Sensors Setup Wizard");
		setDescription("Please select the types of sensors to configure");
	}
	
	//update page position when <back> pressed
	@Override
	public IWizardPage getPreviousPage() {
		SetupWizard.pages = SetupWizard.pages - 1;
		return super.getPreviousPage();
	}
	
	//ui
	@Override
	public void createControl(Composite parent){
		//layout stuff
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		
		//encoder label
		Label labelCheck1 = new Label(container, SWT.NONE);
		labelCheck1.setText("Quad Encoders");
		//encoder check
		checkEncoder = new Button(container, SWT.CHECK);
		checkEncoder.setSelection(true);
		
		//gyro label and check
		Label labelCheck2 = new Label(container, SWT.NONE);
		labelCheck2.setText("Gyroscope");
		checkGyro = new Button(container, SWT.CHECK);
		checkGyro.setSelection(true);
		
		//ultrasonic " " "
		Label labelCheckUlt = new Label(container, SWT.NONE);
		labelCheckUlt.setText("Ultrasonic");
		checkUlt = new Button(container, SWT.CHECK);
		checkUlt.setSelection(true);
		
		//and so on . . .
		Label labelCheckIme = new Label(container, SWT.NONE);
		labelCheckIme.setText("IME");
		checkIme = new Button(container, SWT.CHECK);
		checkIme.setSelection(true);
		
		Label labelCheckLcd = new Label(container, SWT.NONE);
		labelCheckLcd.setText("LCD");
		checkLcd = new Button(container, SWT.CHECK);
		checkLcd.setSelection(true);
		
		Label labelCheckInput = new Label(container, SWT.NONE);
		labelCheckInput.setText("General Input");
		checkInput = new Button(container, SWT.CHECK);
		
		Label labelCheckOutput = new Label(container, SWT.NONE);
		labelCheckOutput.setText("General Output");
		checkOutput = new Button(container, SWT.CHECK);
		
		setControl(container);
		setPageComplete(true);
	}
	
	//function to get check selection, could just as well call check.getSelection, but oh well
	public static boolean getCheckSelection(Button check){
		return check.getSelection();
	}
	
}
