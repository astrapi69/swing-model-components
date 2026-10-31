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

import io.github.astrapi69.collection.array.ArrayFactory;
import io.github.astrapi69.collection.pair.ValueBox;
import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.LambdaModel;
import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.swing.model.combobox.GenericComboBoxModel;

/**
 * Headless unit tests for the model binding of {@link JMComboBox}. These tests verify the
 * propagation between the combo box selection and the property model without any UI robot
 * interaction, so they also run in headless environments like CI
 */
public class JMComboBoxModelBindingTest
{

	/**
	 * Test that the initial selection is taken from the given property model
	 */
	@Test
	public void testInitialSelectionFromPropertyModel()
	{
		GenericComboBoxModel<Integer> comboBoxModel;
		ValueBox<Integer> valueBox;
		IModel<Integer> selectedItemModel;
		JMComboBox<Integer, GenericComboBoxModel<Integer>> comboBox;

		comboBoxModel = new GenericComboBoxModel<>(ArrayFactory.newArray(1, 2, 3, 4));
		valueBox = ValueBox.<Integer> builder().value(1).build();
		selectedItemModel = LambdaModel.of(valueBox::getValue, valueBox::setValue);

		comboBox = new JMComboBox<>(comboBoxModel, selectedItemModel);

		assertEquals(Integer.valueOf(1), comboBox.getModel().getSelectedItem());
		assertEquals(Integer.valueOf(1), comboBox.getPropertyModel().getObject());
	}

	/**
	 * Test that a programmatic selection change propagates to the property model and to the bound
	 * bean
	 */
	@Test
	public void testProgrammaticSelectionUpdatesPropertyModel()
	{
		GenericComboBoxModel<Integer> comboBoxModel;
		ValueBox<Integer> valueBox;
		IModel<Integer> selectedItemModel;
		JMComboBox<Integer, GenericComboBoxModel<Integer>> comboBox;

		comboBoxModel = new GenericComboBoxModel<>(ArrayFactory.newArray(1, 2, 3, 4));
		valueBox = ValueBox.<Integer> builder().value(1).build();
		selectedItemModel = LambdaModel.of(valueBox::getValue, valueBox::setValue);
		comboBox = new JMComboBox<>(comboBoxModel, selectedItemModel);

		comboBox.setSelectedItem(2);

		assertEquals(Integer.valueOf(2), comboBox.getPropertyModel().getObject());
		assertEquals(Integer.valueOf(2), valueBox.getValue());
		assertEquals(Integer.valueOf(2), comboBox.getModel().getSelectedItem());

		comboBox.setSelectedIndex(3);

		assertEquals(Integer.valueOf(4), comboBox.getPropertyModel().getObject());
		assertEquals(Integer.valueOf(4), valueBox.getValue());
		assertEquals(Integer.valueOf(4), comboBox.getModel().getSelectedItem());
	}

	/**
	 * Test that the constructor with a selected model object selects the given object
	 */
	@Test
	public void testConstructorWithSelectedModelObject()
	{
		GenericComboBoxModel<Integer> comboBoxModel;
		JMComboBox<Integer, GenericComboBoxModel<Integer>> comboBox;

		comboBoxModel = new GenericComboBoxModel<>(ArrayFactory.newArray(1, 2, 3, 4));

		comboBox = new JMComboBox<>(Integer.valueOf(2), comboBoxModel);

		assertEquals(Integer.valueOf(2), comboBox.getModel().getSelectedItem());
		assertEquals(Integer.valueOf(2), comboBox.getPropertyModel().getObject());
	}

	/**
	 * Test that setting a new property model updates the selection and further selection changes
	 * propagate to the new property model
	 */
	@Test
	public void testSetPropertyModelUpdatesSelection()
	{
		GenericComboBoxModel<Integer> comboBoxModel;
		JMComboBox<Integer, GenericComboBoxModel<Integer>> comboBox;

		comboBoxModel = new GenericComboBoxModel<>(ArrayFactory.newArray(1, 2, 3, 4));
		comboBox = new JMComboBox<>(comboBoxModel);

		comboBox.setPropertyModel(BaseModel.of(3));

		assertEquals(Integer.valueOf(3), comboBox.getModel().getSelectedItem());

		comboBox.setSelectedItem(4);

		assertEquals(Integer.valueOf(4), comboBox.getPropertyModel().getObject());
	}

}
