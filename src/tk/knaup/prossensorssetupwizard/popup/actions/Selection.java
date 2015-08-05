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

	//get the name of the project that the user right-clicked
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
	
	//open the necessary file from the selected project
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
