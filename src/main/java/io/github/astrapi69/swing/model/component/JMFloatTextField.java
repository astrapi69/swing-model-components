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

import javax.swing.event.DocumentEvent;

import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.swing.listener.document.DocumentListenerAdapter;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link JMFloatTextField} provides a text field component for handling {@link Float}
 * values.
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JMFloatTextField extends JMGenericTextField<Float>
{

	/**
	 * Constructs a new <code>JMFloatTextField</code> with the specified property model.
	 *
	 * @param propertyModel
	 *            the text model to be displayed
	 */
	public JMFloatTextField(final @NonNull IModel<Float> propertyModel)
	{
		super(propertyModel);
	}

	/**
	 * Constructs a new <code>JMFloatTextField</code>. A default model is created, the initial
	 * string is <code>null</code>, and the number of columns is set to 0.
	 */
	public JMFloatTextField()
	{
		super();
	}

	/**
	 * Constructs a new <code>JMFloatTextField</code> initialized with the specified text. A default
	 * model is created and the number of columns is 0.
	 *
	 * @param text
	 *            the text to be displayed, or <code>null</code>
	 */
	public JMFloatTextField(String text)
	{
		super(text);
	}

	/**
	 * Constructs a new <code>JMFloatTextField</code> initialized with the specified text and
	 * columns. A default model is created.
	 *
	 * @param text
	 *            the text to be displayed, or <code>null</code>
	 * @param columns
	 *            the number of columns to use to calculate the preferred width
	 */
	public JMFloatTextField(String text, int columns)
	{
		super(text, columns);
	}

	/**
	 * Constructs a new <code>JMFloatTextField</code> initialized with the specified columns.
	 *
	 * @param columns
	 *            the number of columns to use to calculate the preferred width
	 */
	public JMFloatTextField(int columns)
	{
		super(columns);
	}

	/**
	 * Initializes the text field by setting a document that allows only decimal number values and
	 * adding a document listener.
	 */
	@Override
	protected void onInitialize()
	{
		setDocument(new DecimalNumberValuesDocument());
		getDocument().addDocumentListener(new DocumentListenerAdapter()
		{
			@Override
			public void onDocumentChanged(final DocumentEvent documentEvent)
			{
				int currentLength = documentEvent.getDocument().getLength();
				final String text = RuntimeExceptionDecorator
					.decorate(() -> documentEvent.getDocument().getText(0, currentLength));
				if (JMFloatTextField.this.getPropertyModel() != null)
				{
					JMFloatTextField.this.getPropertyModel().setObject(toGenericObject(text));
				}
			}
		});
	}

	/**
	 * Converts the given text to a {@link Float} object.
	 *
	 * @param text
	 *            the text to convert
	 * @return the converted {@link Float} object
	 */
	@Override
	public Float toGenericObject(String text)
	{
		if (text == null || text.isEmpty() || "-".equals(text))
		{
			return 0f;
		}
		return Float.valueOf(text);
	}

	/**
	 * Converts the given {@link Float} object to its text representation.
	 *
	 * @param propertyModelObject
	 *            the {@link Float} object to convert
	 * @return the text representation of the {@link Float} object
	 */
	@Override
	public String toText(Float propertyModelObject)
	{
		return propertyModelObject != null ? propertyModelObject.toString() : "";
	}
}
