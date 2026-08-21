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

import io.github.astrapi69.model.BaseModel;

/**
 * Headless unit tests for the model binding of {@link JMProgressBar}. These tests verify the
 * propagation between the progress bar value and the property model without any UI robot
 * interaction, so they also run in headless environments like CI
 */
public class JMProgressBarModelBindingTest
{

	/**
	 * Test that a value change propagates to the property model
	 */
	@Test
	public void testSetValueUpdatesPropertyModel()
	{
		JMProgressBar progressBar;

		progressBar = new JMProgressBar(0, 100);

		progressBar.setValue(66);

		assertEquals(Integer.valueOf(66), progressBar.getPropertyModel().getObject());
	}

	/**
	 * Test that setting a new property model updates the progress bar value
	 */
	@Test
	public void testSetPropertyModelUpdatesValue()
	{
		JMProgressBar progressBar;

		progressBar = new JMProgressBar(0, 100);

		progressBar.setPropertyModel(BaseModel.of(25));

		assertEquals(25, progressBar.getValue());
		assertEquals(Integer.valueOf(25), progressBar.getPropertyModel().getObject());
	}

}
