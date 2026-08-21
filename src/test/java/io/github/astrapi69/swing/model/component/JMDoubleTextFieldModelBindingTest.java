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

import org.junit.jupiter.api.Test;

/**
 * Headless unit tests for the model binding of {@link JMDoubleTextField}. These tests verify the
 * propagation between the document of the text field and the property model without any UI robot
 * interaction, so they also run in headless environments like CI
 */
public class JMDoubleTextFieldModelBindingTest
{

	/**
	 * Test that a text change propagates as {@link Double} to the property model
	 */
	@Test
	public void testSetTextUpdatesPropertyModel()
	{
		JMDoubleTextField textField;

		textField = new JMDoubleTextField();

		textField.setText("123.45");

		assertEquals("123.45", textField.getText());
		assertEquals(Double.valueOf(123.45d), textField.getPropertyModel().getObject());
	}

	/**
	 * Test that an invalid text is rejected by the document and the property model keeps the last
	 * valid value
	 */
	@Test
	public void testInvalidTextIsRejected()
	{
		JMDoubleTextField textField;

		textField = new JMDoubleTextField();

		textField.setText("12.5");
		textField.setText("abc");

		assertEquals("12.5", textField.getText());
		assertEquals(Double.valueOf(12.5d), textField.getPropertyModel().getObject());
	}

}
