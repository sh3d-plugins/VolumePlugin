package com.eteks.test;

import javax.swing.JOptionPane;

import com.eteks.sweethome3d.model.PieceOfFurniture;
import com.eteks.sweethome3d.plugin.Plugin;
import com.eteks.sweethome3d.plugin.PluginAction;

public class VolumePlugin extends Plugin {

	@Override
	public PluginAction[] getActions() {
		// TODO Auto-generated method stub
		return new PluginAction [] {new VolumeAction()}; 
	}
	
	public class VolumeAction extends PluginAction {

        public VolumeAction() {
            putPropertyValue(Property.NAME, "Compute volume");
            putPropertyValue(Property.MENU, "Tools");
            // Enables the action by default
            setEnabled(true);
        }
		
		@Override
		public void execute() {
			// TODO Auto-generated method stub
            float volumeInCm3 = 0;
            // Compute the sum of the volume of the bounding box of 
            // each movable piece of furniture in home
            for (PieceOfFurniture piece : getHome().getFurniture()) {
                if (piece.isMovable()) {
                    volumeInCm3 += piece.getWidth() 
                                   * piece.getDepth() 
                                   * piece.getHeight();
                }
            }
            
            // Display the result in a message box (\u00b3 is for 3 in supercript)
            String message = String.format(
                "The maximum volume of the movable furniture in home is %.2f m\u00b3.", 
                volumeInCm3 / 1000000);
            JOptionPane.showMessageDialog(null, message);
		}

	}

}
