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

import java.awt.event.ItemEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link JMRadioButtonGroup} binds a group of {@link JRadioButton} objects to a single
 * typed property model. Every radio button is associated with a value of the generic type; when a
 * radio button is selected the property model is updated with its associated value, and setting a
 * new property model selects the radio button that is associated with the model object.
 *
 * @param <T>
 *            the type of the value that is associated with each radio button
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JMRadioButtonGroup<T>
{

	/** The button group that enforces the single selection. */
	final ButtonGroup buttonGroup = new ButtonGroup();

	/** The map with the associations between the values and the radio buttons. */
	final Map<T, JRadioButton> radioButtons = new LinkedHashMap<>();

	/** The model. */
	IModel<T> propertyModel;

	/**
	 * Constructs a new <code>JMRadioButtonGroup</code> with a default property model.
	 */
	public JMRadioButtonGroup()
	{
		this(BaseModel.of());
	}

	/**
	 * Constructs a new <code>JMRadioButtonGroup</code> with the specified property model.
	 *
	 * @param propertyModel
	 *            the property model to be used
	 */
	public JMRadioButtonGroup(final @NonNull IModel<T> propertyModel)
	{
		this.propertyModel = propertyModel;
	}

	/**
	 * Adds the given radio button to this group and associates it with the given value. If the
	 * current property model object equals the given value the radio button is selected.
	 *
	 * @param value
	 *            the value to associate with the radio button
	 * @param radioButton
	 *            the radio button to add
	 * @return this {@link JMRadioButtonGroup} object for method chaining
	 */
	public JMRadioButtonGroup<T> add(final @NonNull T value,
		final @NonNull JRadioButton radioButton)
	{
		buttonGroup.add(radioButton);
		radioButtons.put(value, radioButton);
		radioButton.addItemListener(event -> {
			if (event.getStateChange() == ItemEvent.SELECTED)
			{
				propertyModel.setObject(value);
			}
		});
		if (Objects.equals(propertyModel.getObject(), value))
		{
			radioButton.setSelected(true);
		}
		return this;
	}

	/**
	 * Resolves the radio button that is associated with the given value.
	 *
	 * @param value
	 *            the value
	 * @return the radio button that is associated with the given value or <code>null</code> if none
	 *         is associated
	 */
	public JRadioButton getRadioButton(final T value)
	{
		return radioButtons.get(value);
	}

	/**
	 * Sets the property model and selects the radio button that is associated with the model
	 * object.
	 *
	 * @param propertyModel
	 *            the new property model
	 * @return this {@link JMRadioButtonGroup} object for method chaining
	 */
	public JMRadioButtonGroup<T> setPropertyModel(final @NonNull IModel<T> propertyModel)
	{
		this.propertyModel = propertyModel;
		JRadioButton radioButton = radioButtons.get(propertyModel.getObject());
		if (radioButton != null)
		{
			radioButton.setSelected(true);
		}
		return this;
	}
}
