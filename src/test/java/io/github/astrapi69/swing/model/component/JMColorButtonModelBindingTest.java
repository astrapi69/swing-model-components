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

import java.awt.Color;

import org.junit.jupiter.api.Test;

import io.github.astrapi69.model.BaseModel;

/**
 * Headless unit tests for the model binding of {@link JMColorButton}. These tests verify the
 * propagation between the selected color and the property model without any UI robot interaction,
 * so they also run in headless environments like CI
 */
public class JMColorButtonModelBindingTest
{

	/**
	 * Test that setting the selected color updates the property model and the background
	 */
	@Test
	public void testSetSelectedColorUpdatesPropertyModel()
	{
		JMColorButton colorButton;

		colorButton = new JMColorButton("choose color");

		colorButton.setSelectedColor(Color.RED);

		assertEquals(Color.RED, colorButton.getPropertyModel().getObject());
		assertEquals(Color.RED, colorButton.getBackground());
	}

	/**
	 * Test that the constructor with an initial color sets the model object and the background
	 */
	@Test
	public void testConstructorWithColor()
	{
		JMColorButton colorButton;

		colorButton = new JMColorButton("choose color", Color.BLUE);

		assertEquals(Color.BLUE, colorButton.getPropertyModel().getObject());
		assertEquals(Color.BLUE, colorButton.getBackground());
	}

	/**
	 * Test that setting a new property model updates the background
	 */
	@Test
	public void testSetPropertyModelUpdatesBackground()
	{
		JMColorButton colorButton;

		colorButton = new JMColorButton("choose color");

		colorButton.setPropertyModel(BaseModel.of(Color.GREEN));

		assertEquals(Color.GREEN, colorButton.getBackground());
		assertEquals(Color.GREEN, colorButton.getPropertyModel().getObject());
	}

}
