package guishortcuts

import java.awt.GridBagConstraints
import javax.swing.*

class ConstrainedLabel(text: String): JLabel(text), Constrainable {
    override val GBC: GridBagConstraints = GridBagConstraints()

    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }
}

infix fun Int.add(label: ConstrainedLabel): ConstrainedLabel {
    return label
}
