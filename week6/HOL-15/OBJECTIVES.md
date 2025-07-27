# React Forms Guide

## React Forms

React forms are interactive elements that allow users to input data. Unlike traditional HTML forms, React forms are typically handled using component state and event handlers. React provides two approaches for handling forms:
- **Controlled Components**: Form data is handled by React component state
- **Uncontrolled Components**: Form data is handled by the DOM itself

## Controlled Components

**Definition**: A controlled component is an input form element whose value is controlled by React state. The React component that renders the form also controls what happens in that form on subsequent user input.

**Key Characteristics**:
- Input value is set by React state
- Changes are handled through event handlers
- Single source of truth for form data
- Enables validation and formatting

**Basic Structure**:
```javascript
const [value, setValue] = useState('');

<input 
  type="text" 
  value={value} 
  onChange={(e) => setValue(e.target.value)} 
/>
```

## Various Input Controls

### 1. **Text Input**
```javascript
<input 
  type="text" 
  value={name} 
  onChange={(e) => setName(e.target.value)} 
  placeholder="Enter name"
/>
```

### 2. **Textarea**
```javascript
<textarea 
  value={message} 
  onChange={(e) => setMessage(e.target.value)}
  rows="4"
/>
```

### 3. **Select Dropdown**
```javascript
<select value={country} onChange={(e) => setCountry(e.target.value)}>
  <option value="">Select Country</option>
  <option value="usa">USA</option>
  <option value="uk">UK</option>
</select>
```

### 4. **Checkbox**
```javascript
<input 
  type="checkbox" 
  checked={isChecked} 
  onChange={(e) => setIsChecked(e.target.checked)}
/>
```

### 5. **Radio Buttons**
```javascript
<input 
  type="radio" 
  value="male" 
  checked={gender === 'male'} 
  onChange={(e) => setGender(e.target.value)}
/>
<input 
  type="radio" 
  value="female" 
  checked={gender === 'female'} 
  onChange={(e) => setGender(e.target.value)}
/>
```

### 6. **File Input**
```javascript
<input 
  type="file" 
  onChange={(e) => setFile(e.target.files[0])}
/>
```

### 7. **Number Input**
```javascript
<input 
  type="number" 
  value={age} 
  onChange={(e) => setAge(e.target.value)}
  min="0" 
  max="100"
/>
```

## Handling Forms

### 1. **State Management**
- Use `useState` hook to manage form data
- Create separate state variables or use a single object

```javascript
// Individual states
const [name, setName] = useState('');
const [email, setEmail] = useState('');

// Single state object
const [formData, setFormData] = useState({
  name: '',
  email: ''
});
```

### 2. **Event Handling**
- Use `onChange` events to update state
- Extract values from event objects

```javascript
const handleInputChange = (e) => {
  const { name, value } = e.target;
  setFormData(prev => ({
    ...prev,
    [name]: value
  }));
};
```

### 3. **Form Validation**
- Validate input on change or submit
- Display error messages conditionally

```javascript
const [errors, setErrors] = useState({});

const validateForm = () => {
  const newErrors = {};
  if (!name.trim()) newErrors.name = 'Name is required';
  if (!email.includes('@')) newErrors.email = 'Valid email required';
  setErrors(newErrors);
  return Object.keys(newErrors).length === 0;
};
```

## Submitting Forms

### 1. **Form Submit Handler**
```javascript
const handleSubmit = (e) => {
  e.preventDefault(); // Prevent page reload
  
  if (validateForm()) {
    // Process form data
    console.log('Form submitted:', formData);
    // API call, state update, etc.
  }
};

<form onSubmit={handleSubmit}>
  {/* form inputs */}
  <button type="submit">Submit</button>
</form>
```

### 2. **Preventing Default Behavior**
- Always call `e.preventDefault()` to prevent page refresh
- Allows React to handle form submission

### 3. **Processing Form Data**
- Send data to APIs
- Update application state
- Navigate to different pages
- Reset form after successful submission

```javascript
const handleSubmit = async (e) => {
  e.preventDefault();
  
  try {
    const response = await fetch('/api/submit', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(formData)
    });
    
    if (response.ok) {
      // Reset form
      setFormData({ name: '', email: '' });
      // Show success message
    }
  } catch (error) {
    console.error('Submission error:', error);
  }
};
```

### 4. **Form Reset**
```javascript
const resetForm = () => {
  setFormData({ name: '', email: '' });
  setErrors({});
};
```

## Best Practices

- Always use controlled components for better data control
- Implement proper validation
- Provide clear error messages
- Use appropriate input types for better UX
- Handle loading states during submission
- Reset forms after successful submission