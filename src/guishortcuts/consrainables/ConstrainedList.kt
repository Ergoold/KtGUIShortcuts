package guishortcuts.consrainables

import guishortcuts.*
import java.awt.GridBagConstraints
import javax.swing.*

/**
 * A list with GridBagConstraints.
 */
class ConstrainedList(text: Array<String>): JList<String>(text.toListModel()), Constrainable {
    /**
     * This list's GridBagConstraints.
     */
    override val GBC: GridBagConstraints = GridBagConstraints()
    
    /**
     * This list's listModel.
     */
    private var listModel = DefaultListModel<String>()
    
    /**
     * Instantiate the listModel and set the JLabel's list to it.
     */
    init {
        listModel = text.toListModel()
        model = listModel
    }
    
    /**
     * Add this list to a frame.
     *
     * @param frame the frame this list will be added to.
     */
    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }
    
    /**
     * Add an action listener to this list.
     *
     * @param func the function to execute when this list's selected value is changed.
     */
    infix fun does(func: () -> Unit) {
        addListSelectionListener {
            if(!valueIsAdjusting) func()
        }
    }
    
    /**
     * Get the current selected item.
     *
     * @param kind must be equal to the variable item.
     *
     * @return the current selected item.
     */
    infix fun selected(kind: Int): String {
        if(kind != item) throw Exception("Use 'item' when attempting to get selected list item")
        return selectedValue
    }
    
    /**
     * Get the current selected item's index.
     *
     * @param kind must be equal to the variable index.
     *
     * @return the current selected item's index.
     */
    infix fun selected(kind: Double): Int {
        if(kind != index) throw Exception("Use 'index' when attempting to get selected list item's index")
        return selectedIndex
    }
    
    /**
     * Add an item to this list.
     *
     * @param item the item to add.
     */
    infix fun add(item: String) {
        listModel.addElement(item)
        model = listModel
    }
    
    /**
     * Remove an item from this list.
     *
     * @param item the item to remove.
     */
    infix fun remove(item: String) {
        listModel.removeElement(item)
        model = listModel
    }
    
    /**
     * Add multiple items to this list.
     *
     * @param items an array of the items to add.
     */
    infix fun add(items: Array<String>) {
        items.forEach {this add it}
        model = listModel
    }
    
    /**
     * Remove multiple items from this list.
     *
     * @param items an array of the items to remove.
     */
    infix fun remove(items: Array<String>) {
        items.forEach {this remove it}
        model = listModel
    }
}

val single = 0
val interval = 1
val free = 2
val item = 3
val index = 0.0

/**
 * This function is purely for cosmetic purposes.
 *
 * @param list the list to return.
 *
 * @return the list it eas given.
 */
infix fun Int.add(list: ConstrainedList): ConstrainedList {
    return list
}

/**
 * Enable the list.
 * Int must be equal to the variable make.
 *
 * @param list the list to enable.
 */
infix fun Int.enabled(list: ConstrainedList) {
    if(this != make) throw Exception("Use 'make' when attempting to set component isEnabled")
    list.isEnabled = true
}

/**
 * Disable the list.
 * Int must be equal to the variable make.
 *
 * @param list the list to disable.
 */
infix fun Int.disabled(list: ConstrainedList) {
    if(this != make) throw Exception("Use 'make' when attempting to set component isEnabled")
    list.isEnabled = false
}

/**
 * Change the list's selection mode.
 * Int must be one of:
 * - single: the user may only select a single item.
 * - interval: the user may select multiple items that are in adjacent places on the list.
 * - free: the user may multiple items with no restrictions.
 *
 * @param list the list to change the selection mode of.
 */
infix fun Int.selection(list: ConstrainedList) {
    when (this) {
        single -> list.selectionMode = ListSelectionModel.SINGLE_SELECTION
        interval -> list.selectionMode = ListSelectionModel.SINGLE_INTERVAL_SELECTION
        free -> list.selectionMode = ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
        else -> throw Exception("Specify a selection mode when attempting to set it.")
    }
}

/**
 * Turn this array into a DefaultListModel.
 *
 * @return a DefaultListModel containing the array's elements.
 */
fun Array<String>.toListModel(): DefaultListModel<String> {
    val listModel = DefaultListModel<String>()
    this.forEach {listModel.addElement(it)}
    return listModel
}

/**
 * An alias for the items function.
 */
fun items(vararg item: String) = options(*item)
