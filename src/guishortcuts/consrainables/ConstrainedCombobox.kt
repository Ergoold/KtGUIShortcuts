package guishortcuts.consrainables

import guishortcuts.make
import java.awt.GridBagConstraints
import javax.swing.*

class ConstrainedCombobox(text: Array<String>): JComboBox<String>(text), Constrainable {
    override val GBC: GridBagConstraints = GridBagConstraints()

    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }

    infix fun does(func: () -> Unit) {
        addActionListener {func()}
    }

    infix fun select(item: String) {
        selectedItem = item
    }

    infix fun select(index: Int) {
        selectedIndex = index
    }
}

infix fun Int.add(combobox: ConstrainedCombobox): ConstrainedCombobox {
    return combobox
}

infix fun Int.enabled(combobox: ConstrainedCombobox) {
    if(this != make) throw Exception("Use 'make' when attempting to set component isEnabled")
    combobox.isEnabled = true
}

infix fun Int.disabled(combobox: ConstrainedCombobox) {
    if(this != make) throw Exception("Use 'make' when attempting to set component isEnabled")
    combobox.isEnabled = false
}
