## Table of Contents

- [Component Lifecycle Overview](#component-lifecycle-overview)
- [Need and Benefits](#need-and-benefits)
- [Lifecycle Methods & Hooks](#lifecycle-methods--hooks)
- [Component Rendering Sequence](#component-rendering-sequence)

## Component Lifecycle Overview

The **component lifecycle** in React refers to the series of phases a component goes through from its creation to its removal from the DOM. Understanding and leveraging the lifecycle is crucial for managing side effects, optimizing performance, and controlling component behavior.

## Need and Benefits

### Need for Component Lifecycle

- **Initialization**: Set up initial state, props, or resources when a component is created
- **Updates**: Handle changes in state or props to update the UI or perform side effects (e.g., fetching data)
- **Cleanup**: Release resources (e.g., timers, subscriptions) when a component is removed to prevent memory leaks
- **Optimization**: Control when and how a component re-renders to improve performance
- **Side Effects**: Manage operations like API calls, DOM manipulations, or event listeners that aren't directly tied to rendering

### Benefits of Component Lifecycle

- **Controlled Execution**: Lifecycle methods/hooks allow precise control over what happens at each stage (mounting, updating, unmounting)
- **Efficient Resource Management**: Clean up resources (e.g., timers, subscriptions) to avoid memory leaks
- **Dynamic Updates**: Respond to state/prop changes to keep the UI in sync with data
- **Performance Optimization**: Methods like `shouldComponentUpdate` or hooks like `useMemo` prevent unnecessary re-renders
- **Flexibility**: Enables integration with external systems (e.g., APIs, WebSockets) at specific points in a component's life

## Lifecycle Methods & Hooks

React provides lifecycle methods for class components and hooks for function components to manage lifecycle events.

### Class Component Lifecycle Methods

#### Mounting Phase
*When a component is created and inserted into the DOM*

- **`constructor(props)`**: Initializes state and binds methods; called before mounting
- **`static getDerivedStateFromProps(props, state)`**: Rarely used; updates state based on initial props
- **`render()`**: Returns JSX to describe the UI; required in class components
- **`componentDidMount()`**: Runs after the component is added to the DOM; ideal for API calls or setting up subscriptions

#### Updating Phase
*When state or props change*

- **`static getDerivedStateFromProps(props, state)`**: Updates state based on prop changes
- **`shouldComponentUpdate(nextProps, nextState)`**: Determines if the component should re-render (for optimization)
- **`render()`**: Re-renders the UI with updated state/props
- **`getSnapshotBeforeUpdate(prevProps, prevState)`**: Captures data (e.g., scroll position) before DOM updates
- **`componentDidUpdate(prevProps, prevState, snapshot)`**: Runs after DOM updates; used for side effects like fetching data based on prop changes

#### Unmounting Phase
*When a component is removed from the DOM*

- **`componentWillUnmount()`**: Runs before the component is removed; used for cleanup (e.g., clearing timers, unsubscribing)

#### Error Handling
*When an error occurs in a child component*

- **`static getDerivedStateFromError(error)`**: Updates state to handle errors (e.g., show fallback UI)
- **`componentDidCatch(error, info)`**: Logs errors or performs side effects after an error

### Function Component Lifecycle Hooks

Function components use hooks to manage lifecycle events *(introduced in React 16.8)*:

#### Primary Hooks

- **`useEffect(callback, [dependencies])`**: Handles side effects; combines `componentDidMount`, `componentDidUpdate`, and `componentWillUnmount`
  - **Mounting**: Runs after the component mounts (if no dependencies or empty array)
  - **Updating**: Runs after updates if dependencies change
  - **Unmounting**: Runs cleanup function (returned from `useEffect`) when the component unmounts or dependencies change

- **`useLayoutEffect(callback, [dependencies])`**: Similar to `useEffect` but runs synchronously after DOM updates; used for DOM measurements

- **`useState`**: Manages state, indirectly affecting updates by triggering re-renders

- **Custom Hooks**: Encapsulate reusable lifecycle logic (e.g., `useFetch` for data fetching)

## Component Rendering Sequence

The rendering process in React involves a series of steps, differing slightly for class and function components.

### Class Component Rendering Sequence

#### 1.Mounting (Initial Render)

```
Constructor → getDerivedStateFromProps → Render → DOM Update → componentDidMount
```

1. **Constructor**: Initializes state and binds methods (`constructor(props)`)
2. **getDerivedStateFromProps**: Updates state based on initial props (static method)
3. **Render**: Generates JSX to describe the UI (`render()`)
4. **DOM Update**: React updates the real DOM based on the virtual DOM
5. **componentDidMount**: Runs after the component is mounted (e.g., for API calls)

#### 2.Updating (Re-render due to state/props change)

```
getDerivedStateFromProps → shouldComponentUpdate → Render → getSnapshotBeforeUpdate → DOM Update → componentDidUpdate
```

1. **getDerivedStateFromProps**: Updates state based on new props
2. **shouldComponentUpdate**: Determines if rendering should proceed (defaults to `true`)
3. **Render**: Generates updated JSX
4. **getSnapshotBeforeUpdate**: Captures data before DOM updates
5. **DOM Update**: React updates the DOM with minimal changes
6. **componentDidUpdate**: Runs after DOM updates (e.g., for side effects)

#### 3. Unmounting

```
componentWillUnmount → DOM Removal
```

1. **componentWillUnmount**: Performs cleanup (e.g., clears timers) before removal
2. **DOM Removal**: Component is removed from the DOM

#### 4. Error Handling (if an error occurs)

```
getDerivedStateFromError → componentDidCatch
```

1. **getDerivedStateFromError**: Updates state to handle errors
2. **componentDidCatch**: Logs or processes errors

### Function Component Rendering Sequence

#### 1.Mounting (Initial Render)

```
Function Execution → JSX Return → DOM Update → useEffect/useLayoutEffect
```

1. **Function Execution**: The function component runs, processing props and hooks (e.g., `useState`)
2. **JSX Return**: Returns JSX to describe the UI
3. **DOM Update**: React updates the real DOM based on the virtual DOM
4. **useEffect/useLayoutEffect**: Runs after mounting (or synchronously for `useLayoutEffect`) for side effects

#### 2.Updating (Re-render due to state/props change)

```
Function Re-execution → JSX Return → DOM Update → useEffect/useLayoutEffect
```

1. **Function Re-execution**: Component re-runs with updated props/state
2. **JSX Return**: Returns updated JSX
3. **DOM Update**: React applies minimal DOM changes via reconciliation
4. **useEffect/useLayoutEffect**: Runs again if dependencies change; cleanup function (if provided) runs before the effect

#### 3.Unmounting

```
Cleanup in useEffect → DOM Removal
```

1. **Cleanup in useEffect**: Runs the cleanup function returned by `useEffect` (e.g., unsubscribing)
2. **DOM Removal**: Component is removed from the DOM

