import React, { useState } from "react";
import "./register.css"; // ✅ Make sure this import is enabled

function Register() {
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    password: ""
  });

  const validate = () => {
    const errors = {};
    if (formData.name.trim().length < 5) {
      errors.name = "Name should have at least 5 characters";
    }
    if (!formData.email.includes("@") || !formData.email.includes(".")) {
      errors.email = "Email must include '@' and '.'";
    }
    if (formData.password.length < 8) {
      errors.password = "Password should have at least 8 characters";
    }
    return errors;
  };

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const errors = validate();

    if (Object.keys(errors).length === 0) {
      alert("Form submitted successfully!");
      console.log(formData);
    } else {
      if (errors.name) alert(errors.name);
      if (errors.email) alert(errors.email);
      if (errors.password) alert(errors.password);
    }
  };

  return (
    <div className="form-container">
      <h1 className="form-title">Register Here!!!</h1>
      <form onSubmit={handleSubmit} className="form">
        <div className="form-group">
          <label className="form-label">Name:</label>
          <input
            type="text"
            name="name"
            value={formData.name}
            onChange={handleChange}
            className="form-input"
          />
        </div>

        <div className="form-group">
          <label className="form-label">Email:</label>
          <input
            type="text"
            name="email"
            value={formData.email}
            onChange={handleChange}
            className="form-input"
          />
        </div>

        <div className="form-group">
          <label className="form-label">Password:</label>
          <input
            type="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            className="form-input"
          />
        </div>

        <button type="submit" className="form-button">Submit</button>
      </form>
    </div>
  );
}

export default Register;
