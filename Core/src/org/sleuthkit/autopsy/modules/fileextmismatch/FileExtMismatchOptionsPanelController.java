/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sleuthkit.autopsy.modules.fileextmismatch;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.JComponent;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.sleuthkit.autopsy.coreutils.Logger;

@OptionsPanelController.TopLevelRegistration(
        categoryName = "#OptionsCategory_Name_FileExtMismatchOptions",
        iconBase = "org/sleuthkit/autopsy/modules/fileextmismatch/options-icon.png",
        position = 5,
        keywords = "#OptionsCategory_FileExtMismatch",
        keywordsCategory = "KeywordSearchOptions")
public final class FileExtMismatchOptionsPanelController extends OptionsPanelController {

    private FileExtMismatchSettingsPanel panel;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private boolean changed;
    private static final Logger logger = Logger.getLogger(FileExtMismatchOptionsPanelController.class.getName());

    /**
     * Component should load its data here.
     */
    @Override
    public void update() {
        getPanel().load();
        changed = false;
    }

    /**
     * This method is called when both the Ok and Apply buttons are pressed. It
     * applies to any of the panels that have been opened in the process of
     * using the options pane.
     */
    @Override
    public void applyChanges() {
        if (changed) {
            getPanel().ok();
            changed = false;
        }
    }

    /**
     * This method is called when the Cancel button is pressed. It applies to
     * any of the panels that have been opened in the process of using the
     * options pane.
     */
    @Override
    public void cancel() {
        getPanel().cancel();
    }

    @Override
    public boolean isValid() {
        return getPanel().valid();
    }

    /**
     * Used to determine whether any changes have been made to this controller's
     * panel.
     *
     * @return Whether or not a change has been made.
     */
    @Override
    public boolean isChanged() {
        return changed;
    }

    @Override
    public HelpCtx getHelpCtx() {
        return null; // new HelpCtx("...ID") if you have a help set
    }

    @Override
    public JComponent getComponent(Lookup masterLookup) {
        return getPanel();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener l) {
        pcs.removePropertyChangeListener(l);
    }

    private FileExtMismatchSettingsPanel getPanel() {
        if (panel == null) {
            panel = new FileExtMismatchSettingsPanel();
            panel.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if (evt.getPropertyName().equals(OptionsPanelController.PROP_CHANGED)) {
                        changed();
                    }
                }
            });
        }
        return panel;
    }

    void changed() {
        if (!changed) {
            changed = true;

            pcs.firePropertyChange(OptionsPanelController.PROP_CHANGED, false, true);
        }

        pcs.firePropertyChange(OptionsPanelController.PROP_VALID, null, null);
    }
}
