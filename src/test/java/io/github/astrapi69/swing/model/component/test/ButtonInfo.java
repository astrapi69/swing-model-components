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

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * The type Button info.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ButtonInfo implements Serializable
{
	private static final long serialVersionUID = 2685238812269228603L;
	/**
	 * Flag that indicates partial commitment towards triggering the button
	 */
	boolean armed;

	/**
	 * Flag that indicates if the button has been selected. Only needed for certain types of buttons
	 * - such as radio buttons and check boxes
	 */
	boolean selected;

	/**
	 * Flag that indicates if the button can be selected or triggered by an input device, such as a
	 * mouse pointer
	 */
	boolean enabled;

	/**
	 * Flag that indicates if the button is pressed
	 */
	boolean pressed;

	/**
	 * Flag that indicates that the mouse is over the button
	 */
	boolean rollover;

	/** The button's mnemonic. */
	int mnemonic;

	/**
	 * the action command string for the button
	 */
	String actionCommand;

	/**
	 * Flag that indicates that this is a menu item
	 */
	boolean menuItem;

}
