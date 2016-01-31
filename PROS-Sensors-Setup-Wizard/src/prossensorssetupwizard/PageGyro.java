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
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class PageGyro extends WizardPage{
	
	//need this
	private Composite container;
	//combo box to select port
	public static Combo gyroPort;
	//bool page complete, incomplete by default
	public static boolean complete = false;
	//text field for gyro name
	public static Text gyroName;
	
	//set page info
	public PageGyro(){
		super("Gyro Page");
		setTitle("Gyroscope Configuration");
		setDescription("Configure a gyroscope on the selected analog port");
	}
	
	//update page count for <back>
	@Override
	public IWizardPage getPreviousPage() {
		SetupWizard.pages = SetupWizard.pages - 1;
		return super.getPreviousPage();
	}
	
	//create ui
	@Override
	public void createControl(Composite parent){
		//layout stuff
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		
		//instructions
		Label label1 = new Label(container, SWT.NONE);
		label1.setText("Enter the desired gyroscope name");
		//name text field
		gyroName = new Text(container, SWT.BORDER | SWT.SINGLE);
		gyroName.setText("myGyro");
		
		//layout option
		GridData gd = new GridData(SWT.LEFT, SWT.FILL, false, false);
	    gd.widthHint = SWT.DEFAULT;
	    gd.heightHint = SWT.DEFAULT;
	    gd.horizontalSpan = 1;
	    
	    //instructions
		Label label = new Label(container, SWT.NONE);
		label.setText("Select the gyroscope's analog port");
		//port combo drop-down box (analog 1-8)
	    gyroPort = new Combo (container, SWT.READ_ONLY);
		gyroPort.setItems (new String [] {"1", "2", "3", "4", "5", "6", "7", "8"});
		//update <next> button when port selected
		gyroPort.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				setPageComplete(true);
				complete = true;
			}
		});
				
		setControl(container);
		setPageComplete(false);
	}
	
	public String getText1(){
		return gyroPort.getText();
	}
}
