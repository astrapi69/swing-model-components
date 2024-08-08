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

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.DefaultFormatter;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import lombok.NonNull;

/**
 * The class {@link JMSpinner} provides a spinner component with an associated model.
 *
 * @param <T>
 *            the type of the value in the spinner
 */
public class JMSpinner<T> extends JSpinner
{
	/** The model. */
	IModel<T> propertyModel = BaseModel.of();

	/**
	 * Initializes the spinner and sets the formatter to commit on valid edits. Adds a change
	 * listener to update the model when the spinner's value changes.
	 */
	{
		JComponent comp = this.getEditor();
		JFormattedTextField field = (JFormattedTextField)comp.getComponent(0);
		DefaultFormatter formatter = (DefaultFormatter)field.getFormatter();
		formatter.setCommitsOnValidEdit(true);
		addChangeListener(e -> {
			JSpinner s = (JSpinner)e.getSource();
			@SuppressWarnings("unchecked")
			T value = (T)s.getValue();
			propertyModel.setObject(value);
		});
	}

	/**
	 * Constructs a spinner for the given model. The spinner has a set of previous/next buttons, and
	 * an editor appropriate for the model.
	 *
	 * @param model
	 *            the spinner model
	 * @throws NullPointerException
	 *             if the model is {@code null}
	 */
	public JMSpinner(SpinnerModel model)
	{
		super(model);
	}

	/**
	 * Constructs a spinner with an <code>Integer SpinnerNumberModel</code> with initial value 0 and
	 * no minimum or maximum limits.
	 */
	public JMSpinner()
	{
		super();
	}

	/**
	 * Constructs a spinner with an <code>Integer SpinnerNumberModel</code> with the specified
	 * initial value, minimum, maximum, and step size.
	 *
	 * @param value
	 *            the current (initial) value of the model
	 * @param minimum
	 *            the minimum value of the model
	 * @param maximum
	 *            the maximum value of the model
	 * @param stepSize
	 *            the size of the value change between consecutive elements
	 */
	public JMSpinner(int value, int minimum, int maximum, int stepSize)
	{
		super(new SpinnerNumberModel(value, minimum, maximum, stepSize));
	}

	/**
	 * Constructs a spinner with the specified model and property model.
	 *
	 * @param model
	 *            the spinner model
	 * @param propertyModel
	 *            the property model to be used
	 * @throws NullPointerException
	 *             if the model is {@code null}
	 */
	public JMSpinner(SpinnerModel model, IModel<T> propertyModel)
	{
		super(model);
		this.propertyModel = propertyModel;
		getModel().setValue(this.propertyModel.getObject());
	}

	/**
	 * Sets the property model and updates the spinner's value.
	 *
	 * @param propertyModel
	 *            the new property model
	 * @return the current instance of {@link JMSpinner}
	 */
	public JMSpinner<T> setPropertyModel(final @NonNull IModel<T> propertyModel)
	{
		this.propertyModel = propertyModel;
		getModel().setValue(this.propertyModel.getObject());
		return this;
	}
}
