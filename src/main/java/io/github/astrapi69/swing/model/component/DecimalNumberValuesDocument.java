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

import javax.swing.text.BadLocationException;

import io.github.astrapi69.swing.document.RegularExpressionDocument;
import lombok.NonNull;

public class DecimalNumberValuesDocument extends RegularExpressionDocument
{
	public static final String DEFAULT_REGEX = "^-?\\d*(\\.\\d*)?$"; // Updated regex to allow
																		// partial input
	private static final long serialVersionUID = 1L;

	public DecimalNumberValuesDocument()
	{
		this(DEFAULT_REGEX);
	}

	public DecimalNumberValuesDocument(@NonNull String regex)
	{
		super(regex);
	}

	@Override
	public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
		throws BadLocationException
	{
		String currentText = getText(0, getLength());
		String proposedValue = currentText.substring(0, offs) + str + currentText.substring(offs);
		if (proposedValue.matches(DEFAULT_REGEX))
		{
			super.insertString(offs, str, a);
		}
	}

	@Override
	public void replace(int offset, int length, String text, javax.swing.text.AttributeSet attrs)
		throws BadLocationException
	{
		String currentText = getText(0, getLength());
		String proposedValue = currentText.substring(0, offset) + text
			+ currentText.substring(offset + length);
		if (proposedValue.matches(DEFAULT_REGEX))
		{
			super.replace(offset, length, text, attrs);
		}
	}

	@Override
	public String validate(String proposedValue) throws IllegalArgumentException
	{
		if (proposedValue.isEmpty() || proposedValue.matches(DEFAULT_REGEX))
		{
			return proposedValue;
		}
		else
		{
			throw new IllegalArgumentException("Value does not match the required format.");
		}
	}
}
