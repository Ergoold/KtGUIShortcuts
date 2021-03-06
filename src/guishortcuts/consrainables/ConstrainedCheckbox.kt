package guishortcuts.consrainables

import guishortcuts.*
import java.awt.GridBagConstraints
import javax.swing.*

/**
 * A checkbox with GridBagConstraints.
 */
class ConstrainedCheckbox(text: String): JCheckBox(text), Constrainable {
    /**
     * This checkbox's GridBagConstrains.
     */
    override val GBC: GridBagConstraints = GridBagConstraints()
    
    /**
     * Add this checkbox to a frame.
     *
     * @param frame the frame this checkbox will be added to.
     */
    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }
    
    /**
     * Add an action listener to this checkbox.
     *
     * @param func the function to execute when this checkbox is toggled.
     */
    infix fun does(func: () -> Unit) {
        addActionListener {func()}
    }
}

/**
 * This function is purely for cosmetic purposes.
 *
 * @param checkbox the checkbox to return.
 *
 * @return the checkbox it was given.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.add(checkbox: ConstrainedCheckbox): ConstrainedCheckbox {
    if(this != window) throw IllegalKeywordException("Use 'window' when attempting to add a component to a frame")
    return checkbox
}

/**
 * Enable the checkbox.
 * Int must equal to the variable make.
 *
 * @param checkbox the checkbox to enable.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.enabled(checkbox: ConstrainedCheckbox) {
    if(this != make) throw IllegalKeywordException("Use 'make' when attempting to set component isEnabled")
    checkbox.isEnabled = true
}

/**
 * Disable the checkbox.
 * Int must be equal to the variable make.
 *
 * @param checkbox the checkbox to disable.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.disabled(checkbox: ConstrainedCheckbox) {
    if(this != make) throw IllegalKeywordException("Use 'make' when attempting to set component isEnabled")
    checkbox.isEnabled = false
}

/**
 * Make the checkbox selected.
 * Int must be equal to the variable make.
 *
 * @param checkbox the checkbox to make selected.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.selected(checkbox: ConstrainedCheckbox) {
    if(this != make) throw IllegalKeywordException("Use 'make' when attempting to set component isSelected")
    checkbox.isSelected = true
}

/**
 * Make the checkbox deselected.
 * Int must be equal to the variable make.
 *
 * @param checkbox the checkbox to make deselected.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.deselected(checkbox: ConstrainedCheckbox) {
    if(this != make) throw IllegalKeywordException("Use 'make' when attempting to set component isSelected")
    checkbox.isSelected = false
}

/**
 * Create a checkbox.
 * Int must be equal to the variable create.
 *
 * @param text the text on the created checkbox.
 *
 * @return a ConstrainedCheckbox with the supplied text.
 *
 * @throws IllegalKeywordException
 */
infix fun Int.checkbox(text: String): ConstrainedCheckbox {
    if(this != create) throw Exception("Use 'create' when creating components")
    return ConstrainedCheckbox(text)
}
