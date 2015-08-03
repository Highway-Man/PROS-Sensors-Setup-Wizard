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

public class PageUltrasonic extends WizardPage{
	
	private Composite container;
	public static Combo ult1PortEcho;
	public static Combo ult1PortPing;
	public static Combo ult2PortEcho;
	public static Combo ult2PortPing;
	public static Combo ult3PortEcho;
	public static Combo ult3PortPing;
	public static Combo ult4PortEcho;
	public static Combo ult4PortPing;
	public static Combo ult5PortEcho;
	public static Combo ult5PortPing;
	
	public static Text ult1Name;
	public static Text ult2Name;
	public static Text ult3Name;
	public static Text ult4Name;
	public static Text ult5Name;
	
	boolean complete1;
	boolean complete2;
	public static boolean complete;
	
	public PageUltrasonic(){
		super("Ultrasonic Page");
		setTitle("Ultrasonic Configuration");
		setDescription("Configure up to 3 ultrasonic sensors. Leave fields blank for unused ultrasonic sensors.");
	}
	
	@Override
	public void createControl(Composite parent){
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		
		GridData gd = new GridData(SWT.LEFT, SWT.FILL, false, false);
	    gd.widthHint = SWT.DEFAULT;
	    gd.heightHint = SWT.DEFAULT;
	    gd.horizontalSpan = 1;
	    
	    GridData gdSeparator = new GridData(SWT.FILL, SWT.TOP, true, false);
	    gdSeparator.horizontalSpan = 2;
	    
	    GridData gdTextBox = new GridData(SWT.FILL, SWT.TOP, true, false);
	    gdTextBox.horizontalSpan = 1;
	    
	    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Label label1 = new Label(container, SWT.NONE);
		label1.setText("Enter the desired ultrasonic name");
		ult1Name = new Text(container, SWT.BORDER | SWT.SINGLE);
		ult1Name.setText("sonar1");
		ult1Name.setLayoutData(gdTextBox);
				
		Label labelult1Echo = new Label(container, SWT.NONE);
		labelult1Echo.setText("Select the sonar's echo (orange cable) port");
	    ult1PortEcho = new Combo (container, SWT.READ_ONLY);
	    ult1PortEcho.setItems (new String [] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "11", "12"});
	    ult1PortEcho.addModifyListener(new ModifyListener() {
			
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
	    
	    Label labelult1Ping = new Label(container, SWT.NONE);
		labelult1Ping.setText("Select the sonar's ping (yellow cable) port");
	    ult1PortPing = new Combo (container, SWT.READ_ONLY);
	    ult1PortPing.setItems (new String [] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});
	    ult1PortPing.addModifyListener(new ModifyListener() {
			
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
	    
	    /*/////////////////////////*/Label separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
	    separator.setLayoutData(gdSeparator);//////////////////////////////
	    
	    Label labelUlt2Name = new Label(container, SWT.NONE);
	    labelUlt2Name.setText("Enter the desired name for the 2nd ultrasonic sensor");
		ult2Name = new Text(container, SWT.BORDER | SWT.SINGLE);
		ult2Name.setText("sonar2");
		ult2Name.setLayoutData(gdTextBox);
				
		Label labelult2Echo = new Label(container, SWT.NONE);
		labelult2Echo.setText("Select the sonar's echo (orange cable) port");
	    ult2PortEcho = new Combo (container, SWT.READ_ONLY);
	    ult2PortEcho.setItems (new String [] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "11", "12"});
	    
	    Label labelult2Ping = new Label(container, SWT.NONE);
	    labelult2Ping.setText("Select the sonar's ping (yellow cable) port");
	    ult2PortPing = new Combo (container, SWT.READ_ONLY);
	    ult2PortPing.setItems (new String [] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});
				
	    /*/////////////////////////*/separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
	    separator.setLayoutData(gdSeparator);//////////////////////////////

	    
	    Label labelUlt3Name = new Label(container, SWT.NONE);
	    labelUlt3Name.setText("Enter the desired name for the 3rd ultrasonic sensor");
		ult3Name = new Text(container, SWT.BORDER | SWT.SINGLE);
		ult3Name.setText("sonar3");
		ult3Name.setLayoutData(gdTextBox);
				
		Label labelult3Echo = new Label(container, SWT.NONE);
		labelult3Echo.setText("Select the sonar's echo (orange cable) port");
	    ult3PortEcho = new Combo (container, SWT.READ_ONLY);
	    ult3PortEcho.setItems (new String [] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "11", "12"});
	    
	    Label labelult3Ping = new Label(container, SWT.NONE);
	    labelult3Ping.setText("Select the sonar's ping (yellow cable) port");
	    ult3PortPing = new Combo (container, SWT.READ_ONLY);
	    ult3PortPing.setItems (new String [] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});
				
	    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    
		setControl(container);
		setPageComplete(false);
	}

}
