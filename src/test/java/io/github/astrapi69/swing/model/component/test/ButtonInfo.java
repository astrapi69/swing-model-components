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
