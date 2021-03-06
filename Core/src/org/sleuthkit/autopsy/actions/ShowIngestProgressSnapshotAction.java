/*
 * Autopsy Forensic Browser
 * 
 * Copyright 2014 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.actions;

import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.NbBundle.Messages;
import org.openide.util.actions.CallableSystemAction;
import org.sleuthkit.autopsy.casemodule.Case;
import org.sleuthkit.autopsy.ingest.IngestProgressSnapshotDialog;

@ActionID(
        category = "Help",
        id = "org.sleuthkit.autopsy.actions.ShowIngestProgressSnapshotAction"
)
@ActionRegistration(
        displayName = "#CTL_ShowIngestProgressSnapshotAction",
        lazy = false
)
@ActionReference(path = "Menu/Help", position = 1125)
@Messages("CTL_ShowIngestProgressSnapshotAction=Ingest Status Details")
public final class ShowIngestProgressSnapshotAction extends CallableSystemAction implements ActionListener {

    private static final String ACTION_NAME = NbBundle.getMessage(ShowIngestProgressSnapshotAction.class, "ShowIngestProgressSnapshotAction.actionName.text");

    @Override
    public void performAction() {
        IngestProgressSnapshotDialog dialog = new IngestProgressSnapshotDialog();
    }

    @Override
    public String getName() {
        return ACTION_NAME;
    }

    @Override
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    @Override
    public boolean isEnabled() {
        return Case.isCaseOpen();
    }

    @Override
    public boolean asynchronous() {
        return false; // run on edt
    }
}
