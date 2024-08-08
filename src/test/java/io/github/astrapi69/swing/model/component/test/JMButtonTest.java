package io.github.astrapi69.swing.model.component.test;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import io.github.astrapi69.collection.pair.ValueBox;
import io.github.astrapi69.model.LambdaModel;

public class JMButtonTest
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
