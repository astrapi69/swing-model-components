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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import io.github.astrapi69.model.BaseModel;

/**
 * Headless unit tests for the model binding of {@link JMDateSpinner}. These tests verify the
 * propagation between the spinner value and the property model without any UI robot interaction, so
 * they also run in headless environments like CI
 */
public class JMDateSpinnerModelBindingTest
{

	private Date newDate(int year, int month, int day)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(year, month, day);
		return calendar.getTime();
	}

	/**
	 * Test that the initial spinner value is propagated to the property model
	 */
	@Test
	public void testInitialValueInPropertyModel()
	{
		JMDateSpinner dateSpinner;

		dateSpinner = new JMDateSpinner();

		assertNotNull(dateSpinner.getPropertyModel().getObject());
		assertEquals(dateSpinner.getValue(), dateSpinner.getPropertyModel().getObject());
	}

	/**
	 * Test that a value change propagates to the property model
	 */
	@Test
	public void testSetValueUpdatesPropertyModel()
	{
		JMDateSpinner dateSpinner;
		Date date;

		dateSpinner = new JMDateSpinner();
		date = newDate(2026, Calendar.AUGUST, 21);

		dateSpinner.setValue(date);

		assertEquals(date, dateSpinner.getPropertyModel().getObject());
	}

	/**
	 * Test that the constructor with a property model sets the model object as the spinner value
	 */
	@Test
	public void testConstructorWithPropertyModelSetsValue()
	{
		JMDateSpinner dateSpinner;
		Date date;

		date = newDate(2026, Calendar.JANUARY, 1);
		dateSpinner = new JMDateSpinner(BaseModel.of(date));

		assertEquals(date, dateSpinner.getValue());
		assertEquals(date, dateSpinner.getPropertyModel().getObject());
	}

	/**
	 * Test that setting a new property model updates the spinner value
	 */
	@Test
	public void testSetPropertyModelUpdatesValue()
	{
		JMDateSpinner dateSpinner;
		Date date;

		dateSpinner = new JMDateSpinner();
		date = newDate(2027, Calendar.JULY, 15);

		dateSpinner.setPropertyModel(BaseModel.of(date));

		assertEquals(date, dateSpinner.getValue());
		assertEquals(date, dateSpinner.getPropertyModel().getObject());
	}

}
