# React Context API

## Need for React Context API

The React Context API addresses the problem of **prop drilling** - the need to pass data through multiple component layers to reach a deeply nested component that needs it. Without Context API:

- Data must be passed as props through every intermediate component
- Intermediate components receive props they don't actually use
- Code becomes difficult to maintain and track
- Component interfaces become cluttered with unnecessary props
- Makes refactoring and component reusability challenging

## Benefits of React Context API

### 1. **Eliminates Prop Drilling**
- Direct access to shared data from any component in the tree
- No need to pass props through intermediate components
- Cleaner component interfaces

### 2. **Global State Management**
- Share state across the entire application
- Centralized data storage and management
- Consistent data access patterns

### 3. **Performance Benefits**
- Reduces unnecessary prop passing
- Components only re-render when context values they consume change
- Better memory usage and optimization

### 4. **Improved Code Organization**
- Better separation of concerns
- Logical grouping of related data and functions
- Enhanced component composition

### 5. **Built-in Solution**
- No external dependencies required
- Official React feature with full support
- Well-documented and widely adopted

### 6. **Type Safety** (with TypeScript)
- Strong typing for context values
- Compile-time error detection
- Better IDE support and auto-completion

## Working with createContext()

### Basic Syntax
```javascript
const MyContext = createContext(defaultValue);
```

### Key Steps:

#### 1. **Create Context**
```javascript
import { createContext } from 'react';
const ThemeContext = createContext('light'); // default value
```

#### 2. **Create Provider Component**
```javascript
const ThemeProvider = ({ children }) => {
  const [theme, setTheme] = useState('light');
  
  return (
    <ThemeContext.Provider value={{ theme, setTheme }}>
      {children}
    </ThemeContext.Provider>
  );
};
```

#### 3. **Wrap Components with Provider**
```javascript
<ThemeProvider>
  <App />
</ThemeProvider>
```

#### 4. **Consume Context**
```javascript
// Using useContext hook
const { theme, setTheme } = useContext(ThemeContext);

// Using Consumer component (legacy)
<ThemeContext.Consumer>
  {({ theme, setTheme }) => (
    <div>Current theme: {theme}</div>
  )}
</ThemeContext.Consumer>
```

### Important Parameters:

- **defaultValue**: Used when component doesn't have a matching Provider above it
- **value prop**: The actual data passed to consuming components
- **children**: Components that can access the context

# React Router Components

## Types of Router Components

React Router provides several types of router components to handle different routing scenarios and environments:

## 1. **BrowserRouter**

- **Purpose**: Uses HTML5 history API for clean URLs
- **URL Format**: `/users/123` (no hash)
- **Use Case**: Production web applications with server support
- **Requirements**: Server must be configured to handle client-side routing
- **Advantages**: Clean, SEO-friendly URLs

```javascript
import { BrowserRouter } from 'react-router-dom';

<BrowserRouter>
  <App />
</BrowserRouter>
```

## 2. **HashRouter**

- **Purpose**: Uses URL hash portion for routing
- **URL Format**: `/#/users/123` (with hash)
- **Use Case**: Static file hosting, environments without server configuration
- **Requirements**: No server configuration needed
- **Advantages**: Works with any server setup, easy deployment

```javascript
import { HashRouter } from 'react-router-dom';

<HashRouter>
  <App />
</HashRouter>
```

## 3. **MemoryRouter**

- **Purpose**: Keeps routing history in memory (doesn't use browser URL)
- **URL Format**: URL doesn't change
- **Use Case**: Testing, React Native, non-browser environments
- **Requirements**: None
- **Advantages**: Complete control over history, isolated routing

```javascript
import { MemoryRouter } from 'react-router-dom';

<MemoryRouter initialEntries={['/home']}>
  <App />
</MemoryRouter>
```

## 4. **StaticRouter**

- **Purpose**: Router that never changes location
- **URL Format**: Fixed URL
- **Use Case**: Server-side rendering (SSR)
- **Requirements**: Node.js environment
- **Advantages**: Predictable routing for SSR

```javascript
import { StaticRouter } from 'react-router-dom/server';

<StaticRouter location={request.url}>
  <App />
</StaticRouter>
```

## 5. **NativeRouter**

- **Purpose**: Router for React Native applications
- **URL Format**: N/A (mobile navigation)
- **Use Case**: React Native mobile apps
- **Requirements**: React Native environment
- **Advantages**: Mobile-optimized navigation

```javascript
import { NativeRouter } from 'react-router-native';

<NativeRouter>
  <App />
</NativeRouter>
```

## Router Comparison

| Router Type | Environment | URL Changes | Server Config | Best For |
|-------------|-------------|-------------|---------------|----------|
| BrowserRouter | Web Browser | Yes (clean) | Required | Production web apps |
| HashRouter | Web Browser | Yes (hash) | Not required | Static hosting |
| MemoryRouter | Any | No | Not required | Testing, React Native |
| StaticRouter | Server | No | N/A | Server-side rendering |
| NativeRouter | React Native | N/A | N/A | Mobile applications |

## Key Properties

### Common Props:
- **basename**: Base URL for all locations
- **children**: React components to render

### BrowserRouter Specific:
- **window**: Window object to use (default: defaultView)

### HashRouter Specific:
- **hashType**: Type of hash to use ("slash", "noslash", "hashbang")
- **window**: Window object to use

### MemoryRouter Specific:
- **initialEntries**: Array of initial history entries
- **initialIndex**: Initial active entry index

### StaticRouter Specific:
- **location**: The server request URL
- **context**: Object for server-side rendering context