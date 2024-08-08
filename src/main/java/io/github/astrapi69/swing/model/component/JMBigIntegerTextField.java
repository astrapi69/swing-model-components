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

import java.math.BigInteger;

import javax.swing.event.DocumentEvent;

import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.swing.document.NumberValuesDocument;
import io.github.astrapi69.swing.listener.document.DocumentListenerAdapter;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link JMBigIntegerTextField} provides a text field component for handling
 * {@link BigInteger} values.
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JMBigIntegerTextField extends JMGenericTextField<BigInteger>
{

	/**
	 * Constructs a new <code>TextField</code> with the specified property model.
	 *
	 * @param propertyModel
	 *            the text model to be displayed
	 */
	public JMBigIntegerTextField(final @NonNull IModel<BigInteger> propertyModel)
	{
		super(propertyModel);
	}

	/**
	 * Constructs a new <code>TextField</code>. A default model is created, the initial string is
	 * <code>null</code>, and the number of columns is set to 0.
	 */
	public JMBigIntegerTextField()
	{
		super();
	}

	/**
	 * Constructs a new <code>TextField</code> initialized with the specified text. A default model
	 * is created and the number of columns is 0.
	 *
	 * @param text
	 *            the text to be displayed, or <code>null</code>
	 */
	public JMBigIntegerTextField(String text)
	{
		super(text);
	}

	/**
	 * Constructs a new <code>TextField</code> initialized with the specified text and columns.
	 *
	 * @param text
	 *            the text to be displayed, or <code>null</code>
	 * @param columns
	 *            the number of columns to use to calculate the preferred width
	 */
	public JMBigIntegerTextField(String text, int columns)
	{
		super(text, columns);
	}

	/**
	 * Constructs a new <code>TextField</code> initialized with the specified columns.
	 *
	 * @param columns
	 *            the number of columns to use to calculate the preferred width
	 */
	public JMBigIntegerTextField(int columns)
	{
		super(columns);
	}

	/**
	 * Initializes the text field by setting a document that allows only number values and adding a
	 * document listener.
	 */
	@Override
	protected void onInitialize()
	{
		setDocument(new NumberValuesDocument());
		getDocument().addDocumentListener(new DocumentListenerAdapter()
		{
			@Override
			public void onDocumentChanged(final DocumentEvent documentEvent)
			{
				int currentLength = documentEvent.getDocument().getLength();
				final String text = RuntimeExceptionDecorator
					.decorate(() -> documentEvent.getDocument().getText(0, currentLength));
				if (JMBigIntegerTextField.this.getPropertyModel() != null)
				{
					JMBigIntegerTextField.this.getPropertyModel().setObject(toGenericObject(text));
				}
			}
		});
	}

	/**
	 * Converts the given text to a {@link BigInteger} object.
	 *
	 * @param text
	 *            the text to convert
	 * @return the converted {@link BigInteger} object
	 */
	@Override
	public BigInteger toGenericObject(String text)
	{
		if (text == null || text.isEmpty())
		{
			return BigInteger.ZERO;
		}
		return new BigInteger(text);
	}

	/**
	 * Converts the given {@link BigInteger} object to its text representation.
	 *
	 * @param propertyModelObject
	 *            the {@link BigInteger} object to convert
	 * @return the text representation of the {@link BigInteger} object
	 */
	@Override
	public String toText(BigInteger propertyModelObject)
	{
		return propertyModelObject != null ? propertyModelObject.toString() : "";
	}

}
