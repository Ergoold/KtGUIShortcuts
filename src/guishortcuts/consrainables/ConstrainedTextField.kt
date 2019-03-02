package guishortcuts.consrainables

import guishortcuts.*
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
     * Set this text field's width in columns.
     *
     * @param cols the text field's new width in columns.
     */
    infix fun set(cols: Int) {
        this.columns = cols
    }
    
    /**
     * Get this text field's content.
     *
     * @param kw must be equal to the variable content.
     *
     * @return the content of this text field.
     *
     * @throws IllegalKeywordException
     */
    fun get(kw: Int): String {
        if(kw != content) throw IllegalKeywordException("Use 'text' when getting the text from a text field")
        return text
    }
    
    /**
     * Change the alignment of content in the text field.
     * Parameter must be equal to one of the following variables:
     * start: The start of the text field.
     * center: The center of the text field.
     * end: The end of the text field.
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
}

const val content = 0
const val start = 1
const val center = 2
const val end = 3

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
 * @param cols the int to return.
 *
 * @return the int it was given.
 */
fun width(cols: Int): Int {
    return cols
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
 *
 * @throws IllegalKeywordException
 */
infix fun Int.enabled(textfield: ConstrainedTextField) {
    if(this != make) throw IllegalKeywordException("Use 'make' to make components enabled or disabled")
    textfield.isEditable = true
}

/**
 * Disable the text field.
 * Int must be equal to the variable make.
 *
 * @param textfield the text field to disable.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.disabled(textfield: ConstrainedTextField) {
    if(this != make) throw IllegalKeywordException("Use 'make' to make components enabled or disabled")
    textfield.isEditable = false
}
