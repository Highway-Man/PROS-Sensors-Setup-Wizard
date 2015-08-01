package prossensorssetupwizard;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;

import prossensorssetupwizard.performconfiguration.PerformEdits;



public class SetupWizard extends Wizard{
	
	public static Composite container;
	
	protected PageOne one;
	protected PageTwo two;
	protected PageGyro gyro;
	protected PageUltrasonic ultrasonic;
	protected PageIme ime;
	protected PageLcd lcd;
	protected PageDigitalIn input;
	protected PageDigitalOut output;
	protected PageEnd end;
	
	boolean canFinish = false;
	public static boolean selectedPort[];
	
	public SetupWizard(){
		super();
		setNeedsProgressMonitor(true);
	}
	
	@Override
	public String getWindowTitle(){
		return "Export My Data";
	}
	
	@Override
	public void addPages(){
		one = new PageOne();
		two = new PageTwo();
		gyro = new PageGyro();
		ultrasonic = new PageUltrasonic();
		ime = new PageIme();
		lcd = new PageLcd();
		input = new PageDigitalIn();
		output = new PageDigitalOut();
		end = new PageEnd();
		addPage(two);
		addPage(one);
		addPage(gyro);
		addPage(ultrasonic);
		addPage(ime);
		addPage(lcd);
		addPage(input);
		addPage(output);
		addPage(end);
	}
	
	void updateSelectedPorts(Class page){
		try {
            Object ob = page.newSelectedPorts();
        } catch (InstantiationException ex) {
           
        } catch (IllegalAccessException ex) {
            
        }
	}
	
	boolean portsConflict(){
		if()
	}
	
	@Override
	public IWizardPage getNextPage(IWizardPage currentPage) {
	    if (PageTwo.getCheckSelection(PageTwo.check1) && !PageOne.complete) 
	       return one;
	    else if (PageTwo.getCheckSelection(PageTwo.check2) && !PageGyro.complete)
	    	return gyro;
	    else if (PageTwo.getCheckSelection(PageTwo.checkUlt) && !PageUltrasonic.complete)
	    	return ultrasonic;
	    else if(PageTwo.getCheckSelection(PageTwo.checkIme) && !PageIme.complete)
	    	return ime;
	    else if (PageTwo.getCheckSelection(PageTwo.checkLcd) && !PageLcd.complete)
	    	return lcd;
	    else if (PageTwo.getCheckSelection(PageTwo.checkInput) && PageDigitalIn.complete != true)
	    	return input;
	    else if (PageTwo.getCheckSelection(PageTwo.checkOutput) && !PageDigitalOut.complete)
	    	return output;
	    else{ 
	    	canFinish = true;
	        return end;
	    }
	} 
	
	@Override
	public boolean canFinish(){
		return canFinish;
	}
		
	@Override
	public boolean performFinish(){
						
		PerformEdits.performConfiguration();
		
		return true;
	}
	
	

}
