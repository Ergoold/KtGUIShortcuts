package guishortcuts.consrainables

import guishortcuts.*
import java.awt.GridBagConstraints
import javax.swing.*

/**
 * A label with GridBagConstraints.
 */
class ConstrainedLabel(text: String): JLabel(text), Constrainable {
    /**
     * This label's GridBagConstraints.
     */
    override val GBC: GridBagConstraints = GridBagConstraints()
    
    /**
     * Add this label to a frame.
     *
     * @param frame th frame to add this label to.
     */
    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }
}

/**
 * This function is purely for cosmetic purposes.
 *
 * @param label the label to return.
 *
 * @return the label it was given.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.add(label: ConstrainedLabel): ConstrainedLabel {
    if(this != window) throw IllegalKeywordException("Use 'window' when attempting to add a component to a frame")
    return label
}

/**
 * Create a label.
 * Int must be equal to the variable create.
 *
 * @param text the text on the created label.
 *
 * @return a ConstrainedLabel with the supplied text.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.label(text: String): ConstrainedLabel {
    if(this != create) throw Exception("Use 'create' when creating components")
    return ConstrainedLabel(text)
}
