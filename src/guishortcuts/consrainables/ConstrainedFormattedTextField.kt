package guishortcuts.consrainables

import guishortcuts.IllegalKeywordException
import java.awt.GridBagConstraints
import javax.swing.*
import guishortcuts.*
import javax.swing.event.*
import javax.swing.text.MaskFormatter

/**
 * A formatted text field with GridBagConstraints.
 */
class ConstrainedFormattedTextField(format: MaskFormatter): JFormattedTextField(format), Constrainable {
    /**
     * This formatted text field's GridBagConstraints.
     */
    override val GBC = GridBagConstraints()
    
    /**
     * Add this formatted text field to a frame.
     *
     * @param frame the frame to add this formatted text field to.
     */
    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }
    
    /**
     * Set this formatted text field's content.
     *
     * @param text the text to set this formatted text field's content to.
     */
    infix fun set(text: String) {
        this.text = text
    }
    
    /**
     * Set this formatted text field's width in columns.
     *
     * @param cols the formatted text field's new width in columns.
     */
    infix fun set(cols: Int) {
        this.columns = cols
    }
    
    /**
     * Get this formatted text field's content.
     *
     * @param kw must be equal to the variable content.
     *
     * @return the content of this formatted text field.
     *
     * @throws IllegalKeywordException
     */
    infix fun get(kw: Int): String {
        if(kw != content) throw IllegalKeywordException("Use 'content' when getting the content from a text field")
        return text
    }
    
    /**
     * Change the alignment of content in the formatted text field.
     * Parameter must be equal to one of the following variables:
     * start: The start of the formatted text field.
     * center: The center of the formatted text field.
     * end: The end of the formatted text field.
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
     * Add a document listener to this text field.
     *
     * @param func the function to execute when this text field's content is changed.
     */
    infix fun does(func: () -> Unit) {
        document.addDocumentListener(object: DocumentListener {
            override fun changedUpdate(p0: DocumentEvent?) {
                func()
            }
            
            override fun insertUpdate(p0: DocumentEvent?) {
                func()
            }
            
            override fun removeUpdate(p0: DocumentEvent?) {
                func()
            }
        })
    }
}

/**
 * This function is purely for cosmetic purposes.
 *
 * @param formattedtextfield the formatted text field to return.
 *
 * @return the formatted text field it was given.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.add(formattedtextfield: ConstrainedFormattedTextField): ConstrainedFormattedTextField {
    if(this != window) throw IllegalKeywordException("Use 'window' when attempting to add a component to a frame")
    return formattedtextfield
}

/**
 * Enable the formatted text field.
 * Int must be equal to the variable make.
 *
 * @param formattedtextfield the text field to enable.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.enabled(formattedtextfield: ConstrainedFormattedTextField) {
    if(this != make) throw IllegalKeywordException("Use 'make' to make components enabled or disabled")
    formattedtextfield.isEditable = true
}

/**
 * Disable the formatted text field.
 * Int must be equal to the variable make.
 *
 * @param textfield the formatted text field to disable.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.disabled(formattedtextfield: ConstrainedFormattedTextField) {
    if(this != make) throw IllegalKeywordException("Use 'make' to make components enabled or disabled")
    formattedtextfield.isEditable = false
}

/**
 * Create a formatted text field.
 * Int must be equal to the variable create.
 *
 * @param format the the format of the formatted text field's comments.
 *
 * @return a ConstrainedFormattedTextField with the supplied format.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.textfield(format: MaskFormatter): ConstrainedFormattedTextField {
    if(this != create) throw Exception("Use 'create' when creating components")
    return ConstrainedFormattedTextField(format)
}

/**
 * Create a new format to use with FormattedTextFields.
 *
 * @param format a format string.
 *
 * @return a MaskFormatter matching the given FormattedString.
 */
fun format(format: String): MaskFormatter {
    return MaskFormatter(format)
}
