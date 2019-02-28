package guishortcuts.consrainables

import java.awt.GridBagConstraints
import javax.swing.*

/**
 * A spinner with GridBagConstraints.
 */
class ConstrainedSpinner(text: Array<String>): JSpinner(text.toSpinnerModel()), Constrainable {
    /**
     * This spinner's GridBagConstraints.
     */
    override val GBC: GridBagConstraints = GridBagConstraints()
    
    /**
     * Add this spinner to a frame.
     *
     * @param frame the frame this spinner will be added to.
     */
    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }
    
    /**
     * Add an action listener to this spinner.
     *
     * @param func the function to execute when this spinner's value is changed.
     */
    infix fun does(func: () -> Unit) {
        addChangeListener {
            func()
        }
    }
    
    /**
     * Get the current selected item.
     *
     * @param kind must be equal to the variable item.
     *
     * @return The current selected item.
     */
    infix fun selected(kind: Int): String {
        if(kind != item) throw Exception("Use 'item' when attempting to get selected spinner item")
        return (model as SpinnerListModel).value.toString()
    }
}

/**
 * This function is purely for cosmetic purposes.
 *
 * @param spinner the list to return.
 *
 * @return the spinner it was given.
 */
infix fun Int.add(spinner: ConstrainedSpinner): ConstrainedSpinner {
    return spinner
}

/**
 * Turn this array into a SpinnerListModel.
 *
 * @return a SpinnerListModel containing the array's elements.
 */
fun Array<String>.toSpinnerModel(): SpinnerListModel {
    return SpinnerListModel(this)
}
