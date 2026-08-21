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

import javax.swing.BoundedRangeModel;
import javax.swing.JProgressBar;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link JMProgressBar} provides a progress bar component with an associated model.
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JMProgressBar extends JProgressBar
{

	/** The model. */
	IModel<Integer> propertyModel = BaseModel.of(0);

	/**
	 * Initializes the progress bar and adds a change listener to update the model when the value
	 * changes.
	 */
	{
		addChangeListener(event -> propertyModel.setObject(getValue()));
		propertyModel.setObject(getValue());
	}

	/**
	 * Constructs a new <code>JMProgressBar</code> with a horizontal orientation and the range 0 to
	 * 100.
	 */
	public JMProgressBar()
	{
		super();
	}

	/**
	 * Constructs a new <code>JMProgressBar</code> with the specified orientation.
	 *
	 * @param orientation
	 *            the orientation of the progress bar
	 */
	public JMProgressBar(int orientation)
	{
		super(orientation);
	}

	/**
	 * Constructs a new <code>JMProgressBar</code> with the specified minimum and maximum values.
	 *
	 * @param min
	 *            the minimum value of the progress bar
	 * @param max
	 *            the maximum value of the progress bar
	 */
	public JMProgressBar(int min, int max)
	{
		super(min, max);
	}

	/**
	 * Constructs a new <code>JMProgressBar</code> with the specified orientation, minimum and
	 * maximum values.
	 *
	 * @param orientation
	 *            the orientation of the progress bar
	 * @param min
	 *            the minimum value of the progress bar
	 * @param max
	 *            the maximum value of the progress bar
	 */
	public JMProgressBar(int orientation, int min, int max)
	{
		super(orientation, min, max);
	}

	/**
	 * Constructs a new <code>JMProgressBar</code> with the specified bounded range model.
	 *
	 * @param boundedRangeModel
	 *            the bounded range model to be used
	 */
	public JMProgressBar(BoundedRangeModel boundedRangeModel)
	{
		super(boundedRangeModel);
	}

	/**
	 * Sets the property model and updates the progress bar's value.
	 *
	 * @param propertyModel
	 *            the new property model
	 * @return the current instance of {@link JMProgressBar}
	 */
	public JMProgressBar setPropertyModel(final @NonNull IModel<Integer> propertyModel)
	{
		this.propertyModel = propertyModel;
		if (this.propertyModel.getObject() != null)
		{
			setValue(this.propertyModel.getObject());
		}
		return this;
	}
}
