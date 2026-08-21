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

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link JMColorButton} provides a button component that opens a {@link JColorChooser}
 * dialog on click and binds the selected color to an associated model. The background of the button
 * always shows the selected color.
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JMColorButton extends JButton
{

	/** The model. */
	IModel<Color> propertyModel = BaseModel.of();

	/**
	 * Initializes the color button and adds an action listener that opens a color chooser dialog
	 * and updates the model with the selected color.
	 */
	{
		addActionListener(event -> {
			Color selectedColor = JColorChooser.showDialog(this, getText(),
				propertyModel.getObject());
			if (selectedColor != null)
			{
				setSelectedColor(selectedColor);
			}
		});
	}

	/**
	 * Constructs a new <code>JMColorButton</code> with no text.
	 */
	public JMColorButton()
	{
		super();
	}

	/**
	 * Constructs a new <code>JMColorButton</code> with the specified text.
	 *
	 * @param text
	 *            the text to display in the button and as the title of the color chooser dialog
	 */
	public JMColorButton(String text)
	{
		super(text);
	}

	/**
	 * Constructs a new <code>JMColorButton</code> with the specified text and initial color.
	 *
	 * @param text
	 *            the text to display in the button and as the title of the color chooser dialog
	 * @param color
	 *            the initial color
	 */
	public JMColorButton(String text, Color color)
	{
		super(text);
		setSelectedColor(color);
	}

	/**
	 * Sets the selected color, updates the model and the background of the button.
	 *
	 * @param selectedColor
	 *            the new selected color
	 * @return the current instance of {@link JMColorButton}
	 */
	public JMColorButton setSelectedColor(final @NonNull Color selectedColor)
	{
		propertyModel.setObject(selectedColor);
		setBackground(selectedColor);
		return this;
	}

	/**
	 * Sets the property model and updates the background of the button.
	 *
	 * @param propertyModel
	 *            the new property model
	 * @return the current instance of {@link JMColorButton}
	 */
	public JMColorButton setPropertyModel(final @NonNull IModel<Color> propertyModel)
	{
		this.propertyModel = propertyModel;
		if (this.propertyModel.getObject() != null)
		{
			setBackground(this.propertyModel.getObject());
		}
		return this;
	}
}
