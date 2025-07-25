# ES6 Features Guide

A comprehensive guide covering ES6 (ECMAScript 2015) features and enhancements to JavaScript.

## Table of Contents

- [Features of ES6](#features-of-es6)
- [JavaScript `let`](#javascript-let)
- [Differences Between `var` and `let`](#differences-between-var-and-let)
- [JavaScript `const`](#javascript-const)
- [ES6 Class Fundamentals](#es6-class-fundamentals)
- [ES6 Class Inheritance](#es6-class-inheritance)
- [ES6 Arrow Functions](#es6-arrow-functions)
- [`Set()` and `Map()`](#set-and-map)

## Features of ES6

ES6 (ECMAScript 2015) introduced significant enhancements to JavaScript, improving its syntax and functionality. Below are the key features of ES6:

1. **Block-Scoped Variables (`let` and `const`)**: Introduced `let` for mutable variables and `const` for immutable variables, replacing `var` for better scoping.
2. **Arrow Functions**: Concise syntax for functions with implicit `this` binding.
3. **Classes**: Syntactic sugar for creating object-oriented code with `class` syntax, supporting constructors and inheritance.
4. **Template Literals**: Enhanced string literals using backticks (`` ` ``) for multi-line strings and interpolation (`${expression}`).
5. **Destructuring Assignment**: Allows unpacking arrays or objects into variables (e.g., `const {name, age} = person`).
6. **Default Parameters**: Functions can have default parameter values (e.g., `function greet(name = 'Guest')`).
7. **Rest and Spread Operators**:
   - **Rest**: Collects multiple arguments into an array (e.g., `function sum(...numbers)`).
   - **Spread**: Expands arrays or objects (e.g., `[...arr1, ...arr2]`).
8. **Modules**: Standardized `import` and `export` syntax for modular code.
9. **Promises**: Native support for asynchronous operations with `Promise` objects.
10. **Symbol Type**: A new primitive type for unique identifiers.
11. **Enhanced Object Literals**: Shorthand for property names, methods, and computed property names.
12. **Block Bindings**: Improved scoping with `let` and `const` in blocks (`{}`).
13. **Iterators and Generators**: Custom iteration with `Symbol.iterator` and `function*` for yielding values.
14. **New Data Structures**: `Map`, `Set`, `WeakMap`, and `WeakSet` for advanced data storage.
15. **Array Methods**: New methods like `Array.prototype.find`, `findIndex`, `includes`, and `forEach`.
16. **String Methods**: Additions like `startsWith`, `endsWith`, `includes`, and `repeat`.
17. **Math and Number Enhancements**: New methods like `Math.sign`, `Number.isInteger`, and safe integer limits.
18. **Tail Call Optimization**: Optimizes recursive calls in certain cases.

## JavaScript `let`

The `let` keyword in ES6 declares variables with **block scope**, meaning the variable is only accessible within the block (`{}`) it is defined in, unlike `var`, which has function or global scope.

### Key Characteristics

- **Block Scope**: Variables are confined to the nearest enclosing block (e.g., inside `{}` in loops or conditionals).
- **No Hoisting for Access**: `let` variables are hoisted but not initialized, leading to a Temporal Dead Zone (TDZ) where accessing them before declaration throws a `ReferenceError`.
- **Reassignable**: Values can be changed after declaration.
- **No Redeclaration**: Cannot redeclare the same variable with `let` in the same scope.

### Example

```javascript
{
  let x = 10;
  console.log(x); // 10
}
console.log(x); // ReferenceError: x is not defined

let y = 5;
y = 10; // Valid: reassignment
let y = 15; // SyntaxError: Identifier 'y' has already been declared
```

### Use Case
Use `let` for variables that need to be reassigned within a block, such as loop counters or temporary values.

## Differences Between `var` and `let`

| **Aspect** | **var** | **let** |
|------------|---------|---------|
| **Scope** | Function-scoped or global-scoped. | Block-scoped (confined to `{}` block). |
| **Hoisting** | Hoisted and initialized with `undefined`. | Hoisted but not initialized (Temporal Dead Zone). |
| **Redeclaration** | Allows redeclaration in the same scope. | No redeclaration in the same scope (throws error). |
| **Access Before Declaration** | Returns `undefined`. | Throws `ReferenceError` due to TDZ. |
| **Use in Loops** | Shares single binding across iterations (can cause issues). | Creates a new binding per iteration. |
| **Example** | `var x = 1; var x = 2; console.log(x); // 2` | `let x = 1; let x = 2; // SyntaxError` |
| **Loop Example** | `for (var i = 0; i < 3; i++) { setTimeout(() => console.log(i), 0); } // 3, 3, 3` | `for (let i = 0; i < 3; i++) { setTimeout(() => console.log(i), 0); } // 0, 1, 2` |

## JavaScript `const`

The `const` keyword in ES6 declares variables with **block scope** that cannot be reassigned after their initial declaration. However, the value itself can be mutable if it's an object or array.

### Key Characteristics

- **Block Scope**: Like `let`, `const` is confined to the block it's defined in.
- **No Reassignment**: The variable cannot be reassigned, but the contents of objects/arrays can be modified.
- **Must Be Initialized**: Requires an initial value at declaration.
- **Temporal Dead Zone**: Cannot be accessed before declaration (like `let`).
- **No Redeclaration**: Cannot redeclare in the same scope.

### Example

```javascript
const x = 10;
x = 20; // TypeError: Assignment to constant variable

const obj = { name: "Alice" };
obj.name = "Bob"; // Valid: Mutating object property
obj = {}; // TypeError: Assignment to constant variable

const arr = [1, 2];
arr.push(3); // Valid: Mutating array
arr = [4, 5]; // TypeError
```

### Use Case
Use `const` for variables that should not be reassigned, such as constants, configuration objects, or references to arrays/objects.

## ES6 Class Fundamentals

ES6 introduced the `class` syntax as syntactic sugar over JavaScript's prototype-based inheritance, making object-oriented programming more intuitive.

### Key Features

- **Class Declaration**: Defined using the `class` keyword.
- **Constructor**: A special method (`constructor`) for initializing instances.
- **Methods**: Defined directly in the class body (added to the prototype).
- **Static Methods**: Defined with the `static` keyword, called on the class itself, not instances.
- **Getters/Setters**: Use `get` and `set` for computed properties.
- **Prototype-Based**: Under the hood, classes use JavaScript's prototype system.

### Example

```javascript
class Person {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }

  greet() {
    return `Hello, I'm ${this.name}!`;
  }

  static isPerson(obj) {
    return obj instanceof Person;
  }

  get info() {
    return `${this.name} is ${this.age} years old`;
  }
}

const alice = new Person("Alice", 30);
console.log(alice.greet()); // Hello, I'm Alice!
console.log(Person.isPerson(alice)); // true
console.log(alice.info); // Alice is 30 years old
```

### Use Case
Classes are ideal for creating reusable blueprints for objects, such as in React class components or modeling entities.

## ES6 Class Inheritance

ES6 classes support **inheritance** using the `extends` keyword, allowing a subclass to inherit properties and methods from a parent class. The `super` keyword is used to call the parent class's constructor or methods.

### Key Features

- **Extends**: Specifies the parent class to inherit from.
- **Super**: Calls the parent class's constructor or methods.
- **Method Overriding**: Subclasses can redefine parent methods.
- **Prototype Chain**: Subclasses inherit via the prototype chain.

### Example

```javascript
class Animal {
  constructor(name) {
    this.name = name;
  }

  speak() {
    return `${this.name} makes a sound`;
  }
}

class Dog extends Animal {
  constructor(name, breed) {
    super(name); // Call parent constructor
    this.breed = breed;
  }

  speak() {
    return `${this.name} barks!`; // Override parent method
  }
}

const dog = new Dog("Rex", "Labrador");
console.log(dog.speak()); // Rex barks!
console.log(dog.breed); // Labrador
```

### Use Case
Inheritance is useful for creating specialized versions of a base class (e.g., a `Button` class extending a `Component` class in React).

## ES6 Arrow Functions

**Arrow Functions** (`=>`) in ES6 provide a concise syntax for writing functions and have a key difference in how they handle the `this` keyword.

### Key Characteristics

- **Concise Syntax**: Shorter than traditional function expressions (e.g., `(x) => x * 2`).
- **Lexical `this`**: Inherits `this` from the surrounding scope, unlike regular functions that bind `this` dynamically.
- **No `arguments` Object**: Cannot access `arguments`; use rest parameters instead.
- **Cannot Be Constructors**: Cannot be used with `new` to create objects.
- **Implicit Return**: Single-expression arrow functions return the result without `return` (e.g., `x => x * 2`).

### Example

```javascript
// Traditional function
const add = function(a, b) {
  return a + b;
};

// Arrow function
const addArrow = (a, b) => a + b;

// Lexical this
const obj = {
  name: "Alice",
  sayName: function() {
    setTimeout(() => console.log(this.name), 1000); // Arrow function uses obj's this
  },
};
obj.sayName(); // Alice
```

### Use Case
Ideal for callbacks, event handlers, and functional programming (e.g., `map`, `filter`).

## Set() and Map()

### Set()

A `Set` is an ES6 data structure that stores **unique values** of any type (primitives or objects).

#### Key Features

- No duplicates: Each value is stored only once.
- Methods: `add()`, `has()`, `delete()`, `clear()`, `size` (property).
- Iterable: Can be used with `for...of` or `forEach`.

#### Example

```javascript
const mySet = new Set([1, 2, 2, 3]);
mySet.add(4);
console.log(mySet.has(2)); // true
console.log(mySet.size); // 4
console.log([...mySet]); // [1, 2, 3, 4]
```

### Map()

A `Map` is an ES6 data structure that stores **key-value pairs** where keys can be any type (unlike objects, which use strings/symbols).

#### Key Features

- Keys can be primitives, objects, or functions.
- Methods: `set(key, value)`, `get(key)`, `has(key)`, `delete(key)`, `clear()`, `size`.
- Iterable: Supports `for...of`, `forEach`, and iteration over keys/values/entries.

#### Example

```javascript
const myMap = new Map();
myMap.set("name", "Alice");
myMap.set(1, "one");
console.log(myMap.get("name")); // Alice
console.log(myMap.has(1)); // true
myMap.delete("name");
console.log(myMap.size); // 1
```

### Use Cases

- `Set`: Storing unique values (e.g., removing duplicates from an array).
- `Map`: Storing key-value pairs with non-string keys (e.g., mapping objects to data).
