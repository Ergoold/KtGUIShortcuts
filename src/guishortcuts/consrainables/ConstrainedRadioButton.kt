package guishortcuts.consrainables

import guishortcuts.make
import java.awt.GridBagConstraints
import javax.swing.*

class ConstrainedRadioButton(text: String): JRadioButton(text), Constrainable {
    override val GBC: GridBagConstraints = GridBagConstraints()

    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }

    infix fun does(func: () -> Unit) {
        addActionListener {func()}
    }
}

infix fun Int.add(radiobutton: ConstrainedRadioButton): ConstrainedRadioButton {
    return radiobutton
}

infix fun Int.enabled(radiobutton: ConstrainedRadioButton) {
    if(this != make) throw Exception("Use 'make' when attempting to set component isEnabled")
    radiobutton.isEnabled = true
}

infix fun Int.disabled(radiobutton: ConstrainedRadioButton) {
    if(this != make) throw Exception("Use 'make' when attempting to set component isEnabled")
    radiobutton.isEnabled = false
}

infix fun Int.selected(radiobutton: ConstrainedRadioButton) {
    if(this != make) throw Exception("Use 'make' when attempting to set component isSelected")
    radiobutton.isSelected = true
}

infix fun Int.deselected(radiobutton: ConstrainedRadioButton) {
    if(this != make) throw Exception("Use 'make' when attempting to set component isSelected")
    radiobutton.isSelected = false
}

