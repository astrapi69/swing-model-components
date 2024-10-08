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

import javax.swing.JTextArea;
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
 * The class {@link JMTextArea} provides a text area component with an associated model.
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JMTextArea extends JTextArea
{

	/** The model. */
	IModel<String> propertyModel = BaseModel.of();

	/**
	 * Initializes the text area and adds a document listener to update the model when the text
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
				if (JMTextArea.this.propertyModel != null)
				{
					JMTextArea.this.propertyModel.setObject(text);
				}
			}
		});
	}

	/**
	 * Constructs a new <code>JMTextArea</code>.
	 */
	public JMTextArea()
	{
		super();
	}

	/**
	 * Constructs a new <code>JMTextArea</code> with the specified property model.
	 *
	 * @param propertyModel
	 *            the text model to be displayed
	 */
	public JMTextArea(final @NonNull IModel<String> propertyModel)
	{
		this.propertyModel = propertyModel;
	}

	/**
	 * Constructs a new <code>JMTextArea</code> with the specified text.
	 *
	 * @param text
	 *            the text to be displayed
	 */
	public JMTextArea(String text)
	{
		super(text);
		this.propertyModel.setObject(text);
	}

	/**
	 * Constructs a new <code>JMTextArea</code> with the specified number of rows and columns.
	 *
	 * @param rows
	 *            the number of rows
	 * @param columns
	 *            the number of columns
	 */
	public JMTextArea(int rows, int columns)
	{
		super(rows, columns);
	}

	/**
	 * Constructs a new <code>JMTextArea</code> with the specified text and number of rows and
	 * columns.
	 *
	 * @param text
	 *            the text to be displayed
	 * @param rows
	 *            the number of rows
	 * @param columns
	 *            the number of columns
	 */
	public JMTextArea(String text, int rows, int columns)
	{
		super(text, rows, columns);
		this.propertyModel.setObject(text);
	}

	/**
	 * Constructs a new <code>JMTextArea</code> with the specified document model, text, and number
	 * of rows and columns.
	 *
	 * @param doc
	 *            the document model to be used
	 * @param text
	 *            the text to be displayed, or <code>null</code>
	 * @param rows
	 *            the number of rows
	 * @param columns
	 *            the number of columns
	 */
	public JMTextArea(javax.swing.text.Document doc, String text, int rows, int columns)
	{
		super(doc, text, rows, columns);
	}

	/**
	 * Sets the property model and updates the text area's text.
	 *
	 * @param propertyModel
	 *            the new property model
	 * @return the current instance of {@link JMTextArea}
	 */
	public JMTextArea setPropertyModel(final @NonNull IModel<String> propertyModel)
	{
		this.propertyModel = propertyModel;
		setText(this.propertyModel.getObject());
		return this;
	}
}
