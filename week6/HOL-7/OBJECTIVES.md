# React Props, State & ReactDOM Guide

A comprehensive guide covering React props, state management, default props, and ReactDOM rendering.

## Table of Contents

- [Props in React](#props-in-react)
- [Default Props](#default-props)
- [State vs Props](#state-vs-props)
- [ReactDOM.render()](#reactdomrender)


## Props in React

**Props** (short for "properties") in React are read-only data passed from a parent component to a child component to configure or customize its behavior and rendering. Props allow components to be reusable and dynamic by enabling data flow between components in a unidirectional manner.

### Key Characteristics

- **Immutable**: Props cannot be modified by the child component
- **Passed as JSX attributes**: `<MyComponent name="Alice" />`
- **Accessible in components**: As function parameters or via `this.props`
- **Any data type**: Strings, numbers, objects, arrays, functions, or JSX

### Basic Props Example

```jsx
function Greeting(props) {
  return <h1>Hello, {props.name}!</h1>;
}

// Usage
<Greeting name="Alice" />
```

### Props with Destructuring

```jsx
function Greeting({ name, age }) {
  return (
    <div>
      <h1>Hello, {name}!</h1>
      <p>You are {age} years old.</p>
    </div>
  );
}

// Usage
<Greeting name="Alice" age={25} />
```

## Default Props

**Default Props** allow developers to define fallback values for props when the parent component doesn't provide them. This ensures predictable component behavior even when certain props are omitted.

### Setting Default Props

#### Function Components

```jsx
function Greeting({ name }) {
  return <h1>Hello, {name}!</h1>;
}

// Define default props
Greeting.defaultProps = {
  name: "Guest",
};

// Usage examples
<Greeting />              {/* Renders "Hello, Guest!" */}
<Greeting name="Alice" /> {/* Renders "Hello, Alice!" */}
```

#### Class Components

```jsx
class Greeting extends React.Component {
  render() {
    return <h1>Hello, {this.props.name}!</h1>;
  }
}

Greeting.defaultProps = {
  name: "Guest",
};
```

#### Modern Approach with Default Parameters

```jsx
function Greeting({ name = "Guest", age = 0 }) {
  return (
    <div>
      <h1>Hello, {name}!</h1>
      <p>Age: {age}</p>
    </div>
  );
}
```

### Benefits of Default Props

- ✅ Prevents errors from undefined props
- ✅ Improves component reusability with sensible defaults
- ✅ Simplifies parent component code by making props truly optional
- ✅ Makes component behavior more predictable

## State vs Props

Understanding the differences between state and props is crucial for effective React development.

| **Aspect** | **State** | **Props** |
|------------|-----------|-----------|
| **Definition** | Internal data managed within a component | Data passed from parent to child component |
| **Mutability** | Mutable; updated using `setState` or hooks | Immutable; child cannot modify props |
| **Scope** | Local to component; private unless passed down | Passed from parent; accessible via `props` |
| **Purpose** | Manages dynamic data that changes over time | Configures/customizes component rendering |
| **Initialization** | Set in constructor or `useState` hook | Defined by parent when rendering child |
| **Update Trigger** | Component controls updates; triggers re-renders | Updates come from parent; causes re-render |
| **Control** | Controlled by the component itself | Controlled by the parent component |
| **Example** | `useState(0)` or `this.state = { count: 0 }` | `<MyComponent count={5} />` |

### State vs Props Example

```jsx
// Parent Component (manages state)
function App() {
  const [count, setCount] = useState(0);
  
  return (
    <div>
      <Counter 
        count={count}                    // Props
        onIncrement={() => setCount(count + 1)} // Props (function)
      />
      <DisplayCount count={count} />     // Props
    </div>
  );
}

// Child Component (receives props, manages own state)
function Counter({ count, onIncrement }) {
  const [isHovered, setIsHovered] = useState(false); // State
  
  return (
    <div>
      <p>Count from parent: {count}</p>  {/* Props */}
      <button 
        onClick={onIncrement}
        onMouseEnter={() => setIsHovered(true)}    // State update
        onMouseLeave={() => setIsHovered(false)}   // State update
        style={{ 
          backgroundColor: isHovered ? 'lightblue' : 'white' // State
        }}
      >
        Increment
      </button>
    </div>
  );
}

// Pure component (only props)
function DisplayCount({ count }) {
  return <h2>Current Count: {count}</h2>;
}
```

## ReactDOM.render()

**`ReactDOM.render()`** is a method from the `react-dom` package that renders React components into the real DOM. It serves as the entry point for displaying React applications in the browser.

### Purpose

- Renders React elements into a specified DOM container
- Initiates the rendering process, integrating React's virtual DOM with the browser's DOM
- Bootstraps the React application

### Syntax

```jsx
ReactDOM.render(element, container[, callback])
```

- **`element`**: The React element or component to render
- **`container`**: The DOM element where React will render
- **`callback`** (optional): Function called after rendering completes

### Legacy Example (React 17 and below)

```jsx
import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';

ReactDOM.render(<App />, document.getElementById('root'));
```

### Modern Approach (React 18+)

React 18 introduced `createRoot` for better performance and concurrent rendering:

```jsx
import { createRoot } from 'react-dom/client';
import App from './App';

const root = createRoot(document.getElementById('root'));
root.render(<App />);
```

### Key Points

- ⚠️ `ReactDOM.render()` is considered legacy in React 18
- ✅ Use `createRoot` for new React 18+ applications
- 🔄 Triggers initial rendering and lifecycle methods
- 📍 Typically used once at the application root

