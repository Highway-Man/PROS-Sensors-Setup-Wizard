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
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class PageIme extends WizardPage{

	private Composite container;
	//text field for int that stores # of initialized imes
	public static Text countName;
	//<next> disabled by default
	public static boolean complete=false;

	//set page info
	public PageIme() {
		super("IME Page");
		setTitle("IME Configuration");
		setDescription("Configure IMEs on the I2C port");
	}
	
	//update page count when <back> pressed
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

		//a layout option
		GridData gd2 = new GridData(SWT.LEFT, SWT.FILL, true, false);
		gd2.widthHint = SWT.DEFAULT;
		gd2.heightHint = SWT.DEFAULT;
		gd2.horizontalSpan = 2;
		
		//another layout option
		GridData gd1 = new GridData(SWT.FILL, SWT.FILL, true, false);
		gd1.horizontalSpan = 1;

		//instructions
		Label label1 = new Label(container, SWT.NONE);
		label1.setText("Enter the name for the variable in which to store the number of initialized IMEs");
		label1.setLayoutData(gd2);
		//create text field
		countName = new Text(container, SWT.BORDER | SWT.SINGLE);
		//enable <next> when text entered
		countName.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				setPageComplete(true);
				complete = true;
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		countName.setLayoutData(gd1);

		setControl(container);
		setPageComplete(false);
	}
	
}
