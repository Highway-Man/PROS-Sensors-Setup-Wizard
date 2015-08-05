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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class PageEncoder extends WizardPage {
	//mandatory
	private Composite container;
	//create 2 drop down combos for each of 5 encoders
	public static Combo combo11;
	public static Combo combo12;
	public static Combo combo21;
	public static Combo combo22;
	public static Combo combo31;
	public static Combo combo32;
	public static Combo combo41;
	public static Combo combo42;
	public static Combo combo51;
	public static Combo combo52;
	
	//text fields for 5 encoders
	public static Text enc1Name;
	public static Text enc2Name;
	public static Text enc3Name;
	public static Text enc4Name;
	public static Text enc5Name;
	
	//reverse button for each encoder
	public static Button enc1Rev;
	public static Button enc2Rev;
	public static Button enc3Rev;
	public static Button enc4Rev;
	public static Button enc5Rev;
	
	//bools to ensure 2 ports are selected for @ least 1 encoder
	boolean complete1= false;
	boolean complete2=false;
	public static boolean complete = false;

	//set page info
	public PageEncoder(){
		super("Encoder Page");
		setTitle("Encoder Configuration");
		setDescription("Configure up to 5 encoders. Leave fields blank for unused encoders.");
	}
	
	//update page count when <back> is clicked
	@Override
	public IWizardPage getPreviousPage() {
		SetupWizard.pages = SetupWizard.pages - 2;
		return super.getNextPage();
	}
	
	//create ui
	@Override
	public void createControl(Composite parent){
		//layout data
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 4;
		
		//3 layout options
		GridData gd = new GridData(SWT.LEFT, SWT.FILL, false, false);
	    gd.widthHint = SWT.DEFAULT;
	    gd.heightHint = SWT.DEFAULT;
	    gd.horizontalSpan = 1;
	    
	    GridData gdSeparator = new GridData(SWT.FILL, SWT.FILL, true, false);
	    gdSeparator.horizontalSpan = 4;
	    
	    GridData gdTextBox = new GridData(SWT.FILL, SWT.FILL, true, false);
	    gdTextBox.horizontalSpan = 1;	    

	    //1st encoder
		Label labelFirstEnc = new Label(container, SWT.NONE);
		//instructions
		labelFirstEnc.setText("Enter the name and ports of the first quad encoder; check the box to reverse encoder counts.");
		labelFirstEnc.setLayoutData(gdSeparator);
		//text field for encoder name
		enc1Name = new Text(container, SWT.BORDER | SWT.SINGLE);
		//default name
		enc1Name.setText("encoder1");
		enc1Name.setLayoutData(gdTextBox);
		//drop down combo for 1st port
	    combo11 = new Combo (container, SWT.READ_ONLY);
	    //port options -- no port 10
		combo11.setItems (new String [] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "11", "12"});
		//update <next> button when 2 ports selected
		combo11.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				complete1 = true;
				if(complete1 && complete2){
					setPageComplete(true);
					complete = true;
				}
			}
		});
		//drop down combo box for 2nd port
		combo12 = new Combo (container, SWT.READ_ONLY);
		//no port 10
		combo12.setItems (new String [] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "11", "12"});
		//update next button when 2 ports selected
		combo12.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				complete2 = true;
				if(complete1 && complete2){
					setPageComplete(true);
					complete = true;
				}
			}
		});
		//add reversed check box
		enc1Rev = new Button(container, SWT.CHECK);
		enc1Rev.setLayoutData(gd);
		
		//horizontal line between encoders
		Label separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
	    separator.setLayoutData(gdSeparator);
		
	    //2nd encoder
		Label label2ndEnc = new Label(container, SWT.NONE);
		label2ndEnc.setText("Enter the name and ports of the second quad encoder");
		label2ndEnc.setLayoutData(gdSeparator);
		enc2Name = new Text(container, SWT.BORDER | SWT.SINGLE);
		enc2Name.setText("encoder2");
		enc2Name.setLayoutData(gdTextBox);
	    combo21 = new Combo (container, SWT.READ_ONLY);
		combo21.setItems (new String [] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "11", "12"});
		combo22 = new Combo (container, SWT.READ_ONLY);
		combo22.setItems (new String [] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "11", "12"});
		enc2Rev = new Button(container, SWT.CHECK);
		enc2Rev.setLayoutData(gd);

		separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
	    separator.setLayoutData(gdSeparator);
		
	    //3rd encoder
		Label label3rdEnc = new Label(container, SWT.NONE);
		label3rdEnc.setText("Enter the name and ports of the third quad encoder");
		label3rdEnc.setLayoutData(gdSeparator);
		enc3Name = new Text(container, SWT.BORDER | SWT.SINGLE);
		enc3Name.setText("encoder3");
		enc3Name.setLayoutData(gdTextBox);
	    combo31 = new Combo (container, SWT.READ_ONLY);
		combo31.setItems (new String [] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "11", "12"});
		combo32 = new Combo (container, SWT.READ_ONLY);
		combo32.setItems (new String [] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "11", "12"});
		enc3Rev = new Button(container, SWT.CHECK);
		enc3Rev.setLayoutData(gd);
		
		separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
	    separator.setLayoutData(gdSeparator);
		
	    //4th encoder
		Label label4thEnc = new Label(container, SWT.NONE);
		label4thEnc.setText("Enter the name and ports of the fourth quad encoder");
		label4thEnc.setLayoutData(gdSeparator);
		enc4Name = new Text(container, SWT.BORDER | SWT.SINGLE);
		enc4Name.setText("encoder4");
		enc4Name.setLayoutData(gdTextBox);
	    combo41 = new Combo (container, SWT.READ_ONLY);
		combo41.setItems (new String [] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "11", "12"});
		combo42 = new Combo (container, SWT.READ_ONLY);
		combo42.setItems (new String [] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "11", "12"});
		enc4Rev = new Button(container, SWT.CHECK);
		enc4Rev.setLayoutData(gd);
		
		separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
	    separator.setLayoutData(gdSeparator);
		
	    //5th encoder
		Label label5thEnc = new Label(container, SWT.NONE);
		label5thEnc.setText("Enter the name and ports of the fifth quad encoder");
		label5thEnc.setLayoutData(gdSeparator);
		enc5Name = new Text(container, SWT.BORDER | SWT.SINGLE);
		enc5Name.setText("encoder5");
		enc5Name.setLayoutData(gdTextBox);
	    combo51 = new Combo (container, SWT.READ_ONLY);
		combo51.setItems (new String [] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "11", "12"});
		combo52 = new Combo (container, SWT.READ_ONLY);
		combo52.setItems (new String [] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "11", "12"});
		enc5Rev = new Button(container, SWT.CHECK);
		enc5Rev.setLayoutData(gd);
		
		setControl(container);
		setPageComplete(false);
	}
	
}
