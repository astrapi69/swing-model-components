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
import javax.swing.JSlider;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link JMSlider} provides a slider component with an associated model.
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JMSlider extends JSlider
{

	/** The model. */
	IModel<Integer> propertyModel = BaseModel.of(0);

	/**
	 * Initializes the slider and adds a change listener to update the model when the value changes.
	 */
	{
		addChangeListener(event -> propertyModel.setObject(getValue()));
		propertyModel.setObject(getValue());
	}

	/**
	 * Constructs a new <code>JMSlider</code> with a horizontal orientation and the range 0 to 100
	 * with an initial value of 50.
	 */
	public JMSlider()
	{
		super();
	}

	/**
	 * Constructs a new <code>JMSlider</code> with the specified orientation.
	 *
	 * @param orientation
	 *            the orientation of the slider
	 */
	public JMSlider(int orientation)
	{
		super(orientation);
	}

	/**
	 * Constructs a new <code>JMSlider</code> with the specified minimum and maximum values.
	 *
	 * @param min
	 *            the minimum value of the slider
	 * @param max
	 *            the maximum value of the slider
	 */
	public JMSlider(int min, int max)
	{
		super(min, max);
	}

	/**
	 * Constructs a new <code>JMSlider</code> with the specified minimum, maximum and initial
	 * values.
	 *
	 * @param min
	 *            the minimum value of the slider
	 * @param max
	 *            the maximum value of the slider
	 * @param value
	 *            the initial value of the slider
	 */
	public JMSlider(int min, int max, int value)
	{
		super(min, max, value);
	}

	/**
	 * Constructs a new <code>JMSlider</code> with the specified orientation, minimum, maximum and
	 * initial values.
	 *
	 * @param orientation
	 *            the orientation of the slider
	 * @param min
	 *            the minimum value of the slider
	 * @param max
	 *            the maximum value of the slider
	 * @param value
	 *            the initial value of the slider
	 */
	public JMSlider(int orientation, int min, int max, int value)
	{
		super(orientation, min, max, value);
	}

	/**
	 * Constructs a new <code>JMSlider</code> with the specified bounded range model.
	 *
	 * @param boundedRangeModel
	 *            the bounded range model to be used
	 */
	public JMSlider(BoundedRangeModel boundedRangeModel)
	{
		super(boundedRangeModel);
	}

	/**
	 * Sets the property model and updates the slider's value.
	 *
	 * @param propertyModel
	 *            the new property model
	 * @return the current instance of {@link JMSlider}
	 */
	public JMSlider setPropertyModel(final @NonNull IModel<Integer> propertyModel)
	{
		this.propertyModel = propertyModel;
		if (this.propertyModel.getObject() != null)
		{
			setValue(this.propertyModel.getObject());
		}
		return this;
	}
}
