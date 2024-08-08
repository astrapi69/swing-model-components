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

import javax.swing.JTextField;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * The abstract class {@link JMGenericTextField} provides a text field component that is associated
 * with a model.
 *
 * @param <T>
 *            the type of the model object
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class JMGenericTextField<T> extends JTextField
{

	/** The model. */
	IModel<T> propertyModel = BaseModel.of();

	/**
	 * Init block to call the {@link #onInitialize()} method.
	 */
	{
		onInitialize();
	}

	/**
	 * Constructs a new <code>TextField</code> with the specified property model.
	 *
	 * @param propertyModel
	 *            the text model to be displayed
	 */
	public JMGenericTextField(final @NonNull IModel<T> propertyModel)
	{
		this.propertyModel = propertyModel;
	}

	/**
	 * Constructs a new <code>TextField</code>. A default model is created, the initial string is
	 * <code>null</code>, and the number of columns is set to 0.
	 */
	public JMGenericTextField()
	{
		this("");
	}

	/**
	 * Constructs a new <code>TextField</code> initialized with the specified text. A default model
	 * is created and the number of columns is 0.
	 *
	 * @param text
	 *            the text to be displayed, or <code>null</code>
	 */
	public JMGenericTextField(String text)
	{
		super(text);
		this.propertyModel.setObject(toGenericObject(text));
	}

	/**
	 * Constructs a new <code>TextField</code> initialized with the specified text and columns.
	 *
	 * @param text
	 *            the text to be displayed, or <code>null</code>
	 * @param columns
	 *            the number of columns to use to calculate the preferred width
	 */
	public JMGenericTextField(String text, int columns)
	{
		super(text, columns);
		this.propertyModel.setObject(toGenericObject(text));
	}

	/**
	 * Constructs a new <code>TextField</code> initialized with the specified columns.
	 *
	 * @param columns
	 *            the number of columns to use to calculate the preferred width
	 */
	public JMGenericTextField(int columns)
	{
		this("", columns);
	}

	/**
	 * Sets the property model and updates the text field with the model's text representation.
	 *
	 * @param propertyModel
	 *            the new property model
	 * @return the current instance of {@link JMGenericTextField}
	 */
	public JMGenericTextField setPropertyModel(final @NonNull IModel<T> propertyModel)
	{
		this.propertyModel = propertyModel;
		setText(toText(this.propertyModel.getObject()));
		return this;
	}

	/**
	 * Called during initialization.
	 */
	protected abstract void onInitialize();

	/**
	 * Converts the given text to the generic object type.
	 *
	 * @param text
	 *            the text to convert
	 * @return the converted object of type T
	 */
	public abstract T toGenericObject(String text);

	/**
	 * Converts the given property model object to its text representation.
	 *
	 * @param propertyModelObject
	 *            the property model object to convert
	 * @return the text representation of the property model object
	 */
	public abstract String toText(T propertyModelObject);

}
