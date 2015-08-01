package tk.knaup.prossensorssetupwizard.popup.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import prossensorssetupwizard.SetupWizard;

public class NewAction implements IObjectActionDelegate {

	private Shell shell;
	protected SetupWizard setup;
	
	/**
	 * Constructor for Action1.
	 */
	public NewAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		// Instantiates and initializes the wizard
	    SetupWizard wizard = new SetupWizard();
	    //wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
	    // Instantiates the wizard container with the wizard and opens it
	    WizardDialog dialog = new WizardDialog(shell, wizard);
	    dialog.create();
	    dialog.open();
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

}
