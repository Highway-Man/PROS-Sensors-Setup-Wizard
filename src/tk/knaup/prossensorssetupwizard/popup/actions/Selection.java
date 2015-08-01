package tk.knaup.prossensorssetupwizard.popup.actions;


import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

public class Selection {

	public static String getSelectedProject(){
		
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IStructuredSelection selection = (IStructuredSelection)page.getSelection();
		IResource resource = (IResource)selection.getFirstElement();
		IProject activeProject = resource.getProject();
		String activeProjectName = activeProject .getName();
		//Object selObject = selection.getFirstElement();
		//IResource resource = (IResource)Platform.getAdapterManager().getAdapter(selObject, IResource.class);
		System.out.println(activeProjectName);
		
		return activeProjectName;
	}
	
	public static IFile getFileInProject(String fileName){
		
		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace()
				.getRoot();
		IProject myWebProject = myWorkspaceRoot.getProject(getSelectedProject());
		// open if necessary
		if (myWebProject.exists() && !myWebProject.isOpen()){
			try {
				myWebProject.open(null);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String folder = "";
		if (fileName.matches(".*" + ".c"))
			folder = "src";
		else if (fileName.matches(".*" + ".h"))
			folder = "include";
		IFolder codeFolder = myWebProject.getFolder(folder);
		
		return codeFolder.getFile(fileName);
	}
	
}
