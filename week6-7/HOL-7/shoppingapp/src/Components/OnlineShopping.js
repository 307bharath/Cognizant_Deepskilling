// src/components/OnlineShopping.js
import React from "react";
import Cart from "./Cart";

class OnlineShopping extends React.Component {
  constructor() {
    super();
    this.items = [
      { itemname: "Laptop", price: 80000 },
      { itemname: "Tv", price: 120000 },
      { itemname: "Washing Machine", price: 50000 },
      { itemname: "Mobile", price: 30000 },
      { itemname: "Fridge", price: 70000 }
    ];
  }

  render() {
    return (
      <div style={{ width:"150px" , margin: "auto", textAlign: "center", color:"green"}}>
        <h2>Items Ordered: </h2>
        <table border="1" style={{ width: "100%", marginTop: "10px" }}>
          <thead>
            <tr>
              <th>Name</th>
              <th>Price</th>
            </tr>
          </thead>
          <tbody>
            {this.items.map((item, index) => (
              <Cart key={index} itemname={item.itemname} price={item.price} />
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default OnlineShopping;
