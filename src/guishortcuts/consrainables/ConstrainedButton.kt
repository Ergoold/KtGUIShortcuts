package guishortcuts.consrainables

import guishortcuts.*
import java.awt.GridBagConstraints
import javax.swing.*

/**
 * A button with GridBagConstraints.
 */
class ConstrainedButton(text: String): JButton(text), Constrainable {
    /**
     * This button's GridBagConstrains.
     */
    override val GBC: GridBagConstraints = GridBagConstraints()
    
    /**
     * Add this button to a frame.
     *
     * @param frame the frame this button will be added to.
     */
    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }
    
    /**
     * Add an action listener to this button.
     *
     * @param func the function to be executed when the button is pressed.
     */
    infix fun does(func: () -> Unit) {
        addActionListener {func()}
    }
}

/**
 * This function is purely for cosmetic purposes.
 *
 * @param button the button to be returned.
 *
 * @return the button it was given.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.add(button: ConstrainedButton): ConstrainedButton {
    if(this != window) throw IllegalKeywordException("Use 'window' when attempting to add a component to a frame")
    return button
}

/**
 * Enable the button.
 * Int must equal to the variable make.
 *
 * @param button the button to enable.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.enabled(button: ConstrainedButton) {
    if(this != make) throw IllegalKeywordException("Use 'make' when attempting to set component isEnabled")
    button.isEnabled = true
}

/**
 * Disable the button. Int must equal to the variable make.
 *
 * @param button the button to disable.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.disabled(button: ConstrainedButton) {
    if(this != make) throw IllegalKeywordException("Use 'make' when attempting to set component isEnabled")
    button.isEnabled = false
}

/**
 * Create a button.
 * Int must be equal to the variable create.
 *
 * @param text the text on the created button.
 *
 * @return a ConstrainedButton with the supplied text.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.button(text: String): ConstrainedButton {
    if(this != create) throw Exception("Use 'create' when creating components")
    return ConstrainedButton(text)
}
