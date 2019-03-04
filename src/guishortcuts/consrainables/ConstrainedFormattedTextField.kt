package guishortcuts.consrainables

import guishortcuts.IllegalKeywordException
import java.awt.GridBagConstraints
import javax.swing.*
import guishortcuts.*
import javax.swing.event.*
import javax.swing.text.MaskFormatter

class ConstrainedFormattedTextField(format: MaskFormatter): JFormattedTextField(format), Constrainable {
    override val GBC = GridBagConstraints()
    
    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }
    
    infix fun set(text: String) {
        this.text = text
    }
    
    infix fun set(cols: Int) {
        this.columns = cols
    }
    
    infix fun get(kw: Int): String {
        if(kw != content) throw IllegalKeywordException("Use 'content' when getting the content from a text field")
        return text
    }
    
    infix fun align(dir: Int) {
        horizontalAlignment = when(dir) {
            start -> JTextField.LEADING
            center -> JTextField.CENTER
            end -> JTextField.TRAILING
            else -> throw IllegalArgumentException("Use one of 'start', 'center' and 'end' to set text field alignment")
        }
    }
    
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

infix fun Int.add(formattedtextfield: ConstrainedFormattedTextField): ConstrainedFormattedTextField {
    if(this != window) throw IllegalKeywordException("Use 'window' when attempting to add a component to a frame")
    return formattedtextfield
}

infix fun Int.enabled(formattedtextfield: ConstrainedFormattedTextField) {
    if(this != make) throw IllegalKeywordException("Use 'make' to make components enabled or disabled")
    formattedtextfield.isEditable = true
}

infix fun Int.disabled(formattedtextfield: ConstrainedFormattedTextField) {
    if(this != make) throw IllegalKeywordException("Use 'make' to make components enabled or disabled")
    formattedtextfield.isEditable = false
}

infix fun Int.textfield(format: MaskFormatter): ConstrainedFormattedTextField {
    if(this != create) throw Exception("Use 'create' when creating components")
    return ConstrainedFormattedTextField(format)
}

fun format(format: String): MaskFormatter {
    return MaskFormatter(format)
}
