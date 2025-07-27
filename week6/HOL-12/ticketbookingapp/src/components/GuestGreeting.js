import React from 'react';
import FlightDetails from './FlightDetails';
function GuestGreeting() {
    return (
      <div>
        <h2>Welcome, Guest!</h2>
        <FlightDetails />
        <p>Please login to book your ticket.</p>
      </div>
    );
}

export default GuestGreeting;
