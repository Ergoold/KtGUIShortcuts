package guishortcuts.consrainables

import guishortcuts.*
import java.awt.GridBagConstraints
import javax.swing.*

/**
 * A combobox with GridBagConstraints.
 */
class ConstrainedCombobox(text: Array<String>): JComboBox<String>(text), Constrainable {
    /**
     * This combobox's GridBagConstraints.
     */
    override val GBC: GridBagConstraints = GridBagConstraints()
    
    /**
     * Add this combobox to a frame.
     *
     * @param frame the frame this checkbox will be added to.
     */
    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }
    
    /**
     * Add an action listener to this combobox.
     *
     * @param func the function to execute when this combobox is changed.
     */
    infix fun does(func: () -> Unit) {
        addActionListener {func()}
    }
    
    /**
     * Change the selected item.
     *
     * @param item the item to change to.
     */
    infix fun select(item: String) {
        selectedItem = item
    }
    
    /**
     * Change the selected item.
     *
     * @param index the index of the item to change to.
     */
    infix fun select(index: Int) {
        selectedIndex = index
    }
}

/**
 * This function is purely for cosmetic purposes.
 *
 * @param combobox the combobox to return.
 *
 * @return the combobox it was given.
 */
infix fun Int.add(combobox: ConstrainedCombobox): ConstrainedCombobox {
    return combobox
}

/**
 * Enable the combobox.
 * Int must be equal to the variable make.
 *
 * @param combobox the combobox to disable.
 */
infix fun Int.enabled(combobox: ConstrainedCombobox) {
    if(this != make) throw IllegalKeywordException("Use 'make' when attempting to set component isEnabled")
    combobox.isEnabled = true
}

/**
 * Disable the combobox.
 * Int must be equal to the variable make.
 *
 * @param combobox the combobox to disable.
 */
infix fun Int.disabled(combobox: ConstrainedCombobox) {
    if(this != make) throw IllegalKeywordException("Use 'make' when attempting to set component isEnabled")
    combobox.isEnabled = false
}
