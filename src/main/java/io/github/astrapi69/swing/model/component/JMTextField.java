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
import javax.swing.event.DocumentEvent;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.swing.listener.document.DocumentListenerAdapter;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link JMTextField} provides a text field component with an associated model.
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JMTextField extends JTextField
{

	/** The model. */
	IModel<String> propertyModel = BaseModel.of();

	/**
	 * Initializes the text field and adds a document listener to update the model when the text
	 * changes.
	 */
	{
		getDocument().addDocumentListener(new DocumentListenerAdapter()
		{
			@Override
			public void onDocumentChanged(final DocumentEvent documentEvent)
			{
				int currentLength = documentEvent.getDocument().getLength();
				final String text = RuntimeExceptionDecorator
					.decorate(() -> documentEvent.getDocument().getText(0, currentLength));
				if (JMTextField.this.propertyModel != null)
				{
					JMTextField.this.propertyModel.setObject(text);
				}
			}
		});
	}

	/**
	 * Constructs a new <code>JMTextField</code> with the specified property model.
	 *
	 * @param propertyModel
	 *            the text model to be displayed
	 */
	public JMTextField(final @NonNull IModel<String> propertyModel)
	{
		this.propertyModel = propertyModel;
	}

	/**
	 * Constructs a new <code>JMTextField</code>. A default model is created, the initial string is
	 * <code>null</code>, and the number of columns is set to 0.
	 */
	public JMTextField()
	{
		super();
	}

	/**
	 * Constructs a new <code>JMTextField</code> initialized with the specified text. A default
	 * model is created and the number of columns is 0.
	 *
	 * @param text
	 *            the text to be displayed, or <code>null</code>
	 */
	public JMTextField(String text)
	{
		super(text);
		this.propertyModel.setObject(text);
	}

	/**
	 * Constructs a new <code>JMTextField</code> initialized with the specified text and columns. A
	 * default model is created.
	 *
	 * @param text
	 *            the text to be displayed, or <code>null</code>
	 * @param columns
	 *            the number of columns to use to calculate the preferred width
	 */
	public JMTextField(String text, int columns)
	{
		super(text, columns);
		this.propertyModel.setObject(text);
	}

	/**
	 * Constructs a new <code>JMTextField</code> initialized with the specified columns.
	 *
	 * @param columns
	 *            the number of columns to use to calculate the preferred width
	 */
	public JMTextField(int columns)
	{
		super();
		setColumns(columns);
	}

	/**
	 * Constructs a new <code>JTextField</code> that uses the given text storage model and the given
	 * number of columns. This is the constructor through which the other constructors feed. If the
	 * document is <code>null</code>, a default model is created.
	 *
	 * @param doc
	 *            the text storage to use; if this is <code>null</code>, a default will be provided
	 *            by calling the <code>createDefaultModel</code> method
	 * @param text
	 *            the initial string to display, or <code>null</code>
	 * @param columns
	 *            the number of columns to use to calculate the preferred width &ge; 0; if
	 *            <code>columns</code> is set to zero, the preferred width will be whatever
	 *            naturally results from the component implementation
	 * @throws IllegalArgumentException
	 *             if <code>columns</code> &lt; 0
	 */
	public JMTextField(javax.swing.text.Document doc, String text, int columns)
	{
		super(doc, text, columns);
	}

	/**
	 * Sets the property model and updates the text field's text.
	 *
	 * @param propertyModel
	 *            the new property model
	 * @return the current instance of {@link JMTextField}
	 */
	public JMTextField setPropertyModel(final @NonNull IModel<String> propertyModel)
	{
		this.propertyModel = propertyModel;
		setText(this.propertyModel.getObject());
		return this;
	}
}
