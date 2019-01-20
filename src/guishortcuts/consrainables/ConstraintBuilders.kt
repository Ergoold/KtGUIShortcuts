package guishortcuts.consrainables

import java.awt.GridBagConstraints

fun constraints(col: Int, row: Int, width: Int, height: Int, colweight: Double, rowweight: Double): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.gridx = col
    GBC.gridy = row
    GBC.gridwidth = width
    GBC.gridheight = height
    GBC.weightx = colweight
    GBC.weighty = rowweight

    return GBC
}

fun constraints(col: Int, row: Int, width: Int, height: Int, colweight: Int, rowweight: Int): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.gridx = col
    GBC.gridy = row
    GBC.gridwidth = width
    GBC.gridheight = height
    GBC.weightx = colweight.toDouble()
    GBC.weighty = rowweight.toDouble()

    return GBC
}

fun constraints(col: Int, row: Int, width: Int, height: Int): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.gridx = col
    GBC.gridy = row
    GBC.gridwidth = width
    GBC.gridheight = height

    return GBC
}

fun coordinates(col: Int, row: Int): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.gridx = col
    GBC.gridy = row

    GBC.gridwidth = -1
    GBC.gridheight = -1

    return GBC
}

fun coords(col: Int, row: Int): GridBagConstraints = coordinates(col, row)

fun cells(width: Int, height: Int): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.gridwidth = width
    GBC.gridheight = height

    return GBC
}

fun weights(colweight: Double, rowweight: Double): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.weightx = colweight
    GBC.weighty = rowweight

    GBC.gridwidth = -1
    GBC.gridheight = -1

    return GBC
}

fun weights(colweight: Int, rowweight: Int): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.weightx = colweight.toDouble()
    GBC.weighty = rowweight.toDouble()

    GBC.gridwidth = -1
    GBC.gridheight = -1

    return GBC
}

fun col(col: Int): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.gridx = col

    GBC.gridwidth = -1
    GBC.gridheight = -1

    return GBC
}

fun row(row: Int): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.gridy = row

    GBC.gridwidth = -1
    GBC.gridheight = -1

    return GBC
}

fun colweight(colweight: Int): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.weightx = colweight.toDouble()

    GBC.gridwidth = -1
    GBC.gridheight = -1

    return GBC
}

fun rowweight(rowweight: Int): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.weighty = rowweight.toDouble()

    GBC.gridwidth = -1
    GBC.gridheight = -1

    return GBC
}

fun colweight(colweight: Double): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.weightx = colweight

    GBC.gridwidth = -1
    GBC.gridheight = -1

    return GBC
}

fun rowweight(rowweight: Double): GridBagConstraints {
    val GBC = GridBagConstraints()

    GBC.weighty = rowweight

    GBC.gridwidth = -1
    GBC.gridheight = -1

    return GBC
}
