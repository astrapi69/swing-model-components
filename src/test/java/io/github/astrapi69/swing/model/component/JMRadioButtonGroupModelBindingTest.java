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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import io.github.astrapi69.model.BaseModel;

/**
 * Headless unit tests for the model binding of {@link JMRadioButtonGroup}. These tests verify the
 * propagation between the radio button selection and the typed property model without any UI robot
 * interaction, so they also run in headless environments like CI
 */
public class JMRadioButtonGroupModelBindingTest
{

	/**
	 * Test that the radio button that is associated with the initial model object is selected when
	 * it is added to the group
	 */
	@Test
	public void testInitialSelectionFromPropertyModel()
	{
		JMRadioButtonGroup<String> radioButtonGroup;
		JMRadioButton first;
		JMRadioButton second;
		JMRadioButton third;

		first = new JMRadioButton("first");
		second = new JMRadioButton("second");
		third = new JMRadioButton("third");

		radioButtonGroup = new JMRadioButtonGroup<String>(BaseModel.of("second"))
			.add("first", first).add("second", second).add("third", third);

		assertTrue(second.isSelected());
		assertFalse(first.isSelected());
		assertFalse(third.isSelected());
		assertEquals("second", radioButtonGroup.getPropertyModel().getObject());
	}

	/**
	 * Test that a selection change propagates the associated value to the property model and the
	 * button group enforces the single selection
	 */
	@Test
	public void testSelectionUpdatesPropertyModel()
	{
		JMRadioButtonGroup<String> radioButtonGroup;
		JMRadioButton first;
		JMRadioButton second;
		JMRadioButton third;

		first = new JMRadioButton("first");
		second = new JMRadioButton("second");
		third = new JMRadioButton("third");

		radioButtonGroup = new JMRadioButtonGroup<String>(BaseModel.of("first")).add("first", first)
			.add("second", second).add("third", third);

		third.setSelected(true);

		assertEquals("third", radioButtonGroup.getPropertyModel().getObject());
		assertTrue(third.isSelected());
		assertFalse(first.isSelected());
		assertFalse(second.isSelected());
	}

	/**
	 * Test that setting a new property model selects the radio button that is associated with the
	 * model object
	 */
	@Test
	public void testSetPropertyModelUpdatesSelection()
	{
		JMRadioButtonGroup<String> radioButtonGroup;
		JMRadioButton first;
		JMRadioButton second;

		first = new JMRadioButton("first");
		second = new JMRadioButton("second");

		radioButtonGroup = new JMRadioButtonGroup<String>().add("first", first).add("second",
			second);

		radioButtonGroup.setPropertyModel(BaseModel.of("second"));

		assertTrue(second.isSelected());
		assertFalse(first.isSelected());
		assertEquals("second", radioButtonGroup.getPropertyModel().getObject());
		assertEquals(second, radioButtonGroup.getRadioButton("second"));
	}

}
