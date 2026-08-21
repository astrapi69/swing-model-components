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

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
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
 * The class {@link JMFileField} provides a composite component with a text field and a browse
 * button that binds the selected file to an associated model. The browse button opens a
 * {@link JFileChooser} dialog; a manual change of the text field also updates the model.
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JMFileField extends JPanel
{

	/** The model. */
	IModel<File> propertyModel = BaseModel.of();

	/** The text field that shows the absolute path of the selected file. */
	final JMTextField textField = new JMTextField();

	/** The button that opens the file chooser dialog. */
	final JButton browseButton = new JButton("...");

	/** The file chooser that is opened by the browse button. */
	final JFileChooser fileChooser = new JFileChooser();

	/**
	 * Initializes the panel with the text field and the browse button and wires the listeners that
	 * update the model.
	 */
	{
		setLayout(new BorderLayout());
		add(textField, BorderLayout.CENTER);
		add(browseButton, BorderLayout.EAST);
		textField.getDocument().addDocumentListener(new DocumentListenerAdapter()
		{
			@Override
			public void onDocumentChanged(final DocumentEvent documentEvent)
			{
				int currentLength = documentEvent.getDocument().getLength();
				final String text = RuntimeExceptionDecorator
					.decorate(() -> documentEvent.getDocument().getText(0, currentLength));
				propertyModel.setObject(text.isEmpty() ? null : new File(text));
			}
		});
		browseButton.addActionListener(event -> {
			if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
			{
				setFile(fileChooser.getSelectedFile());
			}
		});
	}

	/**
	 * Constructs a new <code>JMFileField</code> with a default property model.
	 */
	public JMFileField()
	{
		super();
	}

	/**
	 * Constructs a new <code>JMFileField</code> with the specified property model.
	 *
	 * @param propertyModel
	 *            the property model to be used
	 */
	public JMFileField(final @NonNull IModel<File> propertyModel)
	{
		super();
		this.propertyModel = propertyModel;
		if (this.propertyModel.getObject() != null)
		{
			textField.setText(this.propertyModel.getObject().getAbsolutePath());
		}
	}

	/**
	 * Sets the given file, updates the text field and the model.
	 *
	 * @param file
	 *            the new file
	 * @return the current instance of {@link JMFileField}
	 */
	public JMFileField setFile(final @NonNull File file)
	{
		textField.setText(file.getAbsolutePath());
		propertyModel.setObject(file);
		return this;
	}

	/**
	 * Sets the property model and updates the text field.
	 *
	 * @param propertyModel
	 *            the new property model
	 * @return the current instance of {@link JMFileField}
	 */
	public JMFileField setPropertyModel(final @NonNull IModel<File> propertyModel)
	{
		this.propertyModel = propertyModel;
		File file = this.propertyModel.getObject();
		textField.setText(file != null ? file.getAbsolutePath() : "");
		return this;
	}
}
