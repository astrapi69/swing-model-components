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
package io.github.astrapi69.swing.model.component.test;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import io.github.astrapi69.collection.pair.ValueBox;
import io.github.astrapi69.model.LambdaModel;

public class JMButtonDemo
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Custom Button Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		ValueBox<String> stringBox = ValueBox.<String> builder().value("foo").build();

		JMButton customButton = new JMButton();

		customButton.setPropertyModel(LambdaModel.of(stringBox::getValue, stringBox::setValue));
		panel.add(customButton);

		frame.add(panel);
		frame.setVisible(true);
	}
}
