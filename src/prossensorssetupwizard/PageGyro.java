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


public class PageGyro extends WizardPage{
	
	private Composite container;
	public static Combo gyroPort;
	public static boolean complete;
	
	public PageGyro(){
		super("Gyro Page");
		setTitle("Gyroscope Configuration");
		setDescription("Configure a gyroscope on the selected analog port");
	}
	
	public static Text gyroName;
	
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
