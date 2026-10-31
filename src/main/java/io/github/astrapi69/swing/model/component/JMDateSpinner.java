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

import java.util.Date;

import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link JMDateSpinner} provides a spinner component for {@link Date} values with an
 * associated model.
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JMDateSpinner extends JSpinner
{

	/** The model. */
	IModel<Date> propertyModel = BaseModel.of();

	/**
	 * Initializes the date spinner and adds a change listener to update the model when the value
	 * changes.
	 */
	{
		addChangeListener(event -> propertyModel.setObject((Date)getValue()));
		propertyModel.setObject((Date)getValue());
	}

	/**
	 * Constructs a new <code>JMDateSpinner</code> with a default {@link SpinnerDateModel}.
	 */
	public JMDateSpinner()
	{
		super(new SpinnerDateModel());
	}

	/**
	 * Constructs a new <code>JMDateSpinner</code> with the specified spinner date model.
	 *
	 * @param spinnerDateModel
	 *            the spinner date model to be used
	 */
	public JMDateSpinner(SpinnerDateModel spinnerDateModel)
	{
		super(spinnerDateModel);
	}

	/**
	 * Constructs a new <code>JMDateSpinner</code> with a default {@link SpinnerDateModel} and the
	 * specified property model.
	 *
	 * @param propertyModel
	 *            the property model to be used
	 */
	public JMDateSpinner(final @NonNull IModel<Date> propertyModel)
	{
		super(new SpinnerDateModel());
		this.propertyModel = propertyModel;
		if (this.propertyModel.getObject() != null)
		{
			setValue(this.propertyModel.getObject());
		}
		else
		{
			this.propertyModel.setObject((Date)getValue());
		}
	}

	/**
	 * Sets the property model and updates the date spinner's value.
	 *
	 * @param propertyModel
	 *            the new property model
	 * @return the current instance of {@link JMDateSpinner}
	 */
	public JMDateSpinner setPropertyModel(final @NonNull IModel<Date> propertyModel)
	{
		this.propertyModel = propertyModel;
		if (this.propertyModel.getObject() != null)
		{
			setValue(this.propertyModel.getObject());
		}
		return this;
	}
}
