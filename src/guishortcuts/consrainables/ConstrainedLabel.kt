package guishortcuts.consrainables

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
 */
infix fun Int.add(label: ConstrainedLabel): ConstrainedLabel {
    return label
}
