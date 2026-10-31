/**
 * The MIT License
 *
 * Copyright (C) 2026 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.swing.model.component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;

import org.junit.jupiter.api.Test;

import io.github.astrapi69.model.BaseModel;

/**
 * Headless unit tests for the model binding of {@link JMFileField}. These tests verify the
 * propagation between the text field, the selected file and the property model without any UI robot
 * interaction, so they also run in headless environments like CI
 */
public class JMFileFieldModelBindingTest
{

	/**
	 * Test that setting a file updates the text field and the property model
	 */
	@Test
	public void testSetFileUpdatesPropertyModel()
	{
		JMFileField fileField;
		File file;

		fileField = new JMFileField();
		file = new File("/tmp/test.txt");

		fileField.setFile(file);

		assertEquals(file, fileField.getPropertyModel().getObject());
		assertEquals(file.getAbsolutePath(), fileField.getTextField().getText());
	}

	/**
	 * Test that a text change propagates as {@link File} to the property model
	 */
	@Test
	public void testSetTextUpdatesPropertyModel()
	{
		JMFileField fileField;

		fileField = new JMFileField();

		fileField.getTextField().setText("/tmp/other.txt");

		assertEquals(new File("/tmp/other.txt"), fileField.getPropertyModel().getObject());
	}

	/**
	 * Test that an empty text sets the property model object to null
	 */
	@Test
	public void testEmptyTextSetsNull()
	{
		JMFileField fileField;

		fileField = new JMFileField();

		fileField.getTextField().setText("/tmp/some.txt");
		fileField.getTextField().setText("");

		assertNull(fileField.getPropertyModel().getObject());
	}

	/**
	 * Test that the constructor with a property model shows the absolute path in the text field
	 */
	@Test
	public void testConstructorWithPropertyModel()
	{
		JMFileField fileField;
		File file;

		file = new File("/tmp/model.txt");
		fileField = new JMFileField(BaseModel.of(file));

		assertEquals(file.getAbsolutePath(), fileField.getTextField().getText());
		assertEquals(file, fileField.getPropertyModel().getObject());
	}

	/**
	 * Test that setting a new property model updates the text field
	 */
	@Test
	public void testSetPropertyModelUpdatesTextField()
	{
		JMFileField fileField;
		File file;

		fileField = new JMFileField();
		file = new File("/tmp/new-model.txt");

		fileField.setPropertyModel(BaseModel.of(file));

		assertEquals(file.getAbsolutePath(), fileField.getTextField().getText());
		assertEquals(file, fileField.getPropertyModel().getObject());
	}

}
