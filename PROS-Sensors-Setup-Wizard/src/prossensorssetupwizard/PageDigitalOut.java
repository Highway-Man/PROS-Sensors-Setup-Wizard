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
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class PageDigitalOut extends WizardPage{
	
	//need this
	private Composite container;
	//check buttons for ports
	public static Button[] checkDig;
	//<next> disabled by default
	public static boolean complete = false;
	
	//set page info
	public PageDigitalOut(){
		super("General Digital Output Page");
		setTitle("Digital Output Configuration");
		setDescription("Configure general digital outputs such as pneumatic solenoids and LEDs");
	}
	
	//update page count when <back> clicked
	@Override
	public IWizardPage getPreviousPage() {
		SetupWizard.pages--;
		return super.getPreviousPage();
	}
	
	@Override
	public void createControl(Composite parent) {
		//layout data
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		GridData gd2 = new GridData(SWT.FILL, SWT.FILL, true, false);
		gd2.horizontalSpan = 2;
		
		GridData gd1 = new GridData(SWT.LEFT, SWT.FILL, false, false);
		gd1.horizontalSpan = 1;
		
		//instructions
		Label instructions = new Label(container, SWT.NONE);
		instructions.setText("Select the ports to use as digital outputs for pneumatic solenoids, LEDs, etc.");
		instructions.setLayoutData(gd2);

		//port labels
		Label[] labelPort = new Label[13];
		//port checks
		checkDig = new Button[13];
		for(int i = 1; i < 13; i++){
			//create a dozen checks
			checkDig[i] = new Button(container, SWT.CHECK);
			checkDig[i].setLayoutData(gd1);
			//update <next> button
			checkDig[i].addSelectionListener(new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					setPageComplete(true);
					complete = true;
				}
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
				}
			});
			//create a dozen port labels
			labelPort[i] = new Label(container, SWT.NONE);
			labelPort[i].setText("Digital " + i);
			labelPort[i].setLayoutData(gd1);
		}
		
		setControl(container);
		setPageComplete(false);
	}
	
}