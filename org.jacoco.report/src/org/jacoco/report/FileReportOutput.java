/*******************************************************************************
 * Copyright (c) 2009 Mountainminds GmbH & Co. KG and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Marc R. Hoffmann - initial API and implementation
 *    
 * $Id: $
 *******************************************************************************/
package org.jacoco.report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Implementation of {@link IReportOutput} that writes files directly to a given
 * directory.
 * 
 * @author Marc R. Hoffmann
 * @version $Revision: $
 */
public class FileReportOutput implements IReportOutput {

	private final File basedir;

	/**
	 * Creates a new instance for document output in the given base directory.
	 * 
	 * @param basedir
	 */
	public FileReportOutput(File basedir) {
		this.basedir = basedir;
	}

	public OutputStream createFile(String path) throws IOException {
		final File file = new File(basedir, path);
		final File parent = file.getParentFile();
		parent.mkdirs();
		if (!parent.isDirectory()) {
			throw new IOException("Can't create directory " + parent);
		}
		return new FileOutputStream(file);
	}

}