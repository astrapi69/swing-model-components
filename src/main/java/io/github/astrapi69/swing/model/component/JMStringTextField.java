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
 * The class {@link JMStringTextField} provides a text field component for handling {@link String}
 * values.
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JMStringTextField extends JMGenericTextField<String>
{

	/**
	 * Constructs a new <code>JMStringTextField</code> with the specified property model.
	 *
	 * @param propertyModel
	 *            the text model to be displayed
	 */
	public JMStringTextField(final @NonNull IModel<String> propertyModel)
	{
		super(propertyModel);
	}

	/**
	 * Constructs a new <code>JMStringTextField</code>. A default model is created, the initial
	 * string is <code>null</code>, and the number of columns is set to 0.
	 */
	public JMStringTextField()
	{
		super();
	}

	/**
	 * Constructs a new <code>JMStringTextField</code> initialized with the specified text. A
	 * default model is created and the number of columns is 0.
	 *
	 * @param text
	 *            the text to be displayed, or <code>null</code>
	 */
	public JMStringTextField(String text)
	{
		super(text);
	}

	/**
	 * Constructs a new <code>JMStringTextField</code> initialized with the specified text and
	 * columns. A default model is created.
	 *
	 * @param text
	 *            the text to be displayed, or <code>null</code>
	 * @param columns
	 *            the number of columns to use to calculate the preferred width
	 */
	public JMStringTextField(String text, int columns)
	{
		super(text, columns);
	}

	/**
	 * Constructs a new <code>JMStringTextField</code> initialized with the specified columns.
	 *
	 * @param columns
	 *            the number of columns to use to calculate the preferred width
	 */
	public JMStringTextField(int columns)
	{
		super();
		setColumns(columns);
	}

	/**
	 * Initializes the text field by adding a document listener to update the model when the text
	 * changes.
	 */
	@Override
	protected void onInitialize()
	{
		getDocument().addDocumentListener(new DocumentListenerAdapter()
		{
			@Override
			public void onDocumentChanged(final DocumentEvent documentEvent)
			{
				int currentLength = documentEvent.getDocument().getLength();
				final String text = RuntimeExceptionDecorator
					.decorate(() -> documentEvent.getDocument().getText(0, currentLength));
				if (JMStringTextField.this.getPropertyModel() != null)
				{
					JMStringTextField.this.getPropertyModel().setObject(toGenericObject(text));
				}
			}
		});
	}

	/**
	 * Converts the given text to a {@link String} object.
	 *
	 * @param text
	 *            the text to convert
	 * @return the converted {@link String} object
	 */
	@Override
	public String toGenericObject(String text)
	{
		return text;
	}

	/**
	 * Converts the given {@link String} object to its text representation.
	 *
	 * @param propertyModelObject
	 *            the {@link String} object to convert
	 * @return the text representation of the {@link String} object
	 */
	@Override
	public String toText(String propertyModelObject)
	{
		return propertyModelObject;
	}
}
