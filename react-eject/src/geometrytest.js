import { center, belowleft, rightof, topleft } from "./geometry";

const makeSquare = (offset, size, color) => {
  const e = document.createElement("div");
  e.style.position = "absolute";
  e.style.top = offset + "px";
  e.style.left = offset + "px";
  e.style.width = size + "px";
  e.style.height = size + "px";
  e.style.backgroundColor = color;
  return e;
};

// red square should be in the middle of yellow sqaure
const testCenter1 = () => {
  const root = makeSquare(10, 60, "yellow");
  document.body.appendChild(root);

  const square = makeSquare(0, 20, "red");
  root.appendChild(square);

  center([square], [root], root);
};

// red square should be in the middle of the blue squares
const testCenter2 = () => {
  const root = makeSquare(10, 50, "yellow");
  document.body.appendChild(root);

  const sqtl = makeSquare(10, 10, "blue");
  root.appendChild(sqtl);
  const sqbr = makeSquare(30, 10, "blue");
  root.appendChild(sqbr);
  const sqtr = makeSquare(10, 10, "blue");
  sqtr.style.left = "30px";
  root.appendChild(sqtr);
  const sqbl = makeSquare(30, 10, "blue");
  sqbl.style.left = "10px";
  root.appendChild(sqbl);
  const red = makeSquare(0, 10, "red");
  root.appendChild(red);
  center([red], [sqtl, sqbr, sqtr, sqbl], root);
};

// red square should be below blue rectangle, on the left
const testBelow = () => {
  const root = makeSquare(10, 60, "yellow");
  document.body.appendChild(root);
  const blue = makeSquare(10, 20, "blue");
  blue.style.height = "10px";
  root.appendChild(blue);
  const red = makeSquare(0, 10, "red");
  root.appendChild(red);
  belowleft([red], [blue], root);
};

// red square should be on the right of the blue rectangle, vertically centered
const testRightOf = () => {
  const root = makeSquare(10, 60, "yellow");
  document.body.appendChild(root);
  const blue = makeSquare(10, 20, "blue");
  blue.style.width = "10px";
  root.appendChild(blue);
  const red = makeSquare(0, 10, "red");
  root.appendChild(red);
  rightof([red], [blue], root);
};

// red square should be on top left of the blue square, insie
// TODO: find a way to distinguish top left in side from top left outside
const testTopLeft = () => {
  const root = makeSquare(10, 60, "yellow");
  document.body.appendChild(root);
  const blue = makeSquare(10, 20, "blue");
  root.appendChild(blue);
  const red = makeSquare(0, 10, "red");
  root.appendChild(red);
  topleft([red], [blue], root);
};

export { testCenter1, testCenter2, testBelow, testRightOf, testTopLeft };
