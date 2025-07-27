import React from "react";

class Counter extends React.Component {
  constructor() {
    super();
    this.state = { count: 0 };
  }

  incrementAndGreet = () => {
    this.setState(
      (prev) => ({ count: prev.count + 1 }),
      () => {
        alert(`Hello! Member ${this.state.count-1}`);
      }
    );
  };

  decrement = () => {
    this.setState((prev) => ({ count: prev.count - 1 }));
  };

  sayWelcome = (msg) => {
    alert(msg);
  };

  handleSyntheticEvent = (event) => {
    alert("I was clicked!");
    console.log("Synthetic event details:", event);
  };

  render() {
    return (
      <div style={{ margin: "40px" }}>
        <p><strong>Count:</strong> {this.state.count}</p>

        <button onClick={this.incrementAndGreet}>Increment</button>{" "}
        <button onClick={this.decrement}>Decrement</button>{" "}
        <button onClick={() => this.sayWelcome("Welcome!")}>Say Welcome</button>{" "}
        <button onClick={this.handleSyntheticEvent}>Click on me</button>
      </div>
    );
  }
}

export default Counter;
