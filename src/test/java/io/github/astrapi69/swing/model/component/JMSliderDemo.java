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

import java.awt.Frame;
import java.awt.GridLayout;

import io.github.astrapi69.awt.window.adapter.CloseWindow;

public class JMSliderDemo
{
	public static void main(String[] args)
	{
		final JMSlider slider = new JMSlider(0, 100, 50);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);

		final JMLabel valueLabel = new JMLabel("50");
		slider.addChangeListener(
			e -> valueLabel.setText(String.valueOf(slider.getPropertyModel().getObject())));

		final Frame frame = new Frame("JMSliderDemo");
		frame.addWindowListener(new CloseWindow());

		frame.setLayout(new GridLayout(2, 1));
		frame.add(slider);
		frame.add(valueLabel);
		frame.setSize(320, 160);
		frame.setVisible(true);
	}
}
