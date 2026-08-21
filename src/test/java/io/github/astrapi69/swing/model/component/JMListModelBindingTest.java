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

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;

import org.junit.jupiter.api.Test;

import io.github.astrapi69.model.BaseModel;

/**
 * Headless unit tests for the model binding of {@link JMList}. These tests verify the propagation
 * between the list selection and the property models without any UI robot interaction, so they also
 * run in headless environments like CI
 */
public class JMListModelBindingTest
{

	private DefaultListModel<String> newListModel()
	{
		DefaultListModel<String> listModel = new DefaultListModel<>();
		listModel.addElement("alpha");
		listModel.addElement("beta");
		listModel.addElement("gamma");
		return listModel;
	}

	/**
	 * Test that a selection change propagates the selected value to the property model
	 */
	@Test
	public void testSelectionUpdatesPropertyModel()
	{
		JMList<String> list;

		list = new JMList<>(newListModel());

		list.setSelectedValue("beta", false);

		assertEquals("beta", list.getPropertyModel().getObject());
	}

	/**
	 * Test that a multi selection propagates all selected values to the selected items model
	 */
	@Test
	public void testMultiSelectionUpdatesSelectedItemsModel()
	{
		JMList<String> list;

		list = new JMList<>(newListModel());
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		list.setSelectionInterval(0, 1);

		assertEquals(List.of("alpha", "beta"), list.getSelectedItemsModel().getObject());
	}

	/**
	 * Test that the constructor with a property model selects the model object
	 */
	@Test
	public void testConstructorWithPropertyModelSelectsObject()
	{
		JMList<String> list;

		list = new JMList<>(newListModel(), BaseModel.of("gamma"));

		assertEquals("gamma", list.getSelectedValue());
		assertEquals("gamma", list.getPropertyModel().getObject());
	}

	/**
	 * Test that setting a new property model updates the selection
	 */
	@Test
	public void testSetPropertyModelUpdatesSelection()
	{
		JMList<String> list;

		list = new JMList<>(newListModel());

		list.setPropertyModel(BaseModel.of("alpha"));

		assertEquals("alpha", list.getSelectedValue());
		assertEquals("alpha", list.getPropertyModel().getObject());
	}

}
