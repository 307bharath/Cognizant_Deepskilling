// src/components/Cart.js
import React from "react";

class Cart extends React.Component {
  render() {
    const { itemname, price } = this.props;
    return (
      <tr>
        <td>{itemname}</td>
        <td>₹{price}</td>
      </tr>
    );
  }
}

export default Cart;
