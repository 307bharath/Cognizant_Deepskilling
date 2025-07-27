# React Events Complete Guide

## 1. Explain React Events

React events are interactions or actions triggered by users, such as clicking a button, typing in an input field, or hovering over an element. In React, events are handled using event handlers, which are functions that execute in response to these interactions. React wraps native browser events into a unified system called **Synthetic Events** to ensure consistent behavior across different browsers.

React events are similar to native DOM events but are designed to work seamlessly with React's virtual DOM, providing a consistent API and improved performance. Common events include `onClick`, `onChange`, `onMouseOver`, `onKeyDown`, etc.

### Example:
```jsx
function Button() {
  function handleClick() {
    alert("Button clicked!");
  }

  return <button onClick={handleClick}>Click Me</button>;
}
```
Here, `onClick` is a React event that triggers the `handleClick` function when the button is clicked.

---

## 2. Explain About Event Handlers

Event handlers in React are functions that define what happens when a specific event occurs. They are attached to elements via event attributes (e.g., `onClick`, `onChange`) in JSX. Event handlers receive a **Synthetic Event** object as an argument, which provides information about the event, such as the target element or event type.

### Key Points:
- **Declaration**: Event handlers are typically defined as functions within a component or passed as props.
- **Binding**: In class components, event handlers often need to be bound to the component's `this` context (not required in functional components with hooks).
- **Performance**: Avoid defining event handlers inline in JSX (e.g., `<button onClick={() => console.log("Clicked")}>`) for frequently rendered components, as it creates a new function on each render, potentially impacting performance.

### Examples:

#### 1. Functional Component:
```jsx
function Input() {
  const handleChange = (event) => {
    console.log("Input value:", event.target.value);
  };

  return <input type="text" onChange={handleChange} />;
}
```

#### 2. Class Component (Binding):
```jsx
class Button extends React.Component {
  constructor(props) {
    super(props);
    this.handleClick = this.handleClick.bind(this); // Bind in constructor
  }

  handleClick() {
    console.log("Button clicked!");
  }

  render() {
    return <button onClick={this.handleClick}>Click Me</button>;
  }
}
```

Alternatively, use an arrow function to avoid manual binding:
```jsx
handleClick = () => {
  console.log("Button clicked!");
};
```

#### 3. Passing Parameters:
```jsx
function Item({ id }) {
  const handleDelete = (itemId) => {
    console.log(`Deleting item ${itemId}`);
  };

  return <button onClick={() => handleDelete(id)}>Delete</button>;
}
```

---

## 3. Define Synthetic Event

A **Synthetic Event** is a cross-browser wrapper around the browser's native event system provided by React. It normalizes event properties and behavior to ensure consistency across different browsers, which may handle native events differently. Synthetic Events are pooled for performance, meaning their properties are reused after the event handler executes, so you cannot access them asynchronously unless you call `event.persist()`.

### Key Features:
- **Cross-Browser Compatibility**: Synthetic Events ensure properties like `event.target` or `event.preventDefault()` work consistently across browsers.
- **Event Pooling**: To optimize performance, React reuses Synthetic Event objects. If you need to access the event asynchronously (e.g., in a `setTimeout`), call `event.persist()` to prevent the event object from being nullified.
- **Properties**: Synthetic Events provide standard event properties like `event.target`, `event.type`, `event.preventDefault()`, and `event.stopPropagation()`.

### Example:
```jsx
function Form() {
  const handleSubmit = (event) => {
    event.preventDefault(); // Prevents default form submission
    console.log("Form submitted", event.target);
  };

  return (
    <form onSubmit={handleSubmit}>
      <button type="submit">Submit</button>
    </form>
  );
}
```

### Async Event Access:
```jsx
function Example() {
  const handleClick = (event) => {
    event.persist(); // Keep event object accessible
    setTimeout(() => {
      console.log(event.target); // Works because of persist()
    }, 1000);
  };

  return <button onClick={handleClick}>Click Me</button>;
}
```

---

## 4. Identify React Event Naming Convention

React event names follow a specific naming convention to distinguish them from native DOM events and align with JSX syntax. The convention is based on camelCase, and event names are prefixed with `on` followed by the event type.

### Rules:
- **CamelCase**: Event names use camelCase (e.g., `onClick`, `onMouseOver`) instead of lowercase (e.g., `onclick` in native JavaScript).
- **Prefix**: All event attributes start with `on` (e.g., `onSubmit`, `onKeyDown`).
- **JSX Attribute**: Events are specified as JSX attributes, and their values are functions (event handlers), not strings as in HTML.

### Common React Events:
- **Mouse Events**: `onClick`, `onDoubleClick`, `onMouseOver`, `onMouseOut`, `onMouseEnter`, `onMouseLeave`.
- **Keyboard Events**: `onKeyDown`, `onKeyPress`, `onKeyUp`.
- **Form Events**: `onChange`, `onSubmit`, `onInput`, `onFocus`, `onBlur`.
- **Touch Events**: `onTouchStart`, `onTouchEnd`, `onTouchMove`.
- **Clipboard Events**: `onCopy`, `onCut`, `onPaste`.

### Example:
```jsx
function Component() {
  const handleClick = () => console.log("Clicked");
  const handleChange = (event) => console.log("Value:", event.target.value);

  return (
    <div>
      <button onClick={handleClick}>Click Me</button>
      <input type="text" onChange={handleChange} />
    </div>
  );
}
```

### Contrast with Native HTML:
- **HTML**: `<button onclick="handleClick()">Click Me</button>`
- **React**: `<button onClick={handleClick}>Click Me</button>`
  - In React, `onClick` takes a function reference, not a string, and uses camelCase.


---
