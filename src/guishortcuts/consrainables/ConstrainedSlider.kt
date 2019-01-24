package guishortcuts.consrainables

import java.awt.GridBagConstraints
import javax.swing.*

class ConstrainedSlider(min: Int, max: Int): JSlider(min, max), Constrainable {
    override val GBC: GridBagConstraints = GridBagConstraints()

    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }
}

infix fun Int.add(slider: ConstrainedSlider): ConstrainedSlider {
    return slider
}

infix fun Int.horizontal(slider: ConstrainedSlider): ConstrainedSlider {
    slider.orientation = JSlider.HORIZONTAL
    return slider
}
