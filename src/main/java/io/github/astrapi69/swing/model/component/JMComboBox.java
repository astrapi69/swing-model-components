/**
 * The MIT License
 *
 * Copyright (C) 2022 Asterios Raptis
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

import java.awt.event.ItemEvent;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.plaf.ComboBoxUI;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link JMComboBox} provides a combo box component with an associated model.
 *
 * @param <T> the type of the items in the combo box
 * @param <CMB> the type of the combo box model
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JMComboBox<T, CMB extends ComboBoxModel<T>> extends JComboBox<T>
{
	/** The model. */
	IModel<T> propertyModel = BaseModel.of();

	/**
	 * Initializes the combo box and adds an item listener to update the model when an item is selected.
	 */
	{
		addItemListener(event -> {
			if (event.getStateChange() == ItemEvent.SELECTED) {
				T item = (T) event.getItem();
				propertyModel.setObject(item);
			}
		});
	}

	/**
	 * Constructs a new <code>JMComboBox</code> with the specified combo box model.
	 *
	 * @param comboBoxModel the combo box model to be used
	 */
	public JMComboBox(CMB comboBoxModel)
	{
		super(comboBoxModel);
	}

	/**
	 * Constructs a new <code>JMComboBox</code> with the specified combo box model and property model.
	 *
	 * @param comboBoxModel the combo box model to be used
	 * @param propertyModel the property model to be used
	 */
	public JMComboBox(CMB comboBoxModel, IModel<T> propertyModel)
	{
		super(comboBoxModel);
		this.propertyModel = propertyModel;
		getModel().setSelectedItem(this.propertyModel.getObject());
	}

	/**
	 * Constructs a new <code>JMComboBox</code> with the specified selected model object and combo box model.
	 *
	 * @param selectedModelObject the selected model object
	 * @param comboBoxModel the combo box model to be used
	 */
	public JMComboBox(T selectedModelObject, CMB comboBoxModel)
	{
		super(comboBoxModel);
		this.propertyModel.setObject(selectedModelObject);
		getModel().setSelectedItem(this.propertyModel.getObject());
	}

	/**
	 * Constructs a new <code>JMComboBox</code> with an array of items.
	 *
	 * @param items the array of items to be used
	 */
	public JMComboBox(T[] items)
	{
		super(items);
	}

	/**
	 * Constructs a new <code>JMComboBox</code> with an array of items and a property model.
	 *
	 * @param items the array of items to be used
	 * @param propertyModel the property model to be used
	 */
	public JMComboBox(T[] items, IModel<T> propertyModel)
	{
		super(items);
		this.propertyModel = propertyModel;
		getModel().setSelectedItem(this.propertyModel.getObject());
	}

	/**
	 * Constructs a new <code>JMComboBox</code> with no items and the specified property model.
	 *
	 * @param propertyModel the property model to be used
	 */
	public JMComboBox(IModel<T> propertyModel)
	{
		super();
		this.propertyModel = propertyModel;
		getModel().setSelectedItem(this.propertyModel.getObject());
	}

	/**
	 * Constructs a new <code>JMComboBox</code> with no items.
	 */
	public JMComboBox()
	{
		super();
	}

	/**
	 * Constructs a new <code>JMComboBox</code> with a custom UI.
	 *
	 * @param ui the custom UI to be used
	 */
	public JMComboBox(ComboBoxUI ui)
	{
		super();
		setUI(ui);
	}

	/**
	 * Sets the property model and updates the combo box's selected item.
	 *
	 * @param propertyModel the new property model
	 * @return the current instance of {@link JMComboBox}
	 */
	public JMComboBox<T, CMB> setPropertyModel(final @NonNull IModel<T> propertyModel)
	{
		this.propertyModel = propertyModel;
		getModel().setSelectedItem(this.propertyModel.getObject());
		return this;
	}
}
