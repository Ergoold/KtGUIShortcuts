package guishortcuts.consrainables

import guishortcuts.*
import java.awt.GridBagConstraints
import java.util.*
import javax.swing.*

/**
 * A password field with GridBagConstraints.
 */
class ConstrainedPasswordField(text: String): JPasswordField(text), Constrainable {
    /**
     * This password field's GridBagConstraints.
     */
    override val GBC = GridBagConstraints()
    
    /**
     * Add this password field to a frame.
     *
     * @param frame the frame to add this password field to.
     */
    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }
    
    /**
     * Set this text field's width in columns.
     *
     * @param cols the text field's new width in columns.
     */
    infix fun set(cols: Int) {
        this.columns = cols
    }
    
    /**
     * Get this password field's content.
     *
     * @param kw must be equal to the variable content.
     *
     * @return the content of this password field.
     *
     * @throws IllegalKeywordException
     */
    infix fun get(kw: Int): String {
        if(kw != content) throw IllegalKeywordException("Use 'content' when getting the content from a password field")
        return Arrays.toString(password)
    }
    
    /**
     * Change the alignment of content in the password field.
     * Parameter must be equal to one of the following variables:
     * start: The start of the password field.
     * center: The center of the password field.
     * end: The end of the password field.
     *
     * @param dir the alignment of the content (start, end or center).
     *
     * @throws IllegalArgumentException
     */
    infix fun align(dir: Int) {
        horizontalAlignment = when(dir) {
            start -> JTextField.LEADING
            center -> JTextField.CENTER
            end -> JTextField.TRAILING
            else -> throw IllegalArgumentException("Use one of 'start', 'center' and 'end' to set text field alignment")
        }
    }
    
    /**
     * Set the character that will be displayed as placeholder for the actual content.
     *
     * @param char the placeholder character.
     */
    infix fun set(char: Char) {
        echoChar = char
    }
    
    /**
     * Add an action listener to this password field.
     *
     * @param func the function to be executed when the password field's content is changed.
     */
    infix fun does(func: () -> Unit) {
        addActionListener {func()}
    }
}

/**
 * This function is purely for cosmetic purposes.
 *
 * @param passwordfield the password field to return.
 *
 * @return the password field it was given.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.add(passwordfield: ConstrainedPasswordField): ConstrainedPasswordField {
    if(this != window) throw IllegalKeywordException("Use 'window' when attempting to add a component to a frame")
    return passwordfield
}


/**
 * Enable the password field.
 * Int must be equal to the variable make.
 *
 * @param passwordfield the password field to enable.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.enabled(passwordfield: ConstrainedPasswordField) {
    if(this != make) throw IllegalKeywordException("Use 'make' to make components enabled or disabled")
    passwordfield.isEditable = true
}

/**
 * Disable the password field.
 * Int must be equal to the variable make.
 *
 * @param passwordfield the password field to disable.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.disabled(passwordfield: ConstrainedPasswordField) {
    if(this != make) throw IllegalKeywordException("Use 'make' to make components enabled or disabled")
    passwordfield.isEditable = false
}

/**
 * Create a password field.
 * Int must be equal to the variable create.
 *
 * @param content the initial content of the text field.
 *
 * @return a ConstrainedPasswordField with the supplied content.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.passwordfield(content: String): ConstrainedPasswordField {
    if(this != create) throw Exception("Use 'create' when creating components")
    val passwordfield = ConstrainedPasswordField(content)
    return passwordfield
}
