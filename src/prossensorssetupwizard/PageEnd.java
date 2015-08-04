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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class PageEnd extends WizardPage{
	
	private Composite container;

	public PageEnd(){
		super("Final Page");
		setTitle("Configuration Complete");
		setDescription("Click Finish to complete the configuration");
	}
	
	@Override
	public IWizardPage getPreviousPage() {
		SetupWizard.pages--;
		return super.getPreviousPage();
	}
	
	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		GridData gd2 = new GridData(SWT.LEFT, SWT.FILL, true, false);
		gd2.widthHint = SWT.DEFAULT;
		gd2.heightHint = SWT.DEFAULT;
		gd2.horizontalSpan = 2;
		
		Label label1 = new Label(container, SWT.NONE);
		label1.setText("The wizard will now add the selected setup code to the necessary files.");
		label1.setLayoutData(gd2);

		setControl(container);
		setPageComplete(false);
	}

}
