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

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBox;

import io.github.astrapi69.model.PropertyModel;
import io.github.astrapi69.model.api.IModel;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link JMCheckBox} provides a checkbox component with an associated model.
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JMCheckBox extends JCheckBox
{

	/** The model. */
	IModel<Boolean> propertyModel = PropertyModel.of(this, "model.selected");

	/**
	 * Initializes the checkbox and adds an item listener to update the model when the checkbox
	 * state changes.
	 */
	{
		addItemListener(e -> {
			Object source = e.getSource();
			if (source instanceof JCheckBox)
			{
				propertyModel.setObject(JMCheckBox.this.isSelected());
			}
		});
	}

	/**
	 * Constructs a new <code>JMCheckBox</code> with no text or icon.
	 */
	public JMCheckBox()
	{
		super();
	}

	/**
	 * Constructs a new <code>JMCheckBox</code> with the specified icon.
	 *
	 * @param icon
	 *            the icon to display in the checkbox
	 */
	public JMCheckBox(Icon icon)
	{
		super(icon);
	}

	/**
	 * Constructs a new <code>JMCheckBox</code> with the specified icon and selection state.
	 *
	 * @param icon
	 *            the icon to display in the checkbox
	 * @param selected
	 *            the initial selection state of the checkbox
	 */
	public JMCheckBox(Icon icon, boolean selected)
	{
		super(icon, selected);
	}

	/**
	 * Constructs a new <code>JMCheckBox</code> with the specified text.
	 *
	 * @param text
	 *            the text to display in the checkbox
	 */
	public JMCheckBox(String text)
	{
		super(text);
	}

	/**
	 * Constructs a new <code>JMCheckBox</code> with the specified action.
	 *
	 * @param a
	 *            the action to be associated with the checkbox
	 */
	public JMCheckBox(Action a)
	{
		super(a);
	}

	/**
	 * Constructs a new <code>JMCheckBox</code> with the specified text and selection state.
	 *
	 * @param text
	 *            the text to display in the checkbox
	 * @param selected
	 *            the initial selection state of the checkbox
	 */
	public JMCheckBox(String text, boolean selected)
	{
		super(text, selected);
	}

	/**
	 * Constructs a new <code>JMCheckBox</code> with the specified text and icon.
	 *
	 * @param text
	 *            the text to display in the checkbox
	 * @param icon
	 *            the icon to display in the checkbox
	 */
	public JMCheckBox(String text, Icon icon)
	{
		super(text, icon);
	}

	/**
	 * Constructs a new <code>JMCheckBox</code> with the specified text, icon, and selection state.
	 *
	 * @param text
	 *            the text to display in the checkbox
	 * @param icon
	 *            the icon to display in the checkbox
	 * @param selected
	 *            the initial selection state of the checkbox
	 */
	public JMCheckBox(String text, Icon icon, boolean selected)
	{
		super(text, icon, selected);
	}

	/**
	 * Constructs a new <code>JMCheckBox</code> with the specified selection state.
	 *
	 * @param selected
	 *            the initial selection state of the checkbox
	 */
	public JMCheckBox(boolean selected)
	{
		this("", selected);
	}

	/**
	 * Sets the property model and updates the checkbox's selection state.
	 *
	 * @param propertyModel
	 *            the new property model
	 * @return the current instance of {@link JMCheckBox}
	 */
	public JMCheckBox setPropertyModel(final @NonNull IModel<Boolean> propertyModel)
	{
		this.propertyModel = propertyModel;
		getModel().setSelected(this.propertyModel.getObject());
		return this;
	}
}
