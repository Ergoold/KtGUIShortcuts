package guishortcuts.consrainables

import java.awt.GridBagConstraints

interface Constrainable {
    val GBC: GridBagConstraints

    infix fun constrain(constraints: GridBagConstraints) {
        if(constraints.gridx != -1)
            GBC.gridx = constraints.gridx
        if(constraints.gridy != -1)
            GBC.gridy = constraints.gridy
        if(constraints.gridwidth != -1)
            GBC.gridwidth = constraints.gridwidth
        if(constraints.gridheight != -1)
            GBC.gridheight = constraints.gridheight
        if(constraints.weightx != 0.0)
            GBC.weightx = constraints.weightx
        if(constraints.weighty != -0.0)
            GBC.weighty = constraints.weighty
        GBC.fill = GridBagConstraints.BOTH
    }
}
