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
import java.awt.Frame;

import javax.swing.JButton;

import io.github.astrapi69.awt.window.adapter.CloseWindow;

public class JMFileFieldDemo
{
	public static void main(String[] args)
	{
		final JMFileField fileField = new JMFileField();

		final Frame frame = new Frame("JMFileFieldDemo");
		JButton buttonPrint = new JButton("print model value");
		buttonPrint
			.addActionListener(e -> System.out.println(fileField.getPropertyModel().getObject()));
		frame.addWindowListener(new CloseWindow());

		frame.setLayout(new BorderLayout());
		frame.add(fileField, BorderLayout.NORTH);
		frame.add(buttonPrint, BorderLayout.SOUTH);
		frame.setSize(420, 140);
		frame.setVisible(true);
	}
}
