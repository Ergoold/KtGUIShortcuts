# KtGUIShortcuts
KtGUIShortcuts is a swing-based DSL for creating GUIs in kotlin.

## example
This is a simple example of a program showing a `frame` with a `label` containing the text `Hello, World!`:
```kotlin
package yourPackage

import guishortcuts.*
import guishortcuts.consrainables.*

fun main(args: Array<String>) {
    val myFrame = create frame "Hello, World!"
    window init myFrame

    val myLabel = create label "Hello, World!"
    window add myLabel to myFrame

    myFrame set size(320, 180)
}

```

### Breakdown
```kotlin
package yourPackage
```
The first line is a `package` statement, like you are already familiar with if you program in kotlin. If you don't know kotlin, I highly suggest [checking it out](http://kotlinlang.org/).

```kotlin
import guishortcuts.*
import guishortcuts.constrainables.*
```
These are `import` statements that import the guishortcuts package and its subpackage, constrainables. This is necessary for writing code with KtGUIShortcuts.

#### Inside the main function
```kotlin
val myFrame = create frame "Hello, World!"
window init myFrame
```
These statements create and instantiate a `frame` called `myFrame` with the title `Hello, World!`. When initiated with `window init <frame>`, the `frame` is automatically displayed. However, you won't see it on screen if you run the program now. This is because there are no `component`s on the `frame`, and the `init` command `pack`s the frame - sets its size to the exact size all of the `component`s inside need. There are currently no `component`s, so the `frame` has no width or height. While you could negate this problem by adding `component`s to the `frame` before initiating, I highly recommend you do it in this order so that you can control your `frame`'s size more easily later on.

```kotlin
val myLabel = create label "Hello, World!"
window add myLabel to myFrame
```
These statements create a `label` with the text `Hello, World` and call it `myLabel`, then add it to `myFrame`, the `frame` we created earlier. A `label` is the simpelest type of `component` in KtGUIShortcuts, which just display the text you give them.

```kotlin
myFrame set size(320, 180)
```
This last statement in the main function sets the size of `myFrame` to 320 pixels wide by 180 pixels tall. We recommend putting this statement at the end of your program, so that you aren't concerned by the size of your `frame` during the creation of the `component`s.

There are some alternatives to `set size`, which affect the window size in different ways.

##### Alternatives to `set size`:
```kotlin
window pack myFrame
```
This `pack`s the `frame`, which as we discussed, sets the `frame`'s size to exactly the amount of space all of it's components need.

```kotlin
full screen myFrame
```
This will make `myFrame` fullscreen.

## Basic Usage
### Components
#### Creating components
To create a component in KtGUIShortcuts, use the following code:
```kotlin
val <componentName> = create <component> <args>
```

#### Adding a component to another component
If you want to add a component to another component (usually a panel or frame), the following code is used:
```kotlin
window add <component> to <parent>
```

#### Adding constraints to a component
KtGUIShortcuts automatically creates your `frame` with a `GridBagLayout`. This layout allows components to be constrained in several ways, and this is a highly recommended way to refine the look of your programs.
```kotlin
<component> constrain <constraint>
```

`constraint`s can be one of several things:
```kotlin
constraints(<col>, <row>, <width>, <height>, <colweight>, <rowweight>)
```
```kotlin
constraints(<col>, <row>, <width>, <height>)
```
```kotlin
coordinates(<col>, <row>)
coords(<col>, <row>)
```
```kotlin
cells(<width>, <height>)
```
```kotlin
weights(<colweight>, <rowweight>)
```
`<width>` and `<height>` are always in grid cells.

You can also set each constraint individually:
```kotlin
col(<col>)
```
```kotlin
row(<row>)
```
```kotlin
colweight(<colweight>)
```
```kotlin
rowweight(<rowweight>)
```

I recommend you use `coordinates`, `cells` and `weights` individually to set constraints for your components.
