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

import java.util.List;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListModel;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link JMList} provides a list component with an associated model. The property model
 * holds the selected value and the selected items model holds all selected values.
 *
 * @param <T>
 *            the type of the elements in the list
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JMList<T> extends JList<T>
{

	/** The model with the selected value. */
	IModel<T> propertyModel = BaseModel.of();

	/** The model with all selected values. */
	IModel<List<T>> selectedItemsModel = BaseModel.of();

	/**
	 * Initializes the list and adds a list selection listener to update the models when the
	 * selection changes.
	 */
	{
		addListSelectionListener(event -> {
			if (!event.getValueIsAdjusting())
			{
				propertyModel.setObject(getSelectedValue());
				selectedItemsModel.setObject(getSelectedValuesList());
			}
		});
	}

	/**
	 * Constructs a new <code>JMList</code> with an empty, read-only model.
	 */
	public JMList()
	{
		super();
	}

	/**
	 * Constructs a new <code>JMList</code> that displays elements from the specified model.
	 *
	 * @param listModel
	 *            the list model to be used
	 */
	public JMList(ListModel<T> listModel)
	{
		super(listModel);
	}

	/**
	 * Constructs a new <code>JMList</code> that displays the elements in the specified array.
	 *
	 * @param listData
	 *            the array of elements to be displayed
	 */
	public JMList(T[] listData)
	{
		super(listData);
	}

	/**
	 * Constructs a new <code>JMList</code> that displays the elements in the specified vector.
	 *
	 * @param listData
	 *            the vector of elements to be displayed
	 */
	public JMList(Vector<? extends T> listData)
	{
		super(listData);
	}

	/**
	 * Constructs a new <code>JMList</code> that displays elements from the specified model and
	 * selects the object of the specified property model.
	 *
	 * @param listModel
	 *            the list model to be used
	 * @param propertyModel
	 *            the property model to be used
	 */
	public JMList(ListModel<T> listModel, IModel<T> propertyModel)
	{
		super(listModel);
		this.propertyModel = propertyModel;
		setSelectedValue(this.propertyModel.getObject(), true);
	}

	/**
	 * Sets the property model and updates the list's selection.
	 *
	 * @param propertyModel
	 *            the new property model
	 * @return the current instance of {@link JMList}
	 */
	public JMList<T> setPropertyModel(final @NonNull IModel<T> propertyModel)
	{
		this.propertyModel = propertyModel;
		setSelectedValue(this.propertyModel.getObject(), true);
		return this;
	}

	/**
	 * Sets the selected items model.
	 *
	 * @param selectedItemsModel
	 *            the new selected items model
	 * @return the current instance of {@link JMList}
	 */
	public JMList<T> setSelectedItemsModel(final @NonNull IModel<List<T>> selectedItemsModel)
	{
		this.selectedItemsModel = selectedItemsModel;
		this.selectedItemsModel.setObject(getSelectedValuesList());
		return this;
	}
}
