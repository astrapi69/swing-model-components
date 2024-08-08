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

import javax.swing.*;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.swing.model.label.LabelModel;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link JMLabel} provides a label component with an associated model.
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JMLabel extends JLabel
{
	/** The model. */
	IModel<LabelModel> propertyModel = BaseModel.of(LabelModel.builder().build());

	/**
	 * Constructs a new <code>JMLabel</code> with the specified text.
	 *
	 * @param text
	 *            the text to be displayed by the label
	 */
	public JMLabel(String text)
	{
		super(text);
		propertyModel.getObject().setText(text);
	}

	/**
	 * Constructs a new <code>JMLabel</code> with the specified property model.
	 *
	 * @param propertyModel
	 *            the property model to be used
	 */
	public JMLabel(@NonNull IModel<LabelModel> propertyModel)
	{
		this.setPropertyModel(propertyModel);
	}

	/**
	 * Constructs a new <code>JMLabel</code> with no text or icon.
	 */
	public JMLabel()
	{
		super();
	}

	/**
	 * Constructs a new <code>JMLabel</code> with the specified icon.
	 *
	 * @param image
	 *            the icon to be displayed by the label
	 */
	public JMLabel(Icon image)
	{
		super(image);
	}

	/**
	 * Constructs a new <code>JMLabel</code> with the specified icon and horizontal alignment.
	 *
	 * @param image
	 *            the icon to be displayed by the label
	 * @param horizontalAlignment
	 *            the horizontal alignment of the label's content
	 */
	public JMLabel(Icon image, int horizontalAlignment)
	{
		super(image, horizontalAlignment);
	}

	/**
	 * Constructs a new <code>JMLabel</code> with the specified text and horizontal alignment.
	 *
	 * @param text
	 *            the text to be displayed by the label
	 * @param horizontalAlignment
	 *            the horizontal alignment of the label's content
	 */
	public JMLabel(String text, int horizontalAlignment)
	{
		super(text, horizontalAlignment);
	}

	/**
	 * Constructs a new <code>JMLabel</code> with the specified text, icon, and horizontal
	 * alignment.
	 *
	 * @param text
	 *            the text to be displayed by the label
	 * @param icon
	 *            the icon to be displayed by the label
	 * @param horizontalAlignment
	 *            the horizontal alignment of the label's content
	 */
	public JMLabel(String text, Icon icon, int horizontalAlignment)
	{
		super(text, icon, horizontalAlignment);
	}

	/**
	 * Sets the property model and updates the label's text, icon, and horizontal alignment.
	 *
	 * @param propertyModel
	 *            the new property model
	 * @return the current instance of {@link JMLabel}
	 */
	public JMLabel setPropertyModel(final @NonNull IModel<LabelModel> propertyModel)
	{
		this.propertyModel = propertyModel;
		LabelModel labelModel = this.propertyModel.getObject();
		if (labelModel.getText() != null && !labelModel.getText().equals(getText()))
		{
			setText(labelModel.getText());
		}
		if (labelModel.getIcon() != null && labelModel.getIcon() != getIcon())
		{
			setIcon(labelModel.getIcon());
		}
		if (labelModel.getHorizontalAlignment() != null
			&& labelModel.getHorizontalAlignment() != getHorizontalAlignment())
		{
			setHorizontalAlignment(labelModel.getHorizontalAlignment());
		}
		return this;
	}
}
