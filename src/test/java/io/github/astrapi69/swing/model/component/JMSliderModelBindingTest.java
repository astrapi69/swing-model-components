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
 * Headless unit tests for the model binding of {@link JMSlider}. These tests verify the propagation
 * between the slider value and the property model without any UI robot interaction, so they also
 * run in headless environments like CI
 */
public class JMSliderModelBindingTest
{

	/**
	 * Test that the initial slider value is propagated to the property model
	 */
	@Test
	public void testInitialValueInPropertyModel()
	{
		JMSlider slider;

		slider = new JMSlider(0, 100, 42);

		assertEquals(Integer.valueOf(42), slider.getPropertyModel().getObject());
	}

	/**
	 * Test that a value change propagates to the property model
	 */
	@Test
	public void testSetValueUpdatesPropertyModel()
	{
		JMSlider slider;

		slider = new JMSlider(0, 100, 0);

		slider.setValue(77);

		assertEquals(Integer.valueOf(77), slider.getPropertyModel().getObject());
	}

	/**
	 * Test that setting a new property model updates the slider value
	 */
	@Test
	public void testSetPropertyModelUpdatesValue()
	{
		JMSlider slider;

		slider = new JMSlider(0, 100, 0);

		slider.setPropertyModel(BaseModel.of(30));

		assertEquals(30, slider.getValue());
		assertEquals(Integer.valueOf(30), slider.getPropertyModel().getObject());
	}

}
