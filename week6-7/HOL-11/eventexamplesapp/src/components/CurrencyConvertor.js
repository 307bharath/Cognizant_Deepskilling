// src/components/CurrencyConverter.js
import React from "react";

class CurrencyConvertor extends React.Component {
  constructor() {
    super();
    this.state = {
      amount: "",
      currency: ""
    };
  }

  handleAmountChange = (e) => {
    this.setState({ amount: e.target.value });
  };

  handleCurrencyChange = (e) => {
    this.setState({ currency: e.target.value });
  };

  handleSubmit = (e) => {
    e.preventDefault();

    const { amount, currency } = this.state;
    const rateMapping = {
      euro: 80,
      usd: 84,
      gbp: 95
    };

    const key = currency.trim().toLowerCase();
    const rate = rateMapping[key];

    if (rate) {
      const result = parseFloat(amount) * rate;
      alert(`Converting to ${currency} Amount is ${result}`);
    } else {
      alert("Currency not supported. Try 'euro', 'usd', or 'gbp'.");
    }
  };

  render() {
    return (
      <div style={{  margin: "50px", fontFamily: "sans-serif" }}>
        <h2 style={{ color: "green" }}>Currency Convertor!!!</h2>

        <form onSubmit={this.handleSubmit}>
          <div style={{ marginBottom: "10px" }}>
            <label>Amount: </label>
            <input
              type="number"
              value={this.state.amount}
              onChange={this.handleAmountChange}
              required
            />
          </div>
          <div style={{ marginBottom: "10px" }}>
            <label>Currency: </label>
            <input
              type="text"
              value={this.state.currency}
              onChange={this.handleCurrencyChange}
              required
            />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default CurrencyConvertor;
