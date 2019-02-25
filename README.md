# Constraint Utils
An easier way to add, remove and edit constraints and another ConstraintLayout properties;

## Install
Add this dependency from jCenter:
```gradle
compile 'UPDATE`PACKAGE`N`VERSION`HERE'
```

## Usage

### 1. Import the extension

```kotlin
import com.faogustavo.constraint.utils.modify
```
### 2. Call this function on your Constraint Layout
```kotlin
constraintLayout.modify {
    // Do your changes here
}
```

### 3. Modify your view
```kotlin
constraintLayout.modify {
    on(backgroundImage) {
        bottomToBottomOf(this.parent)
    }

    on(title) {
        unbind(ConstraintViewEditor.Side.LEFT)
        rightToLeftOf(this.parent, 16.dp)
    }

    on(description) {
        unbind(ConstraintViewEditor.Side.BOTTOM)
        topToBottomOf(this.parent)
    }

                    ...
}
```

### 4 Animate the changes if you want
```kotlin
constraintLayout.modify {
    
                    ...

    // Use the default transition type
    animated()

    // Or use a custom one
    val transition = ChangeBounds().apply {
        interpolator = BounceInterpolator()
        duration = 1200
    }
    withTransition(transition)
}
```


## Functions

### **On the ConstraintLayout**
### `modify (block: ConstraintEditor.() -> Unit)`
This is the simple way to start a modification on your constraint layout. Inside the block, you will have access to functions that allows you to modificate your view/views and animate the transaction;

### `modify (layoutId: Int, block: ConstraintEditor.() -> Unit)`
This is another way to start a modification. Passing the layout id as parameter allow you to clone the constraints from another layout;

### **On the ConstraintEditor context**
### `on(view: View, block: ConstraintViewEditor.() -> Unit)`
Start to modify a child view from a constraint layout;

### `on(viewId: int, block: ConstraintViewEditor.() -> Unit)`
Same from the method above, but using the ID instead of the view;

### `animated()`
Use the basic animation on the update from the view constraints;

### `withTransition(transition: Transition)`
Use a custom transition to animate the changes. You can also use a transition set. See the [Transition docs](https://developer.android.com/reference/android/transition/Transition);

### **On the ConstraintViewEditor context**
### `parent` attribute
This attribute from the ConstraintViewEditor is the ID of the constraint layout (_aka_ parent of inner views);

### `unbind(size: ConstraintViewEditor.Side)`
Remove one or more constraints from the view. Calling without a parameter will remove all constraints;

### `topToTopOf(anotherView: View, margin: Int)` and `topToTopOf(anotherView: Int, margin: Int)`
Bind the top of the editing view to the top of anotherView;

### `topToBottomOf(anotherView: View, margin: Int)` and `topToBottomOf(anotherView: Int, margin: Int)`
Bind the top of the editing view to the bottom of anotherView;

### `bottomToBottomOf(anotherView: View, margin: Int)` and `bottomToBottomOf(anotherView: Int, margin: Int)`
Bind the bottom of the editing view to the bottom of anotherView;

### `bottomToTopOf(anotherView: View, margin: Int)` and `bottomToTopOf(anotherView: Int, margin: Int)`
Bind the bottom of the editing view to the top of anotherView;

### `leftToLeftOf(anotherView: View, margin: Int)` and `leftToLeftOf(anotherView: Int, margin: Int)`
Bind the left of the editing view to the left of anotherView;

### `leftToRightOf(anotherView: View, margin: Int)` and `leftToRightOf(anotherView: Int, margin: Int)`
Bind the left of the editing view to the right of anotherView;

### `rightToRightOf(anotherView: View, margin: Int)` and `rightToRightOf(anotherView: Int, margin: Int)`
Bind the right of the editing view to the right of anotherView;

### `rightToLeftOf(anotherView: View, margin: Int)` and `rightToLeftOf(anotherView: Int, margin: Int)`
Bind the right of the editing view to the left of anotherView;

### `alignVerticalWith(anotherView: View)` and `alignVerticalWith(anotherView: Int)`
Bind the top and bottom from the editing view to the top and bottom from the anotherView;

### `alignHorizontalWith(anotherView: View)` and `alignVerticalWith(anotherView: Int)`
Bind the left and right from the editing view to the left and right from the anotherView;

### `width(width: Int)`
Sets a specific width to the view;

### `height(height: Int)`
Sets a specific height to the view;

### `parentWidth()`
Matchs the width with the parents width;

### `parentHeight()`
Matchs the height with the parents height;

### `widthMatchConstraint()`
Makes the view width the maximum allowed by the constraints;

### `heightMatchConstraint()`
Makes the view height the maximum allowed by the constraints;

### `widthWrapContent()`
Makes the view width the minimum necessary by the view;

### `heightWrapContent()`
Makes the view height the minimum necessary by the view;

### `minWidth(width: Int)`
Determines a minimum width to the view;

### `minHeight(height: Int)`
Determines a minimum height to the view;

### `maxWidth(width: Int)`
Determines a maximum width to the view;

### `maxHeight(height: Int)`
Determines a maximum height to the view;

### `rotation(rotation: Float)`
Set the views rotation. Rotation should be from 0 to 360;

### `verticalBias(bias: Float)`
Set the bias from the view. Bias should be from 0 to 1;

### `horizontalBias(bias: Float)`
Set the bias from the view. Bias should be from 0 to 1;

### `setRatio(ratio: String)`
Set the ratio from the view. Width or height sould (at least one of them) must be matchConstraint; Value should be in this format: `width:height`. eg: 4:3;

### `setElevation(elevation: Float)`
Set the view elevation;

### `circleTo(anotherView: View, angle: Float, radius: Int)` and `circleTo(anotherView: Int, angle: Float, radius: Int)`
Align this view in a circle position to another one. The angle should be between 0 and 360;

### `centerCircleWithIdTo(othersViews: List<View>, radius: Int, rangeInitial: Int, rangeFinal: Int)` and `centerCircleWithIdTo(anothersViews: List<Int>, radius: Int, rangeInitial: Int, rangeFinal: Int)`
Distribuite the views equally in the range defined. The initial and final range position must be between 0 and 360.

## TODO
- [x] General
    - [x] Easy way to use
    - [x] Use views or ids to execute the bindings
    - [x] Possibility to animate
    - [x] Basic animation
- [ ] Work with single views
    - [x] Constraints and margins
        - [x] Unbind constraint (All/Top/Bottom/Right/Left)
        - [x] Top to top of
        - [x] Top to bottom of
        - [x] Bottom to bottom of
        - [x] Bottom to top of
        - [x] Left to left of
        - [x] Left to right of
        - [x] Right to right of
        - [x] Right to left of
        - [x] Align center vertically with another view
        - [x] Align center horizontally with another view
        - [x] Circular to another with radius and angle
    - [x] Sizes
        - [x] Height/Width
        - [x] Min/Max
        - [x] WrapConstraint/WrapContent
        - [x] Ratio
    - [x] Rotation
    - [x] Bias
    - [ ] Visibility
- [ ] Work with group of views
    - [ ] Circular constraint
    - [ ] Barriers
    - [ ] Guidelines
    - [ ] Groups

## License
```
Copyright 2019 Gustavo Fão. All rights reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```