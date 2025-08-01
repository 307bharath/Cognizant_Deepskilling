# React Unit Testing and Routing Guide

## Unit Testing in React - Why It's Essential

### Need for Unit Testing

Unit testing in React is crucial for:

- **Component Reliability**: Ensures individual components work as expected in isolation
- **Bug Prevention**: Catches errors early in development before they reach production
- **Refactoring Confidence**: Allows safe code changes without breaking existing functionality
- **Documentation**: Tests serve as living documentation of component behavior
- **Regression Prevention**: Prevents old bugs from reappearing after code changes
- **Code Quality**: Encourages better component design and separation of concerns
- **Team Collaboration**: Provides clear expectations for component behavior
- **Faster Development**: Reduces time spent on manual testing and debugging

## Working with Jest and Enzyme in React

### Jest - JavaScript Testing Framework

Jest is the default testing framework for React applications.

#### Key Features:
- Zero configuration setup with Create React App
- Built-in test runner, assertion library, and mocking capabilities
- Snapshot testing for UI components
- Code coverage reports
- Watch mode for continuous testing



### Enzyme - JavaScript Testing Utility

Enzyme provides utilities for testing React components with jQuery-like API.

#### Installation:
```bash
npm install --save-dev enzyme enzyme-adapter-react-17
```

#### Setup:
```javascript
// setupTests.js
import { configure } from 'enzyme';
import Adapter from 'enzyme-adapter-react-17';

configure({ adapter: new Adapter() });
```

#### Enzyme Rendering Methods:

**1. Shallow Rendering**
```javascript
import { shallow } from 'enzyme';

test('renders without crashing', () => {
  const wrapper = shallow(<MyComponent />);
  expect(wrapper.exists()).toBe(true);
});
```

**2. Full DOM Rendering (Mount)**
```javascript
import { mount } from 'enzyme';

test('simulates click events', () => {
  const wrapper = mount(<Button onClick={mockFn} />);
  wrapper.find('button').simulate('click');
  expect(mockFn).toHaveBeenCalled();
});
```

**3. Static Rendering**
```javascript
import { render } from 'enzyme';

test('renders static HTML', () => {
  const wrapper = render(<MyComponent />);
  expect(wrapper.text()).toContain('Expected text');
});
```

#### Common Enzyme Methods:
```javascript
// Finding elements
wrapper.find('button')
wrapper.find('.className')
wrapper.find('#id')

// Assertions
expect(wrapper.exists()).toBe(true)
expect(wrapper.text()).toEqual('Hello')
expect(wrapper.prop('disabled')).toBe(false)

// Simulating events
wrapper.simulate('click')
wrapper.simulate('change', { target: { value: 'new value' } })

// State and props
wrapper.state('isOpen')
wrapper.setProps({ newProp: 'value' })
```

### Modern Alternative: React Testing Library

Note: React Testing Library is now preferred over Enzyme for testing React components.

```javascript
import { render, fireEvent, screen } from '@testing-library/react';

test('button click test', () => {
  render(<Button>Click me</Button>);
  const button = screen.getByRole('button', { name: /click me/i });
  fireEvent.click(button);
});
```

## Types of Router Components in React Router

React Router provides several components for handling navigation and routing:

### 1. **BrowserRouter**
- Uses HTML5 history API
- Creates clean URLs without hash (#)
- Requires server configuration for production

```javascript
import { BrowserRouter } from 'react-router-dom';

<BrowserRouter>
  <App />
</BrowserRouter>
```

### 2. **HashRouter**
- Uses URL hash portion for routing
- Works without server configuration
- URLs contain # symbol

```javascript
import { HashRouter } from 'react-router-dom';

<HashRouter>
  <App />
</HashRouter>
```

### 3. **MemoryRouter**
- Keeps history in memory
- Useful for testing and non-browser environments
- URLs don't appear in address bar

```javascript
import { MemoryRouter } from 'react-router-dom';

<MemoryRouter initialEntries={['/home']}>
  <App />
</MemoryRouter>
```

### 4. **StaticRouter**
- Used for server-side rendering
- Takes location and context props
- Doesn't change location

```javascript
import { StaticRouter } from 'react-router-dom';

<StaticRouter location={request.url} context={{}}>
  <App />
</StaticRouter>
```

### 5. **Route**
- Renders UI when path matches current URL
- Core component for defining routes

```javascript
import { Route } from 'react-router-dom';

<Route path="/home" component={Home} />
<Route path="/about" render={() => <About />} />
<Route path="/users/:id" children={<User />} />
```

### 6. **Routes (formerly Switch)**
- Renders only the first matching Route
- Ensures exclusive routing

```javascript
import { Routes, Route } from 'react-router-dom';

<Routes>
  <Route path="/home" element={<Home />} />
  <Route path="/about" element={<About />} />
  <Route path="*" element={<NotFound />} />
</Routes>
```

### 7. **Link**
- Creates navigation links
- Prevents page refresh

```javascript
import { Link } from 'react-router-dom';

<Link to="/home">Home</Link>
<Link to="/about">About</Link>
```

### 8. **NavLink**
- Special Link with active styling
- Adds active class when route matches

```javascript
import { NavLink } from 'react-router-dom';

<NavLink 
  to="/home" 
  className={({ isActive }) => isActive ? "active" : ""}
>
  Home
</NavLink>
```

### 9. **Navigate (formerly Redirect)**
- Programmatically navigate to different route
- Used for conditional redirects

```javascript
import { Navigate } from 'react-router-dom';

<Navigate to="/login" replace />
```

### 10. **Outlet**
- Renders child route elements
- Used in nested routing

```javascript
import { Outlet } from 'react-router-dom';

function Layout() {
  return (
    <div>
      <nav>Navigation</nav>
      <Outlet /> {/* Child routes render here */}
    </div>
  );
}
```

### Router Component Comparison:

| Component | Use Case | URL Format | Server Config |
|-----------|----------|------------|---------------|
| BrowserRouter | Production apps | `/path` | Required |
| HashRouter | Simple deployments | `/#/path` | Not required |
| MemoryRouter | Testing/SSR | Not visible | Not applicable |
| StaticRouter | Server-side rendering | Static | Server-side |

### Best Practices:

- Use **BrowserRouter** for most web applications
- Use **HashRouter** for simple static deployments
- Use **MemoryRouter** for testing
- Always wrap your app with a Router component
- Use **Routes** instead of individual Route matching
- Prefer **NavLink** for navigation menus
- Use **Navigate** for programmatic redirects