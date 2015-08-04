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
	
	private Composite container;
	public static Combo gyroPort;
	public static boolean complete = false;
	public static Text gyroName;
	
	public PageGyro(){
		super("Gyro Page");
		setTitle("Gyroscope Configuration");
		setDescription("Configure a gyroscope on the selected analog port");
	}
	
	@Override
	public IWizardPage getPreviousPage() {
		SetupWizard.pages = SetupWizard.pages - 1;
		return super.getPreviousPage();
	}
	
	@Override
	public void createControl(Composite parent){
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		
		Label label1 = new Label(container, SWT.NONE);
		label1.setText("Enter the desired gyroscope name");
		gyroName = new Text(container, SWT.BORDER | SWT.SINGLE);
		gyroName.setText("myGyro");
				
		GridData gd = new GridData(SWT.LEFT, SWT.FILL, false, false);
	    gd.widthHint = SWT.DEFAULT;
	    gd.heightHint = SWT.DEFAULT;
	    gd.horizontalSpan = 1;
		Label labelFirstEnc = new Label(container, SWT.NONE);
		labelFirstEnc.setText("Select the gyroscope's analog port");
	    gyroPort = new Combo (container, SWT.READ_ONLY);
		gyroPort.setItems (new String [] {"1", "2", "3", "4", "5", "6", "7", "8"});
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
