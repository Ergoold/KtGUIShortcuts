package guishortcuts.consrainables

import java.awt.GridBagConstraints
import javax.swing.*

class ConstrainedSlider(min: Int, max: Int): JSlider(min, max), Constrainable {
    override val GBC: GridBagConstraints = GridBagConstraints()

    infix fun to(frame: JFrame) {
        frame.add(this, GBC)
    }

    infix fun set(to: Int) {
        value = to
    }

    infix fun label(action: Int) {
        paintLabels = action == enable
    }

    infix fun ticks(action: Int) {
        paintTicks = action == enable
    }
}

val disable = 0
val enable = 1

infix fun Int.add(slider: ConstrainedSlider): ConstrainedSlider {
    return slider
}

infix fun Int.horizontal(slider: ConstrainedSlider): ConstrainedSlider {
    slider.orientation = JSlider.HORIZONTAL
    return slider
}

infix fun Int.vertical(slider: ConstrainedSlider): ConstrainedSlider {
    slider.orientation = JSlider.VERTICAL
    return slider
}
