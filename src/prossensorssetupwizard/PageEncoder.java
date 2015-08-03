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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;


public class PageEncoder extends WizardPage {
	private Text text1;
	private Composite container;
	public Spinner numberQuads;
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
	
	public static Text enc1Name;
	public static Text enc2Name;
	public static Text enc3Name;
	public static Text enc4Name;
	public static Text enc5Name;
	
	public static Button enc1Rev;
	public static Button enc2Rev;
	public static Button enc3Rev;
	public static Button enc4Rev;
	public static Button enc5Rev;
	
	boolean complete1;
	boolean complete2;
	public static boolean complete;

	public PageEncoder(){
		super("Encoder Page");
		setTitle("Encoder Configuration");
		setDescription("Configure up to 5 encoders. Leave fields blank for unused encoders.");
	}
	
	@Override
	public void createControl(Composite parent){
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 4;
		
		GridData gd = new GridData(SWT.LEFT, SWT.FILL, false, false);
	    gd.widthHint = SWT.DEFAULT;
	    gd.heightHint = SWT.DEFAULT;
	    gd.horizontalSpan = 1;
	    
	    GridData gdSeparator = new GridData(SWT.FILL, SWT.FILL, true, false);
	    gdSeparator.horizontalSpan = 4;
	    
	    GridData gdTextBox = new GridData(SWT.FILL, SWT.FILL, true, false);
	    gdTextBox.horizontalSpan = 1;	    

		Label labelFirstEnc = new Label(container, SWT.NONE);
		labelFirstEnc.setText("Enter the name and ports of the first quad encoder; check the box to reverse encoder counts.");
		labelFirstEnc.setLayoutData(gdSeparator);
		enc1Name = new Text(container, SWT.BORDER | SWT.SINGLE);
		enc1Name.setText("encoder1");
		enc1Name.setLayoutData(gdTextBox);
	    combo11 = new Combo (container, SWT.READ_ONLY);
		combo11.setItems (new String [] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "11", "12"});
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
		
		combo12 = new Combo (container, SWT.READ_ONLY);
		combo12.setItems (new String [] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "11", "12"});
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
		enc1Rev = new Button(container, SWT.CHECK);
		enc1Rev.setLayoutData(gd);
		
		Label separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
	    separator.setLayoutData(gdSeparator);
		
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
	
	public String getText1(){
		return text1.getText();
	}
}
