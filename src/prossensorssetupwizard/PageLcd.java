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

public class PageLcd extends WizardPage {
	
	private Composite container;
	//check buttons for uart1 and uart2
	public static Button checkLcd1;
	public static Button checkLcd2;
	//<next> disabled by default
	public static boolean complete=false;

	//set page info
	public PageLcd() {
		super("Lcd Page");
		setTitle("LCD Configuration");
		setDescription("Configure up to 2 LCDs on the selected uart port(s)");
	}
	
	//update page position when <back> pressed
	@Override
	public IWizardPage getPreviousPage() {
		SetupWizard.pages--;
		return super.getPreviousPage();
	}

	//create ui
	@Override
	public void createControl(Composite parent) {
		//layout stuff
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		//layout option
		GridData gd = new GridData(SWT.LEFT, SWT.FILL, false, false);
		gd.widthHint = SWT.DEFAULT;
		gd.heightHint = SWT.DEFAULT;
		gd.horizontalSpan = 1;

		//check label for uart1 check
		Label labelCheckLcd1 = new Label(container, SWT.NONE);
		labelCheckLcd1.setText("uart1");
		//uart1 check button
		checkLcd1 = new Button(container, SWT.CHECK);
		//enable <next> when a button is checked
		checkLcd1.addSelectionListener(new SelectionListener() {
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
		
		//label and check button for uart2
		Label labelCheckLcd2 = new Label(container, SWT.NONE);
		labelCheckLcd2.setText("uart2");
		checkLcd2 = new Button(container, SWT.CHECK);
		//enable <next> when button is checked
		checkLcd2.addSelectionListener(new SelectionListener() {
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
		
		setControl(container);
		setPageComplete(false);
	}

}
