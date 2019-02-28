package guishortcuts.consrainables

import guishortcuts.make
import java.awt.GridBagConstraints
import javax.swing.*

/**
 * A radio button with GridBagConstraints.
 */
class ConstrainedRadioButton(text: String): JRadioButton(text), Constrainable {
    /**
     * This radio button's GridBagConstraints.
     */
    override val GBC: GridBagConstraints = GridBagConstraints()
    
    /**
     * Add this radio button to a frame.
     *
     * @param frame the frame this radio button will be added to.
     */
    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }
    
    /**
     * Add this radio button to a radio button group.
     *
     * @param radioGroup the radio button group this radio button will be added to.
     */
    infix fun to(radioGroup: ButtonGroup) {
        radioGroup.add(this)
    }
    
    /**
     * Add an action listener to this radio button.
     *
     * @param func the function to execute when this radio button is toggled.
     */
    infix fun does(func: () -> Unit) {
        addActionListener {func()}
    }
}

/**
 * This function is properly for cosmetic purposes.
 *
 * @param radiobutton the radio button to return.
 *
 * @return the radio button it was given.
 */
infix fun Int.add(radiobutton: ConstrainedRadioButton): ConstrainedRadioButton {
    return radiobutton
}

/**
 * Enable the radio button.
 * Int must be equal to the variable make.
 *
 * @param radiobutton the radio button to enable.
 */
infix fun Int.enabled(radiobutton: ConstrainedRadioButton) {
    if(this != make) throw Exception("Use 'make' when attempting to set component isEnabled")
    radiobutton.isEnabled = true
}

/**
 * Disable the radio button.
 * Int must be equal to the variable make.
 *
 * @param radiobutton the radio button to disable.
 */
infix fun Int.disabled(radiobutton: ConstrainedRadioButton) {
    if(this != make) throw Exception("Use 'make' when attempting to set component isEnabled")
    radiobutton.isEnabled = false
}

/**
 * Make the radio button selected.
 * Int must be equal to the variable make.
 *
 * @param radiobutton the radio button to make selected.
 */
infix fun Int.selected(radiobutton: ConstrainedRadioButton) {
    if(this != make) throw Exception("Use 'make' when attempting to set component isSelected")
    radiobutton.isSelected = true
}

/**
 * Make the radio button deselected.
 * Int must be equal to the variable make.
 *
 * @param radiobutton the radio button to make deselected.
 */
infix fun Int.deselected(radiobutton: ConstrainedRadioButton) {
    if(this != make) throw Exception("Use 'make' when attempting to set component isSelected")
    radiobutton.isSelected = false
}
