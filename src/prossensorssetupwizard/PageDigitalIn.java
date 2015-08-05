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

public class PageDigitalIn extends WizardPage{
	
	//need this
	private Composite container;
	//array of buttons for each port
	public static Button[] checkDig;
	//bool to enable <next> button
	public static Boolean complete = false;
	
	//set page info
	public PageDigitalIn(){
		super("General Digital Input Page");
		setTitle("Digital Input Configuration");
		setDescription("Configure general digital inputs such as buttons and limit switches");
	}
	
	//update page count when <back> is clicked
	@Override
	public IWizardPage getPreviousPage() {
		SetupWizard.pages--;
		return super.getPreviousPage();
	}
	
	//creates page ui
	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		//create layouts
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		GridData gd2 = new GridData(SWT.FILL, SWT.FILL, true, false);
		gd2.horizontalSpan = 2;
		
		GridData gd1 = new GridData(SWT.LEFT, SWT.FILL, false, false);
		gd1.horizontalSpan = 1;
		
		//instructions
		Label instructions = new Label(container, SWT.NONE);
		instructions.setText("Select the ports to use as digital inputs for buttons, limit switches, etc.");
		instructions.setLayoutData(gd2);

		//create 12 check buttons and labels
		Label[] labelPort = new Label[13];
		checkDig = new Button[13];
		for(int i = 1; i < 13; i++){
			checkDig[i] = new Button(container, SWT.CHECK);
			checkDig[i].setLayoutData(gd1);
			checkDig[i].addSelectionListener(new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					setPageComplete(true);
					complete=true;
				}
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
				}
			});
			labelPort[i] = new Label(container, SWT.NONE);
			labelPort[i].setText("Digital " + i);
			labelPort[i].setLayoutData(gd1);
		}
		
		setControl(container);
		setPageComplete(false);
	}
	
}
