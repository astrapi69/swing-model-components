package io.github.astrapi69.swing.model.component.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonModel;
import javax.swing.DefaultButtonModel;
import javax.swing.JButton;

import io.github.astrapi69.model.api.IModel;

public class JMButton extends JButton
{
	private IModel<String> propertyModel;

	public JMButton()
	{
		super();
		initialize();
	}

	public JMButton(String text)
	{
		super(text);
		initialize();
	}

	public JMButton(IModel<String> propertyModel)
	{
		super(propertyModel.getObject());
		this.propertyModel = propertyModel;
		initialize();
	}

	private void initialize()
	{
		// Set default properties for the custom button
		this.setFont(new Font("Arial", Font.BOLD, 14));
		this.setBackground(Color.LIGHT_GRAY);
		this.setForeground(Color.BLACK);

		// Set a custom button model if needed
		ButtonModel model = new DefaultButtonModel();
		this.setModel(model);

		// Add a custom action listener for demonstration purposes
		this.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				onButtonClicked();
			}
		});

		// Synchronize the button text with the property model if available
		if (propertyModel != null)
		{
			this.setText(propertyModel.getObject());
			// Update the model whenever the button is clicked
			this.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					propertyModel.setObject(JMButton.this.getText());
				}
			});
		}
	}

	// Custom method to be called when the button is clicked
	private void onButtonClicked()
	{
		if (propertyModel != null)
		{
			System.out.println(
				"JMButton was clicked! Property Model Value: " + propertyModel.getObject());
		}
		else
		{
			System.out.println("JMButton was clicked!");
		}
	}

	// Getter and Setter for the property model
	public IModel<String> getPropertyModel()
	{
		return propertyModel;
	}

	public void setPropertyModel(IModel<String> propertyModel)
	{
		this.propertyModel = propertyModel;
		this.setText(propertyModel.getObject());
	}

	// Additional custom behavior can be added here
}
