package guishortcuts.consrainables

import guishortcuts.make
import java.awt.GridBagConstraints
import javax.swing.*
import kotlin.Exception

/**
 * A text field with GridBagConstraints.
 */
class ConstrainedTextField(text: String): JTextField(text), Constrainable {
    /**
     * This text field's GridBagConstraints.
     */
    override val GBC: GridBagConstraints = GridBagConstraints()
    
    /**
     * Add this text field to a frame.
     *
     * @param frame the frame to add this text field to.
     */
    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }
    
    /**
     * Set this text field's content.
     *
     * @param text the text to set this text field's content to.
     */
    infix fun set(text: String) {
        this.text = text
    }
    
    /**
     * Get this text field's content.
     *
     * @param kw must be equal to the variable content.
     *
     * @return the content of this text field.
     */
    fun get(kw: Int): String {
        if(kw != content) throw Exception("Use 'text' when getting the text from a text field")
        return text
    }
}

const val content = 0

/**
 * This function is purely for cosmetic purposes.
 *
 * @param text the string to return.
 *
 * @return the string it was given.
 */
fun content(text: String): String {
    return text
}

/**
 * This function is purely for cosmetic purposes.
 *
 * @param textfield the text field to return.
 *
 * @return the text field it was given.
 */
infix fun Int.add(textfield: ConstrainedTextField): ConstrainedTextField {
    return textfield
}

/**
 * Enable the text field.
 * Int must be equal to the variable make.
 *
 * @param textfield the text field to enable.
 */
infix fun Int.enabled(textfield: ConstrainedTextField) {
    if(this != make) throw Exception("Use 'make' to make components enabled or disabled")
    textfield.isEditable = true
}

/**
 * Disable the text field.
 * Int must be equal to the variable make.
 *
 * @param textfield the text field to disable.
 */
infix fun Int.disabled(textfield: ConstrainedTextField) {
    if(this != make) throw Exception("Use 'make' to make components enabled or disabled")
    textfield.isEditable = false
}
