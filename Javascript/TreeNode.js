"use strict";

class TreeNode{
  constructor (theValue) {
    this.value = theValue;
    this.children = [];
  }

  addChild(theChild) {
    children.push(theChild);
  }

  hasChildren() {
    return children.length > 0;
  }

  getChildren() {
    return children;
  }

  getValue() {
    return value;
  }
}

module.exports = TreeNode;
