import React, { useState } from 'react';

function ComplaintRegister() {
  const [formData, setFormData] = useState({ ename: '', complaint: '' });
  const [referenceId, setReferenceId] = useState('');

  const handleChange = (event) => {
    setFormData({
      ...formData,
      [event.target.name]: event.target.value
    });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    const refNum = "TID-" + Math.floor(Math.random() * 1000000);
    setReferenceId(refNum);

    const msg = `Thanks ${formData.ename}\nYour Complaint was Submitted.\nID is: ${refNum}`;
    alert(msg);

    setFormData({ ename: '', complaint: '' });
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <h1 style={{ color: 'red', textAlign: 'center', marginBottom: '20px' }}>
        Register your complaints here!!!
      </h1>
        <label>Name: </label><br />
        <input
          type="text"
          name="ename"
          value={formData.ename}
          onChange={handleChange}
          required
             style={{
              width: '100%',
              padding: '8px',
              marginTop: '5px',
              borderRadius: '5px',
              border: '1px solid #ccc'
            }}
        />
      </div>
      <div>
        <label>Complaint: </label><br />
        <textarea
          name="complaint"
          value={formData.complaint}
          onChange={handleChange}
          required
          rows="5"
          cols="50"
           style={{
              width: '100%',
              padding: '8px',
              marginTop: '5px',
              borderRadius: '5px',
              border: '1px solid #ccc',
              resize: 'vertical'
            }}
        />
            
      </div>
      <div style={{ textAlign: 'center' }}>
          <button type="submit"
            style={{
              backgroundColor: '#28a745',
              color: 'white',
              padding: '10px 20px',
              fontSize: '16px',
              border: 'none',
              borderRadius: '5px',
              cursor: 'pointer'
            }}>
            Submit
          </button>
        </div>
    </form>
  );
}

export default ComplaintRegister;
