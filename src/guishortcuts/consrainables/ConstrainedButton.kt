package guishortcuts.consrainables

import guishortcuts.make
import java.awt.GridBagConstraints
import javax.swing.*

class ConstrainedButton(text: String): JButton(text), Constrainable {
    override val GBC: GridBagConstraints = GridBagConstraints()

    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }

    infix fun does(func: () -> Unit) {
        addActionListener {func()}
    }
}

infix fun Int.add(button: ConstrainedButton): ConstrainedButton {
    return button
}

infix fun Int.enabled(button: ConstrainedButton) {
    if(this != make) throw Exception("Use 'make' when attempting to set component isEnabled")
    button.isEnabled = true
}

infix fun Int.disabled(button: ConstrainedButton) {
    if(this != make) throw Exception("Use 'make' when attempting to set component isEnabled")
    button.isEnabled = false
}
