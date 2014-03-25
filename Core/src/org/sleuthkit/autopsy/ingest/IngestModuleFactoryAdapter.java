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
package org.sleuthkit.autopsy.ingest;

/**
 * An adapter that provides no-op implementations of various IngestModuleFactory
 * methods.
 */
public abstract class IngestModuleFactoryAdapter implements IngestModuleFactory {

    @Override
    public abstract String getModuleDisplayName();

    @Override
    public abstract String getModuleDescription();

    @Override
    public abstract String getModuleVersionNumber();

    @Override
    public boolean hasGlobalSettingsPanel() {
        return false;
    }

    @Override
    public IngestModuleGlobalSetttingsPanel getGlobalSettingsPanel() {
        throw new UnsupportedOperationException();
    }

    @Override
    public IngestModuleSettings getDefaultModuleSettings() {
        return new NoIngestModuleSettings();
    }

    @Override
    public boolean hasModuleSettingsPanel() {
        return false;
    }

    @Override
    public IngestModuleSettingsPanel getModuleSettingsPanel(IngestModuleSettings ingestOptions) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isDataSourceIngestModuleFactory() {
        return false;
    }

    @Override
    public DataSourceIngestModule createDataSourceIngestModule(IngestModuleSettings ingestOptions) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isFileIngestModuleFactory() {
        return false;
    }

    @Override
    public FileIngestModule createFileIngestModule(IngestModuleSettings ingestOptions) {
        throw new UnsupportedOperationException();
    }
}