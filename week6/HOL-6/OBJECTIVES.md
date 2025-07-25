# React Router Guide

A comprehensive guide covering React Router for client-side navigation in React applications.

## Table of Contents

- [What is React Router?](#what-is-react-router)
- [Need and Benefits](#need-and-benefits)
- [React Router Components](#react-router-components)
- [Types of Router Components](#types-of-router-components)
- [Parameter Passing via URL](#parameter-passing-via-url)

## What is React Router?

**React Router** is a popular library for handling client-side routing in React applications, particularly Single-Page Applications (SPAs). It enables navigation between different views or components without requiring full page reloads, maintaining a seamless user experience.

## Need and Benefits

### Need for React Router

- **Client-Side Navigation**: In SPAs, the browser loads a single HTML page, and React Router manages navigation by updating the UI based on the URL without server requests
- **Dynamic Routing**: Allows developers to map URLs to specific components, enabling dynamic content rendering
- **State Preservation**: Maintains application state during navigation, unlike traditional Multi-Page Applications (MPAs) where state is lost on page reloads
- **URL Management**: Synchronizes the browser's URL with the application's UI, supporting browser history (back/forward buttons) and bookmarkable URLs
- **Modular UI**: Facilitates organizing the app into distinct views or pages, improving code maintainability

### Benefits of React Router

- **Seamless User Experience**: Provides smooth transitions between views without page refreshes, mimicking native app behavior
- **Declarative Routing**: Defines routes using JSX, making routing intuitive and aligned with React's component-based architecture
- **Nested Routing**: Supports hierarchical routes, allowing complex layouts with nested components
- **Dynamic Navigation**: Enables programmatic navigation (e.g., redirecting users after login) and dynamic route parameters
- **Browser History Support**: Integrates with the browser's history API, ensuring back/forward navigation works as expected
- **Scalability**: Simplifies managing complex navigation structures in large applications
- **SEO Support**: When paired with server-side rendering (e.g., Next.js), improves SEO for SPAs

## React Router Components

React Router (specifically React Router DOM, the version for web applications) provides several key components to manage routing. Below are the primary components in React Router v6:

### Core Components

| Component | Purpose | Description |
|-----------|---------|-------------|
| **`<BrowserRouter>`** | Router wrapper | Uses HTML5 history API to keep UI in sync with browser's URL. Wraps the entire application |
| **`<Routes>`** | Route container | Container for defining route mappings; renders the first `<Route>` that matches the current URL |
| **`<Route>`** | Route definition | Defines mapping between URL path and component. Supports `path`, `element`, and `caseSensitive` props |
| **`<Link>`** | Navigation link | Creates navigational links to route paths, preventing full page reloads |
| **`<NavLink>`** | Active navigation link | Special `<Link>` that adds styling (e.g., `active` class) when the route is active |
| **`<Outlet>`** | Nested route placeholder | Renders child routes in nested routing setups |
| **`<Navigate>`** | Programmatic redirect | Programmatically redirects to another route (e.g., after authentication) |
| **`<RouterProvider>`** | Advanced router provider | Provides routing context when using the data router API (v6.4+) |

## Types of Router Components

React Router DOM provides different router components for various use cases:

### 1. 🌐 `<BrowserRouter>`
- **Uses**: HTML5 history API for clean URLs (e.g., `/about`)
- **Best for**: Modern web applications with server support for URL resolution
- **URL Format**: `example.com/about`

### 2. #️⃣ `<HashRouter>`
- **Uses**: URL hash for routing (e.g., `/#about`)
- **Best for**: Static file servers where server-side routing configuration isn't possible
- **URL Format**: `example.com/#/about`

### 3. 🧠 `<MemoryRouter>`
- **Uses**: Stores routing history in memory, not the browser's URL
- **Best for**: Testing or non-browser environments (e.g., React Native)
- **URL Format**: Not visible in browser URL

### 4. 🖥️ `<StaticRouter>`
- **Uses**: Server-side rendering (SSR), renders specific route without browser interaction
- **Best for**: Node.js environments with frameworks like Next.js or Express
- **URL Format**: Determined by server

### 5. 📱 `<NativeRouter>`
- **Uses**: React Native applications
- **Best for**: Mobile app navigation
- **URL Format**: Native app navigation

### 6. ⚙️ `<Router>` (Low-level)
- **Uses**: Generic router with custom history object
- **Best for**: Advanced customization scenarios
- **URL Format**: Depends on custom history implementation

## Parameter Passing via URL

React Router allows passing parameters via the URL to make routes dynamic. This includes route parameters and query parameters.

### 1. 🎯 Route Parameters

Route parameters capture dynamic segments of the URL using a colon syntax (`:paramName`).

#### Definition
```jsx
<Route path="/user/:id" element={<UserProfile />} />
```

#### Access Parameters
```jsx
import { useParams } from 'react-router-dom';

function UserProfile() {
  const { id } = useParams(); // Extracts 'id' from URL
  return <div>User ID: {id}</div>;
}
```

#### Example URL
```
/user/123 → id = "123"
/user/john → id = "john"
```

### 2. 🔍 Query Parameters

Query parameters are key-value pairs appended after `?` in the URL.

#### Access Query Parameters
```jsx
import { useSearchParams } from 'react-router-dom';

function SearchPage() {
  const [searchParams] = useSearchParams();
  const query = searchParams.get('query');
  const category = searchParams.get('category');
  
  return (
    <div>
      <p>Search Query: {query}</p>
      <p>Category: {category}</p>
    </div>
  );
}
```

#### Example URL
```
/search?query=react&category=tutorial
→ query = "react", category = "tutorial"
```

### 3. ❓ Optional Parameters

Make route parameters optional by adding `?`:

```jsx
<Route path="/user/:id?" element={<UserProfile />} />
```

This matches both `/user` and `/user/123`.

### 4. 🧭 Programmatic Navigation

Navigate programmatically with parameters using `useNavigate`:

```jsx
import { useNavigate } from 'react-router-dom';

function NavigationButton() {
  const navigate = useNavigate();
  
  const goToUser = () => {
    navigate('/user/123?tab=profile');
  };
  
  return <button onClick={goToUser}>Go to User Profile</button>;
}
```

