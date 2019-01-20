package guishortcuts

import java.awt.GridBagConstraints
import javax.swing.*

class ConstrainedCheckbox(text: String): JCheckBox(text), Constrainable {
    override val GBC: GridBagConstraints = GridBagConstraints()

    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }

    infix fun does(func: () -> Unit) {
        addActionListener {func()}
    }
}

infix fun Int.add(checkbox: ConstrainedCheckbox): ConstrainedCheckbox {
    return checkbox
}

infix fun Int.enabled(checkbox: ConstrainedCheckbox) {
    if(this != make) throw Exception("Use 'make' when attempting to set component isEnabled")
    checkbox.isEnabled = true
}

infix fun Int.disabled(checkbox: ConstrainedCheckbox) {
    if(this != make) throw Exception("Use 'make' when attempting to set component isEnabled")
    checkbox.isEnabled = false
}

infix fun Int.selected(checkbox: ConstrainedCheckbox) {
    if(this != make) throw Exception("Use 'make' when attempting to set component isSelected")
    checkbox.isSelected = true
}

infix fun Int.deselected(checkbox: ConstrainedCheckbox) {
    if(this != make) throw Exception("Use 'make' when attempting to set component isSelected")
    checkbox.isSelected = false
}
